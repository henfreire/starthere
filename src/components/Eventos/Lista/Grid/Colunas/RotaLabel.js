import React, { Component } from 'react';
import PropTypes from 'prop-types';;
import { withStyles } from '@material-ui/core/styles';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import Tooltip from '@material-ui/core/Tooltip';
import deepOrange from '@material-ui/core/colors/deepOrange';
import grey from '@material-ui/core/colors/grey';
import amber from '@material-ui/core/colors/amber';
import Avatar from '@material-ui/core/Avatar';
import Chip from '@material-ui/core/Chip';
import { faMapMarkedAlt } from '@fortawesome/free-solid-svg-icons';

const styles = (theme) => ({
	chipRota: {

	},
	avatar: {
		background: '#00000014'
	}
});

class RotaLabel extends Component {
	constructor(props) {
        super(props);
		this.state = {
			icon: 'check'
        };

	}
	configLabel = () => {
		switch (this.props.tipo) {
			case 'Rota':
				this.setState({
					icon: faMapMarkedAlt
				});
				break;
			default:
				break;
		}
    };
    UNSAFE_componentWillMount(){
        this.configLabel();
    }
	render() {
		const { valor, texto, classes, tipo } = this.props;
		const { icon } = this.state;
		return (
			<Tooltip title={texto}>
				<Chip
					avatar={
						<Avatar>
							<FontAwesomeIcon icon={icon}/>
						</Avatar>
					}
					label={valor}
					classes={{ root: classes[`chip${tipo}`], avatar: classes.avatar }}
					variant="outlined"
				/>
			</Tooltip>
		);
	}
}
RotaLabel.propTypes = {
	classes: PropTypes.object.isRequired
};

export default withStyles(styles)(RotaLabel);
