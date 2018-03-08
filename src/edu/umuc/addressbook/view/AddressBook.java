package edu.umuc.addressbook.view;

import edu.umuc.addressbook.model.Contact;
import java.util.ArrayList;

public class AddressBook {
	private ArrayList<Contact> contacts = new ArrayList<>();
	
	public AddressBook() {}
	
	public void display() {
		int i = 1;
		System.out.println("Index\tContact Name\t\tContact Address and Phone Number\n"
				+ "----------------------------------------------------------------");
		for (Contact c : contacts)
			System.out.printf("%5d\t%-20s\t%-40s\n", i++, c.getName().toString(), c.getAddress() + " " + c.getPhone().toString());
	}
	
	public void add(Contact contact)				{contacts.add(contact);}
	public void remove(int index)					{contacts.remove(index);}
	public Contact get(int index)					{return contacts.get(index);}
}
