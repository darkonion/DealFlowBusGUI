package com.dealflowbus.gui.proxy.hystrixfallbacks;

import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.proxy.LeadProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class LeadHystrixClientFallback implements LeadProxy {


    @Override
    public Optional<Lead> getLeadbyId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Lead> getSearchResults(String query) {
        Lead lead = new Lead();
        lead.setProjectName("Error, please try again");
        List<Lead> leads = Arrays.asList(lead);

        return leads;
    }

    @Override
    public String deleteLeadById(int id) {
        return "warning";
    }

    @Override
    public ResponseEntity<Lead> saveLead(Lead lead) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<Lead> updateLead(Lead lead) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
