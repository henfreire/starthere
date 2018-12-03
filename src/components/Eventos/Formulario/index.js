import React from 'react';
import { renderTextField } from 'components/Formularios/ReduxFields';
import { Field, reduxForm } from 'redux-form';
const FormularioEvento = () =>
    (
        <div className="d-flex">
        <div className="form-group">
            <Field
                name="nome"
                component={renderTextField}
                label="Nome"
            />
        </div>
    </div>
    );

export default reduxForm({
    form: 'evento'
})(FormularioEvento);