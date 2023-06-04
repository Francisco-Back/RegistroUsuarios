package com.fbacks.RegistroUser.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fbacks.RegistroUser.Security.Utils.JWTUtil;
import com.fbacks.RegistroUser.Services.UserServices;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;




@RestController
@RequestMapping("api/Usuarios")
public class UserController {

	
	@Autowired
	private UserServices userservices;
	 @Autowired
	    private JWTUtil jwtUtil;

	

	

	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody  UserlnDTO userlnDTO  ) {
		return new ResponseEntity<>(userservices.createUser(userlnDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getlistUser(@RequestHeader(value="Authorization") String token) {
		System.out.println("datos, ");
		 if (!validarToken(token)) {new ResponseEntity<>(HttpStatus.UNAUTHORIZED); }
		return ResponseEntity.ok(userservices.SetUser());
	}
	
	
	
	   private boolean validarToken(String token) {
	        String usuarioId = jwtUtil.getKey(token);
	        return usuarioId != null;
	    }
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> SearchUser(@RequestHeader(value="Authorization") String token
			,@PathVariable("id") long id) throws Exception{
		 if (!validarToken(token)) {new ResponseEntity<>(HttpStatus.UNAUTHORIZED); }
		return ResponseEntity.status(HttpStatus.OK).body(userservices.Search(id));
	}
	

	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?> EliminarLiga(@RequestHeader(value="Authorization") String token,@PathVariable Long id){
		 if (!validarToken(token)) { new ResponseEntity<>(HttpStatus.UNAUTHORIZED); }
		userservices.DeleteUser(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
