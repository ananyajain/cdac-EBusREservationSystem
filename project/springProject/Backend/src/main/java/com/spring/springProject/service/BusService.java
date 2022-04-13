package com.spring.springProject.service;

import java.util.List;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Ticket;

public interface BusService {
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus) ;
	public Boolean deleteBus(Integer busId) ;
	public Bus getBus(Integer busId);
	public List<Ticket>getAllTicket();
	public Boolean setBusAvailability(Availability availability) ;
}
