package org.advyteam.entites;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idCreator;
    private String Action;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Logs() {
    }

    public Logs(Long id, String idCreator, String Action, LocalDateTime createdAt) {
        this.id = id;
        this.idCreator = idCreator;
        this.Action = Action;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return this.id;
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

    public Logs idCreator(String idCreator) {
        setIdCreator(idCreator);
        return this;
    }

    public Logs Action(String Action) {
        setAction(Action);
        return this;
    }

    public Logs createdAt(LocalDateTime createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Logs)) {
            return false;
        }
        Logs logs = (Logs) o;
        return Objects.equals(id, logs.id) && Objects.equals(idCreator, logs.idCreator)
                && Objects.equals(Action, logs.Action) && Objects.equals(createdAt, logs.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCreator, Action, createdAt);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", idCreator='" + getIdCreator() + "'" + ", Action='" + getAction() + "'"
                + ", createdAt='" + getCreatedAt() + "'" + "}";
    }

}
