package by.kotsuba.arrayprocessor.reader;

import by.kotsuba.arrayprocessor.exception.ArrayException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayFileReader {
    public List<String> readLines(String filePath) throws ArrayException {
        Path path = Paths.get(filePath);
        try {
            return Files.readAllLines(path);
        }catch (IOException e){
            throw new ArrayException("Cannot read file: "+ filePath,e);
        }
    }
}
