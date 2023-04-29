package com.se.service.imlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.RealEstate_Save;
import com.se.repository.RealEstateSaveRepository;
import com.se.service.RealEstateSaveService;

@Service
public class RealEstateSaveServiceImlp implements RealEstateSaveService {

	@Autowired
	private RealEstateSaveRepository realEstateSaveRepository;
	
	@Override
	public void saveRealEstate(RealEstate_Save home) {
		// TODO Auto-generated method stub
		realEstateSaveRepository.save(home);
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		realEstateSaveRepository.deleteById(id);
		
	}

	@Override
	public List<RealEstate_Save> getRealEstate_Savelimit3(long iduser) {
		// TODO Auto-generated method stub
		return realEstateSaveRepository.getRealEstateLimit3(iduser);
	}

	@Override
	public List<RealEstate_Save> getRealEstate_SaveForUser(long iduser) {
		// TODO Auto-generated method stub
		return realEstateSaveRepository.getRealEstateForUser(iduser);
	}

	@Override
	public RealEstate_Save checkRealEstate(long iduser, long idrealestate) {
		// TODO Auto-generated method stub
		return realEstateSaveRepository.CheckRealEstate(iduser, idrealestate);
	}

}
