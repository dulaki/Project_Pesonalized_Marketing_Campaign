package org.example.pmc.controller;

import org.example.pmc.model.Segment;
import org.example.pmc.service.SegmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/segments")
public class SegmentController {

    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @PostMapping
    public ResponseEntity<Segment> createSegment(@RequestBody Segment segment) {
        return ResponseEntity.ok(segmentService.createSegment(segment));
    }

    @GetMapping
    public ResponseEntity<List<Segment>> getAllSegments() {
        return ResponseEntity.ok(segmentService.getAllSegments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Segment> getSegmentById(@PathVariable String id) {
        return ResponseEntity.ok(segmentService.getSegmentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSegment(@PathVariable String id) {
        segmentService.deleteSegment(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Segment> updateSegment(@PathVariable String id, @RequestBody Segment updatedSegment) {
        Segment segment = segmentService.updateSegment(id, updatedSegment);
        return ResponseEntity.ok(segment);
    }

}
