package org.advyteam.entites;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String projectString;
    public Boolean EditTasks;
    public Boolean commentOnTasks;
    public Boolean viewTaskAttachements;
    public Boolean uploadAttachementsOnTask;
    public Boolean viewActivityLog;
    public Boolean viewTeamMembers;
    public Boolean hideProjectTasksOnMainTasksTable;

    public Setting() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectString() {
        return projectString;
    }

    public void setProjectString(String projectString) {
        this.projectString = projectString;
    }

    public Boolean getEditTasks() {
        return EditTasks;
    }

    public void setEditTasks(Boolean editTasks) {
        EditTasks = editTasks;
    }

    public Boolean getCommentOnTasks() {
        return commentOnTasks;
    }

    public void setCommentOnTasks(Boolean commentOnTasks) {
        this.commentOnTasks = commentOnTasks;
    }

    public Boolean getViewTaskAttachements() {
        return viewTaskAttachements;
    }

    public void setViewTaskAttachements(Boolean viewTaskAttachements) {
        this.viewTaskAttachements = viewTaskAttachements;
    }

    public Boolean getUploadAttachementsOnTask() {
        return uploadAttachementsOnTask;
    }

    public void setUploadAttachementsOnTask(Boolean uploadAttachementsOnTask) {
        this.uploadAttachementsOnTask = uploadAttachementsOnTask;
    }

    public Boolean getViewActivityLog() {
        return viewActivityLog;
    }

    public void setViewActivityLog(Boolean viewActivityLog) {
        this.viewActivityLog = viewActivityLog;
    }

    public Boolean getViewTeamMembers() {
        return viewTeamMembers;
    }

    public void setViewTeamMembers(Boolean viewTeamMembers) {
        this.viewTeamMembers = viewTeamMembers;
    }

    public Boolean getHideProjectTasksOnMainTasksTable() {
        return hideProjectTasksOnMainTasksTable;
    }

    public void setHideProjectTasksOnMainTasksTable(Boolean hideProjectTasksOnMainTasksTable) {
        this.hideProjectTasksOnMainTasksTable = hideProjectTasksOnMainTasksTable;
    }
}
