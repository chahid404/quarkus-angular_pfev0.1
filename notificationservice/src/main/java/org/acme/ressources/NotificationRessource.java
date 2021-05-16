package org.acme.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.acme.entity.Notification;
import org.acme.repository.NotificationRepository;
import org.acme.service.TaskService;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/notif")
public class NotificationRessource {

    @Inject
    NotificationRepository notificationRepository;

    @Inject
    @RestClient
    TaskService taskService;

    @Path("/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getAllNotifs() {
        return notificationRepository.findAll().list();
    }

    @Path("/getbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Notification getNotifByID(@PathParam("id") Long id) {
        return notificationRepository.findById(id);
    }

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Notification createNotif(Notification notifis) {
        Notification newNotif = new Notification();
        newNotif.setAction(notifis.getAction());
        newNotif.setIdCreator(notifis.getIdCreator());
        newNotif.setIdRecever(notifis.getIdRecever());
        newNotif.setTargetProjectid(notifis.getTargetProjectid());
        notificationRepository.persist(newNotif);
        return notificationRepository.findById(newNotif.getId());
    }

    @Path("/returnlasts/{idRecever}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getLastThreeNotifs(@PathParam("idRecever") String idRecever) {
        Long countNotifs = notificationRepository.find("idRecever", idRecever).count();
        if (countNotifs.intValue() == 0) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }

        if (countNotifs.intValue() < 4) {
            return notificationRepository.find("idRecever", idRecever).list();
        } else

            return notificationRepository.find("idRecever", idRecever)
                    .range(countNotifs.intValue() - 4, countNotifs.intValue()).list();
    }

    @Path("/deletenotifforuser/{iduser}")
    @DELETE
    @Transactional
    public Status deleteNotifsForUsers(@PathParam("iduser") String iduser) {
        Long countNotifs = notificationRepository.find("idRecever", iduser).count();
        if (countNotifs.intValue() == 0) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
        notificationRepository.delete("idRecever", iduser);
        return Response.Status.ACCEPTED;

    }

    @Path("/deletenotifbyid/{idnotif}")
    @DELETE
    @Transactional
    public Status deleteNotifById(@PathParam("idnotif") Long idnotif) {
        if (notificationRepository.findById(idnotif) == null) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
        notificationRepository.deleteById(idnotif);
        return Response.Status.ACCEPTED;

    }

    @Path("/markallasread/{iduser}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Status markAllAsRead(@PathParam("iduser") String iduser) {
        Long countNotifs = notificationRepository.find("idRecever", iduser).count();

        if (countNotifs == 0) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
        List<Notification> newNotifsList = notificationRepository.find("idRecever", iduser).list();

        for (Notification notifis : newNotifsList) {
            notifis.setIsRead(true);
        }
        return Response.Status.ACCEPTED;
    }

    @Path("/markasunread/{idnotif}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Status markAsUnRead(@PathParam("idnotif") Long idnotif) {
        Notification notifis = notificationRepository.findById(idnotif);

        if (notifis == null) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }

        notifis.setIsRead(false);
        return Response.Status.ACCEPTED;
    }

    @Path("/markasread/{idnotif}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Status markAsRead(@PathParam("idnotif") Long idnotif) {
        Notification notifis = notificationRepository.findById(idnotif);

        if (notifis == null) {
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }

        notifis.setIsRead(true);
        return Response.Status.ACCEPTED;
    }

    @Path("/cleanallnotif/{iduser}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Status cleanAllNotifFoUser(@PathParam("iduser") String iduser) {
        Long countNotifs = notificationRepository.find("idRecever", iduser).count();

        if (countNotifs == 0) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        List<Notification> newNotifsList = notificationRepository.find("idRecever", iduser).list();

        for (Notification notifis : newNotifsList) {
            notifis.setIsShow(false);
        }
        return Response.Status.ACCEPTED;
    }

    @Path("/dontshownotif/{idnotif}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Status dontShowNotifById(@PathParam("idnotif") Long idnotif) {
        Notification notifis = notificationRepository.findById(idnotif);

        if (notifis == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        notifis.setIsShow(false);
        return Response.Status.ACCEPTED;
    }

    @Path("/returnisshowbyuser/{idRecever}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> retrunOnlySowed(@PathParam("idRecever") String idRecever) {
        return notificationRepository.find("idRecever = ?1 and isShow = ?2 order by createdAt DESC", idRecever, true).list();
    }

    @Path("/returnunreadnotif/{idRecever}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> returnUnReadNotif(@PathParam("idRecever") String idRecever) {

        return notificationRepository.find("idRecever = ?1 and isShow = ?2 and isRead = ?3", idRecever, true, false)
                .list();
    }

}


