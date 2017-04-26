/**
 * 
 */
package com.adaming.mytombola.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * @author inti0443
 *
 */
@Entity
@DiscriminatorValue("Partenaire")
public class Partenaire extends Personne{

	@OneToMany
	@JoinTable(name="TB_PARTENAIRE_LOT")
	private List<Lot> tabLot = new ArrayList<Lot>();
	
	public Partenaire() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param prenomPersonne
	 * @param nomPersonne
	 */
	public Partenaire(String prenomPersonne, String nomPersonne) {
		super(prenomPersonne, nomPersonne);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the tabLot
	 */
	public List<Lot> getTabLot() {
		return tabLot;
	}


	/**
	 * @param tabLot the tabLot to set
	 */
	public void setTabLot(List<Lot> tabLot) {
		this.tabLot = tabLot;
	}

	
	
	
}
