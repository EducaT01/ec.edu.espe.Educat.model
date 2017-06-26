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
public class CapacitacionAlumnoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAPACITACION") 
    /**
    * Atributo que representa a la clave de la tabla capacitacion.
    */
    private int codCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_ALUMNO")
    /**
    * Atributo que representa a la clave de la tabla alumno.
    */
    private String codAlumno;

    public CapacitacionAlumnoPK() {
    }
    /**
    * Constructor de la clase.
    * @param codCapacitacion representa a la clave de la tabla capacitacion. 
    * @param codAlumno representa a la clave de la tabla alumno.
    */
    public CapacitacionAlumnoPK(int codCapacitacion, String codAlumno) {
        this.codCapacitacion = codCapacitacion;
        this.codAlumno = codAlumno;
    }

    public int getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(int codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
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
        hash += (int) codCapacitacion;
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
        if (!(object instanceof CapacitacionAlumnoPK)) {
            return false;
        }
        CapacitacionAlumnoPK other = (CapacitacionAlumnoPK) object;
        if (this.codCapacitacion != other.codCapacitacion) {
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
        return "ec.edu.espe.EducaT.CapacitacionAlumnoPK[ codCapacitacion=" + codCapacitacion + ", codAlumno=" + codAlumno + " ]";
    }
    
}
