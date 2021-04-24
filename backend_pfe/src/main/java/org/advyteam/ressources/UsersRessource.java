package org.advyteam.ressources;

import org.advyteam.entites.User;
import org.advyteam.services.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/users")
public class UsersRessource {

  @Inject
  @RestClient
  UserService userService;

  @GET
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GET
  @Path("/byid/{userid}")
  public User getUserById(@PathParam("userid") String userid) {
    return userService.getUserById(userid);
  }
}
