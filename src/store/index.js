import { applyMiddleware, compose, createStore } from 'redux';
import reducers from '../reducers/index';
import createHistory from 'history/createHashHistory';
import createSagaMiddleware from 'redux-saga';
import rootSaga from '../sagas/index';
import { routerMiddleware } from 'react-router-redux';
import { createMigrate, persistStore, persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
const history = createHistory();
const routeMiddleware = routerMiddleware(history);
const sagaMiddleware = createSagaMiddleware();
const persistConfig = {
	key: 'root',
	storage,
    version: 7,
    whitelist: [ 'geral'],
};
const middlewares = [ sagaMiddleware, routeMiddleware ];
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export default function configureStore(initialState) {
	const persistedReducer = persistReducer(persistConfig, reducers);
	const store = createStore(persistedReducer, initialState, composeEnhancers(applyMiddleware(...middlewares)));
	const persistor = persistStore(store);
	sagaMiddleware.run(rootSaga);

	if (module.hot) {
		// Enable Webpack hot module replacement for reducers
		module.hot.accept('../reducers/index', () => {
			const nextRootReducer = require('../reducers/index');
			store.replaceReducer(persistReducer(persistConfig, nextRootReducer));
		});
	}
	return { store, persistor };
}
export { history };
