package org.example.pmc.controller;

import org.example.pmc.model.Engagement;
import org.example.pmc.service.EngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Provides endpoints for creating, retrieving, updating, and deleting Engagement entities.
@RestController
@RequestMapping("/api/engagements")
public class EngagementController {

    private final EngagementService engagementService;

    public EngagementController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @PostMapping
    public ResponseEntity<Engagement> recordEngagement(@RequestBody Engagement engagement) {
        return ResponseEntity.ok(engagementService.recordEngagement(engagement));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<Engagement>> getEngagementsByCampaign(@PathVariable Long campaignId) {
        return ResponseEntity.ok(engagementService.getByCampaignId(campaignId));
    }
}
