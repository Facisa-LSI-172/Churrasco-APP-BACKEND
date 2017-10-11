package org.cesed.map.meuchurrascoapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.cesed.map.meuchurrascoapp.base.BaseBean;

@Entity
@Table(name = "local")
public class Local extends BaseBean{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_local")
	private Integer id;
	
	@Column(name= "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
