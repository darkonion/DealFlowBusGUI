package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.proxy.NoteProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private NoteProxy noteProxy;

    public NoteService(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    public String deleteNote(int leadId, int noteId) {
        return noteProxy.deleteNote(leadId, noteId);
    }

    public ResponseEntity<Note> addNote(int leadId, Note note) {
        System.out.println(note);
        return noteProxy.addNote(leadId, note);
    }
}



