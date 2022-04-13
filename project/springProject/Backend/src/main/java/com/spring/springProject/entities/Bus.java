package com.spring.springProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "bus_details")
@JsonRootName("bus_details")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Bus {
	@Id
	@Column(name = "bus_id")
	private Integer busId;
	@Column(name = "bus_name")
	private String busName;
	@Column(name = "bus_source")
	private String startingPoint;
	@Column(name = "bus_destination")
	private String endingPoint;
	@Column(name = "bus_type")
	private String busType;
	@Column(name = "bus_total_seats")
	private Integer totalSeats;
	@Column(name = "bus_cost")
	private Double cost;
	
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
	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getEndingPoint() {
		return endingPoint;
	}
	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
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
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", startingPoint=" + startingPoint + ", endingPoint="
				+ endingPoint + ", busType=" + busType + ", totalSeats=" + totalSeats + ", cost=" + cost + "]";
	}

	
}
