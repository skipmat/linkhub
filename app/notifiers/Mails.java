package notifiers;

import play.*;
import play.i18n.Messages;
import play.mvc.*;
import java.util.*;

import models.UsefulLink;

import org.apache.commons.mail.EmailAttachment;

public class Mails extends Mailer {

	public static boolean mailRecipients(UsefulLink newLink) {
		setFrom(Play.configuration.getProperty("mail.From"));
		setSubject("New '" + newLink.getClassification() + "' related link added: " + newLink.getDescription());
		addRecipient(Play.configuration.getProperty("mail.Recipients"));
		return sendAndWait(newLink);
	}
}