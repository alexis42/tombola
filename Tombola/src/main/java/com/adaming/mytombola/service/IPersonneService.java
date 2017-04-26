/**
 * 
 */
package com.adaming.mytombola.service;

import java.util.List;

import com.adaming.mytombola.entiteDTO.PersonneDTO;
import com.adaming.mytombola.entities.Personne;

/**
 * @author inti0443
 *
 */
public interface IPersonneService {

	PersonneDTO addPersonne (Personne personne);
	
	List<PersonneDTO> getAllPersonne(); 
	
	PersonneDTO getOnePersonne(Long idPersonne);
	
	PersonneDTO updatePersonne (PersonneDTO personne); 
	
	void deletePersonne(Long idPersonne); 
	

}
