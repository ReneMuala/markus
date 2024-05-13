package org.descartes.generators;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class PDFGenerator implements Generator {
    PdfRendererBuilder builder = new PdfRendererBuilder();

    private String getStyledHtml(byte[] source) {
        return "<html>" +
                "<head>" +
                "<link href=\"markus-theme.css\" rel=\"stylesheet\" />" +
                "</head>" +
                "<body> " +
                new String(source) + "</body></html>";
    }

    @Override
    public byte[] generate(byte[] source) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            final var styledHtml = getStyledHtml(source);
            System.out.println(styledHtml);
            builder.withHtmlContent(styledHtml, (new File(System.getProperty("user.dir"))).toURI().toString());
            builder.toStream(outputStream);
            builder.run();
        } catch (Exception e) {
            System.err.printf("Failed to generate pdf, due to %s.%n", e);
        }
        return outputStream.toByteArray();
    }
}
