/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes.style.properties;

/**
 *
 * @author Ivo
 */
public class MarginBottomProp extends StyleProperty{

    @Override
    public String getCssPropName() {
        return "margin-bottom";
    }

    @Override
    public String getXslFoAttrName() {
        return "margin-bottom";
    }
    
}
