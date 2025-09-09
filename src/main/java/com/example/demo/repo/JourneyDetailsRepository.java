package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JourneyDetailsRepository extends JpaRepository<JourneyDetails, Integer> {
	
	@Query(value = "SELECT * FROM journey_details WHERE card_details = :cardNo AND in_transit = true LIMIT 1", nativeQuery = true)
	JourneyDetails fetchData(@Param("cardNo") Long cardNo);

	
}
