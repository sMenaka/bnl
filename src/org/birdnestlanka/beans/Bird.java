package org.birdnestlanka.beans;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@Table(name="bird")
public class Bird {
	int Id;
	int Species_ID;
	int photographerId ;
	String species = null;
	String Common_Name = null;
	String Other_Name=null;
	String remarks=null;
	String group = null;
	String family = null;
	String location = null;
	String equip = null;
	String Date=null;
	String imgUrl=null;
	
	
	@Id
	@GeneratedValue
	@Column(name = "Bird_ID")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	@Column(name = "imgUrl", nullable = false)
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Column(name = "species", nullable = false)
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	@Column(name = "Bgroup", nullable = false)
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	@Column(name = "family", nullable = false)
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}
	@Column(name = "location", nullable = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "equipments", nullable = false)
	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}
	
	
	@Column(name = "Species_ID", nullable = false)
	public int getSpecies_ID() {
		return Species_ID;
	}

	public void setSpecies_ID(int species_ID) {
		Species_ID = species_ID;
	}
	@Column(name = "Photographer_ID", nullable = false)
	public int getPhotographerId() {
		return photographerId;
	}

	public void setPhotographerId(int photographerId) {
		this.photographerId = photographerId;
	}

	@Column(name = "Common_Name", nullable = false)
	public String getCommon_Name() {
		return Common_Name;
	}

	public void setCommon_Name(String common_Name) {
		Common_Name = common_Name;
	}
	@Column(name = "Other_Name", nullable = true)
	public String getOther_Name() {
		return Other_Name;
	}

	public void setOther_Name(String other_Name) {
		Other_Name = other_Name;
	}
	@Column(name = "Remarks", nullable = true)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Column(name = "Date", nullable = false)
	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}


}
