import { all, call, fork, put, takeEvery } from "redux-saga/effects";
import {
    FAZER_LOGIN
} from "constants/ActionTypes";
import { loginSucesso } from "actions/Auth";
import api from '../api/api';
const fazerLoginRequest = async () => api.get('user/login').then(data => data).catch(error => error);

let mensagemUser = "";
function* fazerLogin ({ payload }) {
    const { } = payload;
    const userData = {};

    try {
        const response = yield call(fazerLoginRequest, {});
        if (response.ok) {
            yield put(loginSucesso(userData))
        } else {

        }
    } catch (error) {

    }
}
export function* fazerLoginDados() {
    yield takeEvery(FAZER_LOGIN, fazerLogin);
}
export default function* rootSaga() {
    yield all([fork(fazerLoginDados),
    ]);
} 