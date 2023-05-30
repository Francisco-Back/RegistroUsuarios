package com.fbacks.RegistroUser.Security.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Repository.UserRepository;
import com.fbacks.RegistroUser.Security.Mapper.LoginInDTOLoginEntity;
import com.fbacks.RegistroUser.Security.Services.DTO.LoginInDTO;
import com.fbacks.RegistroUser.Security.Services.ImServices.ImLoginServices;




@Service
public class LoginServices implements ImLoginServices {

    @Autowired
     UserRepository repository;
    @Autowired
    LoginInDTOLoginEntity mapper;
	
	
	public LoginServices(UserRepository repository, LoginInDTOLoginEntity mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
   public UserEntity Search(Long Id) {
	return this.repository.findById(Id).get();
   }

	
	@Override
	public boolean LoginUser(LoginInDTO loginInDTO) {
		 return repository.existsByEmail(loginInDTO.getEmail());
	}



	
	
	
}
