package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.config.models.Statistics;
import com.dealflowbus.gui.services.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping("api/statistics")
    public String getStats(Model model) {

        Statistics statistics = statisticsService.getAllStatistics();
        Map<String, Long> countByField = statistics.getCountByField();

        model.addAttribute("stats", statistics);
        model.addAttribute("labels", countByField.keySet());
        model.addAttribute("counts", countByField.values());

        return "statistics";
    }

}
