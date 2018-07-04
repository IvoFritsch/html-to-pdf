/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.parser.nodes.style.NodeStyle;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/**
 * Represents the footer node in the HTML.
 * 
 * @author Ivo
 */
public class FooterNode extends SimpleBlockNode{

    FooterNode() {
        super();
    }
    
    public FooterNode(Node n, NodeStyle style) {
        super(n,style);
    }
    
    @Override
    protected int getAfinityTo(Node n, SupportedNode parent) {
        int afinityReturn = super.getAfinityTo(n, parent);
        return (afinityReturn > 0 && ((Element)n).tagName().equals("footer")) ? 1 : 0;
    }
    
}
