package com.fbacks.RegistroUser.Security.Services.ImServices;

import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Security.Services.DTO.LoginInDTO;




public interface ImLoginServices {

	UserEntity Search(Long Id);


	boolean LoginUser(LoginInDTO loginInDTO);
	
	

}
