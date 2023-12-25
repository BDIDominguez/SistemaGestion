package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Dario
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Objeto implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    String nombre;
    Boolean estado;
    @OneToMany (mappedBy = "objeto", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
    List<Permiso> permisos;
    
}
