package controllers;

import models.LinkClassification;
import models.UsefulLink;

@CRUD.For(UsefulLink.class)
public class UsefulLinks extends CRUD {
	
	public static void remove(Long id){
		UsefulLink link = UsefulLink.findById(id);
		link.delete();
		redirect("/UsefulLinks/list");
		
	}
	
	public static void editMe(Long id, String value){
		UsefulLink link = UsefulLink.findById(id);
		link.link = value;
		link.save();
		renderText(link.link);
	}
}																																																								