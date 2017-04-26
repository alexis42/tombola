/**
 * 
 */
package com.adaming.mytombola.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author inti0443
 * 
 */
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTicket;
	private Double prixTicket = 20D;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CLIENT")
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_LOT")
	private Lot lot;

	// GETTER SETTER

	
	/**
	 * @return the prixTicket
	 */
	public Double getPrixTicket() {
		return prixTicket;
	}

	/**
	 * @return the idTicket
	 */
	public Long getIdTicket() {
		return idTicket;
	}

	/**
	 * @param idTicket the idTicket to set
	 */
	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	/**
	 * @param prixTicket
	 *            the prixTicket to set
	 */
	public void setPrixTicket(Double prixTicket) {
		this.prixTicket = prixTicket;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the lot
	 */
	public Lot getLot() {
		return lot;
	}

	/**
	 * @param lot
	 *            the lot to set
	 */
	public void setLot(Lot lot) {
		this.lot = lot;
	}

	// CONSTRUCTEUR

	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", client=" + client  + lot + "]";
	}
	
	


}
