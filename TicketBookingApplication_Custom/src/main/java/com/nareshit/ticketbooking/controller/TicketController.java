package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.serice.TicketService;

@RestController
@RequestMapping(value="/ticket") //http://localhost:8080/ticket
// DispatcherServlet will register TicketController with ticket 
//http://localhost:8080/ticket== TicketController obj=new TicketController();
public class TicketController {
	
	
	/*
	 * REST PROTOCOL ==> JAX RS ==> Java IMplementation for RestServices
	 * 
	 * REST SERVICE ==> WEBSERVICE ==> Heterogenious communication
	 * 
	 * Java ==> Dotnet,PHp,MainFrame,SAP,C++
	 * 
	 * 1) SOAP BASED 2) REST BASED
	 * 
	 * 
	 * REST SERVICES ==> JSON OBJECT ==> Universally Accepted Format
	 * JAXB Libary ==> JACKSON LIBARY ==> Java to JSON and JSON to java
	 * 
	 * JSON ==> {
	 * 				KEYNAME: VALUE
	 * 				KEYNAME2:VALUE2
	 * 	
	 * 			}
	 * 
	 * 
	 * PRODUCTJSON == { 
	 * 					"PRODID":123,
	 * 					PRODNAME:"APPLE IPHONE",
	 * 					MODEL:"IPHONE13",
	 * 					PRICE:"100000",
	 * 					RATING:"5"
	 * 				}
	 * 
	 * GET==> retrieve the data ==>@GET
	 * POST ==> CREATE THE DATA ==> @POST
	 * PUT ==> UPDATE THE DATA ==> @PUT
	 * DELETE ==> DELETE THE DATA ==> @DELETE
	 * 
	 * 
	 * @GetMapping ==> @Get+ @RequestMapping
	 * @PostMapping ==> @Post+@RequestMapping
	 * @PutMapping ==> @Put+@RequestMapping
	 * @DeleteMapping ==> @Delete+ @RequestMapping	  
	 * 
	 * 
	 * 
	 * 
	 * 						
	 */

	@Autowired
	private TicketService ticketService;
	
	
	//create ticket
	@PostMapping(value="/create")
	//http://localhost:8080/ticket/create ==> obj.createTicket();
	public Ticket createTicket(@RequestBody Ticket inputObj) {
		return ticketService.createTicket(inputObj);
	}
	
	//Retriving All Tickets
	@GetMapping(value="/all")
	//http://localhost:8080/ticket/all ==> obj.getAllTickets();
	public Iterable<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	
	//Retrving Single Ticket
	//http://localhost:8080/ticket/get/1 ==> 1st Ticket
	//http://localhost:8080/ticket/get/2 ==> 2nd Ticket
	//http://localhost:8080/ticket/get/10 ==> 10th Ticket
	//http://localhost:8080/ticket/get/100 ==> 100th Tickedt
	@GetMapping(value="/get/{ticketId}")
	public Ticket retrieveTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}
	
	//Update Ticket
	//http://localhost:8080/ticket/1/ramu@gmail.com
	//@PutMapping
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket udpateTicket(@PathVariable("ticketId") Integer ticketId,
								@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}
	
	//DeleteTicket
	//http://localholst:8080/ticket/1  ==> delete 1st ticket
	@DeleteMapping(value="/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
	
}
