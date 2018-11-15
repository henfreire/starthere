import { createActions, createReducer } from 'reduxsauce';
export const { Types, Creators } = createActions({
    acaoMensagem: ['payload']
});
const INIT_STATE = {
    mensagemGeral: '',
    mostrarMensagem: false,
};
const acaoMensagem = (state = INIT_STATE, action) => ({
    ...state,
    mensagemGeral: action.payload.mensagem,
    mostrarMensagem: action.payload.mostrar
});


export default createReducer(INIT_STATE, {
    [Types.ACAO_MENSAGEM]: acaoMensagem,
});
