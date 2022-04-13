package com.spring.springProject.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
@Entity
@Table(name = "avail_details")
@JsonRootName("avail_details")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Availability {
	@Column(name = "avail_date")
	private LocalDate availableDate;
	@Column(name = "avail_seat")
	private Integer availableSeat;
	@Id
	@Column(name = "bus_id")
	private Integer busId;
	
	public LocalDate getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}
	public Integer getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(Integer availableSeat) {
		this.availableSeat = availableSeat;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	@Override
	public String toString() {
		return "Availability [availableDate=" + availableDate + ", availableSeat=" + availableSeat + ", busId=" + busId
				+ "]";
	}

	
}

