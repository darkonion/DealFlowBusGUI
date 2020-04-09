package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.models.Detail;
import com.dealflowbus.gui.config.models.Lead;
import com.dealflowbus.gui.proxy.LeadProxy;
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
        } else {
            throw new IllegalArgumentException("Lead with such Id does not exist");
        }

    }

    public void deleteLeadById(int leadId) {
        leadProxy.deleteLeadById(leadId);
    }


    public void saveLead(Lead lead, Detail detail) {

        lead.setDetail(detail);
        leadProxy.saveLead(lead);

    }

    public void updateLead(Lead lead) {

        leadProxy.updateLead(lead);

    }
}
