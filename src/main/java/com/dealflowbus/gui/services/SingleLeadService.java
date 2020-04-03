package com.dealflowbus.gui.services;

import com.dealflowbus.gui.config.AccessToken;
import com.dealflowbus.gui.config.models.LeadExtended;
import com.dealflowbus.gui.proxy.LeadProxy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingleLeadService {

    private final LeadProxy leadProxy;

    public SingleLeadService(LeadProxy leadProxy) {this.leadProxy = leadProxy;}

    public LeadExtended getLead(int id) {
        Optional<LeadExtended> leadoptional =
                leadProxy.getLeadbyId(id, AccessToken.getToken());

        if (leadoptional.isPresent()) {
            LeadExtended lead = leadoptional.get();
            return lead;
        } else {
            throw new IllegalArgumentException("Lead with such Id does not exist");
        }

    }

    public void deleteLeadById(int leadId) {
        leadProxy.deleteLeadById(leadId, AccessToken.getToken());
    }







}
