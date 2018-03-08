package edu.umuc.addressbook;

import edu.umuc.addressbook.controller.AddressBookController;
import edu.umuc.addressbook.model.Contact;
import edu.umuc.addressbook.model.Name;
import edu.umuc.addressbook.model.Address;
import edu.umuc.addressbook.model.Phone;
import edu.umuc.addressbook.view.AddressBook;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Address Book v. 1.0");
		
		Scanner keyboard = new Scanner(System.in);
		
		AddressBook addressBook = new AddressBook();
		
		AddressBookController controller = new AddressBookController(addressBook);
		
		controller.addContact(new Contact(new Name("John", "Smith"), new Address("123 Apple St.", "Richmond", "VA", "12345"), new Phone("123-456-7890")));
		controller.addContact(new Contact(new Name("Ashley", "Baker"), new Address("456 Cooper Trail", "San Antonio", "TX", "78223"), new Phone("123-456-7890")));
		controller.addContact(new Contact(new Name("Lincoln", "Powell"), new Address("1000 Powell Dr.", "Hollywood", "CA", "12345"), new Phone("123-456-7890")));
		
		int selection;
		
		do {
			System.out.println("\nPlease select one of the options:"
					+ "\n\n1. Add a contact to the address book"
					+ "\n2. Delete a contact from the address book"
					+ "\n3. Update a contact from the address book"
					+ "\n4. Display the address book"
					+ "\n0. Exit program");
			
			System.out.print("\nSelection: ");
			
			selection = keyboard.nextInt();
			keyboard.nextLine();
			
			switch (selection) {
				case 1: {
					System.out.print("\nEnter new contact's first name: ");
					String firstName = keyboard.nextLine();
					
					System.out.print("\nEnter new contact's last name: ");
					String lastName = keyboard.nextLine();
					
					System.out.print("\nEnter new contact's street: ");
					String street = keyboard.nextLine();
					
					System.out.print("\nEnter new contact's city: ");
					String city = keyboard.nextLine();
					
					System.out.print("\nEnter new contact's state abbreviation: ");
					String state = keyboard.nextLine();
					
					System.out.print("\nEnter new contact's zip code: ");
					String zip = keyboard.nextLine();
					
					System.out.print("\nEnter new contact's phone number: ");
					String number = keyboard.nextLine();
					
					controller.addContact(new Contact(new Name(firstName, lastName), new Address(street, city, state, zip), new Phone(number)));
					
					break;
				}
				case 2:{
					System.out.print("\nSelect index of contact to delete: ");
					int index = keyboard.nextInt();
					keyboard.nextLine();
					
					controller.deleteContact(index - 1);
					
					break;
				}
				case 3: {
					System.out.print("\nSelect index of contact to update: ");
					int index = keyboard.nextInt();
					keyboard.nextLine();
					
					Contact contact = controller.getContact(index - 1);
					
					int choice;
					
					do {
						System.out.println("\n" + contact.toString());
						System.out.println("\nPlease select one of the options:"
								+ "\n\n1. Update first name"
								+ "\n2. Update last name"
								+ "\n3. Update street"
								+ "\n4. Update city"
								+ "\n5. Update state"
								+ "\n6. Update zip"
								+ "\n7. Update phone number"
								+ "\n0. Main menu");
						
						System.out.print("\nEnter selection: ");
						choice = keyboard.nextInt();
						keyboard.nextLine();
						
						switch (choice) {
							case 1: {
								System.out.print("\nEnter new first name: ");
								String firstName = keyboard.nextLine();
								contact.getName().setFirstName(firstName);
								break;
							}
							case 2: {
								System.out.print("\nEnter new last name: ");
								String lastName = keyboard.nextLine();
								contact.getName().setLastName(lastName);
								break;
							}
							case 3: {
								System.out.print("\nEnter new street: ");
								String street = keyboard.nextLine();
								contact.getAddress().setStreet(street);
								break;
							}
							case 4: {
								System.out.print("\nEnter new city: ");
								String city = keyboard.nextLine();
								contact.getAddress().setCity(city);
								break;
							}
							case 5: {
								System.out.print("\nEnter new state abbreviation: ");
								String state = keyboard.nextLine();
								contact.getAddress().setState(state);
								break;
							}
							case 6: {
								System.out.print("\nEnter new zip code: ");
								String zip = keyboard.nextLine();
								contact.getAddress().setZip(zip);
								break;
							}
							case 7: {
								System.out.print("\nEnter new phone number: ");
								String number = keyboard.nextLine();
								contact.getPhone().setNumber(number);
								break;
							}
							case 0: {
								break;
							}
							default: {
								System.out.println("Invalid selection.  Try again...");
							}
						}
						
					} while (choice != 0);
					break;
				}
				case 4: {
					System.out.println();
					
					controller.display();
					
					break;
				}
				case 0: {
					break;
				}
				default: {
					System.out.println("Invalid selection.  Try again...");
				}
			}
		} while (selection != 0);
		
		keyboard.close();
	}
}