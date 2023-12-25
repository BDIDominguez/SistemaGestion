package controladores;

import entidades.ComandosComunes;
import entidades.Controladora;
import entidades.Objeto;
import entidades.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import vistas.VistaInicioSesion;
import vistas.VistaPantallaPrincipal;
import vistas.VistaPermisos;
import vistas.VistaUsuarios;

public class ControladorVistaPantallaPrincipal implements ActionListener, MenuListener {

    VistaPantallaPrincipal menu;
    ComandosComunes comandos = new ComandosComunes();
    Usuario usuario;
    Controladora ctrl = new Controladora();

    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal menu,Usuario usuario) {
        this.menu = menu;
        this.usuario = usuario;
        

        // Capturando eventos de los Items del menu
        // Archivos
        menu.itemSalir.addActionListener(this);
        // Items del menu Usuarios        
        menu.itemUsuarios.addActionListener(this);
        menu.itemObjetos.addActionListener(this);
        menu.itemPermisos.addActionListener(this);
        menu.itemCambiarUsuario.addActionListener(this);

        // Capturando eventos de los Menu
        menu.menuArchivos.addMenuListener(this);

    }

    public void iniciar() {
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setTitle("Sistema de Gestion -- Bienvenido " + usuario.getNombre());
        menu.setVisible(true);
    }

    // METODOS DEL ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.itemSalir) {
            menu.dispose();
        }
        if (e.getSource() == menu.itemUsuarios) {
            Objeto obj = ctrl.traerObjeto(1);
            if (comandos.tienePermiso(usuario,obj, "Ingresar")) {
                VistaUsuarios vista = new VistaUsuarios();
                ControladorVistaUsuarios ctrl = new ControladorVistaUsuarios(menu, vista, usuario);
                ctrl.iniciar();
            } else {
                JOptionPane.showMessageDialog(menu, "No tienes permiso para ver estas pantalla!!!");
            }
        }
        if (e.getSource() == menu.itemPermisos) {
            Objeto obj = ctrl.traerObjeto(2);
            if (comandos.tienePermiso(usuario,obj, "Ingresar")) {
                VistaPermisos vista = new VistaPermisos();
                ControladorVistaPermisos ctrl = new ControladorVistaPermisos(menu, vista, usuario);
                ctrl.iniciar();
            } else {
                JOptionPane.showMessageDialog(menu, "No tienes permiso para ver estas pantalla!!!");
            }
        }
        if (e.getSource() == menu.itemCambiarUsuario) {
                     
            System.out.println("Cambiado usuario ");
            Objeto obj = ctrl.traerObjeto(4);
            System.out.println("Tenemos el Objeto " + obj.getNombre());
            if (comandos.tienePermiso(usuario, obj, "Ingresar")) {
                System.out.println("El Usuario tiene Permiso!");
                VistaInicioSesion vista = new VistaInicioSesion();
                ControladorVistaInicioSesion ctrl = new ControladorVistaInicioSesion(vista,this);
                ctrl.iniciar();
            } else {
                JOptionPane.showMessageDialog(menu, "No tienes permiso para ver estas pantalla!!!");
            }
           
        }
    }

    // METODOS DEL MENU
    @Override
    public void menuSelected(MenuEvent e) {

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
    public void cambioDeUsuario(Usuario user){
        usuario = user;
        menu.setTitle("Sistema de Gestion -- Bienvenido " + usuario.getNombre());
    }
    
}
