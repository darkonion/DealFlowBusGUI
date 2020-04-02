package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.config.models.Detail;
import com.dealflowbus.gui.config.models.LeadExtended;
import com.dealflowbus.gui.services.SingleLeadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingleLeadController {

    private final SingleLeadService singleLeadService;

    public SingleLeadController(SingleLeadService singleLeadService) {this.singleLeadService = singleLeadService;}


    @RequestMapping("/api/lead")
    private String getLead(Model model, @RequestParam("leadId") int id) {
        LeadExtended lead = singleLeadService.getLead(id);
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

        return "leaddetails";
    }


}
