package org.advyteam.ressources;

import org.advyteam.entites.Project;
import org.advyteam.entites.Task;
import org.advyteam.repositorys.TaskRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tasks")
public class TaskRessource {


    @Inject
    TaskRepository taskRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasks() {
        return taskRepository.findAll().list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTaskById(@PathParam("id") Long id) {
        return taskRepository.findById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Task AddNewTask(Task p) {
        taskRepository.persist(p);
        return p;
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Task> DeleteTask(@PathParam("id") Long id) {
        taskRepository.delete(taskRepository.findById(id));
        return taskRepository.findAll().list();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Task updateProject(@PathParam("id") Long id, Task task) {
        Task newTask = taskRepository.findById(id);
        if (newTask == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setMembres(task.getMembres());
        newTask.setTags(task.getTags());
        newTask.setComments(task.getComments());
        newTask.setDocument(task.getDocument());
        newTask.setVisibility(task.getVisibility());
        newTask.setPriority(task.getPriority());
        newTask.setStatus(task.getStatus());
        newTask.setProgress(task.getProgress());
        newTask.setScore(task.getScore());
        newTask.setStartDate(task.getStartDate());
        newTask.setDueDate(task.getDueDate());
        newTask.setCreatedDate(task.getCreatedDate());
        newTask.setCreatedBy(task.getCreatedBy());
        newTask.setName(task.getName());
        return taskRepository.findById(id);
    }
}
