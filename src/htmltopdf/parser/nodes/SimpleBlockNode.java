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
 *
 * @author Ivo
 */
public abstract class SimpleBlockNode extends SupportedNode{

    SimpleBlockNode() {
        super(null);
    }
    
    public SimpleBlockNode(Node n, NodeStyle style) {
        super(style);
    }
    
    @Override
    protected int getAfinityTo(Node n, SupportedNode parent) {
        return (n instanceof Element && ((Element)n).isBlock()) ? 1 : 0;
    }
    
}
