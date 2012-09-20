package controllers;

import models.UsefulLink;
import play.mvc.Controller;
import play.mvc.Http.Response;

public class Rating extends Controller{
	
	public static void increaseRating(Long id){
		UsefulLink link = UsefulLink.findById(id);
		link.rating++;
		link.saveRating();
		String cookieName = "linkHubIdRating-" + Long.toString(id);
		response.setCookie(cookieName, Long.toString(id));
		renderText(link.rating);
	}
	
	public static void decreaseRating(Long id){
		UsefulLink link = UsefulLink.findById(id);
		link.rating--;
		link.saveRating();
		String cookieName = "linkHubIdRating-" + Long.toString(id);
		response.setCookie(cookieName, Long.toString(id));
		renderText(link.rating);
	}
}
