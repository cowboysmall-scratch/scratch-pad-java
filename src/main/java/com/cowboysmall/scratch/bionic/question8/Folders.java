package com.cowboysmall.scratch.bionic.question8;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.String.format;

public class Folders {

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {

        InputSource inputSource = new InputSource(new StringReader(xml));

        String expression = format("//folder[starts-with(@name, '%s')]/@name", startingLetter);

        NodeList nodes =
                (NodeList) XPathFactory.newInstance()
                        .newXPath()
                        .evaluate(expression, inputSource, XPathConstants.NODESET);

        Collection<String> strings = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++)
            strings.add(nodes.item(i).getNodeValue());
        return strings;
    }
}
