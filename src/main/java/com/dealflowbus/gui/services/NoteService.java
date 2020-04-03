package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.AccessToken;
import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.proxy.NoteProxy;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private NoteProxy noteProxy;

    public NoteService(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    public void deleteNote(int leadId, int noteId) {
        System.out.println(leadId);
        try {
            noteProxy.deleteNote(leadId, noteId, AccessToken.getToken());
        } catch (RuntimeException e) {
            //must think about it
        }

    }

    public void addNote(int leadId, Note note) {
        if (note != null) {
            noteProxy.addNote(leadId, note, AccessToken.getToken());
        } else {
            noteProxy.addNote(leadId, new Note(), AccessToken.getToken());
        }
    }


}
