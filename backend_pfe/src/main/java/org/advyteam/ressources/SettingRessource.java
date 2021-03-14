package org.advyteam.ressources;

import org.advyteam.entites.Setting;
import org.advyteam.repositorys.SettingReposotory;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/settings")
public class SettingRessource {


    @Inject
    SettingReposotory settingReposotory;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Setting> getAllSettings() {
        return settingReposotory.findAll().list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Setting getSettingById(@PathParam("id") Long id) {
        return settingReposotory.findById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Setting AddNewSetting(Setting setting) {
        settingReposotory.persist(setting);
        return setting;
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Setting> DeleteSetting(@PathParam("id") Long id) {
        settingReposotory.delete(settingReposotory.findById(id));
        return settingReposotory.findAll().list();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Setting updateSetting(@PathParam("id") Long id, Setting setting) {
        Setting newSetting = settingReposotory.findById(id);
        if (newSetting == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        newSetting.setProjectString(setting.getProjectString());
        newSetting.setEditTasks(setting.getEditTasks());
        newSetting.setCommentOnTasks(setting.getCommentOnTasks());
        newSetting.setViewTaskAttachements(setting.getViewTaskAttachements());
        newSetting.setUploadAttachementsOnTask(setting.getUploadAttachementsOnTask());
        newSetting.setViewActivityLog(setting.getViewActivityLog());
        newSetting.setViewTeamMembers(setting.getViewTeamMembers());
        newSetting.setHideProjectTasksOnMainTasksTable(setting.getHideProjectTasksOnMainTasksTable());

        return settingReposotory.findById(id);
    }
}
