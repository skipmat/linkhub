package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class LinkClassification extends Model {

	public String classification;
	
	@Override
	public String toString() {
		return classification;
	}
	
	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
}
