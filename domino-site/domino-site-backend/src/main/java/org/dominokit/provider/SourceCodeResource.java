package org.dominokit.provider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/api")
public class SourceCodeResource {

  private final SourceCodeLoader sourceCodeLoader = new SourceCodeLoader();

  @GET
  @Path("source")
  @Produces(MediaType.TEXT_PLAIN)
  public String getSourceCode(@QueryParam("path") String path) {
    return sourceCodeLoader
        .load(path)
        .orElseThrow(() -> new NotFoundException("No source code found for path: " + path));
  }
}
