package controllers;

import javax.persistence.Parameter;

import models.LinkClassification;
import models.UsefulLink;

@CRUD.For(UsefulLink.class)
public class UsefulLinks extends CRUD {

	public static void remove(Long id) {
		UsefulLink link = UsefulLink.findById(id);
		link.delete();
		redirect("/UsefulLinks/list");

	}
	
	public static void editMe(Long id, String field, String value) {
		UsefulLink link = UsefulLink.findById(id);
		if (field.equals("submitter")) {
			link.submitter = value;
			link.save();
			renderText(link.submitter);
		}
		if (field.equals("description")) {
			link.description = value;
			link.save();
			renderText(link.description);
		}
	}
}