package com.fbacks.RegistroUser.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fbacks.RegistroUser.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	// List<UserEntity> findByEmail(String email);

@Query( value= "SELECT email FROM usuarios WHERE usuario.email LIKE %:filtro%", nativeQuery=true)
	boolean buscar(@Param("filtro") String email);



}