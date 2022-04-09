package com.personal.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Booking")
public class CabBooking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer	bookingId;
	private String source;
	private String destination;
	private Float fare;
	private LocalDate travelDate;
	private Long userMobile;
	private Character status;
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
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
	
	
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public Long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "CabBooking [bookingId=" + bookingId + ", source=" + source + ", destination=" + destination + ", fare="
				+ fare + ", travelDate=" + travelDate + ", userMobile=" + userMobile + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getBookingId() == null) ? 0 : this.getBookingId().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CabBooking other = (CabBooking) obj;
		if (this.getBookingId() == null) {
			if (other.getBookingId() != null)
				return false;
		} 
		else if (!this.getBookingId().equals(other.getBookingId()))
			return false;
		return true;
	}

	
}
