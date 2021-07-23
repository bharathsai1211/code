package com.stackroute.covid19tracker.servicetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.stackroute.covid19tracker.model.CovidStat;

//@ExtendWith(MockitoExtension.class)
///**
// * With the @SpringBootTest annotation, Spring Boot provides a convenient way to start up an application context to be used in a test
// */
@SpringBootTest
class CovidStatServiceImplTest {

    @Test
    void givenCorrectUrlShouldCheckForPositiveResponse() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8088/api/v1/covidstat";
        CovidStat result = restTemplate.getForObject(baseUrl, CovidStat.class);
        System.out.println(result);

    }


}
