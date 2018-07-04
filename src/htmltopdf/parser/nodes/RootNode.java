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
 * Represents the root node (aka the "body" node in the HTML).
 * 
 * @author Ivo
 */
public class RootNode extends SupportedNode{

    private SupportedNode headerNode;
    private SupportedNode footerNode;

    RootNode() {
        super(null);
    }
    
    public RootNode(Node n, NodeStyle style) {
        super(style);
    }
    
    
    @Override
    public int getAfinityTo(Node n, SupportedNode parent) {
        return (n instanceof Element && ((Element)n).tagName().equals("body")) ? 1 : 0;
    }
    
    
}
