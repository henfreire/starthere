import React, { Component } from 'react';
import { connect } from 'react-redux';
import MUIDataTable from 'mui-datatables';
import muiDatatableTheme from 'containers/themes/muiDatatableTheme';
import textLabels from 'lngProvider/components/muiDatatable';
import { MuiThemeProvider } from '@material-ui/core/styles';
import Colunas from './Colunas/';
import { mudarDados } from 'actions/DashboardApp';
class GridPrincipal extends Component {
	getMuiTheme = () => muiDatatableTheme;
	options = () => {
		const { linhasPorPagDashApp } = this.props;
		const optionsTabela = {
			textLabels,
			filterType: 'dropdown',
			rowsPerPage: linhasPorPagDashApp,
			download: false,
            print: false,
            responsive: 'scroll',
		};
		return optionsTabela;
	};
	mudar = () => {
		this.props.mudarDados();
	};
	render() {
		const { gridPrincipalDados } = this.props;
		return (
			<div>
				<MuiThemeProvider theme={this.getMuiTheme}>
					<MUIDataTable
						data={gridPrincipalDados.map((grid) => [
                            grid.rota,
							grid.romaneio,
							grid.motorista,
							grid.dataRomaneio,
							grid.remetente,
							grid.entregues,
                            grid.abertas,
                            grid.volume,
							grid.totalNotas,
							grid.porcentagem
						])}
						columns={Colunas({})}
						options={this.options()}
					/>
				</MuiThemeProvider>
			</div>
		);
	}
}
const mapStateToProps = ({ dashboardApp }) => {
	const { gridPrincipalDados, orderDashApp, orderByDashApp, paginaDashApp, linhasPorPagDashApp } = dashboardApp;

	return {
		gridPrincipalDados,
		orderDashApp,
		orderByDashApp,
		paginaDashApp,
		linhasPorPagDashApp
	};
};
export default connect(mapStateToProps, { mudarDados })(GridPrincipal);
