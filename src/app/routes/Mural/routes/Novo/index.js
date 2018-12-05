import React from "react";
import PropTypes from "prop-types";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";
import FormularioEvento from "components/Mural/Formulario/Form";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft } from "@fortawesome/free-solid-svg-icons";
import Fab from "@material-ui/core/Fab";
import { connect } from "react-redux";
import { Creators as ActionsEventos } from "ducks/Eventos";
class Novo extends React.Component {
  novoMural = ({ values }) => {
    const {usuario} = this.props;
    console.log("values", values, "usuario", usuario);
    let reader = new FileReader();
    reader.onloadend = () => {
      let dados = { ...values, imagem: reader.result, id: usuario.id};
      this.props.addEvento({values: dados});
    };
    reader.readAsDataURL(values.imagem);
  };
  handleVoltar = () => {
    this.props.history.goBack();
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
                  <div className="col col-12">
                    <FormularioEvento onSubmit={this.novoMural} />
                  </div>
                </div>
              </Paper>
            </div>
          </div>
          <div className="row">
            <div className="col-12">
              <div className="d-flex justify-content-start mt-3">
                <Fab color="primary" onClick={this.handleVoltar}>
                  <FontAwesomeIcon icon={faArrowLeft} />
                </Fab>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Novo.propTypes = {};
const mapStateToProps = ({auth}) => {
  const {usuario} = auth;
  return {usuario};
};
const { addEvento } = ActionsEventos;
export default connect(
  mapStateToProps,
  { addEvento }
)(Novo);
