package org.cesed.map.meuchurrascoapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.cesed.map.meuchurrascoapp.base.BaseBean;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "evento")
public class Evento extends BaseBean {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_evento")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "data_evento")
	private Date data;

	@Column(name = "descricao")
	private String descricao;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.ALL })
	@JoinColumn(name = "id_local")
	private Local local;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario organizador;

	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Usuario> listaParticipantes;

	public List<Usuario> getListaParticipantes() {
		return listaParticipantes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setListaParticipantes(List<Usuario> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
