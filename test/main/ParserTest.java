/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import htmltopdf.HtmlParser;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author 0186779
 */
public class ParserTest {
    public static void main(String[] args) throws IOException {
        Document html = HtmlParser.parseFile("inp/test.html");
        
        
        Elements allElements = html.getElementsByTag("html");
        //if(allElements.size();
        allElements.forEach(e -> {
                System.out.println("-->> "+ e.nodeName() +"   "+e.className());
        });
        //System.out.println(html.getAllElements());
    }
}
