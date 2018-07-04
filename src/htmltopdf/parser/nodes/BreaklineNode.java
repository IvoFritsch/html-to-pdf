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
 * Represents an breakline (&lt;br/&gt;) in the HTML
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
    public int getAfinityTo(Node n) {
        return (n instanceof Element && ((Element)n).tagName().equals("br")) ? 1 : 0;
    }
}
