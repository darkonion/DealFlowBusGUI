package com.dealflowbus.gui.config.models;

import java.util.Map;

public class Statistics {

    private int countTotal;
    private int countRejected;
    private int countPortfolio;
    private int countProgress;
    private int countForgotten;
    private int countAddedThisMonth;
    private int countAddedThisYear;
    private String trend;
    private Map<String, Long> countByField;

    public Statistics() {
    }

    public int getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    public int getCountRejected() {
        return countRejected;
    }

    public void setCountRejected(int countRejected) {
        this.countRejected = countRejected;
    }

    public int getCountPortfolio() {
        return countPortfolio;
    }

    public void setCountPortfolio(int countPortfolio) {
        this.countPortfolio = countPortfolio;
    }

    public int getCountProgress() {
        return countProgress;
    }

    public void setCountProgress(int countProgress) {
        this.countProgress = countProgress;
    }

    public int getCountForgotten() {
        return countForgotten;
    }

    public void setCountForgotten(int countForgotten) {
        this.countForgotten = countForgotten;
    }

    public int getCountAddedThisMonth() {
        return countAddedThisMonth;
    }

    public void setCountAddedThisMonth(int countAddedThisMonth) {
        this.countAddedThisMonth = countAddedThisMonth;
    }

    public int getCountAddedThisYear() {
        return countAddedThisYear;
    }

    public void setCountAddedThisYear(int countAddedThisYear) {
        this.countAddedThisYear = countAddedThisYear;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public Map<String, Long> getCountByField() {
        return countByField;
    }

    public void setCountByField(Map<String, Long> countByField) {
        this.countByField = countByField;
    }
}
