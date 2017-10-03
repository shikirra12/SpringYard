package com.example.customer.model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    int serial;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String phone;

    @Column
    String email;

    public Customer() {
    }

//    public Customer(int serial, String firstName, String lastName, String phone, String text, int id) {
//        this.serial = serial;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.email = text;
//        this.id = id;
//    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return email;
    }

    public void setText(String text) {
        this.email = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
