package com.spring.springProject.dao;

import java.util.*;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.entities.Availability;
public interface BusDao {
	public Bus addBus(Bus bus) ;
	public Boolean updateBus(Bus bus) ;
	public Bus getBus(Integer busId);
	public Boolean deleteBus(Integer busId) ;
	public List<Ticket>getAllTicket();
	public Boolean setBusAvailability(Availability availability) ;
}