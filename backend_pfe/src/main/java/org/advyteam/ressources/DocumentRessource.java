package org.advyteam.ressources;

import org.advyteam.entites.Document;
import org.advyteam.otherClasses.FileParams;
import org.advyteam.otherClasses.MultiPartBody;
import org.advyteam.repositorys.DocumentRepository;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Path("/documents")
public class DocumentRessource {

  public String path = "../uploads/";

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
    newDocument.setPath(document.getPath());
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
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public FileParams uploadFile(@MultipartForm MultiPartBody bodyFile) throws IOException {
    byte[] bytes = bodyFile.file.readAllBytes();
    Random random = new Random();
    FileParams fileParams = new FileParams();
    int randomNumber = random.nextInt(1000 - 10) + 10;
    LocalDate localDate = LocalDate.now();
    writeFile(bytes, path + randomNumber + "-" + localDate + "-" + bodyFile.getFileName());
    fileParams.setFileName(bodyFile.getFileName());
    fileParams.setFullPath(path + randomNumber + "-" + localDate + "-" + bodyFile.getFileName());
    fileParams.setRegenaratedFileName(randomNumber + "-" + localDate + "-" + bodyFile.getFileName());
    return fileParams;
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

  @Path("/uploadfile/new")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Transactional
  public String testpulodfile() throws IOException {
    String a = "azeazeazeaze";
    File file = new File(path + "file.txt");
    byte[] bytes = a.getBytes();
    FileOutputStream fop = new FileOutputStream(file);
    fop.write(bytes);
    fop.flush();
    fop.close();
    Document doc = new Document();
    documentRepository.persist(doc);
    return file.getAbsoluteFile().toString();
  }

  @GET
  @Path("/download/{filename}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response loadFile(@PathParam("filename") String filename) {

    File file = new File("../uploads/"+filename);  
        ResponseBuilder response = Response.ok((Object) file);  
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build(); 
  }
}
