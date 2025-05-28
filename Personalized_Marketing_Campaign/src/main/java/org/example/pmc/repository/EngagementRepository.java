package org.example.pmc.repository;

import org.example.pmc.model.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngagementRepository extends JpaRepository<Engagement, Long> {
    List<Engagement> findByCampaignId(Long campaignId);
}
