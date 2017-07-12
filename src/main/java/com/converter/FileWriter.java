package com.converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class FileWriter {

    private Path path;

    public FileWriter() {
        this.path = Paths.get("request.txt");
    }

    public void writeToFile(String request) {
        try {
            Files.write(path, Collections.singletonList(request));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
