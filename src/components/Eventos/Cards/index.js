import React, { Component } from "react";
import PropTypes from "prop-types";
import Card from "../Card";
import { connect } from "react-redux";
import { Creators as ActionsEventos } from "ducks/Eventos";
class Cards extends Component {
  UNSAFE_componentWillMount() {
    this.props.buscarTodosEventos();
  }
  render() {
    const { listaEventos } = this.props;
    return (
      <div className="row">
        {listaEventos.map((item, index) => (
          <div className="col-lg-6 col-xs-12  mt-2">
            <Card item={item} numero={index + 1} />
          </div>
        ))}
      </div>
    );
  }
}

Cards.propTypes = {};
const mapStateToProps = ({ eventos }) => {
  const { listaEventos } = eventos;
  return {
    listaEventos
  };
};
const { buscarTodosEventos } = ActionsEventos;

export default connect(
  mapStateToProps,
  { buscarTodosEventos }
)(Cards);
