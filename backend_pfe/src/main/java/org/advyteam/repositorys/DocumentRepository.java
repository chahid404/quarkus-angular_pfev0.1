package org.advyteam.repositorys;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Document;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DocumentRepository implements PanacheRepositoryBase<Document,Long> {
}
