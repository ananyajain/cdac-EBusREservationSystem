package com.spring.springProject.dao;

import java.util.*;
import com.spring.springProject.entities.Feedback;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.entities.User;

public interface ticketDao {
	//user operations	
		public Boolean updateCustomer(User customer) ;
		public Ticket bookTicket(Ticket ticket) ;
		public Boolean cancelTicket(Long bookingId);
		public Ticket getTicketInfo(Integer bookingId);
		public List<Ticket> getAllTicket(String customerId);
		public Boolean writeFeedback(Feedback feed);
}
