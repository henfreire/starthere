import React from "react";
import PropTypes from "prop-types";
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Typography";

import Filtros from "components/Eventos/Filtros";
import Opcoes from "components/Eventos/Opcoes";
import Cards from "components/Eventos/Cards";

class Lista extends React.Component {
  novoEventoTela = () => {
    this.props.history.push(`${this.props.match.url}/novo`);
  };

  render() {
    const { opcoes, filtros } = this.props;
    return (
      <div className="app-wrapper">
        <div className="animated slideInUpTiny animation-duration-3">
          <Typography variant="h6" gutterBottom>
            Eventos
          </Typography>
          <div className="row">
            <div className="col col-6">{filtros != false && <Filtros />}</div>
            <div className="col col-6">
              <div className="d-flex justify-content-end">
                {opcoes != false && <Opcoes novoEvento={this.novoEventoTela} />}
              </div>
            </div>
          </div>
          <div className="row mt-2">
            <div className="col col-12">
              <Cards />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Lista;
