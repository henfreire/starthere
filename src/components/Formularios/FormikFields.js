import React from "react";
import TextField from "@material-ui/core/TextField";
import FormHelperText from "@material-ui/core/FormHelperText";
import Datas from 'components/Datas';
export const renderTextField = ({
  field, // { name, value, onChange, onBlur }
  form: { touched, errors }, // also values, setXXXX, handleXXXX, dirty, isValid, status, etc.
  errorLabel,
  type,
  placeholder,
  ...props
}) => {
  return (
    <div>
      <TextField
        label={
          touched[field.name] && errors[field.name] && !errorLabel
            ? errors[field.name]
            : placeholder
        }
        type={type ? type : "text"}
        value={field.value}
        name={field.name}
        onBlur={field.onBlur}
        onChange={field.onChange}
        fullWidth
        error={touched[field.name] && errors[field.name] ? true : false}
        {...props}
      />
      {errorLabel && touched[field.name] && errors[field.name] && (
        <FormHelperText id="component-error-text" error={true}>
          {errors[field.name]}
        </FormHelperText>
      )}
    </div>
  );
};
export const renderImg = ({
  field, // { name, value, onChange, onBlur }
  form: { touched, errors }, // also values, setXXXX, handleXXXX, dirty, isValid, status, etc.
  errorLabel,
  rowsMax,
  type,
  multiline,
  rows,
  placeholder,
  ...props
}) => {
  return (
    <div>
      <TextField
        label={
          touched[field.name] && errors[field.name] && !errorLabel
            ? errors[field.name]
            : placeholder
        }
        type={type ? type : "file"}
        value={field.value}
        name={field.name}
        onBlur={field.onBlur}
        onChange={event => field.onChange(event.currentTarget.files[0])}
        fullWidth
        {...props}
        error={touched[field.name] && errors[field.name] ? true : false}
      />
      {errorLabel && touched[field.name] && errors[field.name] && (
        <FormHelperText id="component-error-text" error={true}>
          {errors[field.name]}
        </FormHelperText>
      )}
    </div>
  );
};

export const renderReactData = ({ field, label, ...custom }) => {
  console.log("field", field)
	const onMudar = (dados) => {
		field.onChange(dados);
    };
    const {startDate, endDate} = field.value;
	return <Datas  startDate ={startDate} endDate={endDate} onChange={onMudar} />;
};