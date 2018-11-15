import { LOGIN_SUCESSO, FAZER_LOGIN } from "constants/ActionTypes";

export const fazerLogin = (dados) => {
    return {
        type: FAZER_LOGIN,
        payload: dados
    }
}
export const loginSucesso = (dados) => {
    return {
        type: LOGIN_SUCESSO,
        payload: dados
    }
}