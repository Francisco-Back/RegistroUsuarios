package com.fbacks.RegistroUser.Entity;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="telefono")
	private String telefono;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	



}
