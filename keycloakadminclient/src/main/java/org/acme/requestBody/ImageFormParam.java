package org.acme.requestBody;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class ImageFormParam {
    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream file;

    @FormParam("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    public String fileName;

    public ImageFormParam() {
    }

    public ImageFormParam(InputStream file, String fileName) {
        this.file = file;
        this.fileName = fileName;
    }

    public InputStream getFile() {
        return this.file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ImageFormParam file(InputStream file) {
        setFile(file);
        return this;
    }

    public ImageFormParam fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

}
