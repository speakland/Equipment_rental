package org.example.service.impl;
import org.example.entities.Snowboard;
import org.example.repository.SnowboardRepository;
import org.example.service.SnowboardService;
import org.example.utils.PullConnection;
import java.util.List;

public class SnowboardServiceImpl implements SnowboardService {

    private final SnowboardRepository snowboardRepository = new SnowboardRepository(new PullConnection());
    @Override
    public void add(Snowboard snowboard) {
        snowboardRepository.add(snowboard);

    }

    @Override
    public List<Snowboard> getAll() {
        return snowboardRepository.getAll();
    }
}
