package org.advyteam.repositorys;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Comment;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommentRepository implements PanacheRepositoryBase<Comment,Long> {
}
