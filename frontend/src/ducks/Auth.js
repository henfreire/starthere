import { createActions, createReducer } from 'reduxsauce';

export const { Types, Creators } = createActions({
    login: ['payload'],
    loginSucesso: ['payload']
});
const INIT_STATE = {
    loader: false,
    showMessage,
    usuario: {
        nome: 'Usuário'
    }
};
const loginSucesso = (state = INIT_STATE, action) => ({
    ...state,
    usuario: action.payload,
    loader: false
})

export default createReducer({
    [Types.LOGIN_SUCESSO]: loginSucesso
});