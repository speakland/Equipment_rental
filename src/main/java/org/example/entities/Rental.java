package org.example.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Rental {
    private Long rental_id;
    private final Long customer_id;
    private final LocalDate rDate;
    private String time_out;
    private String time_back;
    private Integer price;


    public Rental(Long rental_id, Long customer_id,
                  LocalDate rDate, String time_out,
                  String time_back, Integer price) {
        this.rental_id = rental_id;
        this.customer_id = customer_id;
        this.rDate = rDate;
        this.time_out = time_out;
        this.time_back = time_back;
        this.price = price;
    }

    public Rental(Long customer_id, LocalDate rDate, String time_out, String time_back, Integer price) {
        this.customer_id = customer_id;
        this.rDate = rDate;
        this.time_out = time_out;
        this.time_back = time_back;
        this.price = price;
    }

    public Long getRental_id() {
        return rental_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public LocalDate getDate() {
        return rDate;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public String getTime_back() {
        return time_back;
    }

    public void setTime_back(String time_back) {
        this.time_back = time_back;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental rental)) return false;
        return getRental_id().equals(rental.getRental_id()) &&
                getCustomer_id().equals(rental.getCustomer_id()) &&
                getDate().equals(rental.getDate()) &&
                getTime_out().equals(rental.getTime_out()) &&
                Objects.equals(getTime_back(), rental.getTime_back()) &&
                getPrice().equals(rental.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRental_id(), getCustomer_id(), getDate(),
                getTime_out(), getTime_back(), getPrice());
    }
}