package com.spring.springProject.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springProject.dao.BusBookingDao;
import com.spring.springProject.dao.BusBookingDaoImpl;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Feedback;
@Service
public class BusBookingServiceImpl implements BusBookingService{
	BusBookingDao busBookingDAO=new BusBookingDaoImpl();


	@Override
	public List<Availability> checkAvailability(String source, String destination, Date date) {
		return busBookingDAO.checkAvailability(source, destination, date);
	}

	@Override
	public List<Feedback> viewFeedback() {
		return busBookingDAO.viewFeedback();
	}

	@Override
	public List<Bus> showAllBuses() {
		return busBookingDAO.showAllBuses();
	}
}
