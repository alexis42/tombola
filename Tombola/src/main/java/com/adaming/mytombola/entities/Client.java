/**
 * 
 */
package com.adaming.mytombola.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author inti0443
 *
 */
@Entity
@DiscriminatorValue("Client")
public class Client extends Personne{

	@OneToMany(mappedBy="client")
	private List<Ticket> tabTicket = new ArrayList<Ticket>();
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param prenomPersonne
	 * @param nomPersonne
	 */
	public Client(String prenomPersonne, String nomPersonne) {
		super(prenomPersonne, nomPersonne);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the tabTicket
	 */
	public List<Ticket> getTabTicket() {
		return tabTicket;
	}

	/**
	 * @param tabTicket the tabTicket to set
	 */
	public void setTabTicket(List<Ticket> tabTicket) {
		this.tabTicket = tabTicket;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [prenomPersonne=" + prenomPersonne + ", nomPersonne="
				+ nomPersonne + "]";
	}

	
	
	
	
}
