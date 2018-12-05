import React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';
import Loadable from 'react-loadable';
import LoadingComponent from 'util/LoadingComponent';
const Eventos = ({ match }) => (
		<Switch>
			<Route
                exact
				path={`${match.url}/`}
				component={Loadable({
					loader: () => import('./routes/Lista/'),
					loading: () => <LoadingComponent />
				})}
			/>
			<Route
				path={`${match.url}/novo`}
				component={Loadable({
					loader: () => import('./routes/Novo/'),
					loading: () => <LoadingComponent />
				})}
			/>
            <Route
				path={`${match.url}/editar`}
				component={Loadable({
					loader: () => import('./routes/Editar/'),
					loading: () => <LoadingComponent />
				})}
			/>
			<Route
				component={Loadable({
					loader: () => import('components/Error404'),
					loading: () => <LoadingComponent />
				})}
			/>
		</Switch>
);

export default Eventos;
