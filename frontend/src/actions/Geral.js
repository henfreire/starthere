import {MOSTRAR_MENSAGEM, ESCONDER_MENSAGEM } from "constants/ActionTypes";

export const mostrarMensagem = (dados) => {
    return {
        type: MOSTRAR_MENSAGEM,
        payload: dados
    }
}
export const esconderMensagem = () => {
    return {
        type: ESCONDER_MENSAGEM,    
    }
}