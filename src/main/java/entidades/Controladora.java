package entidades;

import java.util.List;
import persistencias.ControladoraPersistencia;

/**
* @author Dario
*/
public class Controladora {
    ControladoraPersistencia ctrl = new ControladoraPersistencia();
    
    // -----------------   OBVJETO ------------------
    public void crearObjeto(Objeto obj){
        ctrl.crearObjeto(obj);
    }
    public void eliminarObjeto(int id){
        ctrl.eliminarObjeto(id);
    }
    public void editarObjeto(Objeto obj){
        ctrl.editarObjeto(obj);
    }
    public Objeto traerObjeto(int id){
        return ctrl.traerObjeto(id);
    }
    public List<Objeto> traerListaObjetos(){
        return ctrl.traerListaObjetos();
    }
    
    // -----------------   OBVJETO ------------------
    public void crearPermiso(Permiso per){
        ctrl.crearPermiso(per);
    }
    public void eliminarPermiso(int id){
        ctrl.eliminarPermiso(id);
    }
    public void editarPermiso(Permiso per){
        ctrl.editarPermiso(per);
    }
    public Permiso traerPermiso(int id){
        return ctrl.traerPermiso(id);
    }
    public List<Permiso> traerListaPermisos(){
        return ctrl.traerListaPermisos();
    }
    
    // -----------------   USUARIO    ------------------
    public void crearUsuario(Usuario user){
        ctrl.crearUsuario(user);
    }
    public void eliminarUsuario(int id){
        ctrl.eliminarUsuario(id);
    }
    public void editarUsuario(Usuario user){
        ctrl.editarUsuario(user);
    }
    public Usuario traerUsuario(int id){
        return ctrl.traerUsuario(id);
    }
    public List<Usuario> traerListaUsuarios(){
        return ctrl.traerListaUsuarios();
    }
    
} // Fin de la Clase
