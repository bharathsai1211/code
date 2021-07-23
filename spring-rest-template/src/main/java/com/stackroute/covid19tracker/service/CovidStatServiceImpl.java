package com.stackroute.covid19tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.covid19tracker.model.CovidStat;

@Service
public class CovidStatServiceImpl implements CovidStatService {

    public CovidStatServiceImpl() {
    }

    private String uri = "https://api.rootnet.in/covid19-in/stats/latest";

    /*
        RestTemplate
    */
    private RestTemplate restTemplate;

    @Autowired
    public CovidStatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CovidStat getCovidStat() {

        /*
            Send request with GET method
        */
        return restTemplate.getForObject(uri, CovidStat.class);
    }
}
