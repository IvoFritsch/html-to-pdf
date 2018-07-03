/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import htmltopdf.HtmlParser;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 *
 * @author Ivo
 */
public class ParserTest {
    public static void main(String[] args) throws IOException {
        Document html = HtmlParser.parseFile("inp/test.html");
        
        
        Elements allElements = html.body().children();
        //if(allElements.size();
        allElements.forEach(e -> {
            System.out.println(e.tagName()+"  "+e.isBlock());
            e.childNodes().forEach(n -> {
                    System.out.println("   -->> "+ n.toString().trim()+" "+n.getClass());
            });
        });
        //System.out.println(html.getAllElements());
    }
}
