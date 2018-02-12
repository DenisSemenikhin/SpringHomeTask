package com.epam.spring.hometask.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "TICKETS")
@AttributeOverride(name = "id", column = @Column(name = "TICKETID"))
public class Ticket extends DomainObject implements Comparable<Ticket> {

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    @Column(name = "DATETIME")
    private Date dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    private Seat seat;

    public Ticket() {
    }

    public Ticket(User user, Event event, Date dateTime, Seat seat) {
        this.user = user;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Seat getSeat() {
        return seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, event, seat);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Ticket other = (Ticket) obj;
        if (dateTime == null) {
            if (other.dateTime != null) {
                return false;
            }
        } else if (!dateTime.equals(other.dateTime)) {
            return false;
        }
        if (event == null) {
            if (other.event != null) {
                return false;
            }
        } else if (!event.equals(other.event)) {
            return false;
        }
        if (seat != other.seat) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Ticket other) {
        if (other == null) {
            return 1;
        }
        int result = dateTime.compareTo(other.getDateTime());

        if (result == 0) {
            result = event.getName().compareTo(other.getEvent().getName());
        }
        if (result == 0) {
            result = this.getSeat().getNumber().compareTo(other.getSeat().getNumber());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id= " + super.getId() +
                "user=" + user +
                ", event=" + event +
                ", dateTime=" + dateTime +
                ", seat=" + seat +
                '}';
    }

    @ManyToOne(optional = false)
    private User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
