package com.spring.springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springProject.service.BusBookingService;
import com.spring.springProject.service.TicketService;
import com.spring.springProject.util.AvailabilityResponse;
import com.spring.springProject.util.BusResponse;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;

import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/booking")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookingController {
	@Autowired
	private BusBookingService bookingService;
	
	
	@Autowired
	private TicketService customerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/getAllBus")
	public BusResponse getAllBus() {
		List<Bus> busList = bookingService.showAllBuses();
		BusResponse response = new BusResponse();
		if(busList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Fetched  Successfully");
			response.setBusList(busList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch Bus");
		}
		return response;
	}
	
	
	@GetMapping("/checkAvailability/{startingPoint}/{endingPoint}/{availableDate}")
	public AvailabilityResponse checkAvailability(@PathVariable("startingPoint") String startingPoint, @PathVariable("endingPoint") String endingPoint, @PathVariable("availableDate") Date availableDate) {
		
		List<Availability> availList = customerService.checkAvailability(startingPoint, endingPoint, availableDate);
		
		AvailabilityResponse response = new AvailabilityResponse();
		if(availList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Availabilty Fetched  Successfully");
			response.setAvailList(availList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch Bus");
		}
		return response;
	}//end of checkAvailability()
	
	
}