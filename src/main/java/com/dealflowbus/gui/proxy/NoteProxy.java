package com.dealflowbus.gui.proxy;

import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.proxy.hystrixfallbacks.NoteHystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "database-main-reader-notes", url = "http://34.102.169.103", fallback = NoteHystrixClientFallback.class)
public interface NoteProxy {

    @RequestMapping(method = RequestMethod.DELETE, value = "api/leads/{leadId}/notes/{noteId}")
    String deleteNote(@PathVariable("leadId") int leadId, @PathVariable("noteId") int noteId);

    @RequestMapping(method = RequestMethod.POST, value = "api/leads/{leadId}/notes")
    ResponseEntity<Note> addNote(@PathVariable("leadId") int leadId, @RequestBody Note note);

}

