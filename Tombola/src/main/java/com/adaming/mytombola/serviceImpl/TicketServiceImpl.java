/**
 * 
 */
package com.adaming.mytombola.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.mytombola.dao.ITicketDao;
import com.adaming.mytombola.entiteDTO.TicketDTO;
import com.adaming.mytombola.entities.Ticket;
import com.adaming.mytombola.service.ITicketService;

/**
 * @author inti0443
 *
 */
@Transactional
public class TicketServiceImpl implements ITicketService{

	@Autowired
	private ITicketDao daoTicket;
	
	@Override
	public TicketDTO addTicket(Ticket ticket, Long idClient) {
		// TODO Auto-generated method stub
		return daoTicket.addTicket(ticket, idClient);
	}

	@Override
	public List<TicketDTO> getAllTicket() {
		// TODO Auto-generated method stub
		return daoTicket.getAllTicket();
	}

	@Override
	public TicketDTO getOneTicket(Long idTicket) {
		// TODO Auto-generated method stub
		return daoTicket.getOneTicket(idTicket);
	}

	@Override
	public TicketDTO updateTicket(TicketDTO ticketDTO) {
		// TODO Auto-generated method stub
		return daoTicket.updateTicket(ticketDTO);
	}

	@Override
	public void deleteTicket(Long idTicket) {
		// TODO Auto-generated method stub
		daoTicket.deleteTicket(idTicket);
	}

	/**
	 * @param daoTicket the daoTicket to set
	 */
	public void setDaoTicket(ITicketDao daoTicket) {
		this.daoTicket = daoTicket;
	}

	@Override
	public List<TicketDTO> tirage() {
		// TODO Auto-generated method stub
		return daoTicket.tirage();
	}

	@Override
	public void deleteAfterTirage() {
		// TODO Auto-generated method stub
		daoTicket.deleteAfterTirage();
	}

	@Override
	public List<TicketDTO> clientPlusLot() {
		// TODO Auto-generated method stub
		return daoTicket.clientPlusLot();
	}
	
	

}
