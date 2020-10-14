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
	private static Map<String, ArrayList<String>> cityList = new HashMap<String, ArrayList<String>>();

	private static Map<String, ArrayList<String>> stateList = new HashMap<String, ArrayList<String>>();
	static ArrayList<Initialization> contactDetailsCity = new ArrayList<Initialization>();
	static ArrayList<Initialization> contactDetailsState = new ArrayList<Initialization>();

	private static void addingBooksAndContacts() {
		// TODO Auto-generated method stub
		System.out.println("Let total books are 3");

		String bookname1 = "bank";
		String bookname2 = "defence";
		String bookname3 = "pharma";

		ArrayList<Initialization> list1 = new ArrayList<Initialization>();
		ArrayList<Initialization> list2 = new ArrayList<Initialization>();

		ArrayList<Initialization> list3 = new ArrayList<Initialization>();

		Initialization intial1 = new Initialization("sumit", "phogat", "H.NO. 26", "bhiwani", "haryana", 124367,
				"9087654590", "sumit@abc");
		Initialization intial2 = new Initialization("amit", "pradhan", "H.NO. 26", "jalandhar", "punjab", 124367,
				"9087654590", "sumit@abc");
		Initialization intial3 = new Initialization("karmvir", "gahlawat", "H.NO. 26", "bhiwani", "haryana", 124367,
				"9087654590", "sumit@abc");
		Initialization intial4 = new Initialization("jaswinder", "singh", "H.NO. 26", "jalandhar", "punjab", 124367,
				"9087654590", "sumit@abc");
		Initialization intial5 = new Initialization("parveen", "jakhar", "H.NO. 26", "bhiwani", "haryana", 124367,
				"9087654590", "sumit@abc");

		Initialization intial6 = new Initialization("aman", "yadav", "H.NO. 26", "bhiwani", "haryana", 124367,
				"9087654590", "sumit@abc");
		Initialization intial7 = new Initialization("neeraj ", "karwal", "H.NO. 26", "jalandhar", "punjab",
				124367, "9087654590", "sumit@abc");
		Initialization intial8 = new Initialization("sunny", "das", "H.NO. 26", "gurgaon", "haryana", 124367,
				"9087654590", "sumit@abc");
		Initialization intial9 = new Initialization("santy", "jhutta", "H.NO. 26", "jaipur", "rajasthan", 124367,
				"9087654590", "sumit@abc");
		Initialization intial10 = new Initialization("aditya ", "jain", "H.NO. 26", "mathura", "uttar pradesh", 124367,
				"9087654590", "sumit@abc");

		list1.add(intial1);
		list1.add(intial3);
		list1.add(intial5);
		list1.add(intial10);

		list2.add(intial2);
		list2.add(intial8);
		list2.add(intial7);

		list3.add(intial4);
		list3.add(intial6);
		list3.add(intial9);

		bookList.put(bookname1, list1);
		bookList.put(bookname2, list2);
		bookList.put(bookname3, list3);

	}

	private static Map<String, ArrayList<String>> getPersonsCityWise() {
		// TODO Auto-generated method stub
				ArrayList<String> cityNames = new ArrayList<String>();

		for (String i : bookList.keySet()) {

			contactDetailsCity = bookList.get(i);

			for (int j = 0; j < contactDetailsCity.size(); j++) {


					cityNames.add(contactDetailsCity.get(j).addressCity);
			}

		}

		Set<String> duplicateRemoval = new LinkedHashSet<String>();
	   duplicateRemoval.addAll(cityNames);
	   cityNames.clear();
	   cityNames.addAll(duplicateRemoval);






		for (int y = 0; y < cityNames.size(); y++) {
			ArrayList<String> personNames = new ArrayList<String>();

			for (String i : bookList.keySet()) {

				contactDetailsCity = bookList.get(i);

				for (int j = 0; j < contactDetailsCity.size(); j++) {
					Initialization initial = contactDetailsCity.get(j);
					if (initial.addressCity.equals(cityNames.get(y))) {
						personNames.add(initial.firstName + " " + initial.lastName);

					}
				}

			}
		 cityList.put(cityNames.get(y), personNames);
			/*
			 * System.out.println(cityNames.get(y)); for(int k=0;k<personNames.size();k++) {
			 * System.out.println(personNames.get(k)); }
			 * 
			 */

		}

		return cityList;

	}

	private static Map<String, ArrayList<String>> getPersonsStateWise() {
		// TODO Auto-generated method stub
		ArrayList<String> stateNames = new ArrayList<String>();

		for (String i : bookList.keySet()) {

			contactDetailsState = bookList.get(i);

			for (int j = 0; j < contactDetailsState.size(); j++) {

					stateNames.add(contactDetailsState.get(j).addressState);
			}

		}

		Set<String> duplicateRemoval = new LinkedHashSet<String>();
		   duplicateRemoval.addAll(stateNames);
		   stateNames.clear();
		   stateNames.addAll(duplicateRemoval);





		for (int y = 0; y < stateNames.size(); y++) {
			ArrayList<String> personNames = new ArrayList<String>();

			for (String i : bookList.keySet()) {

				contactDetailsState = bookList.get(i);

				for (int j = 0; j < contactDetailsState.size(); j++) {
					Initialization initial = contactDetailsState.get(j);
					if (initial.addressState.equals(stateNames.get(y))) {
						personNames.add(initial.firstName + " " + initial.lastName);
					}
				}

			}
			stateList.put(stateNames.get(y), personNames);

		}

		return stateList;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("this is address book program");

		addingBooksAndContacts();

		System.out.println("address books and contact details added successfully ");

		System.out.println("enter 1 to search person by city");
		System.out.println("enter 2 to search person by state");
		int searchoption = scn.nextInt();

		cityList = getPersonsCityWise();
		stateList = getPersonsStateWise();





		if (searchoption == 1) {
			System.out.println("Enter city name  ");
			Scanner scan = new Scanner(System.in);

			String cityName = scan.nextLine();
			System.out.println("total count of persons in the city is : " + cityList.get(cityName).size());
			System.out.println("persons in the city are : ");

			for (String i : cityList.keySet()) {

				if (i.equals(cityName)) {

					ArrayList<String> persons = cityList.get(i);
					for (int y = 0; y < persons.size(); y++) {
						System.out.println(persons.get(y));
					}
				}

			}

		}

		else if (searchoption == 2) {

			System.out.println("Enter state name  ");
			Scanner sn = new Scanner(System.in);


			String stateName = sn.nextLine();

			System.out.println("total count of persons in the state is : " + stateList.get(stateName).size());
			System.out.println("persons in the state are : ");

			for (String i : stateList.keySet()) {

				if (i.equals(stateName)) {

					ArrayList<String> persons = stateList.get(i);
					for (int y = 0; y < persons.size(); y++) {
						System.out.println(persons.get(y));
					}
				}

			}
		}
		else {
			System.out.println("Wrong input");
		}

	}

}