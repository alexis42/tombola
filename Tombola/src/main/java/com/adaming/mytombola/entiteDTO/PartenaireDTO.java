/**
 * 
 */
package com.adaming.mytombola.entiteDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * @author inti0443
 *
 */
public class PartenaireDTO extends PersonneDTO {

	@SuppressWarnings("unused")
	private List<LotDTO> tabLot = new ArrayList<LotDTO>();
	
	
	


	/**
	 * 
	 */
	public PartenaireDTO() {
		super();
		// TODO Auto-generated constructor stub
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PartenaireDTO [idPersonne=" + idPersonne + ", prenomPersonne="
				+ prenomPersonne + ", nomPersonne=" + nomPersonne + "]";
	}
	
	
}
