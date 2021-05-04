package org.advyteam.ressources;

import org.advyteam.entites.Project;
import org.advyteam.entites.Task;
import org.advyteam.repositorys.DocumentRepository;
import org.advyteam.repositorys.ProjectRepository;
import org.advyteam.repositorys.SettingReposotory;
import org.advyteam.repositorys.TaskRepository;
import org.advyteam.requestBody.ProjectRequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

@Path("/projects")
public class ProjectRessource {
  public String path = "E:/formation quarkus/Angular/test-integration/backend_pfe/assets/description_project/";
  @Inject
  ProjectRepository projectRepository;
  @Inject
  SettingReposotory settingReposotory;
  @Inject
  DocumentRepository documentRepository;
  @Inject
  TaskRepository taskRepository;
  @Inject
  UsersRessource usersRessource;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Project> getAllProjects() {
    return projectRepository.findAll().list();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Project getProjectById(@PathParam("id") Long id) {
    return projectRepository.findById(id);
  }

  @POST
  @Path("/{ids}/{idd}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Transactional
  public Project AddNewProject(@PathParam("idd") Long iddocument, @PathParam("ids") Long idsetting,
      ProjectRequestBody project) throws IOException {

    Project newProject = new Project();
    if (settingReposotory.findById(idsetting) == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    List<Task> tasks = new ArrayList<>();
    Task newtask = new Task(project.getCreator());
    tasks.add(newtask);
    taskRepository.persist(tasks);

    newProject.setCreatedDate(project.getCreatedDate());
    newProject.setCreator(project.getCreator());
    newProject.setDeadline(project.getDeadline());
    newProject.setDescription(ConvertDescriptionToHtmlFile(project.getDescription(), project.getName()));
    newProject.setDocuments(documentRepository.findById(iddocument));
    newProject.setMembres(project.getMembres());
    newProject.setName(project.getName());
    newProject.setProgress(0);
    newProject.setProjectSettings(settingReposotory.findById(idsetting));
    newProject.setStartDate(project.getStartDate());
    newProject.setStatus(project.getStatus());
    newProject.setSubProject(project.getSubProject());
    newProject.setTags(project.getTags());
    newProject.setTasks(tasks);
    projectRepository.persist(newProject);
    return projectRepository.findById(newProject.id);
  }

  @Path("/createnewtask/{idProject}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Transactional
  public Project createNewTask(@PathParam("idProject") Long idProject) {
    Project project = projectRepository.findById(idProject);

    if (project == null) {
      throw new WebApplicationException(Response.Status.NO_CONTENT);
    }
    List<Task> tasks = project.getTasks();
    tasks.add(new Task(project.getCreator()));
    taskRepository.persist(tasks);
    // project.setCreatedDate(project.getCreatedDate());
    // project.setCreator(project.getCreator());
    // project.setDeadline(project.getDeadline());
    // project.setDescription(project.getDescription());
    // project.setDocuments(project.getDocuments());
    // project.setMembres(project.getMembres());
    // project.setName(project.getName());
    // project.setProgress(project.getProgress());
    // project.setProjectSettings(project.getProjectSettings());
    // project.setStartDate(project.getStartDate());
    // project.setStatus(project.getStatus());
    // project.setSubProject(project.getSubProject());
    // project.setTags(project.getTags());
    project.setTasks(tasks);
    return projectRepository.findById(idProject);
  }

  @Path("/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Project updateProject(@PathParam("id") Long id, Project project) {
    Project newProject = projectRepository.findById(id);
    if (newProject == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    newProject.setCreatedDate(project.getCreatedDate());
    newProject.setCreator(project.getCreator());
    newProject.setDeadline(project.getDeadline());
    newProject.setDescription(project.getDescription());
    newProject.setDocuments(project.getDocuments());
    newProject.setMembres(project.getMembres());
    newProject.setName(project.getName());
    newProject.setProgress(project.getProgress());
    newProject.setProjectSettings(project.getProjectSettings());
    newProject.setStartDate(project.getStartDate());
    newProject.setStatus(project.getStatus());
    newProject.setSubProject(project.getSubProject());
    newProject.setTags(project.getTags());
    newProject.setTasks(project.getTasks());
    return projectRepository.findById(id);
  }

  @Path("/{id}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public List<Project> DeleteProvider(@PathParam("id") Long id) {
    projectRepository.delete(projectRepository.findById(id));
    return projectRepository.findAll().list();
  }

  @Path("/taskfilter")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Project> getProjectTasksByFilter(@QueryParam("name") String name, @QueryParam("status") String status,
      @QueryParam("priority") String priority, @QueryParam("startDate") String startDate,
      @QueryParam("membres") String membres, @QueryParam("dueDate") String dueDate, @QueryParam("score") String score) {

    List<Project> projects = projectRepository.findAll().list();
    List<Project> projectWithFiltertTasks = new ArrayList<Project>();
    for (Project project : projects) {
      List<Task> filtertTasks = new ArrayList<Task>();
      for (Task task : project.getTasks()) {
        if (task.name.toLowerCase().matches("(.*)" + name.toLowerCase() + "(.*)")
            && task.getPriority().toLowerCase().matches("(.*)" + priority.toLowerCase() + "(.*)")
            && task.getStatus().toLowerCase().matches("(.*)" + status.toLowerCase() + "(.*)")
            && task.getStartDate().toString().toLowerCase().matches("(.*)" + startDate.toLowerCase() + "(.*)")
            && task.getDueDate().toString().toLowerCase().matches("(.*)" + dueDate.toLowerCase() + "(.*)")
            && task.getScore().toString().toLowerCase().matches("(.*)" + score.toLowerCase() + "(.*)")) {
          if (!membres.matches("")) {
            if (Arrays.asList(task.getMembres()).contains(membres)) {
              filtertTasks.add(task);
            }
          } else
            filtertTasks.add(task);
        }
      }
      project.setTasks(filtertTasks);
      projectWithFiltertTasks.add(project);
    }
    return projectWithFiltertTasks;
  }

  public String ConvertDescriptionToHtmlFile(String descriptionBody, String projectName) throws IOException {
    byte[] bytes = descriptionBody.getBytes(StandardCharsets.UTF_8);
    Random random = new Random();
    int randomNumber = random.nextInt(1000000000 - 10) + 10;
    LocalDate localDate = LocalDate.now();
    String fullPath = path + localDate + randomNumber + projectName + ".html";
    writeFile(bytes, fullPath);
    return fullPath;
  }

  private void writeFile(byte[] content, String filename) throws IOException {
    File file = new File(filename);
    if (!file.exists()) {
      file.createNewFile();
    }
    FileOutputStream fop = new FileOutputStream(file);
    fop.write(content);
    fop.flush();
    fop.close();
  }
}
