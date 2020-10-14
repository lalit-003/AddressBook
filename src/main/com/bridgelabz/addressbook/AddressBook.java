package main.com.bridgelabz.addressbook;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;



public class AddressBook {

	// arraylist created to store contact details
	private ArrayList<Initialization> contactList = new ArrayList<>();
	int k=1;
public	static int startingContactNo=0;
public	static int endingContactNo= 0;

	// method to take input of contact details
	private static Initialization getInitialContactDetails() {
		System.out.println("enter contact details ----");

		Scanner scan = new Scanner(System.in);

		System.out.println("enter first name");
		String firstName = scan.nextLine();

		System.out.println("enter last name");
		String lastName = scan.nextLine();

		System.out.println("enter street address");
		String address = scan.nextLine();

		System.out.println("enter city name");
		String cityName = scan.nextLine();

		System.out.println("enter state name");
		String stateName = scan.nextLine();
		System.out.println("enter phone number");
		String phoneNumber = scan.nextLine();

		System.out.println("enter email Address");
		String emailAddress = scan.nextLine();

		System.out.println("enter zip code of address -- interger type");
		int zipCode = scan.nextInt();

		Initialization entry = new Initialization(firstName, lastName, address, cityName, stateName, zipCode,
				phoneNumber, emailAddress);
		return entry;

	}
	// method to add contact details in linked list

	private void addContact(Initialization contact) {
		contactList.add(contact);
		System.out.println("contact added whose name is :  " + contact.firstName + " " + contact.lastName);

	}
	// method to display all entries of arraylist

	private void displayContactDetails() {
		System.out.println("Book number : " + k);

		System.out.println("displaying contact details :");
		for ( int i=startingContactNo ; i < endingContactNo; i++) {

			System.out.println("");
			System.out.println("contact details ");
			Initialization con = contactList.get(i);
			System.out.println("first name is :" + con.firstName);
			System.out.println(" last name is :" + con.lastName);

			System.out.println(" address is :" + con.address);

			System.out.println(" city name is :" + con.addressCity);

			System.out.println(" state name is :" + con.addressState);

			System.out.println(" zip code is  :" + con.addresszip);

			System.out.println(" phone number is :" + con.phoneNumber);

			System.out.println(" email address is :" + con.email);
		}
		k++;
	}

	// main method
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("this is address book feature");

		AddressBook entry6 = new AddressBook();

		System.out.println("Enter no of contact books you wanted to add");
		int noOfContactBooks = scn.nextInt();
		String[] arrContactBookName = new String[noOfContactBooks];
		HashMap<String,Integer>  contactBooksName = new  HashMap<String,Integer>();

		boolean flag = true;

		for (int b = 0; b < noOfContactBooks; b++) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the unique address book name");
			String bookName = sc.nextLine();
			arrContactBookName[b] = bookName;
			// checking whether book name is unique or not
			//if unique add details else program ends
			for(int c=0;c<b;c++)
			{
				if(arrContactBookName[c].equals(bookName))
				{
					System.out.println("this book name already exist,invalid input");
				flag = false;
			}
				else
				{
					System.out.println("");

				}
			}

			if (flag == true)
			{
			System.out.println("Enter  no of contacts you wants to add in this book");
			int noOfContacts = sc.nextInt();

			contactBooksName.put(bookName,noOfContacts);


				Scanner scan = new Scanner(System.in);

				System.out.println("Book number : " +  (b+1));

				System.out.println("Address Book name is :" + bookName);

				for (int k = 0; k < noOfContacts; k++) {
					System.out.println("Enter   new contact details ");
					entry6.addContact(entry6.getInitialContactDetails());
				}
			}
				else
				{
					b--;
				}


			}





		System.out.println("contact book after addition");
		System.out.println("");



		for (int l=0;l<noOfContactBooks;l++) {

		      System.out.println(" Book Name: " + arrContactBookName[l] + "  and No of contacts in book is/are: " + contactBooksName.get(arrContactBookName[l]));





			 endingContactNo = endingContactNo +contactBooksName.get(arrContactBookName[l]);

			System.out.println("Displaying book details  ");

		entry6.displayContactDetails();

				startingContactNo = startingContactNo+contactBooksName.get(arrContactBookName[l]);

		}

	}
}