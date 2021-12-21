package com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Station;

@Repository("stationDao")
public interface StationDao extends JpaRepository<Station, Integer>
{
	
	@Query("SELECT stationId FROM Station WHERE stationId=:station")
	public int isValidStation(@Param("station")int stationId);
	
	@Query("SELECT stationName FROM Station WHERE stationId=:station")
	public String stationName(@Param("station")int stationId);
	
}
