package org.advyteam.ressources;

import org.advyteam.entites.Project;
import org.advyteam.entites.Task;
import org.advyteam.otherClasses.TaskPercentage;
import org.advyteam.repositorys.ProjectRepository;
import org.advyteam.repositorys.TaskRepository;
import org.advyteam.requestBody.TaskReqDirectEditBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.List;

@Path("/tasks")
public class TaskRessource {

    @Inject
    TaskRepository taskRepository;

    @Inject
    ProjectRepository projectRepository;

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

    @Path("/deletetaskby/{id}")
    @GET
    @Transactional
    public Status DeleteTask(@PathParam("id") Long idtask) {
        Task newTask = taskRepository.findById(idtask);
        if (newTask == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        taskRepository.delete("id", idtask);
        Project project = projectRepository.findById(newTask.project.id);
        TaskPercentage percentage = projectRepository.calculProjectProgressPersentForDelete(project.getTasks());
        project.setProgress(percentage.getFinished());
        return Response.Status.OK;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Task updateTask(@PathParam("id") Long id, Task task) {
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

    @Path("/directedittask/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Task directUpdateTask(@PathParam("id") Long id, TaskReqDirectEditBody task) {
        Task newTask = taskRepository.findById(id);
        if (newTask == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        newTask.setName(task.getName());
        newTask.setTags(task.getTags());
        newTask.setStatus(task.getStatus());
        newTask.setStartDate(task.getStartDate());
        newTask.setDueDate(task.getDueDate());
        newTask.setCreatedBy(task.getCreatedBy());
        newTask.setPriority(task.getPriority());
        newTask.setScore(task.getScore());
        newTask.setMembres(task.getMembres());
        Project project = projectRepository.findById(newTask.project.id);
        TaskPercentage percentage = projectRepository.calculProjectProgressPersent(project.getTasks());
        project.setProgress(percentage.getFinished());
        return taskRepository.findById(id);
    }

    @Path("/createnewtask/{idProject}/{iduser}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Project createNewTask(@PathParam("idProject") Long idProject, @PathParam("iduser") String idcreator) {
        Project project = projectRepository.findById(idProject);
        if (project == null) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
        List<Task> tasks = project.getTasks();
        tasks.add(new Task(idcreator, project));
        taskRepository.persist(tasks);
        project.setTasks(tasks);
        TaskPercentage percentage = projectRepository.calculProjectProgressPersent(project.getTasks());
        project.setProgress(percentage.getFinished());
        return projectRepository.findById(idProject);
    }
}
