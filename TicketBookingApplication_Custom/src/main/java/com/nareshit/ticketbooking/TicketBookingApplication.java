package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.serice.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner {
	
	/*
	 * 
	 * CommandLineRunner is an Interface which has run method 
	 * What ever the code written inside Run Method will be executed only once during startup
	 * 
	 * We will create one sample Ticket during startup
	 */
	
	
	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ticket ticketObj=new Ticket();
		ticketObj.setPassengerName("NARESH");
		ticketObj.setSourceStation("HYDERABAD");
		ticketObj.setDestinationStation("DELHI");
		ticketObj.setTravelDate(new Date());
		ticketObj.setEmail("naresh@gmail.com");
		
		ticketService.createTicket(ticketObj);
		
		
	}

}
