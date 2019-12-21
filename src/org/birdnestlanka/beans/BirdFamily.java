package org.birdnestlanka.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "birdfamily")
public class BirdFamily {
	int familyID;
	int groupID;
	String familyName;
	String des=null;

	@Id
	@GeneratedValue
	@Column(name = "Family_ID")
	public int getFamilyID() {
		return familyID;
	}

	public void setFamilyID(int familyID) {
		this.familyID = familyID;
	}
	@Column(name = "Group_ID", nullable = false)
	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	@Column(name = "Family_Name", nullable = false)
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	@Column(name = "Descrip", nullable = false)
	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
