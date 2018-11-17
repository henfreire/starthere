import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';
import { NotificationContainer, NotificationManager } from 'react-notifications';
import CircularProgress from '@material-ui/core/CircularProgress';
import { logo } from 'components/Logo';
import { Creators as ActionsAuth } from 'ducks/Auth';
import FormularioCadastro from 'components/Cadastrar/Formulario';
import Bolhas from 'components/Efeitos/Bolhas';
const styles = {
	paperContainer: {
		backgroundImage: `)`,
		backgroundSize: 'cover'
	}
};
class Login extends Component {
	constructor(props) {
		super(props);
	}

	componentDidUpdate() {
		if (this.props.exibirAuthMensagem) {
			setTimeout(() => {
				this.props.setAuthMensagem({ mostrar: false });
			}, 100);
		}
		if (this.props.usuario !== null) {
			this.props.history.push('/');
		}
		return true;
	}
	login = () => {
		const { formularioCriarConta } = this.props;
		if (formularioCriarConta.hasOwnProperty('syncErrors')) {
			this.props.setAuthMensagem({
				mensagem: `Por favor preencha os campos corretamente( ${Object.keys(
					formularioCriarConta.syncErrors
				)} )`,
				mostrar: true
			});
			setTimeout(() => {
				this.props.setAuthMensagem({ mostrar: false });
			}, 300);
		} else {
			this.props.setLoaderAuth(true);
			this.props.criarConta({ dados: this.props.formularioCriarConta.values });
		}
	};
	render() {
		const { authMensagem, exibirAuthMensagem, authLoader } = this.props;
		return (
			<Paper className="container-fluid d-flex justify-content-center" style={styles.paperContainer}>
				<div className="app-login-container d-flex justify-content-center align-items-center animated slideInUpTiny animation-duration-3">
					<div className="app-login-main-content">
						<div className="app-logo-content d-flex align-items-center justify-content-center">
							<Link className="logo-sm" to="/" title="Azapfy">
								<img src={logo} alt="Azapfy" title="Azapfy" className="img-fluid" />
							</Link>
						</div>

						<div className="app-login-content">
							<div className="app-login-header mb-4">
								<h1>Criar Conta</h1>
							</div>

							<div className="app-login-form">
								<FormularioCadastro />
								<div className="mt-3 d-flex align-items-center justify-content-between">
									<Button onClick={this.login} variant="raised" color="primary">
									Cadastrar
									</Button>

									<Link to="/login">
										Já tenho uma conta
									</Link>
								</div>
							</div>
						</div>
					</div>
					{authLoader && (
						<div className="loader-view">
							<CircularProgress />
						</div>
					)}
					{exibirAuthMensagem && NotificationManager.error(authMensagem)}
					<NotificationContainer />
				</div>
				<Bolhas />
			</Paper>
		);
	}
}

const mapStateToProps = ({ auth, form }) => {
	const { usuario, authMensagem, exibirAuthMensagem, authLoader } = auth;
	const { FormularioCriarConta } = form;
	return { usuario, authMensagem, exibirAuthMensagem, authLoader, formularioCriarConta: FormularioCriarConta };
};

export default connect(mapStateToProps, {
	criarConta: ActionsAuth.criarConta,
	setAuthMensagem: ActionsAuth.setAuthMensagem,
	setLoaderAuth: ActionsAuth.setLoaderAuth
})(Login);
