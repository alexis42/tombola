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
public class LotDTO {

	protected Long idLot; 
	
	protected String labelLot; 
	protected Double prixLot;
	
	protected List<Ticket> tabTicket = new ArrayList<Ticket>();
	
	
	// GETTER SETTER 
	
	/**
	 * @return the idLot
	 */
	public Long getIdLot() {
		return idLot;
	}
	/**
	 * @param idLot the idLot to set
	 */
	public void setIdLot(Long idLot) {
		this.idLot = idLot;
	}
	/**
	 * @return the labelLot
	 */
	public String getLabelLot() {
		return labelLot;
	}
	/**
	 * @param labelLot the labelLot to set
	 */
	public void setLabelLot(String labelLot) {
		this.labelLot = labelLot;
	}
	/**
	 * @return the prixLot
	 */
	public Double getPrixLot() {
		return prixLot;
	}
	/**
	 * @param prixLot the prixLot to set
	 */
	public void setPrixLot(Double prixLot) {
		this.prixLot = prixLot;
	}



	
	// CONSTRUCTEUR
	
	public LotDTO() {
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LotDTO [idLot=" + idLot + ", labelLot=" + labelLot
				+ ", prixLot=" + prixLot + "]";
	}
	

	
	
	
	
}
