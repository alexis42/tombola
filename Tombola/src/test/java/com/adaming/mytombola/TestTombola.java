/**
 * 
 */
package com.adaming.mytombola;

import org.springframework.context.support.ClassPathXmlApplicationContext;














import com.adaming.mytombola.entiteDTO.LotDTO;
import com.adaming.mytombola.entiteDTO.PersonneDTO;
import com.adaming.mytombola.entiteDTO.TicketDTO;
import com.adaming.mytombola.entities.Client;
import com.adaming.mytombola.entities.Commun;
import com.adaming.mytombola.entities.Epique;
import com.adaming.mytombola.entities.Lot;
import com.adaming.mytombola.entities.Merdique;
import com.adaming.mytombola.entities.Partenaire;
import com.adaming.mytombola.entities.Personne;
import com.adaming.mytombola.entities.Ticket;
import com.adaming.mytombola.service.ILotService;
import com.adaming.mytombola.service.IPersonneService;
import com.adaming.mytombola.service.ITicketService;

/**
 * @author inti0443
 *
 */
public class TestTombola {

	
	private static ClassPathXmlApplicationContext context;
	private static ILotService serviceLot;
	private static IPersonneService servicePersonne;
	private static ITicketService serviceTicket;
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		context = new ClassPathXmlApplicationContext("app.xml");
		serviceLot = (ILotService) context.getBean("lotService");
		servicePersonne = (IPersonneService) context.getBean("personneService");
		serviceTicket = (ITicketService) context.getBean("ticketService");

		
		servicePersonne.addPersonne(new Partenaire("Adel", "BOUMAZA"));
		
		servicePersonne.addPersonne(new Client("Gabriel", "VOLPATO"));
		servicePersonne.addPersonne(new Client("Adrien", "SIBILLE"));
		servicePersonne.addPersonne(new Client("Alexis", "DESJUZEUR"));
		
		serviceLot.addLot(new Merdique("Dinette", 3.5 ), 1L);
		serviceLot.addLot(new Merdique("Poupée", 2.5 ),1L);
		serviceLot.addLot(new Merdique("Bouteille vide", 0.5 ),1L);
		serviceLot.addLot(new Merdique("Bille", 0.2 ),1L);
		serviceLot.addLot(new Merdique("Chaussette", 1.0 ),1L);
		
		
		serviceLot.addLot(new Commun("Bouteille de Vodka ", 10D),1L);
		serviceLot.addLot(new Commun("MP3 ", 30D),1L);
		serviceLot.addLot(new Commun("Bouquin ", 15D),1L);
		serviceLot.addLot(new Commun("CD ", 13D),1L);
		
		serviceLot.addLot(new Epique("PC ", 800D),1L);
		serviceLot.addLot(new Epique("Lingot ", 5000D),1L);
		serviceLot.addLot(new Epique("Voyage ", 500D),1L);
		
		serviceTicket.addTicket(new Ticket(),2L);
		serviceTicket.addTicket(new Ticket(),2L);
		serviceTicket.addTicket(new Ticket(),2L);
		
		serviceTicket.addTicket(new Ticket(),3L);
		serviceTicket.addTicket(new Ticket(),3L);
		
		serviceTicket.addTicket(new Ticket(),4L);
		serviceTicket.addTicket(new Ticket(),4L);
		
		
		
		TicketDTO tDTO = serviceTicket.getOneTicket(1L);
		tDTO.setPrixTicket(50D);
		serviceTicket.updateTicket(tDTO);
		
		LotDTO lDTO = serviceLot.getOneLot(1L);
		lDTO.setLabelLot("Couverts");
		serviceLot.updateLot(lDTO);
		
		PersonneDTO pDTO = servicePersonne.getOnePersonne(1L);
		pDTO.setPrenomPersonne("Roger");
		servicePersonne.updatePersonne(pDTO);
				
		
		System.out.println("Liste de ticket : " + serviceTicket.getAllTicket());
		System.out.println("Liste de lot : " + serviceLot.getAllLot());
		System.out.println("Liste de personne : " + servicePersonne.getAllPersonne());
		
		serviceTicket.tirage();
		
		
		
		for(TicketDTO dto:serviceTicket.clientPlusLot()){
			System.out.println("Nom gagnant : "+dto.getClient().getNomPersonne());
			System.out.println("Lot du gagnant ci dessus : "+dto.getLot().getLabelLot());
		}
		
		
		//serviceLot.deleteLot(1L);
		//serviceTicket.deleteTicket(1L);
		//servicePersonne.deletePersonne(2L);
		
		System.out.println("Liste de ticket : " + serviceTicket.getAllTicket());
		System.out.println("Liste de lot : " + serviceLot.getAllLot());
		System.out.println("Liste de personne : " + servicePersonne.getAllPersonne());		
		
		serviceTicket.deleteAfterTirage();
		System.out.println("Liste de ticket après tirage : " + serviceTicket.getAllTicket());
		
		
		
	}

}
