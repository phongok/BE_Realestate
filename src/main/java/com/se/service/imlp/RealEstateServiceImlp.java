package com.se.service.imlp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.se.entity.RealEstate;
import com.se.entity.User;
import com.se.repository.RealEstateRepository;
import com.se.repository.UserRepository;
import com.se.service.RealEstateService;

@Service
public class RealEstateServiceImlp implements RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<RealEstate> getAllHome() {
		// TODO Auto-generated method stub
		return realEstateRepository.findAll();
	}

	@Override
	public RealEstate getHomeById(long id) {
		// TODO Auto-generated method stub
		Optional<RealEstate> result = realEstateRepository.findById(id);
		RealEstate home = null;
		if (result.isPresent()) {
			home = result.get();
		} else {
			throw new RuntimeException("Did not find home id = " + id);
		}
		return home;
	}
	
	
	@Override
	public void saveHome(RealEstate home) {
		// TODO Auto-generated method stub

		realEstateRepository.save(home);

	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		realEstateRepository.deleteById(id);

	}

	@Override
	public Page<RealEstate> getHome_Sell(Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getHomeSell(pageable);
	}

	@Override
	public Page<RealEstate> getHome_Rent(Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getHomeRent(pageable);
	}

	@Override
	public int getRealEstateNumber() {
		// TODO Auto-generated method stub
		return realEstateRepository.getCountRealeState();
	}

	@Override
	public Page<RealEstate> getAllRealState_Paging(Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getAllByAdmin(pageable);
	}

	@Override
	public Page<RealEstate> getRealStateByUserID(long iduser, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRealStateByUserId(iduser, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateByNewsTypeID(long idNews, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRealStateByNewsTypeID(idNews, pageable);
	}
	
	
	
	
	//////////////////

	@Override
	public Page<RealEstate> getRealStateRentArea(String area, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTArea(area, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateRentPrice(long min, long max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTPrice(min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateRentAcreage(float min, float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTAcreage(min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateRentAreaPrice(String area, long min, long max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTAreaPrice(area, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateRentAreaAcreage(String area, float min, float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTAreaAcreage(area, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateRentPriceAcreage(long minprice, long maxprice, float min, float max,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTPriceAcreage(minprice, maxprice, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateRentAreaPriceAcreage(String area, long minprice, long maxprice, float min,
			float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getRentFTAreaPriceAcreage(area, minprice, maxprice, min, max, pageable);
	}

	

////////////////
	
	
	@Override
	public Page<RealEstate> getRealStateSellArea(String area, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTArea(area, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateSellPrice(long min, long max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTPrice(min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateSellAcreage(float min, float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTAcreage(min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateSellAreaPrice(String area, long min, long max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTAreaPrice(area, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateSellAreaAcreage(String area, float min, float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTAreaAcreage(area, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateSellPriceAcreage(long minprice, long maxprice, float min, float max,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTPriceAcreage(minprice, maxprice, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateSellAreaPriceAcreage(String area, long minprice, long maxprice, float min,
			float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getSellFTAreaPriceAcreage(area, minprice, maxprice, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypeArea(long idnewsType, String area, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTArea(idnewsType, area, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypePrice(long idnewsType, long min, long max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTPrice(idnewsType, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypeAcreage(long idnewsType, float min, float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTAcreage(idnewsType, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypeAreaPrice(long idnewsType, String area, long min, long max,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTAreaPrice(idnewsType, area, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypeAreaAcreage(long idnewsType, String area, float min, float max,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTAreaAcreage(idnewsType, area, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypePriceAcreage(long idnewsType, long minprice, long maxprice, float min,
			float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTPriceAcreage(idnewsType, minprice, maxprice, min, max, pageable);
	}

	@Override
	public Page<RealEstate> getRealStateNewsTypeAreaPriceAcreage(long idnewsType, String area, long minprice,
			long maxprice, float min, float max, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getNewsTypeFTAreaPriceAcreage(idnewsType, area, minprice, maxprice, min, max, pageable);
	}

	
	//FillerAdmin
	@Override
	public Page<RealEstate> getAllByNewsTypeAdmin(long idNewsType, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getAllByNewsTypeAdmin(idNewsType, pageable);
	}

	@Override
	public Page<RealEstate> getAllByUserNameAdmin(String username, Pageable pageable) {
	
		User user = userRepository.findUserByUsername(username);
		return realEstateRepository.getAllByUserNameAdmin(user.getId(), pageable) ;
	}

	@Override
	public Page<RealEstate> getAllByNewsTypeUserNameAdmin(long idNewsType, String username, Pageable pageable) {
	
		User user = userRepository.findUserByUsername(username);
		return realEstateRepository.getAllByNewsTypeUserNameAdmin(idNewsType, user.getId(), pageable);
	}

	//FillerUser
	@Override
	public Page<RealEstate> getAllByNewsTypeUser(long idNewsType, long idUser, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getAllByNewsTypeUser(idNewsType, idUser, pageable);
	}

	@Override
	public Page<RealEstate> getAllByUser(long idUser, Pageable pageable) {
		// TODO Auto-generated method stub
		return realEstateRepository.getAllByUser(idUser, pageable);
	}

	@Override
	public List<RealEstate> getRe20() {
		// TODO Auto-generated method stub
		return realEstateRepository.getRe20();
	}

	@Override
	public RealEstate deleteRealEstate(long idre) {
		// TODO Auto-generated method stub
		RealEstate estate = realEstateRepository.findById(idre).get();
		estate.setStatus("Đã khóa");
		realEstateRepository.save(estate);
		return estate ;
	}

	
	
	
	
	

}
