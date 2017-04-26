/**
 * 
 */
package com.adaming.mytombola.dao;

import java.util.List;

import com.adaming.mytombola.entiteDTO.TicketDTO;
import com.adaming.mytombola.entities.Ticket;

/**
 * @author inti0443
 *
 */
public interface ITicketDao {

	TicketDTO addTicket (Ticket ticket, Long idClient);
	
	List<TicketDTO> getAllTicket(); 
	
	TicketDTO getOneTicket(Long idTicket);
	
	TicketDTO updateTicket (TicketDTO ticket); 
	
	void deleteTicket(Long idTicket); 
	
	List<TicketDTO> tirage();
	
	void deleteAfterTirage();
	
	List<TicketDTO> clientPlusLot();
}
