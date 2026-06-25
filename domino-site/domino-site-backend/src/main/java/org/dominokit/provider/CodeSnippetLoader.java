package org.dominokit.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public final class CodeSnippetLoader {

    private CodeSnippetLoader() {
    }

    public static Map<String, String> loadSnippets(String resourceDir) {
        try {
            String normalizedDir = normalizeDir(resourceDir);
            URL url = Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(normalizedDir);

            if (url == null) {
                return Map.of();
            }

            if (url.getProtocol().equals("file")) {
                return loadFromDirectory(Paths.get(url.toURI()), normalizedDir);
            }

            if (url.getProtocol().equals("jar")) {
                return loadFromJar(url, normalizedDir);
            }

            return Map.of();

        } catch (Exception e) {
            throw new RuntimeException("Failed to load code snippets from " + resourceDir, e);
        }
    }

    private static String normalizeDir(String resourceDir) {
        if (resourceDir == null || resourceDir.isBlank()) {
            return resourceDir;
        }
        return resourceDir.startsWith("/") ? resourceDir.substring(1) : resourceDir;
    }

    private static Map<String, String> loadFromDirectory(
            Path dir, String resourceDir) throws IOException {

        Map<String, String> snippets = new LinkedHashMap<>();

        try (Stream<Path> files = Files.list(dir)) {
            files.filter(p -> p.getFileName().toString().endsWith(".txt"))
                    .forEach(p -> {
                        String key = stripTxt(p.getFileName().toString());
                        snippets.put(key, readFile(p));
                    });
        }

        return snippets;
    }

    private static Map<String, String> loadFromJar(
            URL dirUrl, String resourceDir) throws IOException {

        Map<String, String> snippets = new LinkedHashMap<>();

        String jarPath = dirUrl.getPath().substring(5, dirUrl.getPath().indexOf("!"));
        try (JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"))) {

            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();

                String name = entry.getName();
                if (name.startsWith(resourceDir)
                        && name.endsWith(".txt")
                        && !entry.isDirectory()) {

                    String fileName = name.substring(name.lastIndexOf('/') + 1);
                    String key = stripTxt(fileName);

                    try (InputStream is = jar.getInputStream(entry)) {
                        snippets.put(key, readStream(is));
                    }
                }
            }
        }

        return snippets;
    }
    private static String stripTxt(String fileName) {
        return fileName.endsWith(".txt")
                ? fileName.substring(0, fileName.length() - 4)
                : fileName;
    }

    private static String readFile(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static String readStream(InputStream is) {
        try {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
