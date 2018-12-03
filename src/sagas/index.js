import {all} from 'redux-saga/effects';
import AuthSagas from './Auth';
import EventosSagas from './Eventos';

export default function* rootSaga(getState) {
    yield all([
        AuthSagas(),
        EventosSagas()
    ]);
}
