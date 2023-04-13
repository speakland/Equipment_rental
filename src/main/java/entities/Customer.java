package entities;

import java.util.Objects;

public class Customer {

    private final Integer customer_id;
    private String name;
    private String surname;
    private String passport_info;
    private String phone_number;


    public Customer(Integer customer_id, String name, String surname, String passport_info, String phone_number) {
        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
        this.passport_info = passport_info;
        this.phone_number = phone_number;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getCustomer_id().equals(customer.getCustomer_id()) && getName().equals(customer.getName()) && getSurname().equals(customer.getSurname()) && getPassport_info().equals(customer.getPassport_info()) && Objects.equals(getPhone_number(), customer.getPhone_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer_id(), getName(), getSurname(), getPassport_info(), getPhone_number());
    }
}
