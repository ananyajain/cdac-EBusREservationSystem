package com.spring.springProject.util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.springProject.entities.Availability;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvailabilityResponse {

	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private Availability availability;
	@XmlElement
	private List<Availability> availList;

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public List<Availability> getAvailList() {
		return availList;
	}
	public void setAvailList(List<Availability> availList) {
		this.availList = availList;
	}

}