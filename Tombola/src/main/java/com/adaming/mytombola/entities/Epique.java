/**
 * 
 */
package com.adaming.mytombola.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author inti0443
 *
 */
@Entity
@DiscriminatorValue("Epique")
public class Epique extends Lot{

	/**
	 * @param labelLot
	 * @param prixLot
	 * @param probabilite
	 */
	public Epique(String labelLot, Double prixLot) {
		super(labelLot, prixLot);
		
	}
	public Epique() {
		// TODO Auto-generated constructor stub
	}

	
	
	

	

}
