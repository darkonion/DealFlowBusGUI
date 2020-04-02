package com.dealflowbus.gui.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LeadExtended extends Lead {

    private Detail detail;
    private List<Note> notes;
    private List<DBFIle> files;

    public LeadExtended() {
    }

    public LeadExtended(String projectName,
            String projectOwner,
            String extraAddress,
            String field,
            String email,
            Detail detail, List<Note> notes) {
        super(projectName, projectOwner, extraAddress, field, email);
        this.detail = detail;
        this.notes = notes;
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
}
