var parametros = new URLSearchParams(location.search);
var nombre;
 if(parametros.size != 0){
	 nombre = parametros.get("contacto");
	 document.getElementById("nombre").innerHTML = nombre;
	 }else{
		 document.getElementById("titulo").innerHTML = "Creación de contacto";
	 }

function actualizar(){
	var parametros = new URLSearchParams(location.search);
nombre = parametros.get("contacto");
document.getElementById("contacto").innerHTML = nombre;

const url = 'https://localhost:8080/RELLENAJUANJO'
const http = new XMLHttpRequest()
http.open("GET", url)
http.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200){
        var data = JSON.parse(this.responseText)
        //TIENE QUE COGER LOS DATOS DEL FORMULARIO Y ENVIARLOS AL SERVIDOR PARA ACTUALIZAR EL CONTACTO
        data.nombre = document.getElementById("nombre").innerHTML;
        data.identificador = document.getElementById("identificador").innerHTML;
        data.apellidos = document.getElementById("apellidos").innerHTML;
        data.numero = document.getElementById("numero").innerHTML;
        data.email = document.getElementById("email").innerHTML;
    }
}
http.send()
}