package org.example.pmc.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

 // Includes filters like age or location, used to define target groups for campaigns.


@Entity
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String ageFilter;
    private String townFilter;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    // Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeFilter() {
        return ageFilter;
    }

    public void setAgeFilter(String ageFilter) {
        this.ageFilter = ageFilter;
    }

    public String getTownFilter() {
        return townFilter;
    }

    public void setTownFilter(String townFilter) {
        this.townFilter = townFilter;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
