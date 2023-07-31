package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

@Repository
/*
 * 
 * It will automatically database connection string and creates a connection object
 * Hibernate ==> SessionFactory
 * JPA ==> EntityManagerFactory
 */
public interface TicketDao  extends CrudRepository<Ticket, Integer>{
	
	
	/* 
	 * 
	 * 
	 * C ==> INSERTING THE DATA ==> INSERT INTO TABLE VALUES(.....)
	 * R ==> READING THE DATA ==> SELECT * FROM TABLE
	 * U ==> UPDATE THE DATA ==> UPDATE TABLE SET ..... WHERE ....
	 * D ==> DELETE THE TABLE WHERE COLUMN=?
	 * 
	 * 
	 * CrudRepository ==> It will have all the Implementation for performing CRUD Operations
	 *                ==> 1. ClassName 2. Data Type of Primary Key
	 *                
	 *  1) findAll ==> Retrieve all Records ==> select * from tbl_ticket
	 *  2) findById ==> Retrieve Specific Record ==> select * from tbl_ticket where ticket_id=?
	 *  3) save ===> INserting and updating
	 *  4) deleteall ==> Delete all records
	 *  5) deleteByid ==> Delete speicfic record ==> delete from tbl_ticket where ticket_id=?
	 *
	 *                
	 *                
	 * 
	 * 
	 */

}
