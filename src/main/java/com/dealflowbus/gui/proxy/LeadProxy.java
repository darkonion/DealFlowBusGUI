package com.dealflowbus.gui.proxy;

import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.proxy.hystrixfallbacks.LeadHystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "database-main-reader", url = "http://34.102.169.103", fallback = LeadHystrixClientFallback.class)
public interface LeadProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/api/leads/{id}")
    Optional<Lead> getLeadbyId(@PathVariable("id") int id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/lsearch?query={query}")
    List<Lead> getSearchResults(@PathVariable("query") String query);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/leads/{id}")
    String deleteLeadById(@PathVariable("id") int id);

    @RequestMapping(method = RequestMethod.POST, value = "/api/leads")
    ResponseEntity<Lead> saveLead(@RequestBody Lead lead);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/leads")
    ResponseEntity<Lead> updateLead(@RequestBody Lead lead);
}

