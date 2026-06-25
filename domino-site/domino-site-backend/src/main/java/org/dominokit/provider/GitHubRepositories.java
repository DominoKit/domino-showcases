package org.dominokit.provider;

import java.util.List;

public final class GitHubRepositories {

    private GitHubRepositories() {}

    public static final List<String> REPOSITORIES = List.of(
            "domino-ui",
            "domino-rest",
            "domino-jackson",
            "domino-history",
            "domino-brix"
    );
}
