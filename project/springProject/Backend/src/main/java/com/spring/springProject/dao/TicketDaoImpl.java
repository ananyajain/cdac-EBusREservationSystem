package com.spring.springProject.dao;

import java.util.Date;
import java.time.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Feedback;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.entities.TicketDetail;
import com.spring.springProject.entities.User;

public class TicketDaoImpl implements ticketDao {
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Boolean updateCustomer(User customer)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			//customer.setUserId(AdminDAOImpl.id);
			User customer2=entityManager.find(User.class, customer.getId());
			if(customer2!=null) {
				entityTransaction.begin();
				customer2.setName(customer.getName());
				customer2.setEmail(customer.getEmail());
				customer2.setMobile(customer.getMobile());
				customer2.setPassword(customer.getPassword());			
				entityTransaction.commit();
				entityManager.close();
				return true;
			}		
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}
	
	@Override
	public Ticket bookTicket(Ticket ticket)  {
		Availability availability=null;
		Ticket bookedTicket=null;
		List<Availability> availList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			ticket.setBookingDateTime(new Date());
			System.out.println(ticket.getBusId());
			System.out.println(ticket.getTicketDetails());
			for(int i=0;i<ticket.getNumOfSeats();i++) {
				TicketDetail detail = ticket.getTicketDetails().get(i);
				detail.setTicket(ticket);
			}
			entityManager.persist(ticket);
			LocalDate t = ticket.getJourneyDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Query availQuery=entityManager.createQuery("FROM Availability WHERE busId=:bId and availableDate=:aDate", Availability.class);
			availQuery.setParameter("bId", ticket.getBusId());
			availQuery.setParameter("aDate", t);
			availList=availQuery.getResultList();
			availability=availList.get(0);
			availability.setAvailableSeat(availability.getAvailableSeat()-ticket.getNumOfSeats());
			entityManager.getTransaction().commit();
			entityManager.close();
			return ticket;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookedTicket;
	}
	@Override
	public Boolean cancelTicket(Long bookingId) {
		Boolean status=false;
		Ticket ticket=null;
		Availability availability=null;
		List<Ticket> tickets=null;
		List<Availability> availList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket WHERE id=:bId", Ticket.class);
			TypedQuery<Availability> availQuery=entityManager.createQuery("FROM Availability WHERE availableDate=:aDate and busId=:bid", Availability.class);
			//query.setParameter("id",  );
			query.setParameter("bId", bookingId);
			System.out.println(bookingId);
			tickets=query.getResultList();
			if (tickets.size()>0) {
				ticket=tickets.get(0);
				entityManager.remove(ticket);
				//to increment cancelled ticket 
				LocalDate t = ticket.getJourneyDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				availQuery.setParameter("aDate",t);
				availQuery.setParameter("bid", ticket.getBusId());
				availList=availQuery.getResultList();
				availability=availList.get(0);
				availability.setAvailableSeat(availability.getAvailableSeat()+ticket.getNumOfSeats());
				status=true;
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			//feed.setCustomerId(AdminDAOImpl.id);
			entityManager.persist(feed);
			entityTransaction.commit();
			entityManager.close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		Ticket ticket=null;
		List<Ticket> tickets=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket where ticket_id=:id", Ticket.class);
			query.setParameter("id", bookingId);
			tickets=query.getResultList();
			if(tickets.size()>0) {
				ticket=tickets.get(0);
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	@Transactional
	public List<Ticket> getAllTicket(String customerId) {
		List<Ticket> tickets=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket where emailId=:id", Ticket.class);
			query.setParameter("id", customerId);
			tickets=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tickets;
	}
}
