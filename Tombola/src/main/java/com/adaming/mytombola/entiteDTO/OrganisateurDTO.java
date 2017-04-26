/**
 * 
 */
package com.adaming.mytombola.entiteDTO;

import java.util.ArrayList;
import java.util.List;

import com.adaming.mytombola.entities.Ticket;

/**
 * @author inti0443
 *
 */
public class OrganisateurDTO extends PersonneDTO{

	@SuppressWarnings("unused")
	private List<Ticket> tabTicket = new ArrayList<Ticket>();
	


	
	/**
	 * 
	 */
	public OrganisateurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisateurDTO [idPersonne="
				+ idPersonne + ", prenomPersonne=" + prenomPersonne
				+ ", nomPersonne=" + nomPersonne + "]";
	}
	

	
}
