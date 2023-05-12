/* ECMAScript para el inicio de la aplicación*/
function agregarContacto(){
	window.location.href="actualizar.html";
}

//Código que se ejecuta al cargar la página.
const url = 'https://localhost:8080/RELLENAJUANJO'
const http = new XMLHttpRequest()
http.open("GET", url)
http.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200){
        var data = JSON.parse(this.responseText)
        //TIENE QUE LLENAR LA LISTA CON LOS NOMBRES DE LOS CONTACTOS
        var listaNombres = document.getElementById("lista-nombres");
    for (var i = 0; i < data.length; i++) {
      var nombre = data[i].nombre;
      var li = document.createElement("li");
      li.setAttribute("id", nombre);
      var enlace = document.createElement("a");
      enlace.setAttribute("href", "contacto.html?contacto=" + nombre);
      enlace.textContent = nombre;
      li.appendChild(enlace);
      listaNombres.appendChild(li);
    }
    }
}
http.send()