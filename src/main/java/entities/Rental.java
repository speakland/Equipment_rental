package entities;

import java.util.Objects;

public class Rental {
    private final Integer rental_id;
    private final Integer customer_id;
    private final String date;
    private String time_out;
    private String time_back;
    private Integer price;


    public Rental(Integer rental_id, Integer customer_id, String date, String time_out, String time_back, Integer price) {
        this.rental_id = rental_id;
        this.customer_id = customer_id;
        this.date = date;
        this.time_out = time_out;
        this.time_back = time_back;
        this.price = price;
    }


    public Integer getRental_id() {
        return rental_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public String getDate() {
        return date;
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
        return getRental_id().equals(rental.getRental_id()) && getCustomer_id().equals(rental.getCustomer_id()) && getDate().equals(rental.getDate()) && getTime_out().equals(rental.getTime_out()) && Objects.equals(getTime_back(), rental.getTime_back()) && getPrice().equals(rental.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRental_id(), getCustomer_id(), getDate(), getTime_out(), getTime_back(), getPrice());
    }
}