package org.acme.service;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("download")
public class EmailImages {
    @GET
    @Path("/{filename}")
    public Response loadFile(@PathParam("filename") String filename) {

        File file = new File("../assets/"+filename);  
            ResponseBuilder response = Response.ok((Object) file);  
            response.header("Content-Disposition", "attachment;filename=" + file);
            return response.build(); 
      }
}
