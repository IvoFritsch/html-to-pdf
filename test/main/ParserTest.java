/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import htmltopdf.parser.HtmlParser;
import htmltopdf.parser.nodes.RootNode;
import java.io.IOException;

/**
 *
 * @author Ivo
 */
public class ParserTest {
    public static void main(String[] args) throws IOException {
        RootNode parsed = HtmlParser.parseHtmlToSupportedStructure("inp/test.html");
        System.out.println(parsed.toString());
    }
}