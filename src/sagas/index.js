import {all} from 'redux-saga/effects';
import AuthSagas from './Auth';
import EventosSagas from './Eventos';
import MuralSagas from './Mural';

export default function* rootSaga(getState) {
    yield all([
        AuthSagas(),
        EventosSagas(),
        MuralSagas()
    ]);
}
