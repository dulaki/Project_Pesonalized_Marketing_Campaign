package org.example.pmc.service;

import org.example.pmc.model.Segment;
import org.example.pmc.repository.SegmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentService {

    private final SegmentRepository segmentRepository;

    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public Segment createSegment(Segment segment) {
        return segmentRepository.save(segment);
    }

    public List<Segment> getAllSegments() {
        return segmentRepository.findAll();
    }

    public Segment getSegmentById(String id) {
        return segmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Segment not found with id: " + id));
    }

    public void deleteSegment(String id) {
        segmentRepository.deleteById(id);
    }
    public Segment updateSegment(String id, Segment updatedSegment) {
        Segment existing = getSegmentById(id);
        existing.setName(updatedSegment.getName());
        existing.setAgeFilter(updatedSegment.getAgeFilter());
        existing.setTownFilter(updatedSegment.getTownFilter());
        return segmentRepository.save(existing);
    }

}
