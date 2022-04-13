package com.spring.springProject.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.spring.springProject.dao.BusBookingDao;
import com.spring.springProject.dao.BusBookingDaoImpl;
import com.spring.springProject.dao.TicketDaoImpl;
import com.spring.springProject.dao.ticketDao;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.entities.User;
import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Feedback;

@Service
public class TicketServiceImpl implements TicketService{
	ticketDao customerDAO=new TicketDaoImpl();
	BusBookingDao busBookingDAO=new BusBookingDaoImpl();

	@Override
	public Boolean updateCustomer(User user)  {
		return customerDAO.updateCustomer(user);
	}
	
	@Override
	public Ticket bookTicket(Ticket ticket)  {
		return customerDAO.bookTicket(ticket);
	}
	@Override
	public Boolean cancelTicket(Long bookingId) {
		return customerDAO.cancelTicket(bookingId);
	}
	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		return customerDAO.getTicketInfo(bookingId);
	}

	@Override
	public List<Ticket> getAllTicket(String customerId) {
		return customerDAO.getAllTicket(customerId);
	}
	
	@Override
	public List<Availability> checkAvailability(String source, String destination,Date date) {
		return busBookingDAO.checkAvailability(source, destination, date);
	}
	@Override
	public Boolean writeFeedback(Feedback feed) {
		return customerDAO.writeFeedback(feed);
	}
}
