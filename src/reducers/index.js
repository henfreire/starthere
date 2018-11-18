import {combineReducers} from 'redux';
import {routerReducer} from 'react-router-redux';
import Settings from './Settings';
import Auth from 'ducks/Auth';
import Geral from 'ducks/Geral';
import { reducer as formReducer } from 'redux-form';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
const authPersistConfig = {
	key: 'auth',
	storage: storage,
	whitelist: [ 'usuario' ]
};
const reducers = combineReducers({
    routing: routerReducer,
    settings: Settings,
    auth: persistReducer(authPersistConfig, Auth),
    geral:Geral,
    form: formReducer
});

export default reducers;
