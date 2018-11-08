import React from 'react';
import { Link } from 'react-router-dom'
import { connect } from 'react-redux';
import Button from '@material-ui/core/Button';
import { NotificationContainer, NotificationManager } from 'react-notifications';
import CircularProgress from '@material-ui/core/CircularProgress';
import FormularioLogin from 'components/Login';
import { logo } from 'components/Logo';
class SignIn extends React.Component {
    constructor() {
        super();
        this.state = {
            email: 'demo@example.com',
            password: 'demo#123'
        }
    }

    componentDidUpdate() {

        if (this.props.usuario !== null) {
            this.props.history.push('/');
        }
    }

    render() {
        const {
            email,
            password
        } = this.state;
        const { loader, showMessage } = this.props;
        return (
            <div
                className="app-login-container d-flex justify-content-center align-items-center animated slideInUpTiny animation-duration-3">
                <div className="app-login-main-content">

                    <div className="app-logo-content d-flex align-items-center justify-content-center">
                        <Link className="logo-lg" to="/" title="StartHere">
                            <img src={logo} className="img-fluid" alt="StartHere" title="StartHere" />
                        </Link>
                    </div>

                    <div className="app-login-content">
                        <div className="app-login-header mb-4">
                            <h1>Login</h1>
                        </div>

                        <div className="app-login-form">
                            <FormularioLogin />
                            <Button onClick={() => {

                            }} variant="raised" color="primary">
                                Entrar
                                        </Button>
                        </div>
                    </div>

                </div>
                {
                    loader &&
                    <div className="loader-view">
                        <CircularProgress />
                    </div>
                }
                {showMessage && NotificationManager.error(alertMessage)}
                <NotificationContainer />
            </div>
        );
    }
}

const mapStateToProps = ({ auth }) => {
    const { loader, usuario, showMessage } = auth;
    return { loader, usuario, showMessage }
};

export default connect(mapStateToProps)(SignIn);
