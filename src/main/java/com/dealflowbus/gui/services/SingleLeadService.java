package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.AccessToken;
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
                leadProxy.getLeadbyId(id, AccessToken.getToken());

        if (leadoptional.isPresent()) {
            Lead lead = leadoptional.get();
            return lead;
        } else {
            throw new IllegalArgumentException("Lead with such Id does not exist");
        }

    }

    public void deleteLeadById(int leadId) {
        leadProxy.deleteLeadById(leadId, AccessToken.getToken());
    }


    public void saveLead(Lead lead, Detail detail) {
        lead.setDetail(detail);
        System.out.println(lead);
        leadProxy.saveLead(lead, AccessToken.getToken());

    }
}
