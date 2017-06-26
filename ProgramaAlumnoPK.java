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
 * Clase encargada de obtener los datos de la base de datos EducaTBD.
 *
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 * @version 1.0
 */
@Embeddable
public class ProgramaAlumnoPK implements Serializable {

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
    @Size(min = 1, max = 10)
    @Column(name = "COD_ALUMNO")
    /**
    * Atributo que representa a la clave de la tabla alumno.
    */
    private String codAlumno;
    /*
    *Constructor vacio de la clase.
    */ 
    public ProgramaAlumnoPK() {
    }
    /*
    *Constructor de la clase.
    * @param codPrograma Codigo del programa al que pertenece.
    * @param codAlumno  codigo del alumno inscrito.
    */ 
    public ProgramaAlumnoPK(String codPrograma, String codAlumno) {
        this.codPrograma = codPrograma;
        this.codAlumno = codAlumno;
    }

    public String getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }
    /**
    * Metodo para obtner el codigo Hash
    * @return hash devuelve el codigo hash. 
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }
    /**
    * Metodo para comparar objetos 
    * @return devuelve el resultado de la comparacion 
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaAlumnoPK)) {
            return false;
        }
        ProgramaAlumnoPK other = (ProgramaAlumnoPK) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
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
        return "ec.edu.espe.EducaT.ProgramaAlumnoPK[ codPrograma=" + codPrograma + ", codAlumno=" + codAlumno + " ]";
    }
    
}
