import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import Select from '@material-ui/core/Select';
import MenuItem from '@material-ui/core/MenuItem';

const renderTextField = ({
    input,
    label,
    meta: { touched, error },
    ...custom
}) => (
        <TextField
            id="standard-search"
            type="search"
            label={label}
            value={input.value}
            fullWidth
            onChange={event => { input.onChange(event.target.value) }}
            margin="normal"
            hintText={label}
            floatingLabelText={label}
            errorText={touched && error}
        >
        </TextField>
    );



const renderSelectField = ({ input, label, meta: { touched, error }, children, ...custom }) => {
    return (
        <Select
            value={input.value}
            onChange={event => { input.onChange(event.target.value) }}
            {...custom}
        >
            {children}
        </Select>
    )
}

export {
    renderTextField,
    renderSelectField
}