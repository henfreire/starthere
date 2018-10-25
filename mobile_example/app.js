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
		senha: $('#loginSenha').val()
	};

	route = 'usuario/login';	

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

	route = "usuario/";

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
