/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf;

import htmltopdf.parser.nodes.RootNode;
import htmltopdf.parser.nodes.SupportedNode;
import htmltopdf.parser.nodes.style.NodeStyle;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 *
 * @author Ivo
 */
public class HtmlParser {
    public static Document parseFile(String name) throws IOException{
        File input = new File(name);
        Document doc = Jsoup.parse(input, "UTF-8", "");
        return doc;
    }
    
    public static RootNode parseHtmlToSupportedStructure(String name) throws IOException{
        Document html = HtmlParser.parseFile("inp/test.html");
        Element body = html.body();
        RootNode rootNode = new RootNode(new NodeStyle());
        convertHtmlNodeToSupportedNode(rootNode, body);
        return rootNode;
    }
    
    private static void convertHtmlNodeToSupportedNode(SupportedNode nodeToReceive, Node noteToExtract){
        noteToExtract.childNodes().forEach(cn -> {
            //SupportedNode supportedNode = SupportedNode
        });
    }
}
