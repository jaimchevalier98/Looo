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
public class mbLogin {
    String usuario, contraseña;
    Conexion conexion;
    private ArrayList<UsuaModel> lista;
    UsuaModel usu;
    public mbLogin() {
        conexion = new Conexion();
    }
   public String iniciarSession()
   {
       lista = new ArrayList();
       UsuaModel usuario_login = null;
       try{
           if (usuario.equals("") || contraseña.equals(""))
           {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error todos los campos deben ser completados"));
               return "/index"; 
           }
           else
           {  
               if (usuario.equals("root") && contraseña.equals("12345"))
               {
                   System.out.print("Exito");
                   int numeroAleatorio = (int) (Math.random()*10000+1);
                   FacesContext context = FacesContext.getCurrentInstance();
                   context.getExternalContext().getSessionMap().put("secuencial", numeroAleatorio);
                   return "/Layout/ViewChangePass/changePass"; 
               }
               else
               {
                  return "/index";  
               }
           }
       }catch(Exception e){ return "/index";  }
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
}
