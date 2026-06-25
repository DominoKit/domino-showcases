package org.dominokit.pages.presenters.samples;

import org.dominokit.brix.Brix;
import org.dominokit.pages.shared.events.ContentState;

public class SiteEvents {
  public static void fireContentEvent(){
      Brix.get().getCoreComponent()
                      .core().getEvents().fireEvent(new ContentState());
  }
}
