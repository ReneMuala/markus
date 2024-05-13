package org.descartes.io;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Path;
import java.util.Arrays;

public class FileReader {
    private final Path path;
    
    private final int bufferSize;
    
    public FileReader(Path path, int bufferSize) {
        this.path = path;
        this.bufferSize = bufferSize;
    }

    public String read() throws Exception{
        try (final var inputStream = new FileInputStream( path.toFile())) {
            return new String(inputStream.readNBytes(bufferSize));
        } catch (Exception e){
            throw new IOException(String.format("Failed to read file %s, due to %s.",path, e));
        }
    }
}
