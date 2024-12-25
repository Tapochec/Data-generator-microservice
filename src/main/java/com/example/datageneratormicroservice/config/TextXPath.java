package com.example.datageneratormicroservice.config;

import com.jcabi.xml.XML;
import lombok.RequiredArgsConstructor;

public final class TextXPath {

    private final XML xml;
    private final String node;

    public TextXPath(XML xml, String node) {
        this.xml = xml;
        this.node = node;
    }

    @Override
    public String toString() {
        return this.xml.nodes(this.node).getFirst().xpath("text()").getFirst();
    }

}
