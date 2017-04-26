/**
 * 
 */
package com.adaming.mytombola.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author inti0443
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING , name ="Type_de_Personne")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long idPersonne;
	
	protected String prenomPersonne; 
	protected String nomPersonne;
	
	
	
	// GETTER SETTER 
	
	/**
	 * @return the idPersonne
	 */
	public Long getIdPersonne() {
		return idPersonne;
	}
	/**
	 * @param idPersonne the idPersonne to set
	 */
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	/**
	 * @return the prenomPersonne
	 */
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	/**
	 * @param prenomPersonne the prenomPersonne to set
	 */
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	/**
	 * @return the nomPersonne
	 */
	public String getNomPersonne() {
		return nomPersonne;
	}
	/**
	 * @param nomPersonne the nomPersonne to set
	 */
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	} 
	
	
	
	// CONSTRUCTEUR
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param prenomPersonne
	 * @param nomPersonne
	 */
	public Personne(String prenomPersonne, String nomPersonne) {
		this.prenomPersonne = prenomPersonne;
		this.nomPersonne = nomPersonne;
	}
	
	

	
	
	
}
