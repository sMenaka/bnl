package org.birdnestlanka.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photographer")
public class Photographer {
	int photographer_ID;
	String photographer_Name = null;
	String photographer_Email = null;
	String Img_URL = null;

	@Id
	@GeneratedValue
	@Column(name = "photographer_ID")
	public int getPhotographer_ID() {
		return photographer_ID;
	}

	public void setPhotographer_ID(int photographer_ID) {
		this.photographer_ID = photographer_ID;
	}

	@Column(name = "photographer_Name", nullable = false)
	public String getPhotographer_Name() {
		return photographer_Name;
	}

	public void setPhotographer_Name(String photographer_Name) {
		this.photographer_Name = photographer_Name;
	}

	@Column(name = "photographer_Email", nullable = false)
	public String getPhotographer_Email() {
		return photographer_Email;
	}

	public void setPhotographer_Email(String photographer_Email) {
		this.photographer_Email = photographer_Email;
	}

	@Column(name = "Img_URL", nullable = false)
	public String getImg_URL() {
		return Img_URL;
	}

	public void setImg_URL(String img_URL) {
		Img_URL = img_URL;
	}
}
