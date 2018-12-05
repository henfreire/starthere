import React, { Component } from "react";
import ListaEventos from "app/routes/Eventos/routes/Lista/";
import ListaMural from "app/routes/Mural/routes/Lista/";
class Home extends Component {
  render() {
    return (
      <div className="row">
        <div className="col-6 col-xs-12">
          <ListaEventos />
        </div>
        <div className="col-6 col-xs-12">
          <ListaMural />
        </div>
      </div>
    );
  }
}

export default Home;
