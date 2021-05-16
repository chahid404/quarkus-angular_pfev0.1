package org.acme.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idRecever;
    private String idCreator;
    private String Action;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Boolean isRead = false;
    private Boolean isShow = true;
    private Long targetProjectid;


    public Notification() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdRecever() {
        return idRecever;
    }
    public void setIdRecever(String idRecever) {
        this.idRecever = idRecever;
    }
    public String getIdCreator() {
        return idCreator;
    }
    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }
    public String getAction() {
        return Action;
    }
    public void setAction(String action) {
        Action = action;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getIsRead() {
        return isRead;
    }
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
    public Boolean getIsShow() {
        return isShow;
    }
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }
    public Long getTargetProjectid() {
        return targetProjectid;
    }
    public void setTargetProjectid(Long targetProjectid) {
        this.targetProjectid = targetProjectid;
    }

    
}
