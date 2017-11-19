package org.cesed.map.meuchurrascoapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cesed.map.meuchurrascoapp.base.BaseBean;
import org.hibernate.annotations.Cascade;

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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_contribuicao", joinColumns = {
			@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario") }, inverseJoinColumns = {
					@JoinColumn(name = "id_contribuicao", referencedColumnName = "id_contribuicao") })
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
