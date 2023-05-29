



async function  RegistrarUser(){
  let datos= {};
  datos.nombre= document.getElementById('exampleFirstName').value;
  datos.apellido = document.getElementById('exampleLastName').value;
  datos.email = document.getElementById('exampleInputEmail').value;
  datos.password = document.getElementById('exampleInputPassword').value;
  
  let repetirpassword = document.getElementById('exampleRepeatPassword').value;
  if(repetirpassword != datos.password){
alert('Contraseña diferente');
return;
  }
  
const rawResponse =  await fetch('api/Usuarios',{
	method: 'POST',
  headers:{
    'Accept':'application/json',
    'Content-Type': 'application/json'
  },body: JSON.stringify(datos)
	
	
});
console.log(rawResponse);
alert('Usuairo Creado Correctamente');
location.href = 'login.html';

}