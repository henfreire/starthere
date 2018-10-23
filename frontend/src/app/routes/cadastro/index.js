import React from 'react';
import ContainerHeader from 'components/ContainerHeader/index';
import IntlMessages from 'util/IntlMessages';
import { FormGroup, Input, Paper, Grid, Button, Typography } from '@material-ui/core';

class Cadastro extends React.Component {

	render() {
		return (
			<div className="app-wrapper">
				<Grid container justify="center" >
					<Grid  xs={6} sm={6}>
						<Paper>
							<Grid item alignItems="center" >
								<Typography>Login</Typography>
								<FormGroup>
									<TextField 
										id="outlined-name" 
										label="Name" 
										margin="normal"
										variant="outlined"/>
									
									<TextField 
										id="outlined-email-input" 
										label="Email" 
										type="email" 
										name="email"
										autoComplete="email"
										margin="normal"
										variant="outlined"/>

									<TextField 
										id="outlined-password-input"
										label="Senha"
										type="password"
										autoComplete="current-password"
										margin="normal"
										variant="outlined"/>

									<TextField
										id="filled-select-currency-native"
										select
										label="Categoria"
										helperText="Selecione a categoria"
										margin="normal"
										variant="filled"
									>
										<option>Startup</option>
										<option>Empresa</option>
										<option>Investidor</option>
									</TextField>	
								</FormGroup> 
								<Button>Cadastrar</Button>
							</Grid>
						</Paper>
					</Grid>
				</Grid>
			</div>
		);
	}
}

export default Cadastro;