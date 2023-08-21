package org.example.entities;

import java.util.Objects;

public class Snowboard {

    private final Long snowboard_id;
    private final Long rental_id;
    private Integer length;
    private Integer width;

    public Snowboard(Long snowboard_id, Long rental_id, Integer length, Integer width) {
        this.snowboard_id = snowboard_id;
        this.rental_id = rental_id;
        this.length = length;
        this.width = width;
    }

    public Long getSnowboard_id() {
        return snowboard_id;
    }

    public Long getRental_id() {
        return rental_id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snowboard snowboard)) return false;
        return getSnowboard_id().equals(snowboard.getSnowboard_id()) && getRental_id().equals(snowboard.getRental_id()) && getLength().equals(snowboard.getLength()) && getWidth().equals(snowboard.getWidth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSnowboard_id(), getRental_id(), getLength(), getWidth());
    }
}

