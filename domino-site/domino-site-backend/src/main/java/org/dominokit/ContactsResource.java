package org.dominokit;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.service.ContactsLoader;

@Path("/api/contacts")
public class ContactsResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Contact> getContacts() {
    return ContactsLoader.loadContacts();
  }
}
