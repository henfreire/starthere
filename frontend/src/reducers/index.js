import {combineReducers} from 'redux';
import {routerReducer} from 'react-router-redux';
import Settings from './Settings';
import Auth from './Auth';
import { reducer as formReducer } from 'redux-form';

const reducers = combineReducers({
    routing: routerReducer,
    settings: Settings,
    auth: Auth,
    form: formReducer
});

export default reducers;
