package com.converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    private Path path;

    public FileReader(String path) {
        this.path = Paths.get(path);
    }

    public List<String> readAllLines() {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
