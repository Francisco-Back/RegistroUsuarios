package com.fbacks.RegistroUser.Security.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Repository.UserRepository;
import com.fbacks.RegistroUser.Security.Services.ImServices.ImLoginServices;




@Service
public class LoginServices implements ImLoginServices {

	
	private final UserRepository repository;

	
	public LoginServices(UserRepository repository) {
		this.repository = repository;
		
	}

	
	@Override
   public UserEntity Search(Long Id) {
	return this.repository.findById(Id).get();
   }

	
	@Override
	public boolean LoginUser(String Email, String Pass) {
	
			System.out.println(Email);	
			
			repository.buscar(Email);
		 return true;
				 
				 
	}



	
	
	
}
