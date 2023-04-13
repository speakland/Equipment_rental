package entities;

import java.util.Objects;

public class Helmet {
    private final Integer helmet_id;
    private final Integer rental_id;
    private Integer size;

    public Helmet(Integer helmet_id, Integer rental_id, Integer size) {
        this.helmet_id = helmet_id;
        this.rental_id = rental_id;
        this.size = size;
    }


    public Integer getHelmet_id() {
        return helmet_id;
    }

    public Integer getRental_id() {
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
