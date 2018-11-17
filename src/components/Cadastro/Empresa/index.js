import React from 'react';
import {FormularioSequencia} from './Formulario';
import CardBox from 'components/CardBox';

const CadastroEmpresa = ({ match }) => {
  return (
    <div className="animated slideInUpTiny animation-duration-3">
      <div className="row">
        <CardBox styleName="col-md-12 col-lg-12" childrenStyle="d-flex justify-content-center"
          heading={"Cadastro"}
          headerOutside>
          <FormularioSequencia />
        </CardBox>
      </div>
    </div>
  );
};

export default (CadastroEmpresa);
