/**
 * 
 */
package com.adaming.mytombola.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.mytombola.dao.ILotDao;
import com.adaming.mytombola.entiteDTO.LotDTO;
import com.adaming.mytombola.entities.Lot;
import com.adaming.mytombola.service.ILotService;

/**
 * @author inti0443
 *
 */
@Transactional
public class LotServiceImpl implements ILotService{

	@Autowired
	private ILotDao daoLot;
	
	@Override
	public LotDTO addLot(Lot lot, Long idPartenaire) {
		// TODO Auto-generated method stub
		return daoLot.addLot(lot, idPartenaire);
	}

	@Override
	public List<LotDTO> getAllLot() {
		// TODO Auto-generated method stub
		return daoLot.getAllLot();
	}

	@Override
	public LotDTO getOneLot(Long idLot) {
		// TODO Auto-generated method stub
		return daoLot.getOneLot(idLot);
	}

	@Override
	public LotDTO updateLot(LotDTO lot) {
		// TODO Auto-generated method stub
		return daoLot.updateLot(lot);
	}

	@Override
	public void deleteLot(Long idLot) {
		daoLot.deleteLot(idLot);
		
	}

	/**
	 * @param daoLot the daoLot to set
	 */
	public void setDaoLot(ILotDao daoLot) {
		this.daoLot = daoLot;
	}
	
	

}
