package com.challenge.entity.ids;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AccelerationId implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccelerationId that = (AccelerationId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
