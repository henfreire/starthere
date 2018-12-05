import { createActions, createReducer } from "reduxsauce";

export const { Types, Creators } = createActions({
  buscarTodosMural: ["payload"],
  buscarTodosMuralSucesso: ["payload"],
  addMural: ["payload"],
  addMuralSucesso: ["payload"],
  setMuralMensagem: ["payload"]
});
const INIT_STATE = {
  listaMurals: []
};
const buscarMurals = (state = INIT_STATE, action) => {
	return {
	  ...state,
	  listaMurals: action.payload.Murals
	};
  };
const addMurals = (state = INIT_STATE, action) => {
  return {
    ...state
  };
};
export default createReducer(INIT_STATE, {
  [Types.BUSCAR_TODOS_MURAL_SUCESSO]: buscarMurals
});
