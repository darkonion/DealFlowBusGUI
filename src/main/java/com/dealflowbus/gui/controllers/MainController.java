package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.RestResponsePage;
import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.services.LeadMainListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainController {

    private final LeadMainListService leadService;

    public MainController(LeadMainListService leadService) {this.leadService = leadService;}


    @RequestMapping(value = "/")
    public String loadUI(){
        return "welcome";
    }

    @RequestMapping(value = "/api")
    public String loadLeads(Model model, @RequestParam(value = "p", defaultValue = "0") int page,
                                             @RequestParam(value = "filter", defaultValue = "5") int filter) {

        RestResponsePage<Lead> body = leadService.getLeads(page, filter);

        model.addAttribute("leads", body.getContent());

        model.addAttribute("pageNumbers", leadService.getPageList(body));

        model.addAttribute("currentpage", page + 1);

        model.addAttribute("filter", filter);

        return "index";
    }

    @RequestMapping("/api/search")
    public String searchResults(Model model, @RequestParam("query") String query) {
        List<Lead> searchResults = leadService.getSearchResults(query);
        model.addAttribute("leads", searchResults);

        return "index";
    }


}
