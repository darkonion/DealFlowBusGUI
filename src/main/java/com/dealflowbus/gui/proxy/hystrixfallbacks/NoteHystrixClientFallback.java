package com.dealflowbus.gui.proxy.hystrixfallbacks;

import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.proxy.NoteProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class NoteHystrixClientFallback implements NoteProxy {

    @Override
    public String deleteNote(int leadId, int noteId) {
        return "warning";
    }

    @Override
    public ResponseEntity<Note> addNote(int leadId, Note note) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}