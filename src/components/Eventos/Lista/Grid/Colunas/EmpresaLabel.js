import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Tooltip from '@material-ui/core/Tooltip';
import Chip from '@material-ui/core/Chip';
const styles = (theme) => ({
	chip: {
        margin: theme.spacing.unit,
      },
});
class EmpresaLabel extends Component {
	render() {
		const { texto, classes } = this.props;
		return (
			<Tooltip title={texto}>
				<Chip
					label={texto}
                    variant="outlined"
				/>
			</Tooltip>
		);
	}
}
EmpresaLabel.propTypes = {
	classes: PropTypes.object.isRequired
};

export default withStyles(styles)(EmpresaLabel);
