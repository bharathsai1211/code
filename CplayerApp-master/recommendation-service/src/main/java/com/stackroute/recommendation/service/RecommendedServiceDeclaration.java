package com.stackroute.recommendation.service;

import java.util.List;

import com.stackroute.recommendation.model.Recommended;

public interface RecommendedServiceDeclaration {

	public List<Recommended> getAllData();
	
	public boolean addData(Recommended recommended);
	
	public boolean removeData(int id);
	
}
