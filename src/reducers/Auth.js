import { LOGIN_SUCESSO } from "constants/ActionTypes";
const INIT_STATE = {
    loader: false,
    usuario: {
        nome: 'Usuário'
    }
};
export default (state = INIT_STATE, action) => {
    switch (action.type) {
        case LOGIN_SUCESSO: {
            return {
                ...state,
                loader: false,
                usuario: action.payload
            }
        }
        default:
            return state;
    }
}