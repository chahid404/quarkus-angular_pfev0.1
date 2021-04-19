package org.advyteam.entites;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
  public LocalDate deadline;
  public String subProject;
  public Integer progress;
  public String status;

  @Column
  @ElementCollection(targetClass=String.class)
  public List<String> membres = new ArrayList<>();


  @Column
  @ElementCollection(targetClass=String.class)
  public List<String> tags = new ArrayList<>() ;


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "documents_id", referencedColumnName = "id")
  public Document documents;

  //@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "tasks_id")
  private List<Task> tasks = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "setting_id", referencedColumnName = "id")
  public Setting projectSettings;


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

  public Document getDocuments() {
    return documents;
  }

  public void setDocuments(Document documents) {
    this.documents = documents;
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

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public List<String> getMembres() {
    return membres;
  }

  public void setMembres(List<String> membres) {
    this.membres = membres;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
