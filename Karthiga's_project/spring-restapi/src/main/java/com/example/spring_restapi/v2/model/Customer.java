package com.example.spring_restapi.v2.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.spring_restapi.v1.model.CustomerPOJO;
import com.example.spring_restapi.validation.CustomerIdConstraint;

public class Customer implements CustomerPOJO {

	@CustomerIdConstraint
	@NotNull(message = "Customer Id should not be null")
	private String custId;
	private FullName fullName;
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
	private String mail;
	@Pattern(regexp = "\\d{10}",message="Invalid Phone Number")
	private String contact;

	// Constructors
	public Customer() {

	}

	public Customer(@NotNull(message = "Customer Id should not be null") String custId, FullName fullName,
			@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address") String mail,
			String contact) {

		this.custId = custId;
		this.fullName = fullName;
		this.mail = mail;
		this.contact = contact;
	}

	// Getters and Setters
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fullName=" + fullName + ", mail=" + mail + ", contact=" + contact
				+ "]";
	}

	public static class FullName {
		@Override
		public String toString() {
			return "FullName [firstname=" + firstname + ", lastname=" + lastname + "]";
		}

		public FullName(String firstname, String lastname) {
			this.firstname = firstname;
			this.lastname = lastname;
		}

		private String firstname;
		private String lastname;

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String fname) {
			this.firstname = fname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lname) {
			this.lastname = lname;
		}

	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
}
