package org.dominokit.demo.samples.ui.views.datatable.benchmark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

final class BenchmarkContactGenerator {

  private BenchmarkContactGenerator() {}

  static List<BenchmarkContact> generateContacts(int count) {
    List<BenchmarkContact> contacts = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      contacts.add(generateContact(i));
    }
    return contacts;
  }

  private static BenchmarkContact generateContact(int index) {
    BenchmarkContact contact = new BenchmarkContact();
    long now = System.currentTimeMillis();

    contact.setId(index);
    contact.setFirstName("FirstName" + index);
    contact.setLastName("LastName" + index);
    contact.setEmail("user" + index + "@example.com");
    contact.setPhone("555-000" + index);
    contact.setAddress("123 Example St, Apt " + index);
    contact.setCity("City" + index);
    contact.setState("State" + index);
    contact.setZipCode("Zip" + index);
    contact.setCountry("Country" + index);
    contact.setBirthDate(new Date(now - ((long) index * 86_400_000L)));
    contact.setCompany("Company" + index);
    contact.setJobTitle("JobTitle" + index);
    contact.setDepartment("Department" + index);
    contact.setWebsite("www.example" + index + ".com");
    contact.setTwitterHandle("@twitter" + index);
    contact.setFacebookId("facebook" + index);
    contact.setLinkedinProfile("linkedin" + index);
    contact.setNotes("Notes for contact " + index);
    contact.setCreatedAt(now - (index * 10_000L));
    contact.setUpdatedAt(now - (index * 1_000L));
    contact.setActive(index % 2 == 0);
    contact.setRating((index % 5) + 1.0);
    contact.setCustomField1("Custom1_" + index);
    contact.setCustomField2(index * 10);
    return contact;
  }
}
