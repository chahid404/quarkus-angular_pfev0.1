package org.advyteam.repositorys;

import javax.enterprise.context.ApplicationScoped;

import org.advyteam.entites.Notifis;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class NotificationRepository implements PanacheRepositoryBase<Notifis, Long> {

}
