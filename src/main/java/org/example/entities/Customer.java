package org.example.entities;

import java.util.Objects;

public class Customer {

    private Long customer_id;
    private String name;
    private String surname;
    private String passport_info;
    private String phone_number;

    private String login;
    private String password;

    public Customer(Long customerId, String name,
                    String surname, String passportInfo,
                    String phoneNumber, String login, String password) {
        customer_id = customerId;
        this.name = name;
        this.surname = surname;
        passport_info = passportInfo;
        phone_number = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public Customer(String name, String surname, String passport_info, String phone_number, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.passport_info = passport_info;
        this.phone_number = phone_number;
        this.login = login;
        this.password = password;
    }

    public Long getCustomer_id() {return customer_id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport_info() {
        return passport_info;
    }

    public void setPassport_info(String passport_info) {
        this.passport_info = passport_info;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return customer_id;
    }

    public void setId(Long customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getCustomer_id().equals(customer.getCustomer_id()) &&
                getName().equals(customer.getName()) &&
                getSurname().equals(customer.getSurname()) &&
                getPassport_info().equals(customer.getPassport_info()) &&
                getPhone_number().equals(customer.getPhone_number()) &&
                getLogin().equals(customer.getLogin()) &&
                getPassword().equals(customer.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer_id(), getName(), getSurname(),
                getPassport_info(), getPhone_number(), getLogin(), getPassword());
    }
}
