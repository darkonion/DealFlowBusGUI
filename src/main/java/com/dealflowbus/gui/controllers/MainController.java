package com.dealflowbus.gui.controllers;

import com.dealflowbus.gui.RestResponsePage;
import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.proxy.AuthLogoutProxy;
import com.dealflowbus.gui.services.LeadMainListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller
public class MainController {

    private final LeadMainListService leadService;
    private final AuthLogoutProxy authLogoutProxy;

    public MainController(LeadMainListService leadService, AuthLogoutProxy authLogoutProxy) {this.leadService = leadService;
        this.authLogoutProxy = authLogoutProxy;
    }


    @RequestMapping(value = "/")
    public String loadUI(){
        return "welcome";
    }

    @RequestMapping(value = "/api")
    public String loadLeads(Model model, @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "filter", defaultValue = "5") int filter,
            Principal principal) {

        RestResponsePage<Lead> body = leadService.getLeads(page, filter);

        model.addAttribute("leads", body.getContent());

        model.addAttribute("pageNumbers", leadService.getPageList(body));

        model.addAttribute("currentpage", page + 1);

        model.addAttribute("filter", filter);

        model.addAttribute("principal", principal.getName());

        return "index";
    }

    @RequestMapping("/api/search")
    public String searchResults(Model model, @RequestParam("query") String query) {
        List<Lead> searchResults = leadService.getSearchResults(query);
        model.addAttribute("leads", searchResults);

        return "index";
    }

    @RequestMapping("/api/logmeout")
    public String logMeOut() {

        authLogoutProxy.logmeout();

        return "redirect:/logout";
    }


}
