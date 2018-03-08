package edu.umuc.addressbook.model;

public class Contact {
	private Name name;
	private Address address;
	private Phone phone;
	
	public Contact(Name name, Address address, Phone phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public Name getName()		{return name;}
	public Address getAddress()	{return address;}
	public Phone getPhone()		{return phone;}
	
	public String toString()	{return name.toString() + " " + address.toString() + " " + phone.toString();}
}
