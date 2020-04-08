package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.config.models.Detail;
import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.config.models.Note;
import com.dealflowbus.gui.services.SingleLeadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class SingleLeadController {

    private final SingleLeadService singleLeadService;

    public SingleLeadController(SingleLeadService singleLeadService) {this.singleLeadService = singleLeadService;}


    @RequestMapping("/api/lead")
    private String getLead(Model model, @RequestParam("leadId") int leadId) {
        Lead lead = singleLeadService.getLead(leadId);
        model.addAttribute("lead", lead);

        //temporary
        if (lead.getDetail() == null) {
            Detail detail = new Detail("empty");
            model.addAttribute("descr", detail);
        } else {
            model.addAttribute("descr", lead.getDetail());
        }

        model.addAttribute("notes", lead.getNotes());
        model.addAttribute("files", lead.getFiles());
        model.addAttribute("newnote", new Note());

        return "leaddetails";
    }

    @RequestMapping("/api/delete")
    public String deleteLead(@RequestParam("leadId") int leadId) {

        singleLeadService.deleteLeadById(leadId);

        return "redirect:/api";
    }

    @RequestMapping("/api/addForm")
    public String addLeadForm(Model model) {
        model.addAttribute("newlead", new Lead());
        model.addAttribute("detail", new Detail());

        return "add-form";
    }

    @PostMapping("api/saveLead")
    public String saveLead(@Valid @ModelAttribute("newlead") Lead lead,
            BindingResult bindingResult,
            @ModelAttribute("detail") Detail detail) {

        if (bindingResult.hasErrors()) {
            return "add-form";
        } else {
            singleLeadService.saveLead(lead, detail);
            return "redirect:/api";
        }
    }

    @RequestMapping("api/updateForm")
    public String updateLeadForm(Model model, @RequestParam("leadId") int leadId) {
        Lead lead = singleLeadService.getLead(leadId);
        model.addAttribute("lead", lead);
        return "update-form";
    }

    @RequestMapping("api/updateLead")
    public String updateLead(@Valid @ModelAttribute("lead") Lead lead,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "update-form";
        } else {
            singleLeadService.updateLead(lead);
            return "redirect:/api";
        }
    }



}
