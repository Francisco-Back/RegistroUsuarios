package com.fbacks.RegistroUser.Entity;

import lombok.Data;

@Data
public class Usuarios {
	private Long id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String password;


}
