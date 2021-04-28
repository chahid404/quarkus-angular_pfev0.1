
package org.advyteam.entites;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notifis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String idRecever;
    private String idCreator;
    private String Action;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Boolean isRead = false;
    private Boolean isShow = true;
    private Long targetProjectid;

    public Notifis() {
    }

    public Notifis(Long id, String idRecever, String idCreator, String Action, LocalDateTime createdAt, Boolean isRead,
            Boolean isShow, Long targetProjectid) {
        this.id = id;
        this.idRecever = idRecever;
        this.idCreator = idCreator;
        this.Action = Action;
        this.createdAt = createdAt;
        this.isRead = isRead;
        this.isShow = isShow;
        this.targetProjectid = targetProjectid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdRecever() {
        return this.idRecever;
    }

    public void setIdRecever(String idRecever) {
        this.idRecever = idRecever;
    }

    public String getIdCreator() {
        return this.idCreator;
    }

    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }

    public String getAction() {
        return this.Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean isIsRead() {
        return this.isRead;
    }

    public Boolean getIsRead() {
        return this.isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean isIsShow() {
        return this.isShow;
    }

    public Boolean getIsShow() {
        return this.isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Long getTargetProjectid() {
        return this.targetProjectid;
    }

    public void setTargetProjectid(Long targetProjectid) {
        this.targetProjectid = targetProjectid;
    }

    public Notifis id(Long id) {
        setId(id);
        return this;
    }

    public Notifis idRecever(String idRecever) {
        setIdRecever(idRecever);
        return this;
    }

    public Notifis idCreator(String idCreator) {
        setIdCreator(idCreator);
        return this;
    }

    public Notifis Action(String Action) {
        setAction(Action);
        return this;
    }

    public Notifis createdAt(LocalDateTime createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Notifis isRead(Boolean isRead) {
        setIsRead(isRead);
        return this;
    }

    public Notifis isShow(Boolean isShow) {
        setIsShow(isShow);
        return this;
    }

    public Notifis targetProjectid(Long targetProjectid) {
        setTargetProjectid(targetProjectid);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Notifis)) {
            return false;
        }
        Notifis notifis = (Notifis) o;
        return Objects.equals(id, notifis.id) && Objects.equals(idRecever, notifis.idRecever)
                && Objects.equals(idCreator, notifis.idCreator) && Objects.equals(Action, notifis.Action)
                && Objects.equals(createdAt, notifis.createdAt) && Objects.equals(isRead, notifis.isRead)
                && Objects.equals(isShow, notifis.isShow) && Objects.equals(targetProjectid, notifis.targetProjectid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idRecever, idCreator, Action, createdAt, isRead, isShow, targetProjectid);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", idRecever='" + getIdRecever() + "'" + ", idCreator='" + getIdCreator()
                + "'" + ", Action='" + getAction() + "'" + ", createdAt='" + getCreatedAt() + "'" + ", isRead='"
                + isIsRead() + "'" + ", isShow='" + isIsShow() + "'" + ", targetProjectid='" + getTargetProjectid()
                + "'" + "}";
    }

}
