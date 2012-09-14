package controllers;

import models.UsefulLink;
import play.mvc.Controller;

public class Rating extends Controller{
	
	public static void increaseRating(Long id){
		UsefulLink link = UsefulLink.findById(id);
		link.rating++;
		link.save();
		renderText(link.rating);
		//redirect("/UsefulLinks/list");
	}
	
	public static void decreaseRating(Long id){
		UsefulLink link = UsefulLink.findById(id);
		link.rating--;
		link.save();
		renderText(link.rating);
		//redirect("/UsefulLinks/list");
	}
}
