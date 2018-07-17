/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes.style;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;
import htmltopdf.parser.nodes.style.properties.StyleProperty;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;

/**
 *
 * @author Ivo
 */
public class NodeStyle {

    Map<StyleProperty, String> props = new HashMap<>();
    
    public NodeStyle(String styleAttr) {
        if(styleAttr == null) {
            return;
        }
        InputSource source = new InputSource(new StringReader(styleAttr));
        CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
        CSSStyleDeclaration decl;
        try {
            decl = parser.parseStyleDeclaration(source);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        for (int i = 0; i < decl.getLength(); i++) {
            final String propName = decl.item(i);
            StyleProperty propToAdd = StyleProperty.getProperty(propName);
            if(propToAdd==null) {
                System.out.println("[WARNING  ] : Not supported style property \""+propName+"\"");
                continue;
            }
            props.put(propToAdd, decl.getPropertyValue(propName));
        }
    }
    
    public void addStyleAttrToNode(Element elemToReceive){
        props.forEach((p,v) -> {
            elemToReceive.setAttribute(p.getXslFoAttrName(), v);
        });
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        props.forEach((p,v) -> {
            sb.append(p.getCssPropName());
            sb.append(":");
            sb.append(v);
            sb.append("; ");
        });
        return sb.toString();
    }
    
    
    
}
