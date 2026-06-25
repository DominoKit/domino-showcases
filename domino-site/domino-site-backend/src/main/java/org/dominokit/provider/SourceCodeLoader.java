package org.dominokit.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.regex.Pattern;

final class SourceCodeLoader {

  private static final Pattern CLASS_NAME_PATTERN =
      Pattern.compile("[A-Za-z_$][A-Za-z\\d_$]*(\\.[A-Za-z_$][A-Za-z\\d_$]*)+");

  Optional<String> load(String canonicalName) {
    if (canonicalName == null || canonicalName.isBlank()) {
      return Optional.empty();
    }

    if (!CLASS_NAME_PATTERN.matcher(canonicalName).matches()) {
      return Optional.empty();
    }

    String resourcePath = canonicalName.replace('.', '/') + ".java";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try (InputStream stream = classLoader.getResourceAsStream(resourcePath)) {
      if (stream == null) {
        return Optional.empty();
      }

      return Optional.of(new String(stream.readAllBytes(), StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new UncheckedIOException("Failed to load source code from " + resourcePath, e);
    }
  }
}
