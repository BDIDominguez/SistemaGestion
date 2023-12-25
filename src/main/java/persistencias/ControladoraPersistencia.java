package persistencias;

import entidades.Objeto;
import entidades.Permiso;
import entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencias.exceptions.NonexistentEntityException;

/**
 * @author Dario
 */
public class ControladoraPersistencia {
    ObjetoJpaController objJpa = new ObjetoJpaController();
    PermisoJpaController perJpa = new PermisoJpaController();
    UsuarioJpaController userJpa = new UsuarioJpaController();
    
    // -----------------   OBVJETO ------------------
    public void crearObjeto(Objeto obj){
        objJpa.create(obj);
    }
    public void eliminarObjeto(int id){
        try {
            objJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarObjeto(Objeto obj){
        try {
            objJpa.edit(obj);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Objeto traerObjeto(int id){
        return objJpa.findObjeto(id);
    }
    public List<Objeto> traerListaObjetos(){
        return objJpa.findObjetoEntities();
    }
    // -----------------   PERMISO ------------------
    public void crearPermiso(Permiso per){
        perJpa.create(per);
    }
    public void eliminarPermiso(int id){
        try {
            perJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarPermiso(Permiso per){
        try {
            perJpa.edit(per);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Permiso traerPermiso(int id){
        return perJpa.findPermiso(id);
    }
    public List<Permiso> traerListaPermisos(){
        return perJpa.findPermisoEntities();
    }
    // -----------------   USUARIOS   ------------------
    public void crearUsuario(Usuario user){
        userJpa.create(user);
    }
    public void eliminarUsuario(int id){
        try {
            userJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarUsuario(Usuario user){
        try {
            userJpa.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuario traerUsuario(int id){
        return userJpa.findUsuario(id);
    }
    
    public List<Usuario> traerListaUsuarios(){
        return userJpa.findUsuarioEntities();
    }
    
    
} // Fin de la Clase
