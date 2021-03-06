package org.advyteam.entites;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String documentName;
    public LocalDate uploadDate;
    public String path;

    @ManyToOne
    @JsonbTransient
    public Task task;
    

    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
    public Document() { }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDocumentName() {
        return documentName;
    }
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
    public LocalDate getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }



}
