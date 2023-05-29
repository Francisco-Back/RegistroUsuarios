package com.fbacks.RegistroUser.Services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Mapper.UserInDTOoUseEntity;
import com.fbacks.RegistroUser.Repository.UserRepository;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;
import com.fbacks.RegistroUser.Services.ImServices.ImUserService;

@Service
public class UserServices implements ImUserService {
	
	private final UserRepository repository;
	private final UserInDTOoUseEntity mapper;
	
	
	
	public UserServices(UserRepository repository, UserInDTOoUseEntity mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	// Regresa el Objeto UserEntity 
		@Override
		public UserEntity createUser(UserlnDTO user) {
			 UserEntity UserE= mapper.map(user);
			return this.repository.save(UserE);	
		}
	
	@Override
    public List<UserEntity> SetUser(){
		
	return (List<UserEntity>) this.repository.findAll();
	}
	
	@Override
	public void DeleteUser(Long Id) {
		this.repository.deleteById(Id);
	}

	@Override
public UserEntity Search(Long Id) {
	return this.repository.findById(Id).get();
}
	

}
