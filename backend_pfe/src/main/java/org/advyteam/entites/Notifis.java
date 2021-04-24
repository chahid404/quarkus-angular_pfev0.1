
package org.advyteam.entites;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notifis extends Logs {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // public Long id;
    private String idRecever;
    private Boolean isRead = false;
    private Boolean isShow = true;

    public Notifis() {
    }

    public Notifis(Long id, String idRecever, Boolean isRead, Boolean isShow, String idCreator, String Action,
            LocalDateTime createdAt) {
        super(id, idCreator, Action, createdAt);
        this.idRecever = idRecever;
        this.isRead = isRead;
        this.isShow = isShow;
    }

    public String getIdRecever() {
        return this.idRecever;
    }

    public void setIdRecever(String idRecever) {
        this.idRecever = idRecever;
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

    public Notifis idRecever(String idRecever) {
        setIdRecever(idRecever);
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Notifis)) {
            return false;
        }
        Notifis notification = (Notifis) o;
        return Objects.equals(idRecever, notification.idRecever) && Objects.equals(isRead, notification.isRead)
                && Objects.equals(isShow, notification.isShow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecever, isRead, isShow);
    }

    @Override
    public String toString() {
        return "{" + " idRecever='" + getIdRecever() + "'" + ", isRead='" + isIsRead() + "'" + ", isShow='" + isIsShow()
                + "'" + "}";
    }

}
