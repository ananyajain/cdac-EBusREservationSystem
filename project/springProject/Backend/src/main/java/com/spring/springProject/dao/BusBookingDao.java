package com.spring.springProject.dao;

import java.util.Date;
import java.util.List;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Feedback;



public interface BusBookingDao {

	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();
	public List<Bus> showAllBuses();

}
