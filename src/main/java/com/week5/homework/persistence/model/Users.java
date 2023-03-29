package com.week5.homework.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Random;

@Entity
public class Users {
    private Long id;

    @Id
    @NotNull(message = "email Adress can not be taken as Null")
    @NotBlank(message = "email Adress can not be left Blank")
    @Email(message = "Not a Valid Email Adress Format")
    private String email;

    @NotNull(message = "firstName is Required and can Not be taken As Null")
    @NotBlank(message = "firstName can not be left Blank")
    private String firstName;

    @NotNull(message = "lastName is Required and can Not be taken As Null")
    @NotBlank(message = "lastName  Name can not be left Blank")
    private String lastName;

    @NotNull(message = "phoneNumber is Required and can Not be taken As Null")
    @NotBlank(message = "phoneNumber Name can not be left Blank")
    @Size(min = 12,max = 12,message = "phoneNumber value must be of 12 character of length")
    private String phoneNumber;

    public Users(){}

    public Users(Long id, String email, String firstName, String lastName, String phoneNumber) {
        if (Objects.isNull(id)) {
            id = new Random().nextLong();
        }
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Users(String email, String firstName, String lastName, String phoneNumber) {
        this.id = new Random().nextLong();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id.equals(users.id) && email.equals(users.email) && firstName.equals(users.firstName) && lastName.equals(users.lastName) && phoneNumber.equals(users.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
