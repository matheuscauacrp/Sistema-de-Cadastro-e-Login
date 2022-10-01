package com.projeto.moto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Column(name = "nome", length = 200, nullable = false)
	@Size(min = 3, message ="O nome tem que ter no mínimo 3 caracteres")
	private String nome;
	
	@NotBlank(message = "Email é obrigatório")
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Senha é obrigatório")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = true)
	private String senha;
	
	@NotBlank(message = "Telefone é obrigatório")
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
	
	
}
