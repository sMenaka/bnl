package org.birdnestlanka.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="birdspecies")
public class BirdSpecies {
	int species_ID;
	
	String species_Name = null;
	String common_Name = null;
	String common_Name2=null;
	int family_Id;
	
	@Id
	@GeneratedValue
	@Column(name = "Species_ID")
	public int getSpecies_ID() {
		return species_ID;
	}

	public void setSpecies_ID(int species_ID) {
		this.species_ID = species_ID;
	}
	@Column(name = "Species_Name", nullable = false)
	public String getSpecies_Name() {
		return species_Name;
	}

	public void setSpecies_Name(String species_Name) {
		this.species_Name = species_Name;
	}
	@Column(name = "Family_ID", nullable = false)
	public int getFamily_ID() {
		return family_Id;
	}

	public void setFamily_ID(int family_ID) {
		this.family_Id = family_ID;
	}
	@Column(name = "Common_Name", nullable = false)
	public String getCommon_Name() {
		return common_Name;
	}

	public void setCommon_Name(String common_Name) {
		this.common_Name = common_Name;
	}
	@Column(name = "Common_Name2", nullable = false)
	public String getCommon_Name2() {
		return common_Name2;
	}

	public void setCommon_Name2(String common_Name2) {
		this.common_Name2 = common_Name2;
	}
}
