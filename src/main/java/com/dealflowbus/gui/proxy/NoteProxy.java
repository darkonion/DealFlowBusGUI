package com.dealflowbus.gui.proxy;


import com.dealflowbus.gui.config.models.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "database-main-reader-notes", url = "http://34.102.169.103")
public interface NoteProxy {

    @RequestMapping(method = RequestMethod.DELETE, value = "api/leads/{leadId}/notes/{noteId}")
    void deleteNote(@PathVariable("leadId") int leadId, @PathVariable("noteId") int noteId, @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.POST, value = "api/leads/{leadId}/notes")
    void addNote(@PathVariable("leadId") int leadId, @RequestBody Note note, @RequestHeader("Authorization") String token);

}
