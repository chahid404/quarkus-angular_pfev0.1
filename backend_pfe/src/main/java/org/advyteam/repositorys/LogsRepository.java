package org.advyteam.repositorys;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Logs;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LogsRepository implements PanacheRepositoryBase<Logs, Long> {

}
