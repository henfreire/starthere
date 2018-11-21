import Color from 'color';
import React from 'react';
import lightGreen from '@material-ui/core/colors/lightGreen';
import Tooltip from '@material-ui/core/Tooltip';
const BarraComprovacao = ({ porcentagem }) => {
	const cor = lightGreen['A700'];
	const style = {
		progress: {
			height: '10px',
			backgroundColor: '#eee',
			boxShadow: '0 10px 18px 0 rgba(62,57,107,.2)'
		},
		progressBar: {
			backgroundColor: cor,
			backgroundImage: `linear-gradient(to right,` + cor + ` 0,` + Color(cor).lighten(0.3).hex() + ` 100%)`,
			width: porcentagem + '%'
		}
	};
	return (
		<Tooltip title={`Comprovação ${porcentagem}%`}>
			<div className="progress" style={style.progress}>
				<div
					className="progress-bar"
					role="progressbar"
					aria-valuenow={porcentagem}
					aria-valuemin="0"
					aria-valuemax="100"
					style={style.progressBar}
				>

				</div>
			</div>
		</Tooltip>
	);
};
export default BarraComprovacao;
