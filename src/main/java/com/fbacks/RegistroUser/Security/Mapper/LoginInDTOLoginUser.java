package com.fbacks.RegistroUser.Security.Mapper;

import org.springframework.stereotype.Component;

import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Mapper.IMapper;

@Component
public class LoginInDTOLoginUser  implements IMapper<LoginUser, UserEntity  >{
	
	
	@Override
	public UserEntity map(LoginUser in){
		
	UserEntity UserE=new UserEntity();
UserE.setEmail(in.getEmail());
UserE.setPassword(in.getPassword());
	
		return UserE;
	}
}
