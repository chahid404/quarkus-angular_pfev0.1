package org.acme.ressources;


import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.entity.Logs;
import org.acme.repository.LogsRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;


@Path("logs")
public class LogsRessource {

    @Inject
    LogsRepository logsRepository;

    @Inject
    RappelRessource counter;            


    @Path("/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logs> getAllLogs() {
        return logsRepository.findAll().list();
    }

    @Path("/getbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Logs getLogsByID(@PathParam("id") Long id) {
        return logsRepository.findById(id);
    }

    @Path("/getbyuser/{iduser}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logs> getLogByUser(@PathParam("iduser") Long iduser) {
        Long countLogs = logsRepository.find("idCreator", iduser).count();
        if (countLogs.intValue() == 0) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }

        if (countLogs.intValue() < 4) {
            return logsRepository.find("idCreator", iduser).list();
        } else

            return logsRepository.find("idCreator", iduser).range(countLogs.intValue() - 4, countLogs.intValue())
                    .list();
    }

    @Path("/save/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Logs createLogs(Logs logs) {
        Logs newLogs = new Logs();
        newLogs.setAction(logs.getAction());
        newLogs.setIdCreator(logs.getIdCreator());
        logsRepository.persist(newLogs);
        return logsRepository.findById(newLogs.getId());
    }

    @Path("/returnlasts/{iduser}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logs> getLastThreeNotifs(@PathParam("iduser") String iduser) {
        Long countLogs = logsRepository.find("idCreator", iduser).count();
        if (countLogs.intValue() == 0) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }

        if (countLogs.intValue() < 4) {
            return logsRepository.find("idCreator", iduser).list();
        } else

            return logsRepository.find("idCreator", iduser).range(countLogs.intValue() - 4, countLogs.intValue())
                    .list();
    }

    @Path("/deleteforuser/{iduser}")
    @DELETE
    @Transactional
    public Status deleteForUserLogs(@PathParam("iduser") String iduser) {
        Long countNotifs = logsRepository.find("idCreator", iduser).count();
        if (countNotifs.intValue() == 0) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
        logsRepository.delete("idCreator", iduser);
        return Response.Status.ACCEPTED;
    }
}
