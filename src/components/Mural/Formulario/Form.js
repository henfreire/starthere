import React from "react";
import { Formik, Field } from "formik";
import {
  renderTextField,
  renderImg
} from "components/Formularios/FormikFields";
import Button from "@material-ui/core/Button";

class Thumb extends React.Component {
  state = {
    loading: false,
    thumb: undefined
  };

  componentWillReceiveProps(nextProps) {
    if (!nextProps.file) {
      return;
    }

    this.setState({ loading: true }, () => {
      let reader = new FileReader();

      reader.onloadend = () => {
        this.setState({ loading: false, thumb: reader.result });
      };

      reader.readAsDataURL(nextProps.file);
    });
  }

  render() {
    const { file } = this.props;
    const { loading, thumb } = this.state;

    if (!file) {
      return null;
    }

    if (loading) {
      return <p>loading...</p>;
    }

    return (
      <img
        src={thumb}
        alt={file.name}
        className="img-thumbnail mt-2"
        height={200}
        width={200}
      />
    );
  }
}
class Example extends React.Component {
  render() {
    const { initialValues } = this.props;
    return (
      <div>
        <Formik
          initialValues={
            initialValues
              ? initialValues
              : { nome: "", descricao: "", imagem: "" }
          }
          onSubmit={(values, actions) => {
            this.props.onSubmit({ values });
          }}
          render={({ values, handleSubmit, setFieldValue }) => {
            return (
              <form onSubmit={handleSubmit}>
                <div className="row">
                  <div className="col-6 col-xs-12">
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
                  </div>
                  <div className="col-6 col-xs-12">
                    <Thumb file={values.imagem} />
                    <input
                      id="imagem"
                      name="imagem"
                      type="file"
                      onChange={event => {
                        setFieldValue("imagem", event.currentTarget.files[0]);
                      }}
                      className="form-control"
                    />
                  </div>
                </div>
                <Button
                  variant="contained"
                  color="primary"
                  className="mt-2"
                  type="submit"
                >
                  Adicionar
                </Button>
              </form>
            );
          }}
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
