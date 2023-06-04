package com.fbacks.RegistroUser.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Security.Utils.JWTUtil;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;
import com.fbacks.RegistroUser.Services.ImServices.ImUserService;






@RestController
@RequestMapping("api/LoginUser")
public class AuthController {

    @Autowired
    private ImUserService  imuserService;

    @Autowired
    private JWTUtil jwtUtil;

 /* @PostMapping
    public String login(@RequestBody UserlnDTO usuario) {

        UserEntity usuarioLogueado = imuserService.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
        	System.out.println("Usuario creado");
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            
            return tokenJwt;
        }
        return "FAIL";
    }*/
  
  @PostMapping
	public ResponseEntity<?> login(@RequestBody  UserlnDTO usuario  ) {
	  
	  UserEntity usuarioLogueado = imuserService.obtenerUsuarioPorCredenciales(usuario);
      if (usuarioLogueado != null) {
      	System.out.println("Usuario creado");
          String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
          System.out.println("retornatokien");
          return ResponseEntity.ok(tokenJwt);
          
      }
      System.out.println("faill ffdf");
      return  new ResponseEntity<>(HttpStatus.FOUND);
	  
	}

}
