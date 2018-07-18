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
public class PaddingRightProp extends StyleProperty{

    @Override
    public String getCssPropName() {
        return "padding-right";
    }

    @Override
    public String getXslFoAttrName() {
        return "padding-right";
    }
    
}
