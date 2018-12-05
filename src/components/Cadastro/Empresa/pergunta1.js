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

class Pergunta1 extends React.Component {
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
          <FormLabel component="legend">Tempo de atuação da Startup:</FormLabel>
          <RadioGroup
            name="pergunta1"
            className={classes.group}
            value={this.state.value}
            onChange={this.handleChange} >
            
            <FormControlLabel
              value="1"
              control={<Radio />}
              label="Apenas 2 meses ou menos"
            />
             <FormControlLabel
              value="2"
              control={<Radio />}
              label="Entre 2 e 6 meses"
            />
             <FormControlLabel
              value="3"
              control={<Radio />}
              label="Entre 4 e 8 meses"
            />
             <FormControlLabel
              value="4"
              control={<Radio />}
              label="Entre 8 meses e 1 ano"
            />
             <FormControlLabel
              value="5"
              control={<Radio />}
              label="Mais que um ano"
            />
          </RadioGroup>
        </FormControl>
      </div>
    );
  }
}

Pergunta1.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Pergunta1);