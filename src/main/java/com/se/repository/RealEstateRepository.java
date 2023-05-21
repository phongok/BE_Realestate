package com.se.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {

	@Query(value = "select * from realestatedb.realestate where id_category = 1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getHomeSell(Pageable pageable);

	@Query(value = "select * from realestatedb.realestate where id_category = 2 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getHomeRent(Pageable pageable);

	@Query(value = "select count(*) from realestatedb.realestate", nativeQuery = true)
	public int getCountRealeState();

	@Query(value = "SELECT * FROM realestatedb.realestate where id_user = ?1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getRealStateByUserId(long idUser, Pageable pageable);

	@Query(value = "SELECT * FROM realestatedb.realestate where id_news_type = ?1 and status = 'Đang hoạt động'", nativeQuery = true)
	public Page<RealEstate> getRealStateByNewsTypeID(long idNews, Pageable pageable);

	
	/////
	
	
	
	
	///
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and area = ?1 ", nativeQuery = true)
	public Page<RealEstate> getRentFTArea(String area, Pageable pageable ); ///ok
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and price>= ?1 and price<= ?2 ", nativeQuery = true)
	public Page<RealEstate> getRentFTPrice(long priceMin, long priceMax, Pageable pageable ); 
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
	public Page<RealEstate> getRentFTAcreage(@Param("acreageMin") float acreageMin,@Param("acreageMax") float acreageMax, Pageable pageable );
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and area = ?1 and price>= ?2 and price<= ?3", nativeQuery = true)
	public Page<RealEstate> getRentFTAreaPrice(String area, long priceMin, long priceMax, Pageable pageable ) ;
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and area = :area and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
	public Page<RealEstate> getRentFTAreaAcreage( @Param("area") String area, @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and price >= :priceMin and price<= :priceMax and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
	public Page<RealEstate> getRentFTPriceAcreage(@Param("priceMin") long priceMin, @Param("priceMax") long priceMax,  @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
	
	@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 2  and status=\"Đang hoạt động\" and area = :area and price >= :priceMin and price<= :priceMax and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
	public Page<RealEstate> getRentFTAreaPriceAcreage(@Param("area") String area ,@Param("priceMin") long priceMin, @Param("priceMax") long priceMax,  @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
	///
	
	
	///
	
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and area = ?1 ", nativeQuery = true)
		public Page<RealEstate> getSellFTArea(String area, Pageable pageable ); ///ok
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and price>= ?1 and price<= ?2 ", nativeQuery = true)
		public Page<RealEstate> getSellFTPrice(long priceMin, long priceMax, Pageable pageable ); 
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getSellFTAcreage(@Param("acreageMin") float acreageMin,@Param("acreageMax") float acreageMax, Pageable pageable );
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and area = ?1 and price>= ?2 and price<= ?3", nativeQuery = true)
		public Page<RealEstate> getSellFTAreaPrice(String area, long priceMin, long priceMax, Pageable pageable ) ;
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and area = :area and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getSellFTAreaAcreage( @Param("area") String area, @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and price >= :priceMin and price<= :priceMax and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getSellFTPriceAcreage(@Param("priceMin") long priceMin, @Param("priceMax") long priceMax,  @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_category = 1  and status=\"Đang hoạt động\" and area = :area and price >= :priceMin and price<= :priceMax and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getSellFTAreaPriceAcreage(@Param("area") String area ,@Param("priceMin") long priceMin, @Param("priceMax") long priceMax,  @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
		
		
		///Theo Loại bài đăng
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = ?1  and status=\"Đang hoạt động\" and area = ?2 ", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTArea(long id, String area, Pageable pageable ); ///ok
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = ?1  and status=\"Đang hoạt động\" and price>= ?2 and price<= ?3 ", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTPrice(long id, long priceMin, long priceMax, Pageable pageable ); 
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = :idNewsType  and status=\"Đang hoạt động\" and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTAcreage( @Param("idNewsType") long idNewsType , @Param("acreageMin") float acreageMin,@Param("acreageMax") float acreageMax, Pageable pageable );
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = :idNewsType  and status=\"Đang hoạt động\" and area = :area and price>= :priceMin and price<= :priceMax", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTAreaPrice(@Param("idNewsType") long idNewsType,@Param("area") String area,@Param("priceMin") long priceMin,@Param("priceMax") long priceMax, Pageable pageable ) ;
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = :idNewsType  and status=\"Đang hoạt động\" and area = :area and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTAreaAcreage(@Param("idNewsType") long idNewsType,  @Param("area") String area, @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = :idNewsType  and status=\"Đang hoạt động\" and price >= :priceMin and price<= :priceMax and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTPriceAcreage(@Param("idNewsType") long idNewsType, @Param("priceMin") long priceMin, @Param("priceMax") long priceMax,  @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
		
		@Query(value = "SELECT * FROM realestatedb.realestate  where id_news_type = :idNewsType  and status=\"Đang hoạt động\" and area = :area and price >= :priceMin and price<= :priceMax and acreage >= :acreageMin and acreage <= :acreageMax", nativeQuery = true)
		public Page<RealEstate> getNewsTypeFTAreaPriceAcreage(@Param("idNewsType") long idNewsType, @Param("area") String area ,@Param("priceMin") long priceMin, @Param("priceMax") long priceMax,  @Param("acreageMin") float acreageMin, @Param("acreageMax") float acreageMax, Pageable pageable ) ;
	
		///filter admin
		
		@Query(value = "SELECT * FROM realestatedb.realestate where status = 'Đang hoạt động' ", nativeQuery = true)
		public Page<RealEstate> getAllByAdmin( Pageable pageable);
		
		@Query(value = "SELECT * FROM realestatedb.realestate where id_news_type = :idNewsType and status = 'Đang hoạt động'", nativeQuery = true)
		public Page<RealEstate> getAllByNewsTypeAdmin(@Param("idNewsType") long idNewsType, Pageable pageable);
		
		@Query(value = "SELECT * FROM realestatedb.realestate where id_user = :idUser and status = 'Đang hoạt động'", nativeQuery = true)
		public Page<RealEstate> getAllByUserNameAdmin(@Param("idUser") long idUser, Pageable pageable);
		
		@Query(value = "SELECT * FROM realestatedb.realestate where  id_news_type = :idNewsType and id_user = :idUser and status = 'Đang hoạt động' ", nativeQuery = true)
		public Page<RealEstate> getAllByNewsTypeUserNameAdmin(@Param("idNewsType") long idNewsType , @Param("idUser") long idUser, Pageable pageable);
		
		
		///filter user 
		@Query(value = "SELECT * FROM realestatedb.realestate where id_news_type = :idNewsType and status = 'Đang hoạt động' and id_user = :idUser", nativeQuery = true)
		public Page<RealEstate> getAllByNewsTypeUser(@Param("idNewsType") long idNewsType, @Param("idUser") long idUser , Pageable pageable);
		
		@Query(value = "SELECT * FROM realestatedb.realestate where status = 'Đang hoạt động' and id_user = :idUser", nativeQuery = true)
		public Page<RealEstate> getAllByUser(@Param("idUser") long idUser , Pageable pageable);
		
		
		@Query(value = "SELECT * FROM realestatedb.realestate WHERE id_category = 1 and status = 'Đang hoạt động' ORDER BY price DESC LIMIT 20 ", nativeQuery = true)
		public List<RealEstate> getRe20();
		
	
		
		
		
}
