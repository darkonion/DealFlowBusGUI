package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {this.noteService = noteService;}

    @RequestMapping("api/lead/deletenote")
    public String deleteNote(@RequestParam("leadId") int leadId, @RequestParam("noteId") int noteId) {
        noteService.deleteNote(leadId, noteId);

        return "redirect:/api/lead?leadId=" + leadId;
    }

    @RequestMapping(value = "api/lead/{leadId}/savenote", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("newnote") Note theNote, @PathVariable("leadId") int leadId) {
        noteService.addNote(leadId, theNote);
        return "redirect:/api/lead?leadId=" + leadId;
    }

}
