package org.example.service.impl;
import org.example.entities.Rental;
import org.example.repository.RentalRepository;
import org.example.service.RentalService;
import org.example.utils.PullConnection;
import java.util.List;

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository = new RentalRepository (new PullConnection());


    @Override
    public void add(Rental rental) {
        rentalRepository.add(rental);

    }

    @Override
    public List<Rental> getAll() {
        return rentalRepository.getAll();
    }

    @Override
    public List<Rental> getById(Integer rental_id) {
        return null;
    }

    @Override
    public List<Rental> getById(Long rental_id) {
        return rentalRepository.getById(rental_id);
    }

    @Override
    public Rental findByPrice(Integer price) {
        return rentalRepository.findByPrice(price);
    }

    @Override
    public void update(Rental rental) {
    }


    public void saveRent(Rental rental) {
        rentalRepository.add(rental);
    }


    @Override
    public List<Rental> findAllRentForUserId(Long rental_id) {
        return rentalRepository.getById(rental_id);
    }

}
