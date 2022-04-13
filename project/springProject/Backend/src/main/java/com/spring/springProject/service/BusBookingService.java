package com.spring.springProject.service;


import java.util.Date;
import java.util.List;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Feedback;

public interface BusBookingService {

	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();
	public List<Bus> showAllBuses();
}
