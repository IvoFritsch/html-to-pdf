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
import org.w3c.dom.Text;

/**
 * Represents an breakline (&lt;br/&gt;) in the HTML.
 * 
 * @author Ivo
 */
public class BreaklineNode extends SupportedNode{

    BreaklineNode() {
        super(null);
    }
    
    public BreaklineNode(Node n, NodeStyle style) {
        super(style);
    }
    
    @Override
    public int getAfinityTo(Node n, SupportedNode parent) {
        return (n instanceof Element && ((Element)n).tagName().equals("br")) ? 1 : 0;
    }

    @Override
    public void addNodeToXslFoDOM(Document doc, org.w3c.dom.Element parent) {
        org.w3c.dom.Element newBlock = doc.createElementNS(Converter.foNS, "fo:block");
        newBlock.setAttribute("linefeed-treatment", "preserve");
        Text breakText = doc.createTextNode("\n");
        newBlock.appendChild(breakText);
        parent.appendChild(newBlock);
    }
}
