// Función para mostrar la información del contacto en la página
		function mostrarContacto(identificador, nombre, numero, apellidos, email) {
			document.getElementById("identificador").innerHTML = identificador;
			document.getElementById("nombre").innerHTML = nombre;
			document.getElementById("numero").innerHTML = numero;
			document.getElementById("apellidos").innerHTML = apellidos;
			document.getElementById("email").innerHTML = email;
		}

		// Función para editar la información del contacto
		function actualizarContacto() {
			// Aquí puedes agregar el código para redirigir a la página de edición del contacto
			var contacto = new URLSearchParams(location.search);
			var nombre = contacto.get("contacto");
			window.location.href="actualizar.html?contacto="+nombre;
			
		}
		function eliminarContacto(){
			const url = 'https://localhost:8080/RELLENAJUANJO'
			const http = new XMLHttpRequest()
			http.open("GET", url)
			http.onreadystatechange = function(){
    		if(this.readyState == 4 && this.status == 200){
				var resultado = JSON.parse(this.responseText);
				//TIENE QUE HACER LA PETICIÓN DE ELIMINAR CONTACTO
			}
			}
			http.send()
		}

var parametros = new URLSearchParams(location.search);
nombre = parametros.get("contacto");
document.getElementById("nombre").innerHTML = nombre;

const url = 'https://localhost:8080/RELLENAJUANJO'
const http = new XMLHttpRequest()
http.open("GET", url)
http.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200){
        var data = JSON.parse(this.responseText)
        //TIENE QUE LLENAR LOS DATOS DEL CONTACTO
        document.getElementById("identificador") = data.id;
        document.getElementById("apellidos") = data.apellidos;
        document.getElementById("numero") = data.numero;
        document.getElementById("email") = data.email;
    }
}
http.send()

// Llamar a la función mostrarContacto con los datos del contacto
mostrarContacto(id, nombre, numero, apellidos, email);