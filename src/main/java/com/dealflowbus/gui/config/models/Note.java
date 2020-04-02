package com.dealflowbus.gui.config.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Note {

    private int noteId;
    private String note;
    private LocalDate issueDate;

    public Note() {
    }

}
