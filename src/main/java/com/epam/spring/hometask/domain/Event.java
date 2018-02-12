package com.epam.spring.hometask.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "EVENTS")
@AttributeOverride(name = "id", column = @Column(name = "EVENTID"))
public class Event extends DomainObject{

    @Column(name = "NAME")
	private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Auditorium auditorium;

    @Column(name = "BASEPRICE")
    private double basePrice;

	@Enumerated(EnumType.STRING)
    @Column(name = "RATING")
    private EventRating rating;

    @Column(name = "DATE")
    private Date date;

	public EventRating getRating() {
		return rating;
	}

	public void setRating(EventRating rating) {
		this.rating = rating;
	}

	public Event() {
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
	public int hashCode() {
		return Objects.hash(name);
	}

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
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
		Event other = (Event) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

    @Override
    public String toString() {
        return "Event{" +
				"id= " + super.getId() +
                " name='" + name + '\'' +
                ", auditorium=" + auditorium +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}
