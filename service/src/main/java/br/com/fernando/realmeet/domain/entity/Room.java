package br.com.fernando.realmeet.domain.entity;

import static java.util.Objects.*;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "seats" ,nullable = false)
    private Integer seats;

    @Column(name = "active" ,nullable = false)
    private Boolean active;

    public Room() {

    }

    @PrePersist
    public void prePersist() {
        if(isNull(active)) {
            active = true;
        }
    }


    private Room(Long id, String name, Integer seats, Boolean active) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.active = active;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSeats() {
        return seats;
    }

    public Boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return active == room.active
                && Objects.equals(id, room.id)
                && Objects.equals(name, room.name)
                && Objects.equals(seats, room.seats);
    }

    @Override
    public int hashCode() {
        return hash(id, name, seats, active);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                ", active=" + active +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Integer seats;
        private Boolean active;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Room build() {
            return new Room(id, name, seats, active);
        }
    }
}
