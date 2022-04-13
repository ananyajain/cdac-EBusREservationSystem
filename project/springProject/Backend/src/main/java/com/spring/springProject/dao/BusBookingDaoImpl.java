package com.spring.springProject.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.*;  
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.spring.springProject.entities.Availability;
import com.spring.springProject.entities.Bus;
import com.spring.springProject.entities.Feedback;


public class BusBookingDaoImpl implements BusBookingDao{

	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	
	static Date jdate;

	@Override
	public List<Availability> checkAvailability(String source, String destination, Date date) {
		List<Availability> availList=new ArrayList<Availability>();
		List<Availability> resultList=null;
		List<Bus> busList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Bus> query=entityManager.createQuery("FROM Bus WHERE startingPoint=:sp and endingPoint=:ep", Bus.class);
			query.setParameter("sp", source);
			query.setParameter("ep", destination);
			TypedQuery<Availability> availQuery=entityManager.createQuery("FROM Availability WHERE busId=:bid and availableDate=:aDate", Availability.class);
			busList=query.getResultList();
			if (busList.size()>0) {
				for (Bus bus : busList) {
					
					LocalDate t = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					System.out.println(t);
					availQuery.setParameter("bid", bus.getBusId());
					availQuery.setParameter("aDate", t);
					this.jdate=date;
					resultList=availQuery.getResultList();

					//storing in array list
					availList.addAll(resultList);					
				}
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availList;
	}
	@Override
	public List<Feedback> viewFeedback() {
		List<Feedback> feedbacks=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Feedback> query=entityManager.createQuery("FROM Feedback", Feedback.class);
			feedbacks=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedbacks;
	}
	@Override
	public List<Bus> showAllBuses() {	
		List<Bus> buses=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Bus> query=entityManager.createQuery("FROM Bus", Bus.class);
			buses=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buses;
	}



}

