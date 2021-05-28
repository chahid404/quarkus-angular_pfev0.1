package org.acme;

import org.acme.requestBody.ImageFormParam;
import org.acme.requestBody.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Path("/keycloak")
public class KeycloakRessource {
    final String serverUrl = "http://localhost:8080";
    final String clientSecret = "2b48d9db-9ccf-4e3f-9ccd-f7a824334633";
    final String realmName = "quarkus";
    Keycloak keycloak = KeycloakBuilder.builder().serverUrl(serverUrl).realm("master").clientId("admin-cli")
            .username("admin").password("admin").clientSecret(clientSecret).build();
    private String imgUrl;
    //public String path = "../../../../../uploads/";

    @GET
    @Path("/getallusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> getAllUsers(@QueryParam("currentuser") String userId,
            @QueryParam("search") String search) {
        List<UserRepresentation> listUsers = new ArrayList<UserRepresentation>();
        if (search != "") {
            listUsers = keycloak.realm(realmName).users().search(search, 0, 10);
        } else {
            listUsers = keycloak.realm(realmName).users().list();
        }
        if (userId != "") {
            if (keycloak.realm(realmName).users().get(userId).toRepresentation() != null) {
                int currentUserIndex = returnIndexOfUserInListOfUsers(listUsers,
                        keycloak.realm(realmName).users().get(userId).toRepresentation());
                if (currentUserIndex != -1) {
                    listUsers.remove(currentUserIndex);
                }
            }
        }
        return sortListOfUsersByCreatedDate(listUsers);
    }

    @GET
    @Path("/getRealmSession")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getRealmSession() {
        Map<String, String> newAtt = new HashMap<>();
        List<Map<String, String>> sessionInfomation = keycloak.realm(realmName).getClientSessionStats();
        int numberOfuser = keycloak.realm(realmName).users().count();
        newAtt.put("numberOfuser", Integer.toString(numberOfuser));
        sessionInfomation.get(0).put("CountUser", Integer.toString(numberOfuser));
        sessionInfomation.get(0).put("CountProject", Integer.toString(numberOfuser));
        sessionInfomation.get(0).put("CountTasks", Integer.toString(numberOfuser));
        return sessionInfomation.get(0);
    }

    @GET
    @Path("/getuserbyid/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userid") String userid) {
        User currentUser = new User();
        UserRepresentation userR = keycloak.realm(realmName).users().get(userid).toRepresentation();
        currentUser.setId(userR.getId());
        currentUser.setUsername(userR.getUsername());
        currentUser.setFirstName(userR.getFirstName());
        currentUser.setLastName(userR.getLastName());
        currentUser.setEmail(userR.getEmail());
        currentUser.setEnabled(userR.isEnabled());
        if (userR.getAttributes() != null) {
            currentUser.setAttributes(userR.getAttributes());
        }
        return currentUser;

    }

    @PUT
    @Path("/updateuser/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("userid") String userid, User userBody) {
        this.imgUrl = " ";
        UserRepresentation user = keycloak.realm("quarkus").users().get(userid).toRepresentation();
        Map<String, List<String>> attributes = new HashMap<String, List<String>>();
        if (user.getAttributes() != null) {
            attributes = user.getAttributes();
        }
        user.setEmail(userBody.getEmail());
        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        user.setEnabled(userBody.getEnabled());
        if (userBody.getAttributes().birthday != null) {
            attributes.put("birthday", Arrays.asList(userBody.getAttributes().birthday));
        }
        if (userBody.getAttributes().nationality != null) {
            attributes.put("nationality", Arrays.asList(userBody.getAttributes().nationality));
        }
        if (userBody.getAttributes().gender != null) {
            attributes.put("gender", Arrays.asList(userBody.getAttributes().gender));
        }
        if (userBody.getAttributes().telephone != null) {
            attributes.put("telephone", Arrays.asList(userBody.getAttributes().telephone));
        }
        if (userBody.getAttributes().zip_code != null) {
            attributes.put("zip_code", Arrays.asList(userBody.getAttributes().zip_code));
        }
        if (user.getAttributes() != null) {
            user.getAttributes().entrySet().forEach(key -> {
                if (key.getValue() != null && key.getKey().matches("imgUrl")) {
                    this.imgUrl = key.getValue().get(0);
                }
            });
        }
        attributes.put("imgUrl", Arrays.asList(this.imgUrl));
        if (attributes != null) {
            user.setAttributes(attributes);
        }

        keycloak.realm("quarkus").users().get(userid).update(user);
        UserRepresentation userR = keycloak.realm("quarkus").users().get(userid).toRepresentation();

        userBody.setId(userR.getId());
        userBody.setUsername(userR.getUsername());
        userBody.setFirstName(userR.getFirstName());
        userBody.setLastName(userR.getLastName());
        userBody.setEmail(userR.getEmail());
        userBody.setEnabled(userR.isEnabled());
        if (userR.getAttributes() != null) {
            userBody.setAttributes(userR.getAttributes());
        }
        return userBody;
    }

    @GET
    @Path("/restpassword/{userid}/{oldpass}/{newpass}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Status restPassword(@PathParam("userid") String userid, @PathParam("oldpass") String oldpass,
            @PathParam("newpass") String newpass) {
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", "2b8bbd21-27d0-4680-8a69-5dee3d48d566");
        clientCredentials.put("grant_type", "password");
        Configuration configuration = new Configuration(serverUrl, "quarkus", "backenduser", clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);
        UserRepresentation connectedUser = keycloak.realm("quarkus").users().get(userid).toRepresentation();
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        if (authzClient.obtainAccessToken(connectedUser.getUsername(), oldpass).getToken() != null) {
            credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
            credentialRepresentation.setValue(newpass);
            credentialRepresentation.setTemporary(false);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        keycloak.realm("quarkus").users().get(userid).resetPassword(credentialRepresentation);
        return Response.Status.OK;

    }

    @POST
    @Path("/createuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public StatusType createUser(User userBody) {
        List<UserRepresentation> userRepresentations = keycloak.realm("quarkus").users().search(userBody.getUsername(),
                null, null, null, 0, 1);
        if (!userRepresentations.isEmpty()) {
            throw new WebApplicationException(Response.Status.FOUND);
        }
        Map<String, List<String>> attributes = new HashMap<String, List<String>>();
        attributes.put("imgUrl", Arrays.asList(" "));
        UserRepresentation newUser = new UserRepresentation();
        newUser.setUsername(userBody.getUsername());
        newUser.setFirstName(userBody.getFirstName());
        newUser.setLastName(userBody.getLastName());
        newUser.setEmail(userBody.getEmail());
        newUser.setEnabled(true);

        // Get realm
        RealmResource realmResource = keycloak.realm("quarkus");
        UsersResource userRessource = realmResource.users();

        // Create user (requires manage-users role)
        Response response = userRessource.create(newUser);
        System.out.println("Repsonse: " + response.getStatusInfo());
        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        System.out.printf("User created with userId: %s%n", userId);

        // Get realm role "user" (requires view-realm role)
        RoleRepresentation testerRealmRole = realmResource.roles()//
                .get("user").toRepresentation();

        // Assign realm role user(role) to user
        userRessource.get(userId).roles().realmLevel() //
                .add(Arrays.asList(testerRealmRole));

        // Define password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        String password = new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);
        passwordCred.setTemporary(true);

        // Set password credential
        userRessource.get(userId).resetPassword(passwordCred);
        System.out.print("Password :" + password);
        UserRepresentation userR = keycloak.realm("quarkus").users().get(userId).toRepresentation();
        userR.setAttributes(attributes);
        keycloak.realm("quarkus").users().get(userId).update(userR);
        return response.getStatusInfo();

    }

    @PUT
    @Path("/changeuserstatus/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Status changeUserStatus(@PathParam("userid") String userid) {
        UserRepresentation userR = keycloak.realm("quarkus").users().get(userid).toRepresentation();
        if (userR == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        userR.setEnabled(!userR.isEnabled());
        keycloak.realm("quarkus").users().get(userid).update(userR);
        return Response.Status.OK;
    }

    @PUT
    @Path("/updateuserpic")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response updateUserPic(@QueryParam("userid") String userid, @MultipartForm ImageFormParam fileBody)
            throws IOException {
        UserRepresentation userR = keycloak.realm(realmName).users().get(userid).toRepresentation();
        if (userR == null) {
            throw new WebApplicationException("user not found", Response.Status.NOT_FOUND);
        }
        if (fileBody == null) {
            throw new WebApplicationException("please select profile picture", Response.Status.NO_CONTENT);
        }
        // upload pic
        byte[] bytes = fileBody.file.readAllBytes();
        LocalDateTime localDate = LocalDateTime.now();
        String picFullpath = localDate.toString().replace(":", "") + fileBody.getFileName().replace(" ", "");
        writeFile(bytes,picFullpath);
        // update profile
        if (userR.getAttributes() != null) {
            userR.getAttributes().entrySet().forEach(key -> {
                if (key.getValue() != null && key.getKey().matches("imgUrl")) {
                    userR.getAttributes().replace("imgUrl", Arrays.asList(picFullpath));
                }
            });
        }
        userR.setAttributes(userR.getAttributes());
        keycloak.realm(realmName).users().get(userid).update(userR);
        return Response.ok(userR).build();
    }

    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response loadFile(@QueryParam("filename") String filename) {
        File file = new File(filename);
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build();
    }

    int returnIndexOfUserInListOfUsers(List<UserRepresentation> users, UserRepresentation user) {
        int i = 0;
        for (UserRepresentation userRepresentation : users) {
            if (userRepresentation.getId().equalsIgnoreCase(user.getId())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    List<UserRepresentation> sortListOfUsersByCreatedDate(List<UserRepresentation> users) {
        List<UserRepresentation> sortedUsers = users.stream()
                .sorted(Comparator.comparing(UserRepresentation::getCreatedTimestamp)).collect(Collectors.toList());
        return sortedUsers;
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