package main.com.bridgelabz.addressbook;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

	private static Map<String, ArrayList<Initialization>> bookList = new HashMap<String, ArrayList<Initialization>>();

	private static List<String> duplicateCheck;

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

	private static void getAddressBook() {
		// TODO Auto-generated method stub

		ArrayList<Initialization> contactDetails = new ArrayList<Initialization>();
		Map<String, ArrayList<Initialization>> bookListLocal = new HashMap<String, ArrayList<Initialization>>();
		ArrayList<String> names = new ArrayList<String>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter address book name");
		String bookname = scan.nextLine();
		while (true) {
			System.out.println("enter 1 to add more contact");
			System.out.println("enter 2 to exit ");
			int option = scan.nextInt();
			if (option == 1) {
				Initialization contactEntry = getInitialContactDetails();
				String fullName = contactEntry.firstName + " " + contactEntry.lastName;

				// using stream to check duplicates

				duplicateCheck = names.stream().filter(n -> n.equals(fullName)).collect(Collectors.toList());

				if (duplicateCheck.size() == 0) {
					contactDetails.add(contactEntry);
					names.add(contactEntry.firstName + " " + contactEntry.lastName);
				} else {
					System.out.println("this name already exists , not added to book");
				}
			} else {
				break;
			}

		}
		bookList.put(bookname, contactDetails);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("this is address book program");

		while (true) {
			System.out.println("enter 1 to add more address books");
			System.out.println("enter 2 to exit from address book program");
			int option = scn.nextInt();
			if (option == 1) {
				getAddressBook();

			} else {
				break;
			}
		}

		System.out.println("address books and contact details added successfully ");

		for (String i : bookList.keySet()) {
			System.out.println("book name is " + i);
			System.out.println("contact names are ");

			ArrayList<Initialization> persons = bookList.get(i);
			for (int y = 0; y < persons.size(); y++) {
				System.out.println(persons.get(y).firstName + " " + persons.get(y).lastName);
			}
		}

	}
}