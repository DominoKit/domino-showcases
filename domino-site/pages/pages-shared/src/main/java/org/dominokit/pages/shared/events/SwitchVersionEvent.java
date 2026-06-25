package org.dominokit.pages.shared.events;

import org.dominokit.brix.events.BrixEvent;

public class SwitchVersionEvent extends BrixEvent {

    private final String solution;
    private final String version;

    public static SwitchVersionEvent create(String solution, String version){
        return new SwitchVersionEvent(solution, version);
    }

    public SwitchVersionEvent(String solution, String version) {
        this.solution = solution;
        this.version = version;
    }

    public String getSolution() {
        return solution;
    }

    public String getVersion() {
        return version;
    }
}
