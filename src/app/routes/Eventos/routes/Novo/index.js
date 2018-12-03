import React from "react";
import PropTypes from "prop-types";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";
import FormularioEvento from "components/Eventos/Formulario/Form";
class Novo extends React.Component {
  novoEvento = ({ values }) => {
    console.log("values", values);
  };
  render() {
    return (
      <div className="app-wrapper">
        <div className="animated slideInUpTiny animation-duration-3">
          <div className="row">
            <div className="col-12">
              <Typography variant="h6" gutterBottom>
                Novo Evento
              </Typography>
              <Paper className="p-2">
                <div className="row">
                  <div className="col col-6">
                    <FormularioEvento onSubmit={this.novoEvento} />
                  </div>
                </div>
              </Paper>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Novo.propTypes = {};

export default Novo;
