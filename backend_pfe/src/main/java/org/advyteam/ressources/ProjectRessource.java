package org.advyteam.ressources;

import org.advyteam.entites.Project;
import org.advyteam.repositorys.DocumentRepository;
import org.advyteam.repositorys.ProjectRepository;
import org.advyteam.repositorys.SettingReposotory;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/projects")
public class ProjectRessource {

  @Inject
  ProjectRepository projectRepository;
  @Inject
  SettingReposotory settingReposotory;
  @Inject
  DocumentRepository documentRepository;

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
  public Project AddNewProject(@PathParam("idd") Long iddocument,@PathParam("ids") Long idsetting, Project project) {

    Project newProject = new Project();
    if (settingReposotory.findById(idsetting) == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    newProject.setCreatedDate(project.getCreatedDate());
    newProject.setCreator(project.getCreator());
    newProject.setDeadline(project.getDeadline());
    newProject.setDescription(project.getDescription());
    newProject.setDocuments(documentRepository.findById(iddocument));
    newProject.setMembres(project.getMembres());
    newProject.setName(project.getName());
    newProject.setProgress(project.getProgress());
    newProject.setProjectSettings(settingReposotory.findById(idsetting));
    newProject.setStartDate(project.getStartDate());
    newProject.setStatus(project.getStatus());
    newProject.setSubProject(project.getSubProject());
    newProject.setTags(project.getTags());
    newProject.setTasks(project.getTasks());
    projectRepository.persist(newProject);
    return newProject;
  }


  @Path("/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
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

}
