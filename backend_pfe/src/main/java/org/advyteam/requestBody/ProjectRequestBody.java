package org.advyteam.requestBody;

import org.advyteam.entites.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectRequestBody {

  public String creator;
  public String name;
  public String description;
  public LocalDate createdDate;
  public LocalDate startDate;
  public LocalDate deadline;
  public String[] membres;
  public String status;
  public Integer progress;
  public String[] tags;
  public List<Task> tasks = new ArrayList<>();
  public String subProject;

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getProgress() {
    return progress;
  }

  public String getSubProject() {
    return subProject;
  }

  public void setSubProject(String subProject) {
    this.subProject = subProject;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public String[] getMembres() {
    return membres;
  }

  public void setMembres(String[] membres) {
    this.membres = membres;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }
}
