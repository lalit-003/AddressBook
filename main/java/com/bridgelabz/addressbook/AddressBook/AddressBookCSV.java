package com.bridgelabz.addressbook.AddressBook;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSV {

//
	private static ArrayList<Initialization> contactList = new ArrayList<>();
	public static int startingContactNo = 0;
	public static int endingContactNo = 0;
	public static String Address_Book_File_CSV = "D:\\FileIO\\demo\\addressbook.csv";

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
		ArrayList<Initialization> contact = new ArrayList<>();
		File file = new File(Address_Book_File_CSV);
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = { "firstName", "lastName", "address", "city", "state", "zipCode", "phoneNo", "    email" };
			writer.writeNext(header);

			contact.add(new Initialization("Lalit", "Gahlawat", "299", "bhiwani", "haryana", "124142", "1245341212",
					"lalit@gmail.com"));
			contact.add(new Initialization("Saurav", "Gahlawat", "299", "bhiwani", "haryana", "124142", "1245341212",
					"lalit@gmail.com"));
			
			// add data to csv
			for (Initialization c : contact) {
				String[] dataStr = c.addDataToCSV();
				writer.writeNext(dataStr);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	}

	//reading CSV File
	public void readingFromFile() throws IOException {
		ArrayList<Initialization> contactDetailsList = new ArrayList<Initialization>();
	    try { 

	        FileReader filereader = new FileReader(Address_Book_File_CSV); 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	            for (String contact : nextRecord) { 
	                System.out.print(contact + "   \t   "); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}

	// main method
	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		AddressBookCSV entry6 = new AddressBookCSV();

		entry6.writingToFile();
		entry6.readingFromFile();

	}

}
