import { all, call, fork, put, takeEvery } from 'redux-saga/effects';
import { Creators as ActionsEventos, Types } from 'ducks/Eventos';
import api from '../api/api';

const buscarTodosEventosRequest = async (dados) =>
	api.post('/evento/getAll/', dados).then((result) => result).catch((error) => error);


function* buscarTodosEventos({ payload }) {

	let mensagem = 'Ocorreu um erro no login!';
	let result = null;
	
	try {
		const dados = {

		};
		const response = yield call(buscarTodosEventosRequest, dados);
		console.log("response",response);
		if (response.ok) {
			result = response.data;
			console.log("result", result)
		} else if (Object.prototype.hasOwnProperty.call(response.data, 'error')) {
			switch (response.data.error) {
				case 'Unauthorised':
					mensagem = 'Os dados não estão corretos';
					break;
				default:
					mensagem = 'Ocorreu um erro inusitado. Tente novamente';
					break;
			}
		} else {
			mensagem = 'Ocorreu um erro interno.Tente novamente';
		}

		if (result !== null) {
			yield put(ActionsEventos.buscarTodosEventosSucesso(result));
		} else {
			yield put(ActionsEventos.setEventoMensagem({ mensagem: mensagem, mostrar: true }));
		}
	} catch (error) {
		yield put(ActionsEventos.setEventoMensagem(error));
	}
}

export function* buscarTodosEventosAcao() {
	yield takeEvery(Types.BUSCAR_TODOS_EVENTOS, buscarTodosEventos);
}

export default function* rootSaga() {
	yield all([fork(buscarTodosEventosAcao)]);
}
