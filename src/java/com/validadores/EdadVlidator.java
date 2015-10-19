/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author juandiego
 */

@FacesValidator("edadValidator")
public class EdadVlidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        /**try {
            Integer entero= Integer.parseInt(value.toString());
            System.out.println(entero);
            if(entero!=0 && entero!=100){
                throw  new ValidatorException(new FacesMessage("edad fuera de rango"));
            }
        } catch (Exception e) {
            throw  new ValidatorException(new FacesMessage("valor incorrecto"));
        }+**/
        HtmlInputText htmlInputText = (HtmlInputText) component;
       String label;
       
       if (htmlInputText.getLabel() == null || 
               htmlInputText.getLabel().trim().equals("")){
           label = htmlInputText.getId();
       }else{
           label = htmlInputText.getLabel();
       }
       
        if(!(value instanceof Integer)){
            throw  new ValidatorException(new FacesMessage( label+": debe ser un entero"));
            
        }
        Integer entero= (Integer) value;
        if(entero<0 || entero>100){
            throw  new ValidatorException(new FacesMessage(label+":edad fuera de rango"));
        }
    }
    
}
