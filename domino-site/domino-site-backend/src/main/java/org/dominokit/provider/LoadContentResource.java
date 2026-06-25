package org.dominokit.provider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@ApplicationScoped
@Path("/api")
public class LoadContentResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadContentResource.class);

    @Inject
    IndexPageRenderer renderer;

    @GET
    @Path("content")
    @Produces(MediaType.TEXT_HTML)
    public String getPageContent(@QueryParam("path") String path,
                                 @QueryParam("page") String page,
                                 @QueryParam("docs") @DefaultValue("false") boolean docContent) {
        if (path == null || path.isBlank() || (!docContent && (page == null || page.isBlank()))) {
            throw new IllegalArgumentException("Missing required query parameters");
        }

        // Match old behaviour: "pages/" + path + "/" + (docs ? "body" : page)
        String templateName = "pages/" + path + "/" + (docContent ? "body" : page);

        Map<String, Object> ctx = TemplatesContext.get();
        ctx.put("ctxParamDocs", docContent);

        try {
            return renderer.render(templateName, ctx);
        } catch (Exception e) {
            LOGGER.error("Failed to render content. path=[{}], page=[{}], docs=[{}], template=[{}]",
                    path, page, docContent, templateName, e);
            throw new RuntimeException("Failed to load content for path : " + path + "/" + page, e);
        }
    }
}
