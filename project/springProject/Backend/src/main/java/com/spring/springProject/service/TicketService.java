package com.spring.springProject.service;

import java.util.*;

import com.spring.springProject.entities.Feedback;
import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.User;
import com.spring.springProject.entities.Ticket;

public interface TicketService {
	public Boolean updateCustomer(User user) ;
	public Ticket bookTicket(Ticket ticket) ;
	public Boolean cancelTicket(Long bookingId);
	public Ticket getTicketInfo(Integer bookingId);
	public List<Ticket> getAllTicket(String customerId);
	public List<Availability>checkAvailability(String source, String destination, Date date);
	public Boolean writeFeedback(Feedback feed);
}
