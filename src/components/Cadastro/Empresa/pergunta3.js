import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';

const styles = theme => ({
  root: {
    display: 'flex',
  },
  formControl: {
    margin: theme.spacing.unit * 3,
  },
  group: {
    margin: `${theme.spacing.unit}px 0`,
  },
});

class Pergunta3 extends React.Component {
  state = {
    value: 1,
  };
  handleChange = event => {
    this.setState({ value: event.target.value });
    console.log(event.target.value)
  };
  returnState =  () => {
    this.props.getState(this.state.value)  
  };
  render() {
    const { classes } = this.props;

    return (
      <div className={classes.root}>
        <FormControl component="fieldset" className={classes.formControl}>
          <FormLabel component="legend">Desenvolvimento do projeto:</FormLabel>
          <RadioGroup
            name="pergunta3"
            className={classes.group}
            value={this.state.value}
            onChange={this.handleChange} >
            
            <FormControlLabel
              value="1"
              control={<Radio />}
              label="Apenas uma ideia"
            />
             <FormControlLabel
              value="2"
              control={<Radio />}
              label="Ideia validade"
            />
             <FormControlLabel
              value="3"
              control={<Radio />}
              label="Modelo de negócios definido"
            />
             <FormControlLabel
              value="4"
              control={<Radio />}
              label="Ideia prototipada"
            />
             <FormControlLabel
              value="5"
              control={<Radio />}
              label="MVP ou produto operante"
            />
          </RadioGroup>
        </FormControl>
      </div>
    );
  }
}

Pergunta3.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Pergunta3);