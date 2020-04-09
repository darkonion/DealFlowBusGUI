package com.dealflowbus.gui.proxy;

import com.dealflowbus.gui.config.models.Statistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "statistics-unit", url = "http://34.102.169.103")
public interface StatisticsProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/stats/all")
    Statistics getAllStats();
}
