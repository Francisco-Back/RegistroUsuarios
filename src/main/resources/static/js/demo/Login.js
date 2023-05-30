async function  LoginUser(){
    let datos= {};
  
    datos.email = document.getElementById('exampleInputEmail').value;
    datos.password = document.getElementById('exampleInputPassword').value;
    
 
    
  const rawResponse =  await fetch('api/Login',{
      method: 'POST',
    headers:{
      'Accept':'application/json',
      'Content-Type': 'application/json'
    },body: JSON.stringify(datos)
      
      
  });
  const respuesta = await rawResponse.json();
  console.log(rawResponse);
  
  }