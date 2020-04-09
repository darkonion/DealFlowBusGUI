package com.dealflowbus.gui.config.models;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Lead {

    private int id;

    @NotNull
    @Size(min = 2, message = "Name should be at least 2 characters long")
    @Size(max = 40, message = "Too long name, max 40 characters")
    private String projectName;

    @NotNull
    @Size(min = 2, message = "Owner should be at least 2 characters long")
    @Size(max = 40, message = "Too long name of Owner, max 40 characters")
    private String projectOwner;

    @NotNull(message = "You must choose something")
    private String field;

    @NotNull
    @Email(regexp = "[a-zA-Z0-9_]{0,15}@[a-zA-Z0-9]{0,10}.[a-z]{0,4}|" +
            "[a-zA-Z0-9_]{0,15}@[a-zA-Z0-9]{0,15}.[a-z]{0,4}.[a-z]{0,4}",
            message = "Wrong email Syntax, try again!")
    private String email;

    private String extraAddress;
    private boolean inProgress;
    private boolean rejected;
    private boolean inPortfolio;
    private LocalDate dateArrival;
    private LocalDate lastTouched;
    private Detail detail;
    private List<Note> notes;
    private List<DBFIle> files;

    public Lead() {

    }

    public Lead(String projectName,
            String projectOwner,
            String extraAddress,
            String field,
            String email,
            boolean inProgress,
            boolean rejected,
            boolean inPortfolio,
            Detail detail,
            List<Note> notes, List<DBFIle> files) {
        this.projectName = projectName;
        this.projectOwner = projectOwner;
        this.extraAddress = extraAddress;
        this.field = field;
        this.email = email;
        this.inProgress = inProgress;
        this.rejected = rejected;
        this.inPortfolio = inPortfolio;
        this.detail = detail;
        this.notes = notes;
        this.files = files;
    }

}

