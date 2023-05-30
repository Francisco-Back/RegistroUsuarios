package com.fbacks.RegistroUser.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fbacks.RegistroUser.Entity.UserEntity;

@Component
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
 boolean existsByEmail(String email);
  

}