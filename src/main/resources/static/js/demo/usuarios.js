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
  let BotonEliminar= '<a href="#" onclick="EliminarUser('+ usuario.id+')" class="btn btn-danger btn-circle btn-sm">  <i class="fas fa-trash"></i></a><a href="#" onclick class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>'
let usuarioHtml  = ' <tr><td>01</td><td>'+usuario.nombre+' '+ usuario.apellido+'</td><td>'+usuario.email+
'</td> <td>'+usuario.telefono+
'</td><td>'+BotonEliminar+'</td></tr>' 

listadoHtml += usuarioHtml;
}
document.querySelector('#UserTable tbody').outerHTML = listadoHtml;
}

async function EliminarUser(id){
if(confirm('¿Desea eliminar el Usuario')){
  const rawResponse =  await fetch('api/Usuarios/Delete/'+ id,{
    method: 'DELETE',
    headers:{
      'Accept':'application/json',
      'Content-Type': 'application/json'
    },
    
    
  });
  console.log(rawResponse);
  location.reload();
}else{
return;
}


}