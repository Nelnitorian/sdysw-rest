function actualizar(){
    var id = new URLSearchParams(location.search).get("contacto");

    const url = 'http://127.0.0.1:8080/contactos/'+id;
    const http = new XMLHttpRequest()
    var params = obten_parametros()
    http.open("PUT", url)
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    http.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            alert("Se ha modificado el contacto correctamente")
        } else {
            alert("Se ha producido un error")
        }
        // Después de mandar la petición volvemos a la página inicial
        window.location.href="index.html";
    }
    http.send(params)
}


function crear(){
    nombre = new URLSearchParams(location.search).get("contacto");
    // document.getElementById("contacto").innerHTML = nombre;

    const url = 'http://127.0.0.1:8080/contactos'
    const http = new XMLHttpRequest()
    var params = obten_parametros()
    http.open("POST", url)
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    http.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            alert("Se ha creado el contacto correctamente")
        } else {
            alert("Se ha producido un error")
        }
        // Después de mandar la petición volvemos a la página inicial
        // window.location.href="index.html";
    }

    http.send(params)

}

function actualiza_boton(){
    var parametros = new URLSearchParams(location.search);
    var b_actualizar = document.getElementById("boton_actualizar");
    if (parametros.size != 0){
        // Actualiza
        b_actualizar.addEventListener("click", actualizar);
        b_actualizar.textContent = "Actualizar";
    } else {
        // Crea
        b_actualizar.addEventListener("click", crear);
        b_actualizar.textContent = "Crear";
    }
}

function obten_parametros(){
    // Esta función se encarga de recoger los datos del formulario y crear los parámetros HTTP

    var nombre = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var numero = document.getElementById("numero").value;
    var email = document.getElementById("email").value;

    return "nombre="+nombre+"&apellidos="+apellidos+"&email="+email+"&tlf="+numero;

}

function rellena_textos(){

	var id = new URLSearchParams(location.search).get("contacto");
	
	const url = 'http://127.0.0.1:8080/contactos/'+id;
	const http = new XMLHttpRequest()
	http.open("GET", url)
	http.setRequestHeader('Access-Control-Allow-Origin', '*');
	http.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var data = JSON.parse(this.responseText)

            document.getElementById("nombre").value = data.nombre;
            document.getElementById("apellidos").value = data.apellidos;
            document.getElementById("numero").value = data.tlf;
            document.getElementById("email").value = data.email;
		}
	}
	http.send()
}

window.addEventListener('load', function () {
    actualiza_boton();
    rellena_textos();
})