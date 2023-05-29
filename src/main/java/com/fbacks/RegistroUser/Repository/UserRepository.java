package com.fbacks.RegistroUser.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fbacks.RegistroUser.Entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query(value = "SELECT * FROM usuarios WHERE correo =:correo", nativeQuery = true)
	public List<UserEntity> findByCorreo(String correo);
}