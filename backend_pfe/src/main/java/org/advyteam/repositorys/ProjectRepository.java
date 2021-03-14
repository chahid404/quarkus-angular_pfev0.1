package org.advyteam.repositorys;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Project;


import javax.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class ProjectRepository implements PanacheRepositoryBase<Project,Long>{

}
