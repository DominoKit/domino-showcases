package org.dominokit.pages.tasks.pages;

import dominojackson.shaded.com.google.auto.service.AutoService;
import org.dominokit.brix.api.BrixStartupTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(BrixStartupTask.class)
public class PagesStartupTask extends BrixStartupTask {

  private static final Logger LOGGER = LoggerFactory.getLogger(PagesStartupTask.class);

  @Override
  public void run() {
    LOGGER.info("Running Pages task.");
    complete();
  }

  @Override
  public int order() {
    return 0;
  }
}
