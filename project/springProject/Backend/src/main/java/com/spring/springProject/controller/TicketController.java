package com.spring.springProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springProject.entities.Feedback;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.service.TicketService;
import com.spring.springProject.service.TicketServiceImpl;
import com.spring.springProject.util.FeedbackResponse;
import com.spring.springProject.util.TicketResponse;

@RequestMapping("/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TicketController {
	TicketService customerService=new TicketServiceImpl();
	///AdminService adminService=new AdminServiceImpl();	
	
	/*
	 * @PutMapping("enjoyer/update") public UserResponse updateCustomer(@RequestBody
	 * User user) { UserResponse response = new UserResponse();
	 * if(customerService.updateCustomer( user)) { response.setStatusCode(201);
	 * response.setMessage("Success");
	 * response.setDescription("Profile Updated Successfully");
	 * response.setUser(user); }else { response.setStatusCode(401);
	 * response.setMessage("Failed");
	 * response.setDescription("Unable to update the profile"); } return response;
	 * }//end of updateCustomer()
	 */	
	
	
	@PostMapping("/bookTicket")
	public TicketResponse bookTicket(@RequestBody Ticket ticket) {
		ticket= customerService.bookTicket(ticket);

		TicketResponse responce = new TicketResponse();
		if(ticket!=null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Ticked Booked Successfully");
			responce.setTicket(ticket);
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failed");
			responce.setDescription("Unable to book the ticket");
		}
		return responce;
	}// end of bookTicket()
	
	@DeleteMapping("/deleteTicket/{bookingId}")
	public TicketResponse cancelTicket(@PathVariable("bookingId") Long bookingId) {
		
		TicketResponse response = new TicketResponse();
		if(customerService.cancelTicket(bookingId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket canceled Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Cancel the ticket");
		}
		return response;
	}//end of cancelTicket()


	@GetMapping("/getAllTicket/{emailId}")
	public TicketResponse getAllTickets(@PathVariable("emailId") String emailId) {
		
		System.out.println(emailId);
		List<Ticket>tickets = customerService.getAllTicket(emailId);
		TicketResponse response = new TicketResponse();
		if(tickets.size() > 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket Fetched Successfully");
			response.setTicketList(tickets);
		}else {
			response.setStatusCode(401);	
			response.setMessage("Failed");
			response.setDescription("Unable to fetched the ticket");
		}
		return response;
	}//end of getTicketInfo()
	
	@GetMapping("/getTicket/{bookingId}")
	public TicketResponse getTicketInfo(@PathVariable("bookingId") int bookingId) {
		
		Ticket ticket = customerService.getTicketInfo(bookingId);
		
		TicketResponse response = new TicketResponse();
		if(ticket!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket Fetched Successfully");
			response.setTicket(ticket);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetched the ticket");
		}
		return response;
	}//end of getTicketInfo()
	
	@PostMapping("/giveFeedback")
	public FeedbackResponse giveFeedback(@RequestBody Feedback feedback) {
		
		FeedbackResponse response = new FeedbackResponse();
		if(customerService.writeFeedback(feedback)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Thank You!!!...");
			response.setFeedback(feedback);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Sorry we can't take your feedback now please give later");
		}
		return response;
	}// end of giveFeedback()
	
}
