package org.cesed.map.meuchurrascoapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.cesed.map.meuchurrascoapp.base.BaseBean;

@Entity
@Table(name = "contribuicao")
public class Contribuicao extends BaseBean{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_contribuicao")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario contribuidor;

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

	public Usuario getContribuidor() {
		return contribuidor;
	}

	public void setContribuidor(Usuario contribuidor) {
		this.contribuidor = contribuidor;
	}
	
}
