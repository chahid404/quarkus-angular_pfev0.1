package org.advyteam.requestBody;

import java.time.LocalDate;
import java.util.Objects;

public class TaskReqDirectEditBody {
    private String id;
    private String createdBy;
    private LocalDate dueDate;
    private String name;
    private LocalDate startDate;
    private String status;
    private String tags;
    private String priority;
    private Integer score;
    private String [] membres;


    public String [] getMembres() {
        return membres;
    }

    public void setMembres(String [] membres) {
        this.membres = membres;
    }

    public TaskReqDirectEditBody() {
    }

    public TaskReqDirectEditBody(String id, String createdBy, LocalDate dueDate, String name, LocalDate startDate, String status, String tags, String priority, Integer score) {
        this.id = id;
        this.createdBy = createdBy;
        this.dueDate = dueDate;
        this.name = name;
        this.startDate = startDate;
        this.status = status;
        this.tags = tags;
        this.priority = priority;
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public TaskReqDirectEditBody id(String id) {
        setId(id);
        return this;
    }

    public TaskReqDirectEditBody createdBy(String createdBy) {
        setCreatedBy(createdBy);
        return this;
    }

    public TaskReqDirectEditBody dueDate(LocalDate dueDate) {
        setDueDate(dueDate);
        return this;
    }

    public TaskReqDirectEditBody name(String name) {
        setName(name);
        return this;
    }

    public TaskReqDirectEditBody startDate(LocalDate startDate) {
        setStartDate(startDate);
        return this;
    }

    public TaskReqDirectEditBody status(String status) {
        setStatus(status);
        return this;
    }

    public TaskReqDirectEditBody tags(String tags) {
        setTags(tags);
        return this;
    }

    public TaskReqDirectEditBody priority(String priority) {
        setPriority(priority);
        return this;
    }

    public TaskReqDirectEditBody score(Integer score) {
        setScore(score);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskReqDirectEditBody)) {
            return false;
        }
        TaskReqDirectEditBody taskReqDirectEditBody = (TaskReqDirectEditBody) o;
        return Objects.equals(id, taskReqDirectEditBody.id) && Objects.equals(createdBy, taskReqDirectEditBody.createdBy) && Objects.equals(dueDate, taskReqDirectEditBody.dueDate) && Objects.equals(name, taskReqDirectEditBody.name) && Objects.equals(startDate, taskReqDirectEditBody.startDate) && Objects.equals(status, taskReqDirectEditBody.status) && Objects.equals(tags, taskReqDirectEditBody.tags) && Objects.equals(priority, taskReqDirectEditBody.priority) && Objects.equals(score, taskReqDirectEditBody.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, dueDate, name, startDate, status, tags, priority, score);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", name='" + getName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", tags='" + getTags() + "'" +
            ", priority='" + getPriority() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }

   

}
