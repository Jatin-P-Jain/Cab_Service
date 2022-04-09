package com.personal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fare")
public class FareEstimation {
	
	@Id
	private Integer fareId;
	private String source;
	private String destination;
	private Float fare;
	
	public Integer getFareId() {
		return fareId;
	}
	public void setFareId(Integer fareId) {
		this.fareId = fareId;
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
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getFareId() == null) ? 0 : this.getFareId().hashCode());
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
		FareEstimation other = (FareEstimation) obj;
		if (this.getFareId() == null) {
			if (other.getFareId() != null)
				return false;
		} 
		else if (!this.getFareId().equals(other.getFareId()))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FareEstimation [fareId=" + fareId + ", source=" + source + ", destination=" + destination + ", fare="
				+ fare + "]";
	}
	
	
}
