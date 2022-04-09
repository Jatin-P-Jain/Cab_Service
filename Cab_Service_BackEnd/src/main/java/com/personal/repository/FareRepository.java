package com.personal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.personal.entity.FareEstimation;

public interface FareRepository extends CrudRepository<FareEstimation, Integer>{
	@Query("select f.fare from FareEstimation f where f.source=:source and f.destination=:destination")
	Float findFareBySourceAndDestination(@Param("source") String source,@Param("destination") String destination);
	
	@Query("SELECT f FROM FareEstimation f ")
	List<FareEstimation> findFares();


}
