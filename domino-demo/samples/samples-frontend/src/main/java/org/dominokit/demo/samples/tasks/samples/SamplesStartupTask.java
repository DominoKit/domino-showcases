package org.dominokit.demo.samples.tasks.samples;

import dominojackson.shaded.com.google.auto.service.AutoService;
import java.util.Collections;
import org.dominokit.brix.api.BrixStartupTask;
import org.dominokit.showcases.samples.model.ContactsProvider;
import org.dominokit.showcases.samples.service.DemoServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(BrixStartupTask.class)
public class SamplesStartupTask extends BrixStartupTask {

  private static final Logger LOGGER = LoggerFactory.getLogger(SamplesStartupTask.class);

  @Override
  public void run() {
    LOGGER.info("Running Samples task.");
    DemoServiceFactory.INSTANCE
        .list()
        .onSuccess(
            contacts -> {
              ContactsProvider.setContacts(contacts);
              LOGGER.info("Loaded {} contacts for samples.", contacts.size());
              complete();
            })
        .onFailed(
            failedResponse -> {
              ContactsProvider.setContacts(Collections.emptyList());
              LOGGER.error(
                  "Failed to load contacts for samples. Continuing with an empty dataset. {}",
                  failedResponse.getBody());
              complete();
            })
        .send();
  }

  @Override
  public int order() {
    return -100;
  }
}
