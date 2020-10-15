package com.bridgelabz.addressbook.AddressBook;

import com.opencsv.bean.CsvBindByName;

public class Initialization {

	@CsvBindByName(column = "firstName")
	public String firstName;
	@CsvBindByName(column = "lastName")
	public String lastName;
	@CsvBindByName(column = "address")
	public String address;
	@CsvBindByName(column = "addressCity")
	public String addressCity;
	@CsvBindByName(column = "addressState")
	public String addressState;
	@CsvBindByName(column = "addressZip")
	public String addressZip;
	@CsvBindByName(column = "phoneNumber")
	public String phoneNumber;
	@CsvBindByName(column = "email")
	public String email;

	// constructor for variable initilization
	public Initialization(String firstName, String lastName, String address, String addressCity, String addressState,
			String addresszip, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZip = addresszip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressCity() {
		return addressCity;
	}

	/**
	 * @param city the city to set
	 */
	public void setAddressCity(String city) {
		this.addressCity = city;
	}

	/**
	 * @return the state
	 */
	public String getAddressState() {
		return addressState;
	}

	/**
	 * @param state the state to set
	 */
	public void setAddressState(String state) {
		this.addressState = state;
	}

	/**
	 * @return the zip
	 */
	public String getAddressZip() {
		return addressZip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setAddressZip(String zip) {
		this.addressZip = zip;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

		return firstName + " , " + lastName + " , " + address + " , " + addressCity + " , " + addressState + " , "
				+ addressZip + " , " + phoneNumber + " , " + email;
	}

	public String[] addDataToCSV() {
		// TODO Auto-generated method stub
		String[] contact={firstName, lastName, address, addressCity, addressState, addressZip, phoneNumber, email};
		return contact;
	}
//
	
}