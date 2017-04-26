/**
 * 
 */
package com.adaming.mytombola.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * @author inti0443
 *
 */
@Entity
@DiscriminatorValue("Organisateur")
public class Organisateur extends Personne{

	@OneToMany(fetch =FetchType.LAZY)
	@JoinTable(name="TB_ORGANISATEUR_TICKET")
	private List<Ticket> tabTicket = new ArrayList<Ticket>();
	
	public Organisateur() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param prenomPersonne
	 * @param nomPersonne
	 */
	public Organisateur(String prenomPersonne, String nomPersonne) {
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
	

	
}
