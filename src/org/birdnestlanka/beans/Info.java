package org.birdnestlanka.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info")
public class Info {
	int info_ID;
	int Species_ID;
	String Descrip = null;
	String Sound_Url = null;

	@Id
	@GeneratedValue
	@Column(name = "info_ID")
	public int getInfo_ID() {
		return info_ID;
	}

	public void setInfo_ID(int info_ID) {
		this.info_ID = info_ID;
	}
	@Column(name = "species_ID", nullable = false)
	public int getSpecies_ID() {
		return Species_ID;
	}

	public void setSpecies_ID(int species_ID) {
		Species_ID = species_ID;
	}
	@Column(name = "descrip", nullable = false)
	public String getDescrip() {
		return Descrip;
	}

	public void setDescrip(String descrip) {
		Descrip = descrip;
	}
	@Column(name = "sound_URL", nullable = false)
	public String getSound_Url() {
		return Sound_Url;
	}

	public void setSound_Url(String sound_Url) {
		Sound_Url = sound_Url;
	}
}
