package org.dominokit.provider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.Locale;
@Path("/")
@ApplicationScoped
public class IndexPageResource {

    @Inject
    IndexPageRenderer renderer;

    @GET
    @Produces("text/html;charset=UTF-8")
    public Response index() {
        return renderForPath("/");
    }

    // SPA routes: no assets, no service, no q/, no .well-known, and NO dots in the path
    @GET
    @Path("{path:(?!assets)(?!service/)(?!q/)(?!\\.well-known)(?!.*\\.[^/]+$).+}")
    @Produces("text/html;charset=UTF-8")
    public Response spaRoutes(@PathParam("path") String path) {
        String requestPath = "/" + path;
        return renderForPath(requestPath);
    }

    private Response renderForPath(String requestPath) {
        String templateName = "index";
        String normalized = requestPath.toLowerCase(Locale.ROOT);

        if (!"/".equals(normalized) && !"/home".equals(normalized) && !normalized.contains("css/")) {
            templateName = requestPath.startsWith("/") ? requestPath.substring(1) : requestPath;
        }

        String html = renderer.render(templateName, TemplatesContext.get());
        return Response.ok(html)
                .header("Content-Type", "text/html; charset=UTF-8")
                .build();
    }
}

