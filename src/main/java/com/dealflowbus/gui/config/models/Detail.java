package com.dealflowbus.gui.config.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Detail {

    private int id;
    private String description;

    public Detail() {
    }

    public Detail(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
