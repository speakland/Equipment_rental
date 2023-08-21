package org.example.service;

import org.example.entities.Helmet;

import java.util.List;

public interface HelmetService {

    void add(Helmet helmet);

    List<Helmet> getAll();
}
