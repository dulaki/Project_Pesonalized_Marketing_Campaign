package org.example.pmc.service;

import org.example.pmc.model.Campaign;
import org.example.pmc.model.Engagement;
import org.example.pmc.repository.CampaignRepository;
import org.example.pmc.repository.EngagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngagementService {

    private final EngagementRepository engagementRepository;
    private final CampaignRepository campaignRepository;

    public EngagementService(EngagementRepository engagementRepository,
                             CampaignRepository campaignRepository) {
        this.engagementRepository = engagementRepository;
        this.campaignRepository = campaignRepository;
    }

    public Engagement recordEngagement(Engagement engagement) {
        Long campaignId = engagement.getCampaign().getId();
        Campaign fullCampaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found with id: " + campaignId));
        engagement.setCampaign(fullCampaign);
        return engagementRepository.save(engagement);
    }


    public List<Engagement> getByCampaignId(Long campaignId) {
        return engagementRepository.findByCampaignId(campaignId);
    }
}
