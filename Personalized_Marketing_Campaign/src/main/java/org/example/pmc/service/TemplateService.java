package org.example.pmc.service;

import org.example.pmc.model.Template;
import org.example.pmc.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Template createTemplate(Template template) {
        return templateRepository.save(template);
    }

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    public Template getTemplateById(String id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found with id: " + id));
    }

    public Template updateTemplate(String id, Template updated) {
        Template existing = getTemplateById(id);
        existing.setName(updated.getName());
        existing.setType(updated.getType());
        existing.setSubject(updated.getSubject());
        existing.setBody(updated.getBody());
        return templateRepository.save(existing);
    }

    public void deleteTemplate(String id) {
        templateRepository.deleteById(id);
    }
}
