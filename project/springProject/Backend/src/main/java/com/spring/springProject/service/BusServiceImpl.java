package com.spring.springProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springProject.dao.BusDao;
import com.spring.springProject.dao.BusDaoImpl;
import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Ticket;

@Service
public class BusServiceImpl implements BusService{
	
	BusDao ownerDAO=new BusDaoImpl();
	@Override
	public Bus addBus(Bus bus)  {
		return ownerDAO.addBus(bus);
	}

	@Override
	public Bus getBus(Integer busId)  {
		return ownerDAO.getBus(busId);
	}

	@Override
	public Boolean updateBus(Bus bus)  {
		return ownerDAO.updateBus(bus);
	}
	@Override
	public Boolean deleteBus(Integer busId)  {
		return ownerDAO.deleteBus(busId);
	}
	@Override
	public List<Ticket> getAllTicket() {
		return ownerDAO.getAllTicket();
	}
	@Override
	public Boolean setBusAvailability(Availability availability)  {
		return ownerDAO.setBusAvailability(availability);
	}
}
