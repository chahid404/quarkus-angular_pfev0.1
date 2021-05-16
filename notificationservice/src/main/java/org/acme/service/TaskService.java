package org.acme.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.acme.requestClasses.Task;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@Path("/tasks")
@RegisterRestClient(baseUri = "http://localhost:8083")
public interface TaskService {


    @GET
    @Path("/getnotfinishedtasksbyduedate/{date}")
    List<Task> getNotFinishedTasksByDueDate(@PathParam("date") String date);
}
