package com.fbacks.RegistroUser.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fbacks.RegistroUser.services.dto.UserInDTO;



@RestController
@RequestMapping("api/Usuarios")
public class UserController {

	
	@PostMapping
	public ResponseEntity<?> CreateUser(@RequestBody UserInDTO userIn){
		
		return ResponseEntity<?>userIn;
				
				//ResponseEntity<>();
		
	}
	
	
	
}
