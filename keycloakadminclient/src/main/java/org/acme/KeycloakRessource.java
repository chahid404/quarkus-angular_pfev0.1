package org.acme;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
// import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.MappingsRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/keycloak")
public class KeycloakRessource {
    final String serverUrl = "http://localhost:8080";
    final String clientSecret = "2b48d9db-9ccf-4e3f-9ccd-f7a824334633";
    final String realmName ="quarkus";
    Keycloak keycloak = KeycloakBuilder.builder()
            .serverUrl(serverUrl)
            .realm("master")
            .clientId("admin-cli")
            .username("admin")
            .password("admin")
            .clientSecret(clientSecret)
            .build();


    @GET
    public MappingsRepresentation hello() {

        return keycloak.realm("quarkus").users().get("5c5df9b2-04a0-416d-a90c-fc659ed478b3").roles().getAll();
    }
    @GET
    @Path("v2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> hello2() {
        return keycloak.realm("quarkus").clients().findAll();
    }

    @GET
    @Path("/getallusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> getAllUsers (){
        return keycloak.realm(realmName).users().list();
    }

    @GET
    @Path("/getuserbyid/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserRepresentation getUserById (@PathParam("userid")String userid){
        // UserResource userResource = keycloak.realm(realmName).users().get(userid);
        // UserRepresentation ur = new UserRepresentation();
        // ur.getAttributes();
        // userResource.update(ur);
        return keycloak.realm(realmName).users().get(userid).toRepresentation();
    }


}