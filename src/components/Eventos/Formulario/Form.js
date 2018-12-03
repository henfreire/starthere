import React from "react";
import { Formik, Field } from "formik";
import { renderTextField } from "components/Formularios/FormikFields";
import Button from "@material-ui/core/Button";
class Example extends React.Component {
  render() {
   
    return (
      <div>
        <Formik
          initialValues={{ nome: "", descricao: "" }}
          onSubmit={(values, actions) => {
           this.props.onSubmit({values})
          }}
          render={(props: FormikProps<Values>) => (
            <form onSubmit={props.handleSubmit}>
              <Field
                name="nome"
                placeholder="Nome"
                component={renderTextField}
              />
              <Field
                name="descricao"
                placeholder="Descricao"
                multiline={true}
                rowsMax="4"
                rows="4"
                component={renderTextField}
              />

              <Button
                variant="contained"
                color="primary"
                className="mt-2"
                type="submit"
              >
                Adicionar
              </Button>
            </form>
          )}
        />
      </div>
    );
  }
}

const CustomInputComponent = ({
  field, // { name, value, onChange, onBlur }
  form: { touched, errors }, // also values, setXXXX, handleXXXX, dirty, isValid, status, etc.
  ...props
}) => (
  <div>
    <input type="text" {...field} {...props} />
    {touched[field.name] && errors[field.name] && (
      <div className="error">{errors[field.name]}</div>
    )}
  </div>
);

export default Example;
