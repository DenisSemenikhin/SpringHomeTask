package com.epam.spring.hometask.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SEATS")
@AttributeOverride(name = "id", column = @Column(name = "SEATID"))
public class Seat extends DomainObject{

    @Column(name = "NUMBER")
    private Integer number;


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private SeatStatus seatStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private Auditorium auditorium;

    public Seat() {
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(number, seat.number) &&
                seatStatus == seat.seatStatus &&
                Objects.equals(auditorium, seat.auditorium);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, seatStatus, auditorium);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                ", seatStatus=" + seatStatus +
                ", auditorium=" + auditorium +
                '}';
    }
}
