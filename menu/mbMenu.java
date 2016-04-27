package com.menu;

import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class mbMenu {

    private MenuModel model;

    @PostConstruct
    public void init() 
    {
        model = new DefaultMenuModel();
         
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Inicio");
         
        DefaultMenuItem item = new DefaultMenuItem("External"); 
        model.addElement(firstSubmenu);
         
        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Carga de Archivo");
 
        item = new DefaultMenuItem("Carga de Archivo");
        item.setIcon("ui-icon-disk");
        item.setCommand("");
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Pruebas");
        item.setIcon("ui-icon-close");
        item.setCommand("");
        item.setAjax(false);
        secondSubmenu.addElement(item);
 
        model.addElement(secondSubmenu);
        
        String admin= "admin1";
        if (admin.equals("admin"))
        {
            DefaultSubMenu treeSubmenu = new DefaultSubMenu("Administrador");
 
            item = new DefaultMenuItem("Usuarios");
            item.setIcon("ui-icon-disk");
            item.setCommand("");
            treeSubmenu.addElement(item);

            item = new DefaultMenuItem("Proyectos");
            item.setIcon("ui-icon-close");
            item.setCommand("");
            item.setAjax(false);
            treeSubmenu.addElement(item);

            model.addElement(treeSubmenu);
        }
        
    }
 
    public MenuModel getModel() {
        return model;
    } 
    
}
