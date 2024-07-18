package com.example.spring_restapi.v1.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.spring_restapi.validation.CustomerIdConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Valid
public class Customer implements CustomerPOJO{

	
	@CustomerIdConstraint
	@NotNull(message="Customer Id should not be null")
    private String custId;
    private String fname;
    private String lname;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Invalid email address")
    private String mail;

    // Constructors
    public Customer()
    {

    }

    public Customer(String custId, String fname, String lname, String mail) {
        this.custId = custId;
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
    }

    // Getters and Setters
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public static  class FullName
    {
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

    // toString method (optional for debugging)
    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

}
