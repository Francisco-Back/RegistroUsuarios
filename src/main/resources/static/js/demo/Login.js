async function  LoginUser(){
    let datos= {};
  
    datos.email = document.getElementById('exampleInputEmail').value;
    datos.password = document.getElementById('exampleInputPassword').value;
    
 
    
  const rawResponse =  await fetch('api/LoginUser',{
      method: 'POST',
    headers:{
      'Accept':'application/json',
      'Content-Type': 'application/json'
    },body: JSON.stringify(datos)
  });
  const respuesta = await rawResponse.text();

  if(respuesta == 'OK'){
console.log("Si ingresa");
      window.location.href= 'Usertables.html'
  }else{
    alert("las credencaciales son incorrectas")
 
  }
  
  }