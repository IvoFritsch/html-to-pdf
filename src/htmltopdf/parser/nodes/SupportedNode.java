/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes;

import htmltopdf.parser.nodes.style.NodeStyle;
import java.lang.reflect.Constructor;
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
                new TextNode(),
                new SimpleDivNode(),
                new ParagraphNode(),
                new HeaderNode(),
                new FooterNode()
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
        children.add(n);
    }
    
    public static SupportedNode constructNode(Node n, NodeStyle style, SupportedNode parent){
        int highestAfinity = 0;
        Class nodeToConstruct = null;
        for (SupportedNode sn : supportedNodes){
            int nodeAfinity = sn.getAfinityTo(n, parent);
            if(nodeAfinity > highestAfinity){
                highestAfinity = nodeAfinity;
                nodeToConstruct = sn.getClass();
            }
        }
        if(nodeToConstruct != null){
            Constructor<SupportedNode> constructor = null;
            try {
                constructor = nodeToConstruct.getConstructor(Node.class, NodeStyle.class);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
            try {
                return constructor.newInstance(n,style);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }
    
    /**
     * Receiving an jsoup HTML node, the node implementation should return its afinity level to the node.<br>
     *   For example, receiving an "div" node with the class "row", the DivNode will return the number 1, 
     *   while the DivRowNode will return the number 2, meaning it has more afinity to be constructed with this node.<br>
     *   The parser will use this number to decide wich supported node it has to construct.
     * 
     * @param n The HTML node to test.
     * @param parent Parent node of this node.
     * @return the afinity of this supported node with the HTML node
     */
    protected abstract int getAfinityTo(Node n, SupportedNode parent);

    public String toStringFormatted(int tabulation) {
        StringBuilder sb = new StringBuilder();
        for (int i = tabulation; i > 0; i--) {
            sb.append("   ");
        }
        sb.append(this.getClass().getName());
        sb.append("\n");
        children.forEach(child -> sb.append(child.toStringFormatted(tabulation+1)));
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return toStringFormatted(0);
    }
}
