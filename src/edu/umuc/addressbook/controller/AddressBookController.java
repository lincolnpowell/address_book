package edu.umuc.addressbook.controller;

import edu.umuc.addressbook.view.AddressBook;
import edu.umuc.addressbook.model.Contact;

public class AddressBookController {
	private AddressBook addressBook;
	
	public AddressBookController(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	
	public void addContact(Contact contact) 				{addressBook.add(contact);}
	public void deleteContact(int index)					{addressBook.remove(index);}
	public Contact getContact(int index)					{return addressBook.get(index);}
	public void display()									{addressBook.display();}
}
