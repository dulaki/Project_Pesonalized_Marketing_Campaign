package org.example.pmc.repository;

import org.example.pmc.model.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment, String> {
}
