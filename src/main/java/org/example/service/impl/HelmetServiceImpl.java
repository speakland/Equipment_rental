package org.example.service.impl;
import org.example.entities.Helmet;
import org.example.repository.HelmetRepository;
import org.example.service.HelmetService;
import org.example.utils.PullConnection;

import java.util.List;

public class HelmetServiceImpl implements HelmetService {

    private final HelmetRepository helmetRepository = new HelmetRepository( new PullConnection());


    @Override
    public void add(Helmet helmet) {
        helmetRepository.add(helmet);

    }

    @Override
    public List<Helmet> getAll() {
        return helmetRepository.getAll();
    }
}
