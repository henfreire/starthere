import React from 'react';
import SituacaoLabel from './SituacaoLabel';
import BarraComprovacao from './BarraComprovacao';
import EmpresaLabel from './EmpresaLabel';
import RotaLabel from './RotaLabel';
const Colunas = (dados) => {
	const {} = dados;
	const colunas = [
		{
			name: 'Rota',
			options: {
				filter: true,
				sort: true,
				customBodyRender: (value, tableMeta, updateValue) => {
					return <RotaLabel valor={value} texto={`Rota ${value}`} tipo="Rota" />;
				}
			}
		},
		{
			name: 'Romaneio',
			options: {
				filter: true,
				sort: true
			}
		},
		{
			name: 'Motorista',
			options: {
				filter: true,
				sort: false
			}
		},
		{
			name: 'Data Romaneio',
			options: {
				filter: true,
				sort: false
			}
		},
		{
			name: 'Remetente',
			options: {
				filter: true,
				customBodyRender: (value, tableMeta, updateValue) => {
					return <EmpresaLabel texto={value} />;
				}
			}
		},
		{
			name: 'Entregues',
			options: {
				filter: true,
				customBodyRender: (value, tableMeta, updateValue) => {
					return <SituacaoLabel valor={value} texto={'Entregues'} tipo="Entregue" />;
				}
			}
		},
		{
			name: 'Abertas',
			options: {
				filter: true,
				customBodyRender: (value, tableMeta, updateValue) => {
					return <SituacaoLabel valor={value} texto={'Abertas'} tipo="Aberta" />;
				}
			}
		},
		{
			name: 'Volume',
			options: {
				filter: true,
				sort: true
			}
		},
		{
			name: 'Total Notas',
			options: {
				filter: true,
				sort: false
			}
		},
		{
			name: 'Comprovação',
			options: {
				filter: true,
				customBodyRender: (value, tableMeta, updateValue) => {
					return <BarraComprovacao porcentagem={value} />;
				}
			}
		}
	];

	return colunas;
};
export default Colunas;
