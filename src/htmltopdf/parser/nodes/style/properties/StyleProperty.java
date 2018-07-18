/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmltopdf.parser.nodes.style.properties;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ivo
 */
public abstract class StyleProperty {
    
    private static Map<String,StyleProperty> supportedProperties = new HashMap<>();
    
    
    static {
        addSupportedProp(new BackgroundColorProp());
        addSupportedProp(new FontSizeProp());
        addSupportedProp(new TextAlignProp());
        addSupportedProp(new FontWeightProp());
        
        addSupportedProp(new MarginTopProp());
        addSupportedProp(new MarginBottomProp());
        addSupportedProp(new MarginLeftProp());
        addSupportedProp(new MarginRightProp());
        
        addSupportedProp(new PaddingTopProp());
        addSupportedProp(new PaddingBottomProp());
        //addSupportedProp(new PaddingLeftProp());
        //addSupportedProp(new PaddingRightProp());
        
        //addSupportedProp(new FloatProp());
        addSupportedProp(new WidthProp());
        
        
    }
    
    
    public static StyleProperty getProperty(String propName){
        return supportedProperties.get(propName);
    }
    
    public abstract String getCssPropName();
    public abstract String getXslFoAttrName();
    
    private static void addSupportedProp(StyleProperty prop){
        supportedProperties.put(prop.getCssPropName(), prop);
    }
}
