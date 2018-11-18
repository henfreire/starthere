import { all, call, fork, put, takeEvery } from 'redux-saga/effects';
import { Creators as ActionsAuth, Types } from 'ducks/Auth';
import api from '../api/api';

const criarContaEmailSenhaRequest = async (novoUsuario) =>
	api.post('/empresa/add', novoUsuario).then((authUser) => authUser).catch((error) => error);

const loginEmailSenhaRequest = async (dadosLogin) =>
	api.post('/login', dadosLogin).then((authUser) => authUser).catch((error) => error);

function* criarContaEmailSenha({ payload }) {
	const { dados } = payload;
	let mensagemAuth = 'Ocorreu um erro no login!';
	let usuarioData = null;
	try {
		const novoUsuario = {
			nome: dados.nome,
			email: dados.email,
			senha: dados.senha,

		};

		const response = yield call(criarContaEmailSenhaRequest, novoUsuario);
		if (response.ok) {
			usuarioData = novoUsuario;
		} else if (Object.prototype.hasOwnProperty.call(response.data, 'error')) {
			switch (response.data.error) {
				case 'Unauthorised':
					mensagemAuth = 'Os dados não estão corretos';
					break;
				default:
					mensagemAuth = 'Ocorreu um erro inusitado. Tente novamente';
					break;
			}
		} else {
			mensagemAuth = 'Ocorreu um erro interno.Tente novamente';
		}

		if (usuarioData !== null) {
			yield put(ActionsAuth.loginSucesso(usuarioData));
		} else {
			yield put(ActionsAuth.setAuthMensagem({ mensagem: mensagemAuth, mostrar: true }));
			yield put(ActionsAuth.setLoaderAuth(false));
		}
	} catch (error) {
		yield put(ActionsAuth.setLoaderAuth(false));
		yield put(ActionsAuth.setAuthMensagem(error));
	}
}

function* loginEmailSenha({ payload }) {
	const { dados } = payload;
	let mensagemAuth = 'Ocorreu um erro no login!';
	let usuarioData = null;
	try {
		const dadosLogin = {
			email: dados.email,
			senha: dados.senha
		};
		const response = yield call(loginEmailSenhaRequest, dadosLogin);
		if (response.ok) {
			if (Object.prototype.hasOwnProperty.call(response.data, 'user')) {
				usuarioData = response.data;
			} else {
				mensagemAuth = 'Resposta inválida';
			}

		} else if (Object.prototype.hasOwnProperty.call(response.data, 'error')) {
			switch (response.data.error) {
				case 'Unauthorised':
					mensagemAuth = 'Senha ou usuário inválido';
					break;
				default:
					mensagemAuth = 'Ocorreu um erro inusitado. Tente novamente';
					break;
			}
		} else {
			mensagemAuth = 'Ocorreu um erro interno.Tente novamente';
		}
		if (usuarioData !== null) {
			yield put(ActionsAuth.loginSucesso(usuarioData));
		} else {
			yield put(ActionsAuth.setLoaderAuth(false));
			yield put(ActionsAuth.setAuthMensagem({ mensagem: mensagemAuth, mostrar: true }));
		}
	} catch (error) {
		yield put(ActionsAuth.setLoaderAuth(false));
		yield put(ActionsAuth.setAuthMensagem({ mensagem: 'Ocooreu um error! Tente novamente', mostrar: true }));
	}
}

function* logout() {
	try {
		let signOutUser;
		if (signOutUser === undefined) {
			yield put(ActionsAuth.logoutSucesso(null));
		} else {
			yield put(ActionsAuth.setAuthMensagem({ mensagem: 'Error ao fazer login', mostrar: true }));
		}
	} catch (error) {
		yield put(ActionsAuth.setLoaderAuth(false));
		yield put(ActionsAuth.setAuthMensagem(error));
	}
}

export function* loginAcao() {
	yield takeEvery(Types.LOGIN, loginEmailSenha);
}

export function* logoutAcao() {
	yield takeEvery(Types.LOGOUT, logout);
}
export function* criarContaAcao() {
	yield takeEvery(Types.CRIAR_CONTA, criarContaEmailSenha);
}

export default function* rootSaga() {
	yield all([fork(loginAcao), fork(criarContaAcao), fork(logoutAcao)]);
}
