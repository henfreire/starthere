import React from "react";
import PropTypes from "prop-types";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendarPlus } from "@fortawesome/free-solid-svg-icons";
import Fab from "@material-ui/core/Fab";
import Tooltip from "@material-ui/core/Tooltip";
const Opcoes = ({ novoEvento }) => {
  const handleClick = () => {
    novoEvento();
  };
  return (
    <div>
      <Tooltip title="Acionar Mural">
        <Fab color="primary" onClick={handleClick}>
          <FontAwesomeIcon icon={faCalendarPlus} size="2x" />
        </Fab>
      </Tooltip>
    </div>
  );
};

export default Opcoes;
