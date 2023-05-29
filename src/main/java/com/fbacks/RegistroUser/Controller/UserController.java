package com.fbacks.RegistroUser.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fbacks.RegistroUser.Services.UserServices;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;




@RestController
@RequestMapping("api/Usuarios")
public class UserController {

	
	@Autowired
	private final UserServices userservices;
	
	
	
	public UserController(UserServices userservices) {
		this.userservices = userservices;
	}
	

	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody  UserlnDTO userlnDTO  ) {
		return new ResponseEntity<>(userservices.createUser(userlnDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getlistUser() {
		System.out.println("datos ");
		return ResponseEntity.ok(userservices.SetUser());
	}
	

	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?> EliminarLiga(@PathVariable Long id){
		
		userservices.DeleteUser(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
