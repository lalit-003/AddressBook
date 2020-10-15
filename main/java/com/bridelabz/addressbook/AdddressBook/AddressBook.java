package com.bridelabz.addressbook.AdddressBook;

import java.io.File;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBook {

	// arraylist created to store contact details
	private static ArrayList<Initialization> contactList = new ArrayList<>();
	public static int startingContactNo = 0;
	public static int endingContactNo = 0;
	public static String Address_Book_File_CSV = "D:\\BridgeLabz-Fellowship\\AddressBook\\AdddressBook\\AddressBookContacts-file.csv";

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

		System.out.println("enter zip code of address");
		String zipCode = scan.nextLine();

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

		System.out.println("displaying contact details :");
		for (int i = 0; i < contactList.size(); i++) {

			System.out.println("");
			System.out.println("contact details ");
			Initialization con = contactList.get(i);
			System.out.println("first name is :" + con.firstName);
			System.out.println(" last name is :" + con.lastName);

			System.out.println(" address is :" + con.address);

			System.out.println(" city name is :" + con.addressCity);

			System.out.println(" state name is :" + con.addressState);

			System.out.println(" zip code is  :" + con.addressZip);

			System.out.println(" phone number is :" + con.phoneNumber);

			System.out.println(" email address is :" + con.email);
		}
	}

	// writing CSV file
	public void writingToFile() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Writer writer = Files.newBufferedWriter(Paths.get(Address_Book_File_CSV));
		StatefulBeanToCsv<Initialization> beanToCsv = new StatefulBeanToCsvBuilder<Initialization>(writer)
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
		contactList.add(new Initialization("Lalit", "Gahlawat", "299", "bhiwani", "haryana", "124142", "1245341212",
				"lalit@gmail.com"));
		contactList.add(new Initialization("Saurav", "Gahlawat", "299", "bhiwani", "haryana", "124142", "1245341212",
				"lalit@gmail.com"));
				try {
			System.out.println(contactList);
			beanToCsv.write(contactList);
		} catch (Exception exception) {
			System.out.println("Exception occured while writing");
		}
	}

	public void readingFromFile() throws IOException {
		ArrayList<Initialization> contactDetailsList = new ArrayList<Initialization>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(Address_Book_File_CSV));
			CsvToBean<Initialization> csvToBean = new CsvToBeanBuilder(reader).withType(Initialization.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<Initialization> conIterator = csvToBean.iterator();
			while (conIterator.hasNext()) {
				Initialization contactDetails = conIterator.next();
				System.out.println("first name is :" + contactDetails.firstName);
				System.out.println(" last name is :" + contactDetails.lastName);

				System.out.println(" address is :" + contactDetails.address);

				System.out.println(" city name is :" + contactDetails.addressCity);

				System.out.println(" state name is :" + contactDetails.addressState);

				System.out.println(" zip code is  :" + contactDetails.addressZip);

				System.out.println(" phone number is :" + contactDetails.phoneNumber);

				System.out.println(" email address is :" + contactDetails.email);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	// main method
	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		AddressBook entry6 = new AddressBook();

		entry6.writingToFile();
		entry6.readingFromFile();
		entry6.displayContactDetails();

	}

}
