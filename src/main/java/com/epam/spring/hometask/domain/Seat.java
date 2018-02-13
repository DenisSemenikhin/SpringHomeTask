package com.epam.spring.hometask.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEATS")
@AttributeOverride(name = "id", column = @Column(name = "SEATID"))
public class Seat extends DomainObject {

	@Column(name = "NUMBER")
	private Integer number;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private SeatStatus seatStatus;

	@ManyToOne(cascade = CascadeType.ALL)
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
		if (this == o)
			return true;
		if (!(o instanceof Seat))
			return false;

		Seat seat = (Seat) o;

		if (number != null ? !number.equals(seat.number) : seat.number != null)
			return false;
		return seatStatus == seat.seatStatus;
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (seatStatus != null ? seatStatus.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Seat{");
		sb.append("number=").append(number);
		sb.append(", seatStatus=").append(seatStatus);
		sb.append('}');
		return sb.toString();
	}

}
