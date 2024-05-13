package org.descartes;

import org.descartes.generators.HTMLGenerator;
import org.descartes.generators.PDFGenerator;
import org.descartes.io.FileReader;
import org.descartes.io.FileWriter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "convert")
public class Main implements Callable<Integer> {
    @Parameters(index = "0", description = "input")
    private final Path input = Path.of("example.md");

    @Option(names = {"-o", "--output"}, description = "output")
    private final Path output = Path.of("example.pdf");

    static final int defaultBufferLimit =  512;
    @Option(names = {"-b", "--buffer-limit"}, description = "The maximum size of input buffer in KB (default: " + defaultBufferLimit + " KBs)")
    private final Integer bufferLimit = defaultBufferLimit;

    @Override
    public Integer call() throws Exception {
        final FileReader reader = new  FileReader(input, bufferLimit * 1024 * 1024);
        final FileWriter writer = new FileWriter(output);
        final HTMLGenerator htmlGenerator = new HTMLGenerator();
        final PDFGenerator pdfGenerator = new PDFGenerator();
        final String content = reader.read();
        writer.write(
                pdfGenerator.generate(
                        htmlGenerator.generate(
                                content.getBytes())));
        System.out.println("[ input: " + input + " output: " + output + " ]");
        return 0;
    }

    public static void main(String[] args) {
        int code = new CommandLine(new Main()).execute(args);
        System.exit(code);
    }
}