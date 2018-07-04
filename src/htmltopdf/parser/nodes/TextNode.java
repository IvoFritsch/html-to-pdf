/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.parser.nodes.style.NodeStyle;
import org.jsoup.nodes.Node;

/**
 * Represents an simple text node to be rendered to the PDF.
 * 
 * @author Ivo
 */
public class TextNode extends SupportedNode{

    private String text;

    TextNode() {
        super(null);
    }
    
    public TextNode(Node n, NodeStyle style) {
        super(style);
        this.text = n.toString().trim();
    }
    
    @Override
    public int getAfinityTo(Node n, SupportedNode parent) {
        return ((n instanceof org.jsoup.nodes.TextNode) && n.toString().trim().length() > 0) ? 1 : 0;
    }

    @Override
    public String toStringFormatted(int tabulation) {
        StringBuilder sb = new StringBuilder();
        for (int i = tabulation; i > 0; i--) {
            sb.append("   ");
        }
        sb.append(text);
        sb.append("\n");
        return sb.toString();
    }
}
