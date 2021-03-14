package org.advyteam.repositorys;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Task;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task,Long> {
}
