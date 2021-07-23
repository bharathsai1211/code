package com.stackroute.Covid19TrackerSearchservice.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class CovidTrackerServiceImpl implements CovidTrackerService {

	@Override
	public String getCountry(String country) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Autowired
//	private ResourceLoader resourceLoader;
//
//	@Override
//	public String getCountry(String country) throws Exception {
//		JSONParser jsonParser = new JSONParser();
//		JSONObject dataObj = new JSONObject();
//		Object symbol = new Object();
//		String s = "";
//		try {
//			Resource resource = resourceLoader.getResource("classpath:SymbolList.json");
//			JSONObject obj = (JSONObject) jsonParser
//					.parse(new BufferedReader(new InputStreamReader(resource.getInputStream())));
//			JSONArray jsonArray = (JSONArray) obj.get("countries");
//			for (int i = 0; i < jsonArray.size(); i++) {
//				dataObj = (JSONObject) jsonArray.get(i);
//				if (dataObj.get("Country").equals(country)) {
//					symbol = dataObj.get("symbol");
//					s = symbol.toString();
//
//				}
//
//			}
//			if (s.isEmpty()) {
//				throw new Exception();
//			}
//
//		} catch (IOException e) {
//
//			System.out.println(e.getMessage());
//		} catch (ParseException e) {
//			System.out.println(e.getMessage());
//		}
//
//		return s;
//	}
//		return null;
//	}
}
