package org.dominokit.showcases.samples.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.ContactList;

public final class ContactsLoader {

  private static final String CONTACTS_RESOURCE = "META-INF/resources/assets/json/contacts.json";

  private ContactsLoader() {}

  public static List<Contact> loadContacts() {
    try (InputStream inputStream =
        ContactsLoader.class.getClassLoader().getResourceAsStream(CONTACTS_RESOURCE)) {
      if (inputStream == null) {
        throw new IllegalStateException("Contacts resource not found: " + CONTACTS_RESOURCE);
      }

      ContactList contactList =
          ContactList.MAPPER.read(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8));
      return contactList.getContacts();
    } catch (IOException e) {
      throw new UncheckedIOException("Unable to load contacts resource", e);
    }
  }
}
