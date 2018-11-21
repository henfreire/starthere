import React, { Component } from 'react';
import PropTypes from 'prop-types';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Typography';
import Filtros from 'components/Eventos/Components/Filtros';
import Cards from 'components/Eventos/Components/Cards';
class index extends Component {
    render() {
        return (
            <div className="app-wrapper">
                <div className="animated slideInUpTiny animation-duration-3">
                    <Typography variant="title" gutterBottom> Eventos</Typography>
                    <div className="row">
                        <div className="col col-12">
                            <Filtros />
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

index.propTypes = {

};

export default index;