package org.cesed.map.meuchurrascoapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cesed.map.meuchurrascoapp.base.BaseBean;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseBean{

	private static final long serialVersionUID = 1L;

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
	
	public void setId(Integer id){
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
	
	public Integer getId(){
		return this.id;
	}

}
