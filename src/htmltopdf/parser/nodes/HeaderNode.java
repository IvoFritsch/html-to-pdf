/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.parser.nodes.style.NodeStyle;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.w3c.dom.Document;

/**
 * Represents the header node in the HTML.
 * 
 * @author Ivo
 */
public class HeaderNode extends SimpleBlockNode{

    HeaderNode() {
        super();
    }
    
    public HeaderNode(Node n, NodeStyle style) {
        super(n,style);
    }
    
    @Override
    protected int getAfinityTo(Node n, SupportedNode parent) {
        int afinityReturn = super.getAfinityTo(n, parent);
        return (afinityReturn > 0 && ((Element)n).tagName().equals("header")) ? 1 : 0;
    }

    @Override
    public void addNodeToXslFoDOM(Document doc, org.w3c.dom.Element parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
