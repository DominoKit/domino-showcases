package org.dominokit.demo.shell.tasks.shell;

import dominojackson.shaded.com.google.auto.service.AutoService;
import org.dominokit.brix.api.BrixStartupTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(BrixStartupTask.class)
public class ShellStartupTask extends BrixStartupTask {

  private static final Logger LOGGER = LoggerFactory.getLogger(ShellStartupTask.class);

  @Override
  public void run() {
    LOGGER.info("Running Shell task.");
    complete();
  }

  @Override
  public int order() {
    return 0;
  }
}
