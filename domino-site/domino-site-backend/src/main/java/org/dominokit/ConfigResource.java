package org.dominokit;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.microprofile.config.ConfigProvider;

@Path("/api/config")
public class ConfigResource {

  public static final String BRIX_APPLICATION_ROOT = "brix.application.root";
  public static final String BRIX_API_URL = "brix.api.url";

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Map<String, String> getConfig(){
    Map<String, String> config = new HashMap<>();
    config.put(BRIX_APPLICATION_ROOT, ConfigProvider.getConfig().getValue(BRIX_APPLICATION_ROOT, String.class));
    config.put(BRIX_API_URL, ConfigProvider.getConfig().getValue(BRIX_API_URL, String.class));
    return config;
  }
}
