package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.models.Statistics;
import com.dealflowbus.gui.proxy.StatisticsProxy;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final StatisticsProxy statisticsProxy;

    public StatisticsService(StatisticsProxy statisticsProxy) {
        this.statisticsProxy = statisticsProxy;
    }

        public Statistics getAllStatistics() {

        return statisticsProxy.getAllStats();
    }
}
