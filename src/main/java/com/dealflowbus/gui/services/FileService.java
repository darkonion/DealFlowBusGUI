package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.AccessToken;
import com.dealflowbus.gui.proxy.FileProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public void postFile(int leadId, MultipartFile file) {

        fileProxy.postFile(leadId, file, AccessToken.getToken());
    }

    public void deleteFile(String fileId) {

        fileProxy.deleteFile(fileId, AccessToken.getToken());
    }

}
