package com.spring.springProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_ticketDetail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDetail {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private String gender;
	
	@ManyToOne
	@JoinColumn(name = "ticket_id",referencedColumnName="ticket_id")
	@JsonIgnore
	private Ticket ticket;
	
	public void setName(String name) {
		this.name=  name;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	
}
