package models;

import controllers.UsefulLinks;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
	
	public void doJob() {
			//Fixtures.loadModels("load-usefullinks.yml");
		if (LinkClassification.count() == 0){
			Fixtures.loadModels("load-classifications.yml");
		}
    }
}
