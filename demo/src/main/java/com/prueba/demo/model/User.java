package com.prueba.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Access(AccessType.FIELD)
public class User extends PadreEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name="primer_nombre", nullable= false, length=255)
	private String primerNombre;
	
	@Column(name="segundo_nobre", nullable= true, length=255)
	private String segundoNobre;
	
	@Column(name="primer_apellido", nullable= false, length=255)
	private String primerApellido;
	
	@Column(name="segundo_apellido", nullable= true, length=255)
	private String segundoApellido;
	
	@Column(name="celular", nullable= true, length=30)
	private String celular;
	
	@Column(name="direccion", nullable= false, length=150)
	private String direccion;
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNobre() {
		return segundoNobre;
	}
	public void setSegundoNobre(String segundoNobre) {
		this.segundoNobre = segundoNobre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
