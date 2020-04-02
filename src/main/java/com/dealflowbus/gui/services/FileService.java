package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.AccessToken;
import com.dealflowbus.gui.proxy.FileProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileProxy fileProxy;

    public FileService(FileProxy fileProxy) {this.fileProxy = fileProxy;}

    public ResponseEntity<byte[]> getFileResponse(String fileId, String fileType) {

        byte[] file = fileProxy.getFile(fileId, AccessToken.getToken());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(fileType));

        return new ResponseEntity<>(file, headers, HttpStatus.OK);
    }

}
