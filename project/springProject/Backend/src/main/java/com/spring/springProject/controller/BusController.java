package com.spring.springProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Feedback;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.service.BusBookingService;
import com.spring.springProject.service.BusService;
import com.spring.springProject.util.AvailabilityResponse;
import com.spring.springProject.util.BusResponse;
import com.spring.springProject.util.FeedbackResponse;
import com.spring.springProject.util.TicketResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/buses")
@RestController
public class BusController {
	
	private static Logger log = LoggerFactory.getLogger(BusController.class);

	@Autowired
	private BusService busService;
	
	@Autowired
	private BusBookingService busBookingService;
	
	@PostMapping("/addBus")
	public BusResponse addBus(@RequestBody Bus bus) {
		
		 bus= busService.addBus(bus);
		
		 BusResponse response = new BusResponse();
		if(bus!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus added Successfully");
			response.setBus(bus);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Add");
		}
		return response;
	}//end of addBus()

	@GetMapping("/bus/{busId}")
	public BusResponse getBus(@PathVariable("busId") int busId) {
		
		 Bus bus= busService.getBus(busId);
		
		 BusResponse response = new BusResponse();
		if(bus!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus added Successfully");
			response.setBus(bus);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Add");
		}
		return response;
	}//end of addBus()
	
	@PutMapping("/updateBus")
	public BusResponse updateBus(@RequestBody Bus bus) {
		
		 BusResponse response = new BusResponse();
		if(busService.updateBus(bus)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus updated Successfully");
			response.setBus(bus);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update");
		}
		return response;
	}//end of updateBus()
	
	@DeleteMapping("/deleteBus/{busId}")
	public BusResponse deleteBus(@PathVariable("busId") int busId) {
		
		BusResponse response = new BusResponse();
		if(busService.deleteBus(busId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of deleteBus()
	
	
	//***************************************************
	@GetMapping(path="/getAllTicket", 
			produces = {})
	public TicketResponse getAllTicket() {
		
		List<Ticket> ticketList = busService.getAllTicket();
		
		TicketResponse response = new TicketResponse();
		if(ticketList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket Fetched Successfully");
			response.setTicketList(ticketList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch the tickets");
		}
		return response;
	}//end of getAllTicket()
	
	@PostMapping("/seatAvaliability")
	public AvailabilityResponse seatAvailability(@RequestBody Availability availabilty) {
		
		AvailabilityResponse response = new AvailabilityResponse();
		log.info("BusResource Impl","Seat availability");
		
		if(busService.setBusAvailability(availabilty)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Update Seat availability");
			response.setAvailability(availabilty);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of setAvailability()
	@GetMapping("/getFeedback")
	public FeedbackResponse getAllFeedback() {
		
		List<Feedback> feedList = busBookingService.viewFeedback();
		
		FeedbackResponse response = new FeedbackResponse();
		if(feedList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Feedback Fetched  Successfully");
			response.setFeedList(feedList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch feedbacks");
		}
		return response;
	}// end of getAllFeedback()
}
