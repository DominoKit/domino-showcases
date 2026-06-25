package org.dominokit.demo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class IndexPageResource {

  @Inject
  IndexPageRenderer renderer;

  @GET
  @Produces("text/html;charset=UTF-8")
  public Response index() {
    return htmlResponse();
  }

  @GET
  @Path("{path:(?!api/)(?!app/)(?!prettify/)(?!q/)(?!favicon)(?!.*\\.[^/]+$).+}")
  @Produces("text/html;charset=UTF-8")
  public Response spaRoutes(@PathParam("path") String path) {
    return htmlResponse();
  }

  private Response htmlResponse() {
    return Response.ok(renderer.render())
        .header("Content-Type", "text/html; charset=UTF-8")
        .build();
  }
}
