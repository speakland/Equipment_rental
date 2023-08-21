package org.example.entities;

import java.util.Objects;

public class Helmet {
    private final Long helmet_id;
    private final Long rental_id;
    private Integer size;

    public Helmet(Long helmet_id, Long rental_id, Integer size) {
        this.helmet_id = helmet_id;
        this.rental_id = rental_id;
        this.size = size;
    }


    public Long getHelmet_id() {
        return helmet_id;
    }

    public Long getRental_id() {
        return rental_id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helmet helmet)) return false;
        return getHelmet_id().equals(helmet.getHelmet_id()) && getRental_id().equals(helmet.getRental_id()) && getSize().equals(helmet.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHelmet_id(), getRental_id(), getSize());
    }
}
