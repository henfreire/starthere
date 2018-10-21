import React from 'react';
import ContainerHeader from 'components/ContainerHeader/index';
import IntlMessages from 'util/IntlMessages';
import { FormGroup, Input, Paper, Grid, Button, Typography, TextField } from '@material-ui/core';

class Login extends React.Component {

    render() {
        return (
            <div className="app-wrapper">
							<Grid container justify="center" >
								<Grid  xs={6} sm={6}>
									<Paper>
										<Grid item alignItems="center" >
											<Typography align="center" variant="title">Login</Typography>
											<FormGroup>
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
											</FormGroup> 
											<Grid alignItems="center">
												<Button variant="outlined" size="medium">Entrar</Button>
											</Grid>
										</Grid>
									</Paper>
								</Grid>
							</Grid>
            </div>
        );
    }
}

export default Login;