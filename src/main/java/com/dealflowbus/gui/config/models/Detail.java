package com.dealflowbus.gui.config.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Detail {

    private int descId;
    private String description;

    public Detail() {
    }

    public Detail(String description) {
        this.description = description;
    }

}
