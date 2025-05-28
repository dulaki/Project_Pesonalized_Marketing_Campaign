package org.example.pmc.service;

import org.example.pmc.model.Campaign;
import org.example.pmc.model.Segment;
import org.example.pmc.model.Template;
import org.example.pmc.repository.CampaignRepository;
import org.example.pmc.repository.SegmentRepository;
import org.example.pmc.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final TemplateRepository templateRepository;
    private final SegmentRepository segmentRepository;

    public CampaignService(CampaignRepository campaignRepository,
                           TemplateRepository templateRepository,
                           SegmentRepository segmentRepository) {
        this.campaignRepository = campaignRepository;
        this.templateRepository = templateRepository;
        this.segmentRepository = segmentRepository;
    }

    public Campaign createCampaign(Campaign campaign) {
        String templateId = campaign.getTemplate().getId();
        String segmentId = campaign.getSegment().getId();

        Template fullTemplate = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found: " + templateId));
        Segment fullSegment = segmentRepository.findById(segmentId)
                .orElseThrow(() -> new RuntimeException("Segment not found: " + segmentId));

        campaign.setTemplate(fullTemplate);
        campaign.setSegment(fullSegment);

        return campaignRepository.save(campaign);
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found with id: " + id));
    }

    public Campaign updateCampaign(Long id, Campaign updatedCampaign) {
        Campaign existing = getCampaignById(id);

        existing.setName(updatedCampaign.getName());
        existing.setStatus(updatedCampaign.getStatus());
        existing.setStartDate(updatedCampaign.getStartDate());
        existing.setEndDate(updatedCampaign.getEndDate());
        existing.setChannel(updatedCampaign.getChannel());
        existing.setTest(updatedCampaign.isTest());


        String templateId = updatedCampaign.getTemplate().getId();
        String segmentId = updatedCampaign.getSegment().getId();

        Template fullTemplate = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found: " + templateId));
        Segment fullSegment = segmentRepository.findById(segmentId)
                .orElseThrow(() -> new RuntimeException("Segment not found: " + segmentId));

        existing.setTemplate(fullTemplate);
        existing.setSegment(fullSegment);

        return campaignRepository.save(existing);
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}

