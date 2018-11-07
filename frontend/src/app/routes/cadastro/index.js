import React, { Component } from 'react';
import PropTypes from 'prop-types';
import CadastroEmpresa from 'components/Cadastro/Empresa';
class index extends Component {
    render() {
        return (
            <div className="app-wrapper">
                <div className="animated slideInUpTiny animation-duration-3">
                    <div className="row">
                        <div className="col-md-12">
                            <CadastroEmpresa />
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

index.propTypes = {

};

export default index;