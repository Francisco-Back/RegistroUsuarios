package com.fbacks.RegistroUser.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fbacks.RegistroUser.Security.Services.LoginServices;
import com.fbacks.RegistroUser.Security.Services.DTO.LoginInDTO;





@RestController
@RequestMapping("api/LoginUser")
public class LoginController {
	

	@Autowired
	private final LoginServices loginServices;
	
	public LoginController(LoginServices loginServices) {
		this.loginServices = loginServices;
	}
	
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> SearchUser(@PathVariable("id") long id) throws Exception{
		try {
		
			return ResponseEntity.status(HttpStatus.OK).body(loginServices.Search(id));
			
		} catch (Exception e) {
			System.out.println(e);
		}
   return new ResponseEntity<>(HttpStatus.CONFLICT);
	
	}
	
	@PostMapping
	public ResponseEntity<?> LoginUser(@RequestBody LoginInDTO loginInDTO){
		return new ResponseEntity<>(loginServices.LoginUser(loginInDTO),HttpStatus.OK);
		
	}

	
	
}
