package org.dominokit.pages.shared.service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.dominokit.rest.shared.request.StringReader;
import org.dominokit.rest.shared.request.service.annotations.Reader;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@RequestFactory
@Path("/")
public interface LoadContentService {

    @GET
    @Path("content")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_PLAIN)
    @Reader(StringReader.class)
    String getPageContent(@QueryParam("path") String path, @QueryParam("page") String page, @QueryParam("docs") boolean docContent);

    @GET
    @Path("source")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Reader(StringReader.class)
    String getSourceCode(@QueryParam("path") String path);
}
