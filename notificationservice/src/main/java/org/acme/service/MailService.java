package org.acme.service;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.acme.emailBody.RappelTask;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

@Path("sendmail")
public class MailService {

    @Inject
    Mailer mailer;

    @GET
    @Path("/simple")
    public Response sendASimpleEmail() {
        mailer.send(Mail.withText("chahid23chirchi@gmail.com", "A simple email from quarkus", "This is my body"));
        return Response.accepted().build();
    }


    public Response sendRappelTaskHtml(String taskname,String emailResiver) {
        RappelTask rt = new RappelTask();
        String body = rt.bodyEmail(taskname, 0);
        mailer.send(Mail.withHtml(emailResiver, taskname+" is due in a day", body));
        return Response.accepted().build();
    }

}
