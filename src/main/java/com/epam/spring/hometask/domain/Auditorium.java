package com.epam.spring.hometask.domain;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUDITORIUMS")
@AttributeOverride(name = "id", column = @Column(name = "AUDITORIUMID"))
public class Auditorium extends DomainObject {

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditorium other = (Auditorium) obj;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Auditorium [name=" + name + ", tickets=" + tickets + ", seats=" + seats + ", events=" + events + "]";
	}

}
