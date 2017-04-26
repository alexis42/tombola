/**
 * 
 */
package com.adaming.mytombola.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.mytombola.dao.ITicketDao;
import com.adaming.mytombola.entiteDTO.TicketDTO;
import com.adaming.mytombola.entities.Client;
import com.adaming.mytombola.entities.Commun;
import com.adaming.mytombola.entities.Epique;
import com.adaming.mytombola.entities.Merdique;
import com.adaming.mytombola.entities.Personne;
import com.adaming.mytombola.entities.Ticket;

/**
 * @author inti0443
 * 
 */
public class TicketDaoImpl implements ITicketDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TicketDTO addTicket(Ticket ticket, Long idClient) {
		Client c = (Client) entityManager.find(Personne.class, idClient);
		ticket.setClient(c);
		entityManager.persist(ticket);
		c.getTabTicket().add(ticket);
		entityManager.persist(c);
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setIdTicket(ticket.getIdTicket());
		ticketDTO.setPrixTicket(ticket.getPrixTicket());
		ticketDTO.setClient(c);
		return ticketDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketDTO> getAllTicket() {
		Query query = entityManager.createQuery("from Ticket");
		List<Ticket> tabTicket = query.getResultList();
		List<TicketDTO> tabTicketDTO = new ArrayList<TicketDTO>();

		for (Ticket x : tabTicket) {
			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setIdTicket(x.getIdTicket());
			ticketDTO.setPrixTicket(x.getPrixTicket());
			ticketDTO.setClient(x.getClient());
			ticketDTO.setLot(x.getLot());
			tabTicketDTO.add(ticketDTO);
		}
		return tabTicketDTO;
	}

	@Override
	public TicketDTO getOneTicket(Long idTicket) {
		Ticket ticket = entityManager.find(Ticket.class, idTicket);
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setIdTicket(ticket.getIdTicket());
		ticketDTO.setPrixTicket(ticket.getPrixTicket());
		ticketDTO.setClient(ticket.getClient());
		ticketDTO.setLot(ticket.getLot());
		
		return ticketDTO;
	}

	@Override
	public TicketDTO updateTicket(TicketDTO ticketDTO) {
		Ticket ticket = entityManager.find(Ticket.class, ticketDTO.getIdTicket());
		ticket.setClient(ticketDTO.getClient());
		ticket.setLot(ticketDTO.getLot());
		ticket.setPrixTicket(ticketDTO.getPrixTicket());
		entityManager.merge(ticket);

		return ticketDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteTicket(Long idTicket) {
		Ticket ticket = entityManager.find(Ticket.class, idTicket);
		List<Client> tabClient = new ArrayList<Client>();
		Query query = entityManager.createQuery("from Personne p where Type_de_Personne = 'Client'");
		tabClient = query.getResultList();
		
		for (Client c : tabClient) {
			if (c.getIdPersonne()==ticket.getClient().getIdPersonne()) {
				c.getTabTicket().remove(ticket);
			}
			
		}
		entityManager.remove(ticket);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketDTO> tirage() {

		Query queryTicket = entityManager.createQuery("from Ticket");
		List<Ticket> tabTicket = queryTicket.getResultList();

		List<TicketDTO> tabTicketDTO = new ArrayList<TicketDTO>();

		for (Ticket x : tabTicket) {
			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setIdTicket(x.getIdTicket());
			ticketDTO.setPrixTicket(x.getPrixTicket());
			ticketDTO.setClient(x.getClient());
			ticketDTO.setLot(x.getLot());
			tabTicketDTO.add(ticketDTO);
		}

		Query query = entityManager
				.createQuery("from Lot where Type_de_Lot = :x");
		query.setParameter("x", "Merdique");
		List<Merdique> tabMerdique = query.getResultList();
		
		Query query1 = entityManager
				.createQuery("from Lot where Type_de_Lot = :y");
		query1.setParameter("y", "Commun");
		List<Commun> tabCommun = query1.getResultList();
		
		Query query2 = entityManager
				.createQuery("from Lot where Type_de_Lot = :z");
		query2.setParameter("z", "Epique");
		List<Epique> tabEpique = query2.getResultList();

		for (TicketDTO t : tabTicketDTO) {

			Double rand = Math.random();

			if (rand <= 0.65) {

				Collections.shuffle(tabMerdique);
				t.setLot(tabMerdique.get(0));


			} else if (rand > 0.65 && rand <= 0.95) {

				Collections.shuffle(tabCommun);
				t.setLot(tabCommun.get(0));
			

			} else if (rand > 0.95) {

				Collections.shuffle(tabEpique);
				t.setLot(tabEpique.get(0));
	
			}
		}
		
		for (TicketDTO x : tabTicketDTO) {
			for (Ticket t : tabTicket) {
				if (x.getIdTicket() == t.getIdTicket()) {
					t.setLot(x.getLot());
					entityManager.persist(t);
				}
			}
		}
		
		return tabTicketDTO;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public void deleteAfterTirage() {
		Query query = entityManager.createQuery("from Ticket");
		List<Ticket> tabTicket = query.getResultList();
		
		
		List<TicketDTO> tabTicketDTO = new ArrayList<TicketDTO>();

		for (Ticket x : tabTicket) {
			entityManager.remove(x);
			
		}

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketDTO> clientPlusLot() {
		Query query = entityManager.createQuery("from Ticket t join fetch t.client join fetch t.lot");
		List<Ticket> tabTicket= query.getResultList();
		System.out.println( query.getResultList());
		
		List<TicketDTO> tabTicketDTO = new ArrayList<TicketDTO>();
		
		for (Ticket x : tabTicket) {
			
			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setIdTicket(x.getIdTicket());
			ticketDTO.setPrixTicket(x.getPrixTicket());
			ticketDTO.setClient(x.getClient());
			ticketDTO.setLot(x.getLot());
			tabTicketDTO.add(ticketDTO);
			
		}

		
		return tabTicketDTO;
	}

}
