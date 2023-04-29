package com.se.service;


import java.util.List;

import com.se.entity.RealEstate_Save;

public interface RealEstateSaveService {
	public void saveRealEstate(RealEstate_Save home);
	public void deleteById(long id);
	public RealEstate_Save checkRealEstate(long iduser, long idrealestate);
	public List<RealEstate_Save> getRealEstate_Savelimit3(long iduser);
	public List<RealEstate_Save> getRealEstate_SaveForUser(long iduser);
}
