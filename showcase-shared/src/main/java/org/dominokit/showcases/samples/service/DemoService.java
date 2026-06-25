package org.dominokit.showcases.samples.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import java.util.List;

@RequestFactory
public interface DemoService {
    @GET
    @Path("contacts")
    List<Contact> list();
}
