package com.dealflowbus.gui.proxy;

import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.config.models.LeadExtended;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "database-main-reader", url = "http://34.102.169.103")
public interface LeadProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/api/leads/{id}")
    Optional<LeadExtended> getLeadbyId(@PathVariable("id") int id, @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.GET, value = "/api/lsearch?query={query}")
    List<Lead> getSearchResults(@PathVariable("query") String query, @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/leads/{id}")
    void deleteLeadById(@PathVariable("id") int id, @RequestHeader("Authorization") String token);
}

