import React, { Component } from 'react';
import PropTypes from 'prop-types';
import Card from '../Card';
class Filtros extends Component {
    render() {
        return (
            <div className="row">
                {[...Array(10)].map((key , index)=> <div className="col col-md-3 mt-2"><Card numero={index + 1}/></div>)}
            </div>
        );
    }
}

Filtros.propTypes = {

};

export default Filtros;