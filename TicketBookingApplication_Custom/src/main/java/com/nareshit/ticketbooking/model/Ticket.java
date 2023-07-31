package com.nareshit.ticketbooking.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tbl_ticket")
/* @Entity It will create a table in the database
 * By default Class Name will be Table Name ==> Ticket
 * @Table ==> Customizes the table name ==> Rather than classname ==> If we want our own name
 * @Column ==> Customizes the column name ==> Optional 
 * If we dont have @column ==> propertyname will be the column name
 * @Id==> It will create Primary Key
 * AUTO ==> JPA WILL TAKE CARE OF GENERATING THE PRIMARY KEY
 *      ==> JPA will create a database sequence and it will increments every time record is created

*/
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="destination_station")
	private String destinationStation;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	
	private String email;


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public String getSourceStation() {
		return sourceStation;
	}


	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}


	public String getDestinationStation() {
		return destinationStation;
	}


	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}


	public Date getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Ticket( String passengerName, String sourceStation, String destinationStation,
			Date travelDate, String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = travelDate;
		this.email = email;
	}
	
	public Ticket( ) {}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}
	
	
	

}
