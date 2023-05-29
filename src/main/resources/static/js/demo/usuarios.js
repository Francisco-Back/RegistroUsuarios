// Call the dataTables jQuery plugin
$(document).ready(function() {
	cargarUser();
  $('#UserTable').DataTable();
});


async function  cargarUser(){
const rawResponse =  await fetch('api/Usuarios',{
	method: 'GET',
  headers:{
    'Accept':'application/json',
    'Content-Type': 'application/json'
  },
	
	
});
const usuarios = await rawResponse.json();
console.log(usuarios);

let listadoHtml ='';
for (let usuario of usuarios){

let usuarioHtml  = ' <tr><td>01</td><td>'+usuario.nombre+' '+ usuario.apellido+'</td><td>'+usuario.email+
'</td> <td>'+usuario.telefono+
'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm">  <i class="fas fa-trash"></i></a><a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a></td></tr>' 

listadoHtml += usuarioHtml;
}
document.querySelector('#UserTable tbody').outerHTML = listadoHtml;
}