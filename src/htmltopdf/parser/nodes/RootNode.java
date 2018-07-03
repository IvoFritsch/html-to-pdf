/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.parser.nodes.style.NodeStyle;
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
    
    public RootNode(NodeStyle style) {
        super(style);
    }
    
    
    @Override
    public boolean canConstructFrom(Node n) {
        return (n instanceof org.jsoup.nodes.TextNode) && n.toString().trim().length() > 0;
    }
    
    
}
