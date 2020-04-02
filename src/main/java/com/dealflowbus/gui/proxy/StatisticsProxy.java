package com.dealflowbus.gui.proxy;

import com.dealflowbus.gui.config.models.Lead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "statistics-unit", url = "http://34.102.169.103")
public interface StatisticsProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/stats/leads?count={count}")
    Page<Lead> getLeadsList(@PathVariable("count") int count, @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.GET, value = "/stats/trends")
    boolean getTrends(@RequestHeader("Authorization") String token);
}
