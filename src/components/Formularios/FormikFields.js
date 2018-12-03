import React from "react";
import TextField from "@material-ui/core/TextField";
import FormHelperText from "@material-ui/core/FormHelperText";
export const renderTextField = ({
  field, // { name, value, onChange, onBlur }
  form: { touched, errors }, // also values, setXXXX, handleXXXX, dirty, isValid, status, etc.
  errorLabel,
  rowsMax,
  type,
  multiline,
  rows,
  placeholder,
  ...props
}) => (
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
      multiline={multiline}
      rowsMax={rowsMax}
      rows={rows}
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
