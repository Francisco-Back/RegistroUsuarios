package com.fbacks.RegistroUser.Mapper;

import org.springframework.stereotype.Component;

import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;

import jakarta.persistence.Column;

@Component
public class UserInDTOoUseEntity implements IMapper<UserlnDTO, UserEntity>{

	@Override
	public UserEntity map(UserlnDTO in){
		
	UserEntity UserE=new UserEntity();
	UserE.setNombre(in.getNombre());
	UserE.setApellido(in.getApellido());
	UserE.setEmail(in.getEmail());
	UserE.setPassword(in.getPassword());
		return UserE;
	}

}
