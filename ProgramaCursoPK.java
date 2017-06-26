/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.EducaT;
/**
* Importacion de los paquetes necesarios para el funcionamiento del sistema.
*/
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Entidad que almacena los cursos que pertenecen a un programa.
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 */
@Embeddable
public class ProgramaCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_PROGRAMA")
    /**
    * Atributo que representa a la clave de la tabla programa.
    */
    private String codPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_CURSO")
    /**
    * Atributo que representa a la clave de la tabla curso.
    */
    private String codCurso;
    /*
    *Constructor vacio de la clase.
    */ 
    public ProgramaCursoPK() {
    }
    /*
    *Constructor de la clase.
    * @param codPrograma Codigo del programa al que pertenece.
    * @param codCurso  codigo del curso que lo conforma.
    */ 
    public ProgramaCursoPK(String codPrograma, String codCurso) {
        this.codPrograma = codPrograma;
        this.codCurso = codCurso;
    }

    public String getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }
    /**
    * Metodo para obtner el codigo Hash
    * @return hash devuelve el codigo hash. 
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }
    /**
    * Metodo para comparar objetos 
    * @return devuelve el resultado de la comparacion 
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaCursoPK)) {
            return false;
        }
        ProgramaCursoPK other = (ProgramaCursoPK) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }
    /**
    * Metodo para enviar al objeto a una cadena de caracteres 
    * @return devuelve la cadena de caracteres
    */
    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.ProgramaCursoPK[ codPrograma=" + codPrograma + ", codCurso=" + codCurso + " ]";
    }
    
}
