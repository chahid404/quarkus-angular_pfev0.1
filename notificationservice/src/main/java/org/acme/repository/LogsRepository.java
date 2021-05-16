package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.Logs;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class LogsRepository implements PanacheRepositoryBase<Logs, Long>{
    
}

