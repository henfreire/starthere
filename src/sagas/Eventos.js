import { all, call, fork, put, takeEvery } from "redux-saga/effects";
import { Creators as ActionsEventos, Types } from "ducks/Eventos";
import api from "../api/api";

const buscarTodosEventosRequest = async dados =>
  api
    .post("/evento/getAll/", dados)
    .then(result => result)
	.catch(error => error);

const addEventoRequest = async dados =>
	api
	  .post("/evento/add/", dados)
	  .then(result => result)
	  .catch(error => error);	
	

function* buscarTodosEventos({ payload }) {
  let mensagem = "";
  let result = null;

  try {
    const dados = {};
    const response = yield call(buscarTodosEventosRequest, dados);
    console.log("response", response);
    if (response.ok) {
      result = response.data;
      console.log("result", result);
    } else if (Object.prototype.hasOwnProperty.call(response.data, "error")) {
      switch (response.data.error) {
        case "Unauthorised":
          mensagem = "Os dados não estão corretos";
          break;
        default:
          mensagem = "Ocorreu um erro inusitado. Tente novamente";
          break;
      }
    } else {
      mensagem = "Ocorreu um erro interno.Tente novamente";
    }

    if (result !== null) {
      yield put(ActionsEventos.buscarTodosEventosSucesso(result));
    } else {
      yield put(
        ActionsEventos.setEventoMensagem({ mensagem: mensagem, mostrar: true })
      );
    }
  } catch (error) {
    yield put(ActionsEventos.setEventoMensagem(error));
  }
}
function* addEvento({ payload }) {
	let result = null;
  let mensagem = "";
  const {values}= payload;
	try {
	  const dados = {};
	  const response = yield call(addEventoRequest, values);
	  console.log("response", response);
	  if (response.ok) {
		result = response.data;
		console.log("result", result);
	  } else if (Object.prototype.hasOwnProperty.call(response.data, "error")) {
		switch (response.data.error) {
		  case "Unauthorised":
			mensagem = "Os dados não estão corretos";
			break;
		  default:
			mensagem = "Ocorreu um erro inusitado. Tente novamente";
			break;
		}
	  } else {
		mensagem = "Ocorreu um erro interno.Tente novamente";
	  }
  
	  if (result !== null) {
		yield put(ActionsEventos.addEventoSucesso(result));
	  } else {
		yield put(
		  ActionsEventos.setEventoMensagem({ mensagem: mensagem, mostrar: true })
		);
	  }
	} catch (error) {
	  yield put(ActionsEventos.setEventoMensagem(error));
	}
  }

export function* buscarTodosEventosAcao() {
  yield takeEvery(Types.BUSCAR_TODOS_EVENTOS, buscarTodosEventos);
}
export function* addEventoAcao() {
  yield takeEvery(Types.ADD_EVENTO, addEvento);
}
export default function* rootSaga() {
  yield all([fork(buscarTodosEventosAcao), fork(addEventoAcao)]);
}
