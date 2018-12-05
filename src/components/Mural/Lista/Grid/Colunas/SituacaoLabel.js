import React, { Component } from 'react';
import PropTypes from 'prop-types';;
import { withStyles } from '@material-ui/core/styles';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import Tooltip from '@material-ui/core/Tooltip';
import lightGreen from '@material-ui/core/colors/lightGreen';
import amber from '@material-ui/core/colors/amber';
import Avatar from '@material-ui/core/Avatar';
import Chip from '@material-ui/core/Chip';
import { faCheck, faTruck } from '@fortawesome/free-solid-svg-icons';

const styles = (theme) => ({
	chipEntregue: {
		background: lightGreen['A700']
	},
	chipAberta: {
		background: amber['A400']
	},
	avatar: {
		background: '#00000014'
	}
});

class SituacaoLabel extends Component {
	constructor(props) {
        super(props);
		this.state = {
			icon: 'check'
        };

	}
	configLabel = () => {
		switch (this.props.tipo) {
			case 'Entregue':
				this.setState({
					icon: faCheck
				});
				break;
			case 'Aberta':
				this.setState({
					icon: faTruck
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
							<FontAwesomeIcon icon={icon} color="#fff" />
						</Avatar>
					}
					label={valor}
					classes={{ root: classes[`chip${tipo}`], avatar: classes.avatar }}
					color="primary"
					variant="outlined"
				/>
			</Tooltip>
		);
	}
}
SituacaoLabel.propTypes = {
	classes: PropTypes.object.isRequired
};

export default withStyles(styles)(SituacaoLabel);
