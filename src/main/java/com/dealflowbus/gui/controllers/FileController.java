package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/api/files")
    public ResponseEntity<byte[]> getFile(@RequestParam("fileId") String fileId, @RequestParam("type") String fileType) {

        return fileService.getFileResponse(fileId, fileType);
    }

    @RequestMapping(value = "/api/lead/{id}/savefile")
    public String addFile(@PathVariable("id") int leadId, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("warning", "You didn't attached any file!");
            return "redirect:/api/lead?leadId=" + leadId;
        }

        try {
            fileService.postFile(leadId, file);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("warning", "Something goes wrong, try again!");
        }

        return "redirect:/api/lead?leadId=" + leadId;
    }

    @RequestMapping(value = "/api/lead/{id}/deletefile")
    public String deleteFile(@PathVariable("id") int leadId, @RequestParam("fileId") String fileId,
            RedirectAttributes redirectAttributes) {

        try {
            fileService.deleteFile(fileId);
            redirectAttributes.addFlashAttribute("message", "File has been deleted succesfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("warning", "Something goes wrong, try again!");
        }


        return "redirect:/api/lead?leadId=" + leadId;
    }
}
