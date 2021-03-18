package org.advyteam.ressources;


import org.advyteam.entites.Document;
import org.advyteam.entites.MultiPartBody;
import org.advyteam.repositorys.DocumentRepository;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Path("/documents")
public class DocumentRessource {

public String path = "E:/formation quarkus/Angular/test-integration/backend_pfe/assets/";
  @Inject
  DocumentRepository documentRepository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Document> getAllDocuments() {
    return documentRepository.findAll().list();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Document getDocumentById(@PathParam("id") Long id) {
    return documentRepository.findById(id);
  }


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Transactional
  public Document AddNewDocument(Document document) {
    document.setPath(path+document.getDocumentName());
    documentRepository.persist(document);
    return document;
  }

  @Path("/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Document updateDocument(@PathParam("id") Long id, Document document) {
    Document newDocument = documentRepository.findById(id);
    if (newDocument == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    newDocument.setDocumentName(document.getDocumentName());
    newDocument.setUploadDate(document.getUploadDate());
    newDocument.setFile(document.getFile());
    newDocument.setPath(document.getPath());
    newDocument.setTask(document.getTask());
    return documentRepository.findById(id);
  }

  @Path("/{id}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public List<Document> DeleteDocument(@PathParam("id") Long id) {
    documentRepository.delete(documentRepository.findById(id));
    return documentRepository.findAll().list();
  }

  @Path("/uploadfile")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public String uploadFile(@MultipartForm MultiPartBody sting) throws IOException {
    byte[] bytes = sting.file.readAllBytes();
    writeFile(bytes, path + sting.getFileName());
    return sting.fileName;
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
