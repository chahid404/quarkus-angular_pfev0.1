package org.advyteam.ressources;



import org.advyteam.entites.Document;
import org.advyteam.repositorys.DocumentRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/documents")
public class DocumentRessource {


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

}
