package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {this.noteService = noteService;}

    @RequestMapping("api/lead/deletenote")
    public String deleteNote(@RequestParam("leadId") int leadId, @RequestParam("noteId") int noteId,
            RedirectAttributes redirectAttributes) {

        if (noteService.deleteNote(leadId, noteId).equals("warning")) {
            redirectAttributes.addFlashAttribute("warning", "Something goes wrong, try again!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Note has been removed successfully");
        }
        return "redirect:/api/lead?leadId=" + leadId;
    }

    @RequestMapping(value = "api/lead/{leadId}/savenote", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("newnote") Note theNote, @PathVariable("leadId") int leadId,
            RedirectAttributes redirectAttributes) {

        if (theNote.getNote().isBlank()) {
            redirectAttributes.addFlashAttribute("warning", "Note is empty! Type something :) ! ");
            return "redirect:/api/lead?leadId=" + leadId;
        }

        if (noteService.addNote(leadId, theNote).getStatusCodeValue() == 500) {
            redirectAttributes.addFlashAttribute("warning", "Something goes wrong, try again!");
        } else {
            redirectAttributes.addFlashAttribute("message", "New note has been added successfully!");
        }
        return "redirect:/api/lead?leadId=" + leadId;
    }

}
