package com.nareshit.ticketbooking.serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

@Service
//It will automatically instanitate transaction Manamgnet and all external systems communications
// Hibernate,JAX WS , KAFKA,Rabit MQ...external Java Frameworks ==> Configuration will be handled by service Layer
public class TicketService {
	
	
	//Need to instantiate TicketDao
	//TicketDao ticketdao=new TicketDao();
	//TicketDao ticketdao;
	//ProducgtDao prodDao;
	//PaymentDao payDao;
	
	
	@Autowired
	private TicketDao ticketDao;
	
	
	//Retrieve All Tickets
	
	public Iterable<Ticket> getAllTickets(){
		
		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket 
		//Resultset converted into Iterable<Ticket>
		
	}
	
	
	//Retrieve Individual Ticket
	
	public Ticket getTicket(Integer ticketId) {
		return ticketDao.findById(ticketId)
				.orElse(new Ticket());
				
		//findById ==> select * from tbl_ticket where ticket_id=ticketId;
	}
	
	
	//Create Ticket
	public Ticket createTicket(Ticket ticketObj) {
		return ticketDao.save(ticketObj);
		//save ==> insert into tbl_ticket values (tiketObj.id,name,source...);
		//By default save Method is for inserting and updating
		//if ticketObj.ticketId ==> null ==> insert the record
		//if ticketObj.ticketId != null && ticketObj.ticketId is not there in the database ==> insert the record
		
		
		
	}
	
	
	
	//Update Ticket
	public Ticket updateTicket(Integer ticketId,String  newEmail) {
		
		Ticket dbTicketObj=getTicket(ticketId);
		dbTicketObj.setEmail(newEmail);
		return ticketDao.save(dbTicketObj);
		
		//Here save Method will update the record
		//dbTicketObj.getTicketId != null and this id will exists in the database
		//Update tbl_ticket set email=newEmail where ticket_id=ticketId
		
		
		
	}
	
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		
		//deleteById ==> delete tbl_ticket where ticket_id=ticketId
	}
	
	
	
	
	
	
	
	
	
	//Delete Ticket

}
