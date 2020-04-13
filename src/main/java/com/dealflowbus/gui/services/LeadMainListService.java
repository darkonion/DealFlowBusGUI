package com.dealflowbus.gui.services;

import com.dealflowbus.gui.RestResponsePage;
import com.dealflowbus.gui.config.AccessToken;
import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.proxy.LeadProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class LeadMainListService {

    private final OAuth2RestTemplate restTemplate;
    private final LeadProxy leadProxy;
    private final AccessToken accessToken;

    public LeadMainListService(@Qualifier("myRestTemplate") OAuth2RestTemplate restTemplate,
            LeadProxy leadProxy, AccessToken accessToken) {
        this.restTemplate = restTemplate;
        this.leadProxy = leadProxy;
        this.accessToken = accessToken;
    }

    public List<Integer> getPageList(RestResponsePage<Lead> body) {
        return IntStream.rangeClosed(0, body.getTotalPages() -1)
                .boxed()
                .collect(Collectors.toList());
    }
    @HystrixCommand(fallbackMethod = "getEmergencyResponse")
    public RestResponsePage<Lead> getLeads (
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "filter", defaultValue = "5") int filter) {

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Lead> httpEntity = new HttpEntity<>(httpHeaders);

        ParameterizedTypeReference<RestResponsePage<Lead>> customerHttpEntity = new ParameterizedTypeReference<>() {};

        ResponseEntity<RestResponsePage<Lead>> responseEntity = restTemplate.exchange(
                "http://34.102.169.103/api/leads?p={page}&filter={filter}",
                HttpMethod.GET,
                httpEntity,
                customerHttpEntity,
                page,
                filter);

        return responseEntity.getBody();
    }

    public List<Lead> getSearchResults(String query) {
        return leadProxy.getSearchResults(query);
    }

    private RestResponsePage<Lead> getEmergencyResponse(int page, int filter) {
        Lead lead = new Lead();
        lead.setProjectName("Internal Error, please try again");
        lead.setId(20000);
        List<Lead> leads = Arrays.asList(lead);
        RestResponsePage<Lead> emergencyPage = new RestResponsePage<>(leads);

        return emergencyPage;
    }

}
