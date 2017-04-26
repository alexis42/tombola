/**
 * 
 */
package com.adaming.mytombola.daoImpl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.mytombola.dao.ILotDao;
import com.adaming.mytombola.entiteDTO.LotDTO;
import com.adaming.mytombola.entities.Lot;
import com.adaming.mytombola.entities.Partenaire;
import com.adaming.mytombola.entities.Personne;
import com.adaming.mytombola.entities.Ticket;

/**
 * @author inti0443
 *
 */
public class LotDaoImpl implements ILotDao{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public LotDTO addLot(Lot lot, Long idPartenaire) {
		entityManager.persist(lot);
		Partenaire p = (Partenaire) entityManager.find(Personne.class, idPartenaire);
		p.getTabLot().add(lot);
		entityManager.persist(p);
		LotDTO lotDTO = new LotDTO();
		lotDTO.setIdLot(lot.getIdLot());
		lotDTO.setLabelLot(lot.getLabelLot());
		lotDTO.setPrixLot(lot.getPrixLot());
		return lotDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LotDTO> getAllLot() {
		Query query = entityManager.createQuery("from Lot");
		List<Lot> tabLot = query.getResultList(); 
		List<LotDTO>tabLotDTO = new ArrayList<LotDTO>();
	
		for (Lot x : tabLot) {
			
			LotDTO lotDTO = new LotDTO();
			lotDTO.setIdLot(x.getIdLot());
			lotDTO.setLabelLot(x.getLabelLot());
			lotDTO.setPrixLot(x.getPrixLot());
			tabLotDTO.add(lotDTO);
		}
		
		return tabLotDTO;
	}

	@Override
	public LotDTO getOneLot(Long idLot) {
		Lot lot = entityManager.find(Lot.class, idLot);
		LotDTO lotDTO = new LotDTO();
		lotDTO.setIdLot(lot.getIdLot());
		lotDTO.setPrixLot(lot.getPrixLot());
		lotDTO.setLabelLot(lot.getLabelLot());
		
		return lotDTO;
	}

	@Override
	public LotDTO updateLot(LotDTO lotDTO) {
		Lot lot = entityManager.find(Lot.class, lotDTO.getIdLot());
		lot.setIdLot(lotDTO.getIdLot());
		lot.setLabelLot(lotDTO.getLabelLot());
		lot.setPrixLot(lotDTO.getPrixLot());
		entityManager.merge(lot);
		
		return lotDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteLot(Long idLot) {
		Lot lot = entityManager.find(Lot.class, idLot);
		
		
		if (lot.getTabTicket()!= null) {
			List<Ticket> tabTicket = new ArrayList<Ticket>();
			Query query = entityManager.createQuery("from Ticket t");
			tabTicket = query.getResultList();
		
			for (Ticket t : tabTicket) {
				
				if (t.getLot().getIdLot() == idLot) {
					tabTicket.remove(t.getLot());
				}
			}
			
			System.out.println(tabTicket);
			
			for (Ticket ticket : tabTicket) {
				ticket.setLot(null);
			}
	
		}
		
		List<Partenaire> tabPartenaire = new ArrayList<Partenaire>();
		Query query = entityManager.createQuery("from Personne where Type_de_Personne = 'Partenaire'");
		tabPartenaire = query.getResultList();
		System.out.println("??"+tabPartenaire);
		for (Partenaire p : tabPartenaire) {

			for (Lot l : p.getTabLot()) {

				if (l.getIdLot()==idLot) {

					p.getTabLot().remove(l);
				}
				
			}
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		}

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		entityManager.remove(lot);
		
	}

	

}
