/**
 * 
 */
package com.adaming.mytombola.entiteDTO;
import com.adaming.mytombola.entities.Client;
import com.adaming.mytombola.entities.Lot;

/**
 * @author inti0443
 *
 */
public class TicketDTO {

	private Long idTicket; 
	private Double prixTicket;
	
	private Client client;

	private Lot lot; 
	

	// GETTER SETTER
	
	/**
	 * @return the prixTicket
	 */
	public Double getPrixTicket() {
		return prixTicket;
	}
	/**
	 * @param prixTicket the prixTicket to set
	 */
	public void setPrixTicket(Double prixTicket) {
		this.prixTicket = prixTicket;
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
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
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
	 * @param lot the lot to set
	 */
	public void setLot(Lot lot) {
		this.lot = lot;
	}
	
	//CONSTRUCTEUR
	

	public TicketDTO() {
		// TODO Auto-generated constructor stub
	}
		

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketDTO [idTicket=" + idTicket + ", prixTicket=" + prixTicket
				+  "]";
	}
}
