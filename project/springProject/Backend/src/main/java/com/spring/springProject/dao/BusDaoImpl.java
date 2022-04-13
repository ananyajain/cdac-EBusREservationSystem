package com.spring.springProject.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Ticket;
import com.spring.springProject.entities.Availability;


public class BusDaoImpl implements BusDao{
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	@Override
	public Bus addBus(Bus bus)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bus);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bus;
	}
	@Override
	public Boolean updateBus(Bus bus)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Bus bus1=entityManager.find(Bus.class, bus.getBusId());
			if(bus1!=null) {
				entityTransaction.begin();
				bus1.setBusName(bus.getBusName());	
				bus1.setBusType(bus.getBusType());
				bus1.setCost(bus.getCost());
				bus1.setStartingPoint(bus.getStartingPoint());
				bus1.setEndingPoint(bus.getEndingPoint());
				bus1.setTotalSeats(bus.getTotalSeats());
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
	public Boolean deleteBus(Integer busId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Bus bus=entityManager.find(Bus.class, busId);		
			entityTransaction.begin();
			entityManager.remove(bus);
			entityTransaction.commit();
			entityManager.close();
			return true;		
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Bus getBus(Integer busId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Bus bus=entityManager.find(Bus.class, busId);		
			entityTransaction.begin();
			entityTransaction.commit();
			entityManager.close();
			return bus;		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> tickets=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket", Ticket.class);
			tickets=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tickets;
	}
	
	@Override
	public Boolean setBusAvailability(Availability availability)  {
		Boolean status=false;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(availability);
			entityTransaction.commit();
			entityManager.close();
			status =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}
}
