import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { renderTextField } from 'components/Formularios/ReduxFiltros';
import { Field, reduxForm } from 'redux-form';
class FormularioLogin extends Component {
    render() {
        return (
            <form>
            <fieldset>
            <div className="row">
            <div className="col-md-6">
                <div className="form-group">
                    <Field
                        name="usuario"
                        component={renderTextField}
                        label="Usuário"
                    />
                </div>
            </div>
            <div className="col-md-6">
                <div className="form-group">
                    <Field
                        name="senha"
                        component={renderTextField}
                        label="Senha"
                    />

                </div>
            </div>
        </div>
            </fieldset>
        </form>
           
        );
    }
}

FormularioLogin.propTypes = {

};

export default reduxForm({
    form: 'FormularioLogin'
})(FormularioLogin);