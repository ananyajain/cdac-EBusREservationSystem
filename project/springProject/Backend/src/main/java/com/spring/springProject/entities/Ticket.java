package com.spring.springProject.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@Entity
@Table(name = "tbl_ticket")
@JsonRootName("ticket")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Ticket {
	@Id
	@GeneratedValue
	@JsonProperty("ticket_id")
	@Column(name = "ticket_id")
	private Long id;
	
	@Column(name = "bus_id")
	private Integer busId;
	@Column(name = "customer_id")
	private String emailId;
	
	@OneToMany(targetEntity = TicketDetail.class, mappedBy = "ticket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<TicketDetail> ticketDetails;
	
	@Column(name = "journey_date")
	private Date journeyDate;
	
	@Column(name = "number_of_seats")
	private Integer numOfSeats;
	
	@Column(name = "booking_date_time")
	private Date bookingDateTime;	

	public Long getId() {
		return id;
	}
	
	public void setTicketDetails(List<TicketDetail> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	
	public List<TicketDetail> getTicketDetails(){
		return ticketDetails;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getBusId() {
		return busId;
	}


	public void setBusId(Integer busId) {
		this.busId = busId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Date getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(Date journeyDate) {
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
		return "Ticket [bookingId=" + id + ", busId=" + busId + ", customerEmailId=" + emailId + ", journeyDate="
				+ journeyDate + ", numOfSeats=" + numOfSeats + ", bookingDateTime=" + bookingDateTime + "]";
	}
	
}
