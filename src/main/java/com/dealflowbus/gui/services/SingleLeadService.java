package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.models.Detail;
import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.proxy.LeadProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingleLeadService {

    private final LeadProxy leadProxy;

    public SingleLeadService(LeadProxy leadProxy) {this.leadProxy = leadProxy;}

    public Lead getLead(int id) {
        Optional<Lead> leadoptional =
                leadProxy.getLeadbyId(id);

        if (leadoptional.isPresent()) {
            Lead lead = leadoptional.get();
            return lead;
        } else if (leadoptional.isEmpty()) {
            Lead error = new Lead();
            error.setProjectName("warning");
            return error;
        }
        return null;
    }

    public String deleteLeadById(int leadId) {
        return leadProxy.deleteLeadById(leadId);
    }


    public ResponseEntity<Lead> saveLead(Lead lead, Detail detail) {

        lead.setDetail(detail);

        return leadProxy.saveLead(lead);
    }

    public ResponseEntity<Lead> updateLead(Lead lead) {

        return leadProxy.updateLead(lead);
    }
}
