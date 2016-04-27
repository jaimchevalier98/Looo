package com.login;

import com.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class mbChangePass {
    String usuario, contraseña, contraseña2;
    Conexion conexion;
    UsuaModel usu;
    int secuencial = 0;
    public mbChangePass() {
        conexion = new Conexion();
        secuencial = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("secuencial");
    }
   public String actualizaPass()
   {
            if(secuencial == 0)
            {
                 return "/index";
            }
            else
            {
                if(contraseña.equals(contraseña2))
                {
                     return "/index";
                }
                else
                {
                     return "/index";
                }
            }
   }
    //Metodos Get y Set
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getContraseña2() {
        return contraseña2;
    }

    public void setContraseña2(String contraseña2) {
        this.contraseña2 = contraseña2;
    }
    
}
