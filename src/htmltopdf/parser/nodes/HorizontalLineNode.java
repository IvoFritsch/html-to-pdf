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
public class HorizontalLineNode extends SupportedNode{

    HorizontalLineNode() {
        super(null);
    }
    
    public HorizontalLineNode(Node n, NodeStyle style) {
        super(style);
    }
    
    @Override
    public int getAfinityTo(Node n, SupportedNode parent) {
        return (n instanceof Element && ((Element)n).tagName().equals("hr")) ? 1 : 0;
    }

    @Override
    public void addNodeToXslFoDOM(Document doc, org.w3c.dom.Element parent) {
        org.w3c.dom.Element newBlock = doc.createElementNS(Converter.foNS, "fo:block");
        org.w3c.dom.Element line = doc.createElementNS(Converter.foNS, "fo:leader");
        line.setAttribute("leader-pattern", "rule");
        line.setAttribute("leader-length", "100%");
        line.setAttribute("rule-style", "solid");
        line.setAttribute("rule-thickness", "2pt");
        style.addStyleAttrToNode(newBlock);
        newBlock.appendChild(line);
        
        parent.appendChild(newBlock);
    }
}
