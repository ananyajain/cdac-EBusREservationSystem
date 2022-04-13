package com.spring.springProject.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.springProject.entities.Feedback;

@XmlRootElement(name= "user-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackResponse {
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private Feedback feedback;
	@XmlElement
	private List<Feedback> feedList;

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public List<Feedback> getFeedList() {
		return feedList;
	}
	public void setFeedList(List<Feedback> feedList) {
		this.feedList = feedList;
	}

}
