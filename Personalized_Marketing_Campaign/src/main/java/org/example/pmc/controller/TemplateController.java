package org.example.pmc.controller;

import org.example.pmc.model.Template;
import org.example.pmc.service.TemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Provides endpoints for creating, retrieving, updating, and deleting Template entities.
@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody Template template) {
        return ResponseEntity.ok(templateService.createTemplate(template));
    }

    @GetMapping
    public ResponseEntity<List<Template>> getAllTemplates() {
        return ResponseEntity.ok(templateService.getAllTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplateById(@PathVariable String id) {
        return ResponseEntity.ok(templateService.getTemplateById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Template> updateTemplate(@PathVariable String id, @RequestBody Template updated) {
        return ResponseEntity.ok(templateService.updateTemplate(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable String id) {
        templateService.deleteTemplate(id);
        return ResponseEntity.noContent().build();
    }
}
