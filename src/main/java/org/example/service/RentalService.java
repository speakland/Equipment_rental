package org.example.service;

import org.example.entities.Rental;

import java.util.List;

public interface RentalService {

    void add(Rental rental);

    List<Rental> getAll();

    List<Rental> getById(Integer rental_id);

    List<Rental> getById(Long rental_id);

    Rental findByPrice(Integer price);


    void update(Rental rental);

    List<Rental> findAllRentForUserId(Long rental_id);
}
