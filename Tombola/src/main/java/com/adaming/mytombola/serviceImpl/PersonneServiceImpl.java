/**
 * 
 */
package com.adaming.mytombola.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.mytombola.dao.IPersonneDao;
import com.adaming.mytombola.dao.ITicketDao;
import com.adaming.mytombola.entiteDTO.PersonneDTO;
import com.adaming.mytombola.entities.Personne;
import com.adaming.mytombola.entities.Ticket;
import com.adaming.mytombola.service.IPersonneService;

/**
 * @author inti0443
 *
 */
@Transactional
public class PersonneServiceImpl implements IPersonneService{

	@Autowired
	private IPersonneDao daoPersonne;
	
	@Autowired
	private ITicketDao daoTicket;
	
	@Override
	public PersonneDTO addPersonne(Personne personne) {
		// TODO Auto-generated method stub
		return daoPersonne.addPersonne(personne);
	}

	@Override
	public List<PersonneDTO> getAllPersonne() {
		// TODO Auto-generated method stub
		return daoPersonne.getAllPersonne();
	}

	@Override
	public PersonneDTO getOnePersonne(Long idPersonne) {
		// TODO Auto-generated method stub
		return daoPersonne.getOnePersonne(idPersonne);
	}

	@Override
	public PersonneDTO updatePersonne(PersonneDTO personneDTO) {
		// TODO Auto-generated method stub
		return daoPersonne.updatePersonne(personneDTO);
	}

	@Override
	public void deletePersonne(Long idPersonne) {
		
		daoPersonne.deletePersonne(idPersonne);
		
	}

	/**
	 * @param daoPersonne the daoPersonne to set
	 */
	public void setDaoPersonne(IPersonneDao daoPersonne) {
		this.daoPersonne = daoPersonne;
	}


	
	

}
