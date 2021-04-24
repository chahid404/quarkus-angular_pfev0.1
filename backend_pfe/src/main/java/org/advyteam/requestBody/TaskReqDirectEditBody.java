package org.advyteam.requestBody;

import java.time.LocalDate;
import java.util.Objects;

public class TaskReqDirectEditBody {
    public String id;
    public String createdBy;
    public LocalDate dueDate;
    public String name;
    public LocalDate startDate;
    public String status;
    public String tags;

    public TaskReqDirectEditBody() {
    }

    public TaskReqDirectEditBody(String id, String createdBy, LocalDate dueDate, String name, LocalDate startDate,
            String status, String tags) {
        this.id = id;
        this.createdBy = createdBy;
        this.dueDate = dueDate;
        this.name = name;
        this.startDate = startDate;
        this.status = status;
        this.tags = tags;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskReqDirectEditBody)) {
            return false;
        }
        TaskReqDirectEditBody taskReqDirectEditBody = (TaskReqDirectEditBody) o;
        return Objects.equals(id, taskReqDirectEditBody.id)
                && Objects.equals(createdBy, taskReqDirectEditBody.createdBy)
                && Objects.equals(dueDate, taskReqDirectEditBody.dueDate)
                && Objects.equals(name, taskReqDirectEditBody.name)
                && Objects.equals(startDate, taskReqDirectEditBody.startDate)
                && Objects.equals(status, taskReqDirectEditBody.status)
                && Objects.equals(tags, taskReqDirectEditBody.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, dueDate, name, startDate, status, tags);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", createdBy='" + getCreatedBy() + "'" + ", dueDate='" + getDueDate()
                + "'" + ", name='" + getName() + "'" + ", startDate='" + getStartDate() + "'" + ", status='"
                + getStatus() + "'" + ", tags='" + getTags() + "'" + "}";
    }

}
