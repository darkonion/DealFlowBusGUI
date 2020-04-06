package com.dealflowbus.gui.config.models;


import lombok.Getter;
import lombok.Setter;

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
    @Size(min = 6, message = "Email should be at least 6 characters long")
    @Size(max = 40, message = "Too long email address, max 40 characters")
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

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Detail getDetail() {
        return detail;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<DBFIle> getFiles() {
        return files;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectOwner='" + projectOwner + '\'' +
                ", field='" + field + '\'' +
                ", email='" + email + '\'' +
                ", extraAddress='" + extraAddress + '\'' +
                ", inProgress=" + inProgress +
                ", rejected=" + rejected +
                ", inPortfolio=" + inPortfolio +
                ", dateArrival=" + dateArrival +
                ", lastTouched=" + lastTouched +
                ", detail=" + detail +
                ", notes=" + notes +
                ", files=" + files +
                '}';
    }
}

