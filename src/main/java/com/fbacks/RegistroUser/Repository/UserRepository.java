package com.fbacks.RegistroUser.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.fbacks.RegistroUser.Entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query(value = "SELECT * FROM usuarios WHERE correo =:email", nativeQuery = true)
	public List<UserEntity> findByCorreo(String email);





}