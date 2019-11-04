package com.capgemini.busscheduling.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private Integer busId;
	private Integer id;
	@Column(name="journey_date")
	private String journeyDate;
	@Column(name="num_of_seats")
	private Integer numOfSeats;
	@Column(name="booking_time")
	private Date bookingDateTime;

	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Integer getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	public Date getBookingDateTime() {
		return bookingDateTime;
	}
	public void setBookingDateTime(Date bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}
	@Override
	public String toString() {
		return "Ticket [bookingId=" + bookingId + ", busId=" + busId + ", id=" + id + ", journeyDate=" + journeyDate
				+ ", numOfSeats=" + numOfSeats + ", bookingDateTime=" + bookingDateTime + "]";
	}
	
}
