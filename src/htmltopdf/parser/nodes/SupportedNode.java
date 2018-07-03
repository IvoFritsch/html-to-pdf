/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.parser.nodes.style.NodeStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.nodes.Node;

/**
 * Superclass of all nodes supported by the converter.
 * 
 * @author Ivo
 */
public abstract class SupportedNode {
    
    protected NodeStyle style;
    protected List<SupportedNode> children;
    private static List<SupportedNode> supportedNodes;
    
    static{
        supportedNodes = Arrays.asList(
                new BreaklineNode(),
                new RootNode(),
                new TextNode()
        );
    }

    /**
     * Construct an new supported node with the specified style.
     * 
     * @param style Style of the node.
     */
    protected SupportedNode(NodeStyle style) {
        this.style = style;
        children = new ArrayList<>();
    }
    
    /**
     * Add an supported node as direct child of this node.
     * 
     * @param n Node to add as child of this node.
     */
    public void addChildNode(SupportedNode n){
        
    }
    
    public static SupportedNode constructNode(Node n){
        
        return null;
    }
    
    /**
     * Receiving an jsoup HTML node, the node implementation should return if it 
     *   can be constructed from this element.
     * 
     * @param n The HTML node to test.
     * @return true if the node can be constructed, false otherwise.
     */
    protected abstract boolean canConstructFrom(Node n);
    
    
}
