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
@DiscriminatorValue("Merdique")
public class Merdique extends Lot{

	/**
	 * @param labelLot
	 * @param prixLot
	 * @param probabilite
	 */
	public Merdique(String labelLot, Double prixLot) {
		super(labelLot, prixLot);
		
	}
	public Merdique() {
		// TODO Auto-generated constructor stub
	}

	
}
