import React from 'react';
import { Field, reduxForm } from 'redux-form';
import { renderTextField } from 'components/Formularios/ReduxFields';
import { validate, asyncValidate } from './Validacoes';
const FormularioLogin = () => (
	<form>
		<fieldset>
        <Field component={renderTextField} label="Nome" name="nome" errorLabel={true} className="mt-3"/>
			<Field component={renderTextField} label="E-mail" name="email" errorLabel={true} className="mt-3"/>
			<Field component={renderTextField} label="Senha" name="senha" errorLabel={true} className="mt-3" type="password"/>
            <Field component={renderTextField} label="Confirmar Senha" name="confirmarSenha" errorLabel={true} className="mt-3" type="password"/>
		</fieldset>
	</form>
);

export default reduxForm({ form: 'FormularioCriarConta', validate, asyncValidate })(FormularioLogin);
