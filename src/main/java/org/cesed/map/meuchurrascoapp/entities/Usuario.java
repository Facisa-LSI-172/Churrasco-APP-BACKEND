package org.cesed.map.meuchurrascoapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseBean {
	
	@Id
	@GeneratedValue
	@Column(name= "id_usuario")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Transient
	private List<Contribuicao> listaContribuicoes;
	
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
	
	public Integer getId(){
		return this.id;
	}

}
