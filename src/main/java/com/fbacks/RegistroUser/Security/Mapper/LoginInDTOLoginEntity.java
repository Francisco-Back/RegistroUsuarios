package com.fbacks.RegistroUser.Security.Mapper;

import org.springframework.stereotype.Component;



import com.fbacks.RegistroUser.Mapper.IMapper;
import com.fbacks.RegistroUser.Security.Services.DTO.LoginInDTO;

@Component
public class LoginInDTOLoginEntity implements IMapper<LoginInDTO, LoginInDTO>{
	
	@Override
	public LoginInDTO map(LoginInDTO in){
		
		LoginInDTO UserE=new LoginInDTO();
	UserE.setPassword(in.getPassword());
	UserE.setEmail(in.getEmail());
		return UserE;
	}

}
