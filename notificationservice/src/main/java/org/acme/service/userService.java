package org.acme.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.acme.requestClasses.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/keycloak")
@RegisterRestClient(baseUri = "http://localhost:8082")
public interface UserService {

  @GET
  @Path("/getallusers")
  List<User> getAllUsers();

  @GET
  @Path("/getuserbyid/{userId}")
  User getUserById(@PathParam("userId") String userId);
}