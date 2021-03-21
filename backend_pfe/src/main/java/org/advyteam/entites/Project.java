package org.advyteam.entites;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Project extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public String creator;
  public String name;
  public String description;
  public LocalDate createdDate;
  public LocalDate startDate;
  ;
  public LocalDate deadline;
  ;
  public String membres;
  public String status;
  public Integer progress;
  public String[] tags;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "documents_id", referencedColumnName = "id")
  public Document documents;
  public String tasks;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "setting_id", referencedColumnName = "id")
  public Setting projectSettings;
  public String subProject;

  public Project() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public String getMembres() {
    return membres;
  }

  public void setMembres(String membres) {
    this.membres = membres;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  public Document getDocuments() {
    return documents;
  }

  public void setDocuments(Document documents) {
    this.documents = documents;
  }

  public String getTasks() {
    return tasks;
  }

  public void setTasks(String tasks) {
    this.tasks = tasks;
  }

  public Setting getProjectSettings() {
    return projectSettings;
  }

  public void setProjectSettings(Setting projectSettings) {
    this.projectSettings = projectSettings;
  }

  public String getSubProject() {
    return subProject;
  }

  public void setSubProject(String subProject) {
    this.subProject = subProject;
  }
}
