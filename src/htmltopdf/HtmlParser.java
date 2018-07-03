/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author 0186779
 */
public class HtmlParser {
    public static Document parseFile(String name) throws IOException{
        File input = new File(name);
        Document doc = Jsoup.parse(input, "UTF-8", "");
        return doc;
    }
}
