/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jerarquico.jerarquicoproy;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@Named(value="logoutBean")
@RequestScoped
public class LogoutBean {
private static Logger  log = Logger.getLogger(LogoutBean.class.getName());
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 public  String logout()  { 
     String destination="/index?faces-redirect=true";
     FacesContext context= FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest(); 
    try{
        request.logout();
    }catch(ServletException e){
        log.log(Level.SEVERE, "Fallo al registrar usuario",e);
        destination = "/error?faces-redirect=true";
    }
      return destination;
}
}
