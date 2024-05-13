package org.descartes.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriter {
        protected Path path;
        public FileWriter(Path path) {
            this.path = path;
        }

        public void write(byte[] content) throws Exception{
            try (final var outputStream = new FileOutputStream( path.toFile())) {
                outputStream.write(content);
            } catch (Exception e){
                throw new IOException(String.format("Failed to write to file %s, due to %s.",path, e));
            }
        }
}
