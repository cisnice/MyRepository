package com.mycompany.myapp.restaurant.service;

public class EventService {
	public int create(Event event){
		return SUCCESS;
	}
	
	public int delete(String ename){
		return SUCCESS;
	}
	
	public int modify(Event event){
		Event event = new Event();
		return event;
	}
}