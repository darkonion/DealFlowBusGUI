package com.dealflowbus.gui.config.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Lead {

    private int id;
    private String projectName;
    private String projectOwner;
    private String extraAddress;
    private String field;
    private String email;
    private boolean inProgress;
    private boolean rejected;
    private boolean inPortfolio;
    private LocalDate dateArrival;
    private LocalDate lastTouched;


    public Lead() {

    }

    public Lead(String projectName, String projectOwner,
            String extraAddress, String field, String email) {


        this.projectName = projectName;
        this.projectOwner = projectOwner;
        this.extraAddress = extraAddress;
        this.inProgress = false;
        this.rejected = false;
        this.inPortfolio = false;
        this.field = field;
        this.email = email;
    }

}

