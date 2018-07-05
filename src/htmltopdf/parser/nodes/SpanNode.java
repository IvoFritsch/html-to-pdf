/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.converter.Converter;
import htmltopdf.parser.nodes.style.NodeStyle;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.w3c.dom.Document;

/**
 * Represents an paragraph (&lt;p&gt;) in the HTML.
 * 
 * @author Ivo
 */
public class SpanNode extends SupportedNode{

    SpanNode() {
        super(null);
    }
    
    public SpanNode(Node n, NodeStyle style) {
        super(style);
    }
    
    
    @Override
    protected int getAfinityTo(Node n, SupportedNode parent) {
        return (n instanceof Element && ((Element)n).tagName().equals("span")) ? 1 : 0;
    }


    @Override
    public void addNodeToXslFoDOM(Document doc, org.w3c.dom.Element parent) {
        org.w3c.dom.Element newBlock = doc.createElementNS(Converter.foNS, "fo:inline");
        newBlock.setAttribute("background-color", "red");
        parent.appendChild(newBlock);
        children.forEach(c -> {
            try{
                c.addNodeToXslFoDOM(doc, newBlock);
            } catch (Exception e){
                System.err.println("not added");
            }
        });
    }

    
}
