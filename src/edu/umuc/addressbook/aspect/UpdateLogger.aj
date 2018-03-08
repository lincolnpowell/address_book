package edu.umuc.addressbook.aspect;

import edu.umuc.addressbook.model.Contact;
import edu.umuc.addressbook.log.Log;

public aspect UpdateLogger {
	private Contact contact;
	
	pointcut updateLogger(): 
		call(public Contact getContact(int)) &&
		!within(DeleteLogger);
	
	after() returning (Contact contact): 
			updateLogger() {
		this.contact = contact;
	}
	
	before() : execution(public void set*(String)) {
		Log log = new Log("log.txt", true);
		log.println("Record Updated: " + contact.toString());
		log.close();
	}
}