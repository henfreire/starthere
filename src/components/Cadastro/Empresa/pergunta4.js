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

class Pergunta4 extends React.Component {
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
          <FormLabel component="legend">Investimento recebido:</FormLabel>
          <RadioGroup
            name="pergunta3"
            className={classes.group}
            value={this.state.value}
            onChange={this.handleChange} >
            
            <FormControlLabel
              value="1"
              control={<Radio />}
              label="R$ 0~1000"
            />
             <FormControlLabel
              value="2"
              control={<Radio />}
              label=" R$ 1.001~10.000"
            />
             <FormControlLabel
              value="3"
              control={<Radio />}
              label="R$ 10.001~30.000"
            />
             <FormControlLabel
              value="4"
              control={<Radio />}
              label="R$ 30.001~50.000"
            />
             <FormControlLabel
              value="5"
              control={<Radio />}
              label="Mais que 50 mil"
            />
          </RadioGroup>
        </FormControl>
      </div>
    );
  }
}

Pergunta4.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Pergunta4);