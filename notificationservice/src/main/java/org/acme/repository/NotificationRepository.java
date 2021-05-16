package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.Notification;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class NotificationRepository implements PanacheRepositoryBase<Notification, Long> {
    
}
