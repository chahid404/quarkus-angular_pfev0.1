package org.acme.requestClasses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    private Long id;
    private String name = "";
    private String description = "";
    private String tags = "";
    private Boolean visibility = true;
    private String priority = "LOW";
    private String status = "Not Started";
    private Integer progress = 0;
    private Integer score = 0;
    private LocalDate startDate = LocalDate.now();
    private LocalDate dueDate = LocalDate.now().plusDays(1);
    private LocalDate createdDate = LocalDate.now();
    private String[] membres = {};
    private String createdBy;
    

    public Task() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean isVisibility() {
        return this.visibility;
    }

    public Boolean getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String[] getMembres() {
        return this.membres;
    }

    public void setMembres(String[] membres) {
        this.membres = membres;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
