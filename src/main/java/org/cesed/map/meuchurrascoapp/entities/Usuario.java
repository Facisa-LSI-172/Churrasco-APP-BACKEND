package org.cesed.map.meuchurrascoapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cesed.map.meuchurrascoapp.base.BaseBean;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseBean {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "passwd")
	private String password;

	@Column(name = "confirmado")
	private Boolean confirmado = false;

	@Transient
	private List<Contribuicao> listaContribuicoes;

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Integer getId() {
		return this.id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contribuicao> getListaContribuicoes() {
		return listaContribuicoes;
	}

	public void setListaContribuicoes(List<Contribuicao> listaContribuicoes) {
		this.listaContribuicoes = listaContribuicoes;
	}

}
