/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;
import java.io.IOException;
import java.io.StringReader;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleDeclaration;

/**
 *
 * @author ivoaf
 */
public class CssParserTest {
    public static void main(String[] args) throws IOException {
        InputSource source = new InputSource(new StringReader("background: blue;"));
        CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
        CSSStyleDeclaration decl = parser.parseStyleDeclaration(source);

        for (int i = 0; i < decl.getLength(); i++) {
            final String propName = decl.item(i);

            System.out.println("'" + propName + "' has value: '" + decl.getPropertyValue(propName) + "'");
        }
    }
}
