package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/api/files", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(@RequestParam("fileId") String fileId, @RequestParam("type") String fileType) {

        return fileService.getFileResponse(fileId, fileType);
    }
}
