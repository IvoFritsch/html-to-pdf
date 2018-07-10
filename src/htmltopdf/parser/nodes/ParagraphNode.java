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

/**
 * Represents an paragraph (&lt;p&gt;) in the HTML.
 * 
 * @author Ivo
 */
public class ParagraphNode extends SimpleBlockNode{

    ParagraphNode() {
        super();
    }
    
    public ParagraphNode(Node n, NodeStyle style) {
        super(n,style);
    }
    
    
    @Override
    protected int getAfinityTo(Node n, SupportedNode parent) {
        int afinityReturn = super.getAfinityTo(n, parent);
        return (afinityReturn > 0 && ((Element)n).tagName().equals("p")) ? 1 : 0;
    }


    @Override
    public void addNodeToXslFoDOM(Document doc, org.w3c.dom.Element parent) {
        org.w3c.dom.Element newBlock = doc.createElementNS(Converter.foNS, "fo:block");
        org.w3c.dom.Element insideBlock = doc.createElementNS(Converter.foNS, "fo:block");
        insideBlock.setAttribute("margin-top", "1em");
        insideBlock.setAttribute("margin-bottom", "1em");
        style.addStyleAttrToNode(insideBlock);
        newBlock.appendChild(insideBlock);
        parent.appendChild(newBlock);
        children.forEach(c -> {
            try{
                c.addNodeToXslFoDOM(doc, insideBlock);
            } catch (Exception e){
                System.err.println("not added");
            }
        });
    }

    
}
