package com.epam.spring.hometask.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;


@Entity
@Table (name = "AUDITORIUMS")
@AttributeOverride(name = "id", column = @Column(name = "AUDITORIUMID"))
public class Auditorium extends DomainObject{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
	private String name;

	@OneToMany
	private Set<Ticket> tickets = new TreeSet<>();

	@OneToMany
	private Set<Seat> seats = new HashSet<>();

    @OneToMany
    private Set<Event> events = new TreeSet<>();

	public Auditorium() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(NavigableSet<Ticket> tickets) {
		this.tickets = tickets;
	}

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return tickets != null ? tickets.equals(that.tickets) : that.tickets == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }


}
