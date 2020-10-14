package main.com.bridgelabz.addressbook;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook {

	private static Map<String, ArrayList<Initialization>> bookList = new HashMap<String, ArrayList<Initialization>>();
	private static Map<String, ArrayList<Initialization>> bookListSorted = new HashMap<String, ArrayList<Initialization>>();

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

	public static void display(Initialization member) {
		System.out.println("first name is :" + member.firstName);
		System.out.println(" last name is :" + member.lastName);

		System.out.println(" address is :" + member.address);

		System.out.println(" city name is :" + member.addressCity);

		System.out.println(" state name is :" + member.addressState);

		System.out.println(" zip code is  :" + member.addresszip);

		System.out.println(" phone number is :" + member.phoneNumber);

		System.out.println(" email address is :" + member.email);

	}

	private static void getAddressBook() {
		// TODO Auto-generated method stub

		ArrayList<Initialization> contactDetails = new ArrayList<Initialization>();
		Map<String, ArrayList<Initialization>> bookListLocal = new HashMap<String, ArrayList<Initialization>>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter address book name");
		String bookname = scan.nextLine();
		while (true) {
			System.out.println("enter 1 to add more contact");
			System.out.println("enter 2 to exit ");
			int option = scan.nextInt();
			if (option == 1) {
				Initialization contactEntry = getInitialContactDetails();
				contactDetails.add(contactEntry);
			} else {
				break;
			}

		}
		bookList.put(bookname, contactDetails);

	}

	private static void sortByCity() {
		// TODO Auto-generated method stub

		for (String i : bookList.keySet()) {

			System.out.println("Book name is : " + i);
			ArrayList<Initialization> contactDetails = bookList.get(i);
			ArrayList<Initialization> contacts = new ArrayList<>();
			System.out.println("Sorting people by City : ");

			for (int j = 0; j < contactDetails.size(); j++) {

				contacts.add(contactDetails.get(j));

			}

			List<Initialization> sortedcontacts = contacts.stream()
					.sorted((o1, o2) -> o1.addressCity.compareTo(o2.addressCity)).collect(Collectors.toList());

			for (Initialization contact : sortedcontacts) {
				display(contact);
			}

		}

	}

	private static void sortByState() {
		// TODO Auto-generated method stub

		for (String i : bookList.keySet()) {

			System.out.println("Book name is : " + i);
			ArrayList<Initialization> contactDetails = bookList.get(i);
			ArrayList<Initialization> contacts = new ArrayList<>();
			System.out.println("Sorting people by State : ");

			for (int j = 0; j < contactDetails.size(); j++) {

				contacts.add(contactDetails.get(j));

			}

			List<Initialization> sortedcontacts = contacts.stream()
					.sorted((o1, o2) -> o1.addressState.compareTo(o2.addressState)).collect(Collectors.toList());

			for (Initialization contact : sortedcontacts) {
				display(contact);
			}

		}

	}

	private static void sortByZip() {
		// TODO Auto-generated method stub

		for (String i : bookList.keySet()) {

			System.out.println("Book name is : " + i);
			ArrayList<Initialization> contactDetails = bookList.get(i);
			ArrayList<Initialization> contacts = new ArrayList<>();
			System.out.println("Sorting people by Zip : ");

			for (int j = 0; j < contactDetails.size(); j++) {

				contacts.add(contactDetails.get(j));

			}

			List<Initialization> sortedcontacts = contacts.stream().sorted((o1, o2) -> o1.addresszip - (o2.addresszip))
					.collect(Collectors.toList());

			for (Initialization contact : sortedcontacts) {
				display(contact);
			}

		}

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

		System.out.println("Select" + "\n1.  to sort by state" + "\n2. to sort by city" + "\n3. to sort by  pin");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		switch (option) {
		case 1:
			sortByState();
			break;

		case 2:
			sortByCity();
			break;

		case 3:
			sortByZip();
			break;

		default:
			System.out.println("Invalid choice");
		}

	}
}