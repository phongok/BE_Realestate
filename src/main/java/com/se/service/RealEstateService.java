package com.se.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.se.entity.RealEstate;
import com.se.entity.User;

public interface RealEstateService {
	public List<RealEstate> getAllHome();
	public RealEstate getHomeById(long id);
	public void saveHome(RealEstate home);
	public void deleteById(long uuid);
	
	public Page<RealEstate> getHome_Sell(Pageable pageable);
	public Page<RealEstate> getHome_Rent(Pageable pageable);
	
	public int getRealEstateNumber();
	
	public Page<RealEstate> getAllRealState_Paging(Pageable pageable);
	
	
	public Page<RealEstate> getRealStateByUserID(long iduser, Pageable pageable) ;
	
	public Page<RealEstate> getRealStateByNewsTypeID(long idNews, Pageable pageable) ;
	
	
	
	
	
	public Page<RealEstate> getRealStateRentArea(String area, Pageable pageable) ;
	public Page<RealEstate> getRealStateRentPrice(long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateRentAcreage(float min, float max, Pageable pageable) ;
	
	public Page<RealEstate> getRealStateRentAreaPrice(String area,long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateRentAreaAcreage(String area,float min, float max, Pageable pageable) ;
	public Page<RealEstate> getRealStateRentPriceAcreage(long minprice, long maxprice, float min, float max,Pageable pageable) ;
	public Page<RealEstate> getRealStateRentAreaPriceAcreage(String area ,long minprice, long maxprice, float min, float max,Pageable pageable) ;
	
	/////////////////
	
	public Page<RealEstate> getRealStateSellArea(String area, Pageable pageable) ;
	public Page<RealEstate> getRealStateSellPrice(long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateSellAcreage(float min, float max, Pageable pageable) ;
	
	public Page<RealEstate> getRealStateSellAreaPrice(String area,long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateSellAreaAcreage(String area,float min, float max, Pageable pageable) ;
	public Page<RealEstate> getRealStateSellPriceAcreage(long minprice, long maxprice, float min, float max,Pageable pageable) ;
	public Page<RealEstate> getRealStateSellAreaPriceAcreage(String area ,long minprice, long maxprice, float min, float max,Pageable pageable) ;
	
	/// Theo newsType
	
	
	public Page<RealEstate> getRealStateNewsTypeArea(long idnewsType,String area, Pageable pageable) ;
	public Page<RealEstate> getRealStateNewsTypePrice(long idnewsType,long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateNewsTypeAcreage(long idnewsType,float min, float max, Pageable pageable) ;
	
	public Page<RealEstate> getRealStateNewsTypeAreaPrice(long idnewsType,String area,long min, long max, Pageable pageable) ;
	public Page<RealEstate> getRealStateNewsTypeAreaAcreage(long idnewsType,String area,float min, float max, Pageable pageable) ;
	public Page<RealEstate> getRealStateNewsTypePriceAcreage(long idnewsType,long minprice, long maxprice, float min, float max,Pageable pageable) ;
	public Page<RealEstate> getRealStateNewsTypeAreaPriceAcreage(long idnewsType,String area ,long minprice, long maxprice, float min, float max,Pageable pageable) ;
	
	
	///FilterAdmin
	
	public Page<RealEstate> getAllByNewsTypeAdmin(long idNewsType, Pageable pageable);
	
	public Page<RealEstate> getAllByUserNameAdmin(String username, Pageable pageable);
	
	public Page<RealEstate> getAllByNewsTypeUserNameAdmin(long idNewsType, String username, Pageable pageable);
	
	
	///FilterUser
	
	
	public Page<RealEstate> getAllByNewsTypeUser(@Param("idNewsType") long idNewsType,@Param("idUser") long idUser , Pageable pageable);
	public Page<RealEstate> getAllByUser(@Param("idUser") long idUser , Pageable pageable);
	
	public List<RealEstate> getRe20();
	
	public RealEstate deleteRealEstate(long idre) ;
		
	
	
}
