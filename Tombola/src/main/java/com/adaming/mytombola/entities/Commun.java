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
@DiscriminatorValue("Commun")
public class Commun extends Lot{

	/**
	 * @param labelLot
	 * @param prixLot
	 * @param probabilite
	 */
	public Commun(String labelLot, Double prixLot) {
		super(labelLot, prixLot);
			}

	public Commun() {
		// TODO Auto-generated constructor stub
	}

	
}
