package org.birdnestlanka.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="birdgroup")
public class BirdGroup {

	int groupID;
	String groupName = null;
	String des=null;
	@Id
	@GeneratedValue
	@Column(name = "Group_ID")
	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	@Column(name = "Group_Name", nullable = false)
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Column(name = "des", nullable = false)
	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
