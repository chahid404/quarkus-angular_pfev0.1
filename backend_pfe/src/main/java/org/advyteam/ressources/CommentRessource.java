package org.advyteam.ressources;


import org.advyteam.entites.Comment;
import org.advyteam.repositorys.CommentRepository;
import org.advyteam.repositorys.TaskRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/comments")
public class CommentRessource {

    @Inject
    CommentRepository commentRepository;

    @Inject
    TaskRepository taskRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments() {
        return commentRepository.findAll().list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getCommentById(@PathParam("id") Long id) {
        return commentRepository.findById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Comment AddNewComment(Comment comment) {
        commentRepository.persist(comment);
        return comment;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Comment updateComment(@PathParam("id") Long id, Comment comment) {
        Comment newComment = commentRepository.findById(id);
        if (newComment == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        newComment.setComment(comment.getComment());
        newComment.setCommentDate(comment.getCommentDate());
        newComment.setCreatedBy(comment.getCreatedBy());
        newComment.setTask(comment.getTask());

        return commentRepository.findById(id);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Comment> DeleteComment(@PathParam("id") Long id) {
        commentRepository.delete(commentRepository.findById(id));
        return commentRepository.findAll().list();
    }

    @Path("addcomment/{idtask}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Comment AddNewComment(@PathParam("idtask") Long idtask,Comment comment) {
        Comment newComment= new Comment();
        newComment.setComment(comment.getComment());
        newComment.setCreatedBy(comment.getCreatedBy());
        newComment.setTask(taskRepository.findById(idtask));
        commentRepository.persist(newComment);
        return commentRepository.findById(newComment.id);
    }


    @Path("getcommentsbytask/{idtask}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Comment> getCommentsByTask(@PathParam("idtask") Long idtask) {
        
        if (taskRepository.findById(idtask)==null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return commentRepository.find("task_id =?1 order by commentDate DESC",idtask).list();
    }
}
