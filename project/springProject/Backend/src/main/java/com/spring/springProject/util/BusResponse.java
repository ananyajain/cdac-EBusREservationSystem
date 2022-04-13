package com.spring.springProject.util;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.springProject.entities.Bus;



@XmlRootElement(name= "bus-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusResponse {

	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private Bus bus;
	@XmlElement
	private List<Bus> busList;

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
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public List<Bus> getBusList() {
		return busList;
	}
	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}
}
