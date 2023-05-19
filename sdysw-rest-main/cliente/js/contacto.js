function mostrarContacto(identificador, nombre, numero, apellidos, email) {
	// Función para mostrar la información del contacto en la página
	document.getElementById("identificador").innerText = identificador;
	document.getElementById("nombre").innerText = nombre;
	document.getElementById("numero").innerText = numero;
	document.getElementById("apellidos").innerText = apellidos;
	document.getElementById("email").innerText = email;
}

function actualizarContacto() {
	// Aquí puedes agregar el código para redirigir a la página de edición del contacto
	var id = new URLSearchParams(location.search).get("contacto");
	window.location.href="actualizar.html?contacto="+id;
}

function eliminarContacto(id){
	var id = new URLSearchParams(location.search).get("contacto");
	const url = 'http://127.0.0.1:8080/contactos/'+id;
	const http = new XMLHttpRequest();
	http.open("DELETE", url)
	http.setRequestHeader('Access-Control-Allow-Origin', '*');
	http.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			// Ignore 
		}
		// Independientemente de si ha tenido éxito o no, se vuelve a index.html
		window.location.href="index.html";
	}
	http.send();
}


window.addEventListener('load', function () {

	var id = new URLSearchParams(location.search).get("contacto");
	
	const url = 'http://127.0.0.1:8080/contactos/'+id;
	const http = new XMLHttpRequest()
	http.open("GET", url)
	http.setRequestHeader('Access-Control-Allow-Origin', '*');
	http.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var data = JSON.parse(this.responseText)
			var id = data.id;
			var nombre = data.nombre;
			var numero = data.tlf;
			var apellidos = data.apellidos;
			var email = data.email;
			mostrarContacto(id, nombre, numero, apellidos, email);
		}
	}
	http.send()
})
