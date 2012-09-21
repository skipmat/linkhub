package models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import notifiers.Mails;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import controllers.CRUD.Hidden;

@Entity
public class UsefulLink extends Model {

	@Required
	public String link;

	@Required
	@MaxSize(100)
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
	public boolean sendMail;
	
	@Required
	@Hidden
	public int rating;

	@Override
	public void _save() {
		if (!link.startsWith("http://")){
			link = "http://" + link;
		}
		super._save();
		if (sendMail){
			Mails.mailRecipients(this);
		}
	}
	
	public void saveRating() {
		super._save();
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
