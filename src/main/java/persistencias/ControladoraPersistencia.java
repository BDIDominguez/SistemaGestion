package persistencias;

import entidades.Objeto;
import entidades.Permiso;
import entidades.Usuario;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;
import persistencias.exceptions.NonexistentEntityException;

/**
 * @author Dario
 */
public class ControladoraPersistencia {

    ObjetoJpaController objJpa;
    PermisoJpaController perJpa;
    UsuarioJpaController userJpa;

    public ControladoraPersistencia() {
        EntityManagerFactory emf = getEntityManagerFactory();
        objJpa = new ObjetoJpaController(emf);
        perJpa = new PermisoJpaController(emf);
        userJpa = new UsuarioJpaController(emf);
    }

    // -----------------   OBVJETO ------------------
    public void crearObjeto(Objeto obj) {
        objJpa.create(obj);
    }

    public void eliminarObjeto(int id) {
        try {
            objJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarObjeto(Objeto obj) {
        try {
            objJpa.edit(obj);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Objeto traerObjeto(int id) {
        return objJpa.findObjeto(id);
    }

    public List<Objeto> traerListaObjetos() {
        return objJpa.findObjetoEntities();
    }

    // -----------------   PERMISO ------------------
    public void crearPermiso(Permiso per) {
        perJpa.create(per);
    }

    public void eliminarPermiso(int id) {
        try {
            perJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPermiso(Permiso per) {
        try {
            perJpa.edit(per);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Permiso traerPermiso(int id) {
        return perJpa.findPermiso(id);
    }

    public List<Permiso> traerListaPermisos() {
        return perJpa.findPermisoEntities();
    }

    // -----------------   USUARIOS   ------------------
    public void crearUsuario(Usuario user) {
        userJpa.create(user);
    }

    public void eliminarUsuario(int id) {
        try {
            userJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(Usuario user) {
        try {
            userJpa.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return userJpa.findUsuario(id);
    }

    public List<Usuario> traerListaUsuarios() {
        return userJpa.findUsuarioEntities();
    }

    // Cargando Configuracion de los archivos 
    private Properties loadProperties() {
    Properties prop = new Properties();
    // Intenta cargar el archivo config.properties del directorio actual
    try (InputStream input = new FileInputStream("config.properties")) {
        prop.load(input);
    } catch (IOException e) {
        // Si no se encuentra en el directorio actual, intenta cargar desde los recursos
        try (InputStream resourceInput = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (resourceInput == null) {
                System.out.println("No se pudo encontrar el archivo de propiedades.");
                return prop;
            }
            prop.load(resourceInput);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    return prop;
}
    /*
    private Properties loadProperties() {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo de propiedades.");
                return prop;
            }
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    } */

    public EntityManagerFactory getEntityManagerFactory() {
        Properties prop = loadProperties();
        String url = prop.getProperty("jdbc.url");
        String user = prop.getProperty("jdbc.user");
        String password = prop.getProperty("jdbc.password");

        // Configura la fábrica de EntityManager con los datos del archivo de propiedades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaGestionPU", createProperties(url, user, password));
        return emf;
    }

    private Map<String, String> createProperties(String url, String user, String password) {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", url);
        properties.put("jakarta.persistence.jdbc.user", user);
        properties.put("jakarta.persistence.jdbc.password", password);
        properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("jakarta.persistence.schema-generation.database.action", "create");
        return properties;
    }
} // Fin de la Clase
