/*
	Author: github.com/thiguet

	Special thanks to github user blueimp (github.com/blueimp), 
	who had the MD5 JS lib.

	Link: https://github.com/blueimp/JavaScript-MD5/
*/

var SERVER_URL = "http://127.0.0.1:7201/";

var sendRequest =  (route, jsonData) => {
	return $.post({
		url: SERVER_URL + route, 
		data: jsonData
	});
};

$('#loginBtn').click(() => {
	var data = {
		email : $('#loginEmail').val(),
		// senha: md5($('#loginSenha').val())
		senha: $('#loginSenha').val()
	};

	route = 'login';	

	sendRequest(route, data).then((response) => {
		localStorage.setItem('loginId', response['id']);
	});
});

$('#cadUsuarioBtn').click(() => {

	var data = {
		nome : $('#cadUsuarioNome').val(),
		senha: $('#cadUsuarioSenha').val(),
		email: $('#cadUsuarioEmail').val()
	};	

	var categoria = $('#cadUsuarioCategoria').val();

	route = "";

	if(categoria === "Empresa") {
		route += "empresa";
	} else if(categoria === "Startup") {
		route += "startup";
	} else if(categoria === "Investidor") {
		route += "investidor";
	}

	route += '/add';

	sendRequest(route, data);
});

$('#cadEventoBtn').click(() => {
	var data = {
		nome : $('#cadEventoNome').val(),
		dataEvento: $('#cadEventoData').val(),
		descricao: $('#cadEventoDescricao').val(),
		idEmpresa: localStorage.getItem('loginId')
	};
	
	route = 'evento/add';
	
	sendRequest(route, data);
});
