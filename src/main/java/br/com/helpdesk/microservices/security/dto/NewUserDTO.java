package br.com.helpdesk.microservices.security.dto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class NewUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 250, message = "Tamanho inválido")
	private String fullName;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String username;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String password;
	
	private ArrayList<Long> roleIds;
	
	public NewUserDTO() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(ArrayList<Long> roleIds) {
		this.roleIds = roleIds;
	}
}
