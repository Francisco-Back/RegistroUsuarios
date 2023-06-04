package com.fbacks.RegistroUser.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import com.fbacks.RegistroUser.Entity.UserEntity;
import com.fbacks.RegistroUser.Mapper.UserInDTOoUseEntity;
import com.fbacks.RegistroUser.Repository.UserRepository;
import com.fbacks.RegistroUser.Security.Utils.JWTUtil;
import com.fbacks.RegistroUser.Services.DTO.UserlnDTO;
import com.fbacks.RegistroUser.Services.ImServices.ImUserService;
import de.mkammerer.argon2.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


	
@Service
public class UserServices implements ImUserService {
	
	@Autowired
    private JWTUtil jwtUtil;
	@Autowired
	private  UserRepository repository;
	@Autowired
	private  UserInDTOoUseEntity mapper;
	
	 @PersistenceContext
	    EntityManager entityManager;
	
	public UserServices(UserRepository repository, UserInDTOoUseEntity mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	// Regresa el Objeto UserEntity 
		@Override
		public UserEntity createUser(UserlnDTO user) {
			 UserEntity UserE= mapper.map(user);
			    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		        String hash = argon2.hash(1, 1024, 1, UserE.getPassword());
		        UserE.setPassword(hash);
			 
			 
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
	
	
	
	   @Override
	    public UserEntity obtenerUsuarioPorCredenciales(UserlnDTO usuario) {
		   System.out.println("ingresa a credenciales");
		   
		   UserEntity UserE= mapper.map(usuario);
		   System.out.println("cerdencial"+ UserE.getEmail());
		   System.out.println("cerdencial"+ UserE.getPassword());
	        String query = "FROM UserEntity WHERE email = :email";
	        List<UserEntity> lista = entityManager.createQuery(query)
	                .setParameter("email", UserE.getEmail())
	                .getResultList();

	        if (lista.isEmpty()) {
	        	System.out.println("Retorna null lista vacia");
	            return null;
	        }

	        String passwordHashed = lista.get(0).getPassword();

	        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
	        if (argon2.verify(passwordHashed, usuario.getPassword())) {
	        	System.out.println("Retona correcto");
	            return lista.get(0);
	        }
	        System.out.println("no encontro nada");
	        return null;
	    }
}
