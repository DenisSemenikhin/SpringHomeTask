package com.epam.spring.hometask.service.impl;

/*
//@Service
public class AuditoriumServiceImpl implements AuditoriumService {


	@Resource(name = "bunchOfAuditoriums")
	private Map<String, Auditorium> auditoriums;

	public Map<String, Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Map<String, Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	@Override
	public Set<Auditorium> getAll() {
		return new HashSet<Auditorium>(auditoriums.values());
	}

	@Override
	public Auditorium getByName(String auditoriumName) {
		return auditoriums.get(auditoriumName);
	}

	/**
     * Counts how many vip seats are there in supplied <code>seats</code>
     *
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
/*
        public long countVipSeats(Auditorium auditorium) {
        return auditorium.getSeats().stream().
        filter(seat -> seat.getSeatStatus().equals(SeatStatus.VIP)).count();
        }

}
*/