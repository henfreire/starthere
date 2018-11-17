import {all} from 'redux-saga/effects';
import AuthSagas from './Auth';

export default function* rootSaga(getState) {
    yield all([
        AuthSagas()
    ]);
}
