package org.descartes.generators;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class HTMLGenerator implements Generator {
    final private Parser parser;
    final private HtmlRenderer renderer;

    public HTMLGenerator(){
        parser = Parser.builder().build();
        renderer = HtmlRenderer.builder().build();
    }

    @Override
    public byte[] generate(byte[] source){
        return renderer.render(parser.parse(new String(source))).getBytes();
    }
}
