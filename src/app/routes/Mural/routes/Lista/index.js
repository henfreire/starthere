import React from "react";
import PropTypes from "prop-types";
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Typography";

import Filtros from "components/Mural/Filtros";
import Opcoes from "components/Mural/Opcoes";
import Cards from "components/Mural/Cards";

class Lista extends React.Component {
  novoMuralTela = () => {
    this.props.history.push(`${this.props.match.url}/novo`);
  };

  render() {
    const { opcoes, filtros } = this.props;
    return (
      <div className="app-wrapper">
        <div className="animated slideInUpTiny animation-duration-3">
          <Typography variant="h6" gutterBottom>
            Mural
          </Typography>
          <div className="row">
            <div className="col col-6">{opcoes != false && <Filtros />}</div>
            <div className="col col-6">
              <div className="d-flex justify-content-end">
                {filtros != false && <Opcoes novoEvento={this.novoMuralTela} />}
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
