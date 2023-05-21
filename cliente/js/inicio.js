function agregarContacto(){
  // Si se quiere agregar contacto, se manda a la página de creación de contacto
	window.location.href="actualizar.html";
}

function filtrar(){
    //Se recoge el valor de la barra de filtro
    var nombrefiltrado = document.getElementById("filtro").value;
    //Se borran los contactos que salen en pantalla
    var listaNombres = document.getElementById("lista-nombres");
    listaNombres.innerHTML = "";
    // Se lanza una petición para obtener todos los contactos en base de datos
  const url = 'http://127.0.0.1:8080/contactos'
  const http = new XMLHttpRequest()
  http.open("GET", url)
  // http.setRequestHeader('Access-Control-Allow-Origin', '*');
  http.onreadystatechange = function(){
      if(this.readyState == 4 && this.status == 200){
        var data = JSON.parse(this.responseText)
        var listaNombres = document.getElementById("lista-nombres");
        for (var i = 0; i < data.length; i++) {
            var nombre = data[i].nombre;

	    if(nombre.startsWith(nombrefiltrado) || nombrefiltrado == ""){
		var id = data[i].id;
		var li = document.createElement("li");
		var enlace = document.createElement("a");

		li.setAttribute("id", nombre);
		enlace.setAttribute("href", "contacto.html?contacto=" + id);
		enlace.textContent = nombre;
		li.appendChild(enlace);
		listaNombres.appendChild(li);
	    }
        }
      }
  }
  http.send()
}

window.addEventListener('load', function () {
  // Se lanza una petición para obtener todos los contactos en base de datos
  const url = 'http://127.0.0.1:8080/contactos'
  const http = new XMLHttpRequest()
  http.open("GET", url)
  // http.setRequestHeader('Access-Control-Allow-Origin', '*');
  http.onreadystatechange = function(){
      if(this.readyState == 4 && this.status == 200){
        var data = JSON.parse(this.responseText)
        var listaNombres = document.getElementById("lista-nombres");
        for (var i = 0; i < data.length; i++) {
          var nombre = data[i].nombre;
          var id = data[i].id;
  
          var li = document.createElement("li");
          var enlace = document.createElement("a");
  
          li.setAttribute("id", nombre);
          enlace.setAttribute("href", "contacto.html?contacto=" + id);
          enlace.textContent = nombre;
  
          li.appendChild(enlace);
          listaNombres.appendChild(li);
        }
      }
  }
  http.send()
})
