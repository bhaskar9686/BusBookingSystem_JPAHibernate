package com.capgemini.busscheduling.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bus_info")
public class Bus {

	@Id
	@Column(name="bus_id")
	private Integer busId;
	@Column(name="bus_name")
	private String busName;
	private String source;
	private String destination;
	@Column(name="bus_type")
	private String busType;
	@Column(name="total_seats")
	private Integer totalSeats;
	private Double price;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="busId")
	private List<Ticket> tickets;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="busId")
	private List<Availability> availability;

	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public List<Availability> getAvailability() {
		return availability;
	}
	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", source=" + source + ", destination=" + destination
				+ ", busType=" + busType + ", totalSeats=" + totalSeats + ", price=" + price + "]";
	}
}
