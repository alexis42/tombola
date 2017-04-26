/**
 * 
 */
package com.adaming.mytombola.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.mytombola.dao.IPersonneDao;
import com.adaming.mytombola.entiteDTO.PersonneDTO;
import com.adaming.mytombola.entities.Client;
import com.adaming.mytombola.entities.Lot;
import com.adaming.mytombola.entities.Partenaire;
import com.adaming.mytombola.entities.Personne;
import com.adaming.mytombola.entities.Ticket;


/**
 * @author inti0443
 *
 */
public class PersonneDaoImpl implements IPersonneDao{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public PersonneDTO addPersonne(Personne personne) {
		entityManager.persist(personne);
		PersonneDTO personneDTO = new PersonneDTO();
		personneDTO.setIdPersonne(personne.getIdPersonne());
		personneDTO.setNomPersonne(personne.getNomPersonne());
		personneDTO.setPrenomPersonne(personne.getPrenomPersonne());
		return personneDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneDTO> getAllPersonne() {
		Query query = entityManager.createQuery("from Personne");
		List<Personne> tabPersonne = query.getResultList(); 
		List<PersonneDTO>tabPersonneDTO = new ArrayList<PersonneDTO>();
	
		for (Personne x : tabPersonne) {
			
			PersonneDTO personneDTO = new PersonneDTO();
			personneDTO.setIdPersonne(x.getIdPersonne());
			personneDTO.setNomPersonne(x.getNomPersonne());
			personneDTO.setPrenomPersonne(x.getPrenomPersonne());
			tabPersonneDTO.add(personneDTO);
			
		}
		return tabPersonneDTO;
	}

	@Override
	public PersonneDTO getOnePersonne(Long idPersonne) {
		Personne personne = entityManager.find(Personne.class, idPersonne);
		PersonneDTO personneDTO = new PersonneDTO();
		personneDTO.setIdPersonne(personne.getIdPersonne());
		personneDTO.setNomPersonne(personne.getNomPersonne());
		personneDTO.setPrenomPersonne(personne.getPrenomPersonne());
		
		return personneDTO;
	}

	@Override
	public PersonneDTO updatePersonne(PersonneDTO personneDTO) {
		Personne personne = entityManager.find(Personne.class, personneDTO.getIdPersonne());
		personne.setNomPersonne(personneDTO.getNomPersonne());
		personne.setPrenomPersonne(personneDTO.getPrenomPersonne());
		entityManager.merge(personne);
		
		return personneDTO;
	}

	@Override
	public void deletePersonne(Long idPersonne) {
		Personne personne = entityManager.find(Personne.class, idPersonne);
		
		if (personne.getClass().getSimpleName().equalsIgnoreCase( "Partenaire")) {
			
			Partenaire partenaire = (Partenaire) personne;
			
			for (Lot l : partenaire.getTabLot()) {
				entityManager.remove(l);
			}
			entityManager.remove(personne);
			
		}else if (personne.getClass().getSimpleName().equalsIgnoreCase("Client")) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Client client = (Client) personne;
			for (Ticket t : client.getTabTicket()) {
				entityManager.remove(t);
			}
			entityManager.remove(personne);
		}
		
		
		
	}



}
