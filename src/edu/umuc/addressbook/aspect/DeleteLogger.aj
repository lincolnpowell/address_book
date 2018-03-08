package edu.umuc.addressbook.aspect;

import edu.umuc.addressbook.controller.AddressBookController;
import edu.umuc.addressbook.log.Log;

public aspect DeleteLogger {	
	pointcut deleteLogger(AddressBookController controller, int index):
		target(controller) &&
		args(index) &&
		call(public void deleteContact(int));
	
	before(AddressBookController controller, int index): deleteLogger(controller, index) {
		Log log = new Log("log.txt", true);
		log.println("Record Deleted: " + controller.getContact(index).toString());
		log.close();
	}
}