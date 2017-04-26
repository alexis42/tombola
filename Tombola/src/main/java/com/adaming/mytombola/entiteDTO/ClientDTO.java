/**
 * 
 */
package com.adaming.mytombola.entiteDTO;

import java.util.ArrayList;
import java.util.List;

import com.adaming.mytombola.entities.Ticket;


public class ClientDTO extends PersonneDTO{

	private List<Ticket> tabTicket = new ArrayList<Ticket>();

	/**
	 * 
	 */
	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientDTO [tabTicket=" + tabTicket + ", idPersonne="
				+ idPersonne + ", prenomPersonne=" + prenomPersonne
				+ ", nomPersonne=" + nomPersonne + "]";
	}

	
}
