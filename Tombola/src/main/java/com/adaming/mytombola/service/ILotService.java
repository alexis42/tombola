/**
 * 
 */
package com.adaming.mytombola.service;

import java.util.List;

import com.adaming.mytombola.entiteDTO.LotDTO;
import com.adaming.mytombola.entities.Lot;

/**
 * @author inti0443
 *
 */
public interface ILotService {

	LotDTO addLot (Lot lot, Long idPartenaire);
	
	List<LotDTO> getAllLot(); 
	
	LotDTO getOneLot(Long idLot);
	
	LotDTO updateLot (LotDTO lot); 
	
	void deleteLot(Long idLot); 
}
