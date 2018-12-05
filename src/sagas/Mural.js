import { all, call, fork, put, takeEvery } from "redux-saga/effects";
import { Creators as ActionsMural, Types } from "ducks/Mural";
import api from "../api/api";

const buscarTodosMuralsRequest = async dados =>
  api
    .post("/evento/getAll/", dados)
    .then(result => result)
	.catch(error => error);

const addMuralRequest = async dados =>
	api
	  .post("/evento/add/", dados)
	  .then(result => result)
	  .catch(error => error);	
	

function* buscarTodosMurals({ payload }) {
  let mensagem = "";
  let result = null;

  try {
    const dados = {};
    const response = yield call(buscarTodosMuralsRequest, dados);
    console.log("response", response);
    if (response.ok) {
      result = response.data;
      console.log("result", result);
    } else if (Object.prototype.hasOwnProperty.call(response.data, "error")) {
      switch (response.data.error) {
        case "Unauthorised":
          mensagem = "Os dados não estão corretos";
          break;
        default:
          mensagem = "Ocorreu um erro inusitado. Tente novamente";
          break;
      }
    } else {
      mensagem = "Ocorreu um erro interno.Tente novamente";
    }

    if (result !== null) {
      yield put(ActionsMural.buscarTodosMuralsSucesso(result));
    } else {
      yield put(
        ActionsMural.setMuralMensagem({ mensagem: mensagem, mostrar: true })
      );
    }
  } catch (error) {
    yield put(ActionsMural.setMuralMensagem(error));
  }
}
function* addMural({ payload }) {
	let result = null;
  let mensagem = "";
  const {values}= payload;
	try {
    const dados = {};
    let formData = new FormData();
   
    for (let key in values){
      formData.append(key, values[key]);
    }
	  const response = yield call(addMuralRequest, formData);
	  console.log("response", response);
	  if (response.ok) {
		result = response.data;
		console.log("result", result);
	  } else if (Object.prototype.hasOwnProperty.call(response.data, "error")) {
		switch (response.data.error) {
		  case "Unauthorised":
			mensagem = "Os dados não estão corretos";
			break;
		  default:
			mensagem = "Ocorreu um erro inusitado. Tente novamente";
			break;
		}
	  } else {
		mensagem = "Ocorreu um erro interno.Tente novamente";
	  }
  
	  if (result !== null) {
		yield put(ActionsMural.addMuralSucesso(result));
	  } else {
		yield put(
		  ActionsMural.setMuralMensagem({ mensagem: mensagem, mostrar: true })
		);
	  }
	} catch (error) {
    console.log("error",error)
	  yield put(ActionsMural.setMuralMensagem(error));
	}
  }

export function* buscarTodosMuralsAcao() {
  yield takeEvery(Types.BUSCAR_TODOS_EVENTOS, buscarTodosMurals);
}
export function* addMuralAcao() {
  yield takeEvery(Types.ADD_EVENTO, addMural);
}
export default function* rootSaga() {
  yield all([fork(buscarTodosMuralsAcao), fork(addMuralAcao)]);
}
