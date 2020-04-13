package com.dealflowbus.gui.proxy.hystrixfallbacks;

import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.config.models.Statistics;
import com.dealflowbus.gui.proxy.StatisticsProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatisticsHystrixClientFallback implements StatisticsProxy {

    @Override
    public Statistics getAllStats() {

        Lead lead = new Lead();
        lead.setField("Internal Error, please try again!");
        List<Lead> leads = Arrays.asList(lead);

        Statistics error = new Statistics();
        error.setCountTotal(0);
        error.setCountProgress(0);
        error.setCountPortfolio(0);
        error.setCountForgotten(0);
        error.setCountRejected(0);
        error.setCountAddedThisMonth(0);
        error.setCountAddedThisYear(0);
        error.setCountByField(leads.stream()
                .collect(Collectors.groupingBy(Lead::getField, Collectors.counting())));

        return error;
    }
}