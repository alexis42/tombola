/**
 * 
 */
package com.adaming.mytombola.entiteDTO;

/**
 * @author inti0443
 *
 */
public class PersonneDTO {

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
	
	public PersonneDTO() {
		// TODO Auto-generated constructor stub
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonneDTO [idPersonne=" + idPersonne + ", prenomPersonne="
				+ prenomPersonne + ", nomPersonne=" + nomPersonne + "]";
	}
	
	
	
}
