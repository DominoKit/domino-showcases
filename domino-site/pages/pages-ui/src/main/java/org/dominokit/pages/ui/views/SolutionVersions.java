package org.dominokit.pages.ui.views;

import java.util.List;

public class SolutionVersions {
    public static List<Version> getSolutionVersion(String solutionName) {
        switch (solutionName) {
            case "domino-rest": return List.of(Version.of("Version 1","v1", "1.x.x"), Version.of("Version 2","v2", "2.x.x"));
            default:
                return List.of(Version.of("Version 1","v1", "1.x.x"));
        }
    }

    public static class Version {
        private final String name;
        private final String version;
        private final String description;

        public static Version of(String name, String version, String description) {
            return new Version(name, version, description);
        }

        public Version(String name, String version, String description) {
            this.name = name;
            this.version = version;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }

        public String getDescription() {
            return description;
        }
    }
}
