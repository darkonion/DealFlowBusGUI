package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.AccessToken;
import com.dealflowbus.gui.config.models.Statistics;
import com.dealflowbus.gui.proxy.StatisticsProxy;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final StatisticsProxy statisticsProxy;

    public StatisticsService(StatisticsProxy statisticsProxy) {
        this.statisticsProxy = statisticsProxy;
    }

    public Statistics getStatistics() {
        Statistics statistics = new Statistics();
        statistics.setCountTotal(statisticsProxy.getCounts(1, AccessToken.getToken()));
        statistics.setCountRejected(statisticsProxy.getCounts(2, AccessToken.getToken()));
        statistics.setCountPortfolio(statisticsProxy.getCounts(3, AccessToken.getToken()));
        statistics.setCountProgress(statisticsProxy.getCounts(4, AccessToken.getToken()));
        statistics.setCountForgotten(statisticsProxy.getCounts(5, AccessToken.getToken()));
        statistics.setCountAddedThisMonth(statisticsProxy.getCounts(6, AccessToken.getToken()));
        statistics.setCountAddedThisYear(statisticsProxy.getCounts(7, AccessToken.getToken()));

        boolean trends = statisticsProxy.getTrends(AccessToken.getToken());
        if (trends) {
            statistics.setTrend("Rising trend");
        } else {
            statistics.setTrend("Downward trend");
        }

        return statistics;
    }

    public Statistics getAllStatistics() {

        return statisticsProxy.getAllStats(AccessToken.getToken());
    }
}
