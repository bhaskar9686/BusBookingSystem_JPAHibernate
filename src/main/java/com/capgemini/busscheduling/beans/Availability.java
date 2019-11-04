package com.capgemini.busscheduling.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="availability")
public class Availability {

	@Column(name="avail_date")
	private String availDate;
	@Column(name="avail_seats")
	private Integer availSeat;
	@Id
	private Integer busId;

	
	public String getAvailDate() {
		return availDate;
	}
	public void setAvailDate(String availDate) {
		this.availDate = availDate;
	}
	public Integer getAvailSeat() {
		return availSeat;
	}
	public void setAvailSeat(Integer availSeat) {
		this.availSeat = availSeat;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return "Availability [availDate=" + availDate + ", availSeat=" + availSeat + ", busId="
				+ busId + "]";
	}
}
