package models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import controllers.CRUD.Hidden;

@Entity
public class UsefulLink extends Model {

	@Required
	public String link;

	@Required
	@MaxSize(30)
	public String description;

	@Required
	@ManyToOne
	public LinkClassification classification;

	@Required
	@Hidden
	public String postedAt;

	@Required
	public String submitter;

	@Required
	@Hidden
	public int rating;

	@Override
	public void _save() {
		super._save();
		//Mails.mailRecipients(this);
	}
	
	@Override
	public void _delete(){
		super._delete();
	}

	public String getDescription() {
		return description;
	}

	public LinkClassification getClassification() {
		return classification;
	}
	
	public UsefulLink(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
		postedAt = formatter.format(new Date());
	}
}
