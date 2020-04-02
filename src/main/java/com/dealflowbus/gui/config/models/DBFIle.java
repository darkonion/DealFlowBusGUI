package com.dealflowbus.gui.config.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBFIle {

    private String id;
    private String fileName;
    private String fileType;
    private byte[] data;

    public DBFIle() {
    }
}
