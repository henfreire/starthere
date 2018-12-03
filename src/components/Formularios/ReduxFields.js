import React from 'react';
import TextField from '@material-ui/core/TextField';
import ListaAutoCompleta from 'components/Formularios/ListaAutoCompleta';
import Select from '@material-ui/core/Select';
import FormControl from '@material-ui/core/FormControl';
import FormHelperText from '@material-ui/core/FormHelperText';
export const renderTextField = ({ input, type, errorLabel, label, ...custom ,  meta: { touched, error },}) => (
	<div>
		<TextField
			label={touched && error && !errorLabel ? error : label}
			type={type ? type : 'text'}
			value={input.value}
			onBlur={input.onBlur}
			onChange={input.onChange}
			fullWidth
			error={touched && error ? true : false}
			{...custom}
		/>
		{errorLabel &&
		touched &&
		error && (
			<FormHelperText id="component-error-text" error={true}>
				{error}
			</FormHelperText>
		)}
	</div>
);

export const renderSelect = ({ input, label, meta: { touched, error }, ...custom }, children) => (
	<Select
		value={input.value}
		onChange={(event) => input.onChange(event.target.value)}
		onBlur={input.onBlur}
		fullWidth
		error={touched && error}
	>
		{children}
	</Select>
);

export const renderListaAutoCompleta = ({ onChange, dados, input, label, meta: { touched, error }, ...custom }) => (
	<ListaAutoCompleta
		placeholder={label}
		value={input.value}
		dados={dados}
		onChange={(event) => input.onChange(event.target.value)}
	/>
);
