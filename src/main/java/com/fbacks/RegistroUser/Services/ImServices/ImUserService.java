package com.fbacks.RegistroUser.Services.ImServices;

import java.util.List;

import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;

public interface ImUserService {

	List<UserEntity> SetUser();

	UserEntity createUser(UserlnDTO user);

	void DeleteUser(Long Id);

}
