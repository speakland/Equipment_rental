package org.example.service;

import org.example.entities.Snowboard;

import java.util.List;

public interface SnowboardService {
    void add(Snowboard snowboard);

    List<Snowboard> getAll();
}
