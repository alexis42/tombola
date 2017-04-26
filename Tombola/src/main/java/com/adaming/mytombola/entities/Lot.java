/**
 * 
 */
package com.adaming.mytombola.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * @author inti0443
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING , name ="Type_de_Lot")
public class Lot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idLot; 
	
	protected String labelLot; 
	protected Double prixLot;
	
	@OneToMany(mappedBy="lot")
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

	
	// CONSTRUCTEUR
	
	
	public Lot() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param labelLot
	 * @param prixLot
	 * @param probabilite
	 */
	public Lot(String labelLot, Double prixLot) {
		this.labelLot = labelLot;
		this.prixLot = prixLot;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lot [" + labelLot + "]";
	}
	
	
	

	
	
	
	
}
