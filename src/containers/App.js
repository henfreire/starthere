import React, { Component } from 'react';
import { createMuiTheme, MuiThemeProvider } from '@material-ui/core/styles';
import MomentUtils from 'material-ui-pickers/utils/moment-utils';
import MuiPickersUtilsProvider from 'material-ui-pickers/utils/MuiPickersUtilsProvider';
import { Redirect, Route, Switch } from 'react-router-dom';
import { connect } from 'react-redux';
import { IntlProvider } from 'react-intl';
import 'react-big-calendar/lib/less/styles.less';
import 'styles/bootstrap.scss';
import 'styles/app.scss';
import 'styles/app-rtl.scss';
import defaultTheme from './themes/defaultTheme';
import AppLocale from '../lngProvider';
import Loadable from 'react-loadable';
import RTL from 'util/RTL';
import LoadingComponent from 'util/LoadingComponent';
import { Creators as ActionsAuth } from 'ducks/Auth';
let RestrictedRoute = ({ component: Component, ...rest, authUser }) => (
	<Route
		{...rest}
		render={(props) =>
			authUser ? (
				<Component {...props} />
			) : (
					<Redirect
						to={{
							pathname: '/login',
							state: { from: props.location }
						}}
					/>
				)}
	/>
);

class App extends Component {
	constructor(props) {
		super(props);
	}
	UNSAFE_componentWillMount() {
		// this.props.setUsuario({
		// 	nome: 'Henrique',
		// 	email: 'h.freire@live.com'
		// });
	}
	render() {
		const { match, location, locale, usuario, initURL, isDirectionRTL } = this.props;
		if (location.pathname === '/') {
			if (usuario === null) {
				return <Redirect to={'/login'} />;
			} else if (initURL === '' || initURL === '/' || initURL === '/login') {
				return <Redirect to={'/app/cadastro'} />;
			} else {
				return <Redirect to={initURL} />;
			}
		}
		const applyTheme = createMuiTheme(defaultTheme);

		if (isDirectionRTL) {
			applyTheme.direction = 'rtl';
			document.body.classList.add('rtl');
		} else {
			document.body.classList.remove('rtl');
			applyTheme.direction = 'ltr';
		}

		const currentAppLocale = AppLocale[locale.locale];
		return (
			<MuiThemeProvider theme={applyTheme}>
				<MuiPickersUtilsProvider utils={MomentUtils}>
					<IntlProvider locale={currentAppLocale.locale} messages={currentAppLocale.messages}>
						<RTL>
							<div className="app-main">
								<Switch>
									<RestrictedRoute
										path={`${match.url}app`}
										authUser={usuario}
										component={Loadable({
											loader: () => import('app/index'),
											loading: () => <LoadingComponent />
										})}
									/>
									<Route
										path="/login"
										component={Loadable({
											loader: () => import('./Login'),
											loading: () => <LoadingComponent />
										})}
									/>
									<Route
										path="/cadastrar"
										component={Loadable({
											loader: () => import('./Cadastrar'),
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
							</div>
						</RTL>
					</IntlProvider>
				</MuiPickersUtilsProvider>
			</MuiThemeProvider>
		);
	}
}

const mapStateToProps = ({ settings, auth }) => {
	const { sideNavColor, locale, isDirectionRTL } = settings;
	const { usuario, initURL } = auth;
	return { sideNavColor, locale, isDirectionRTL, initURL, usuario };
};
const { setUsuario } = ActionsAuth;
export default connect(mapStateToProps, { setUsuario })(App);
