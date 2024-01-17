package com.example.validation.model;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "is Required")
    @Size(min=1, message = "is Required1")
    private String lastName;

    @NotNull(message = "is Required")
    @Min(value=0,message="should be greater or equal to 0")
    @Max(value=10,message = "should be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;
    public Customer(){

    }

    public Customer(String firstName, String lastName, int freepasses, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses=freepasses;
        this.postalCode=postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
