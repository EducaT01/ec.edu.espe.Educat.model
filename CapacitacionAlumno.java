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
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase encargada de obtener los datos de la base de datos EducaTBD.
 *
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 * @version 1.0
 */
@Entity
/**
* Determinar el nombre de la entidad que de la cual se pretende obtener los datos dentro de la base de datos.
*/
@Table(name = "capacitacion_alumno")
/**
* Determinar el query.
*/
@NamedQueries({
    @NamedQuery(name = "CapacitacionAlumno.findAll", query = "SELECT c FROM CapacitacionAlumno c")})
public class CapacitacionAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionAlumnoPK capacitacionAlumnoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA_FINAL")
    private BigDecimal notaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "COD_ALUMNO", referencedColumnName = "COD_ALUMNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;
    
    /**
    * Constructor sin parametros, vacio.
    */
    public CapacitacionAlumno() {
    }//Cierre del constructor.

    /**
    * Constructor con el parametro de capacitacionAlumnoPK.
    * @param capacitacionAlumnoPK variable que hace referencia a la relacion entre las entidades CAPACITACION y ALUMNO.
    */
    public CapacitacionAlumno(CapacitacionAlumnoPK capacitacionAlumnoPK) {
        this.capacitacionAlumnoPK = capacitacionAlumnoPK;
    }//Cierre del constructor.
    
    /**
    * Constructor con los parametros de capacitacionAlumnoPK, notaFinal, estado.
    * @param capacitacionAlumnoPK variable que hace referencia a la relacion entre las entidades CAPACITACION y ALUMNO.
    * @param notaFinal variable que hacer refetencia a la columna de notas finales de los estudiantes en la entidad CAPACITACION_ALUMNO.
    * @param estado variable que hacer refetencia a la columna de estado de las capacitaciones en la entidad CAPACITACION_ALUMNO.
    */
    public CapacitacionAlumno(CapacitacionAlumnoPK capacitacionAlumnoPK, BigDecimal notaFinal, String estado) {
        this.capacitacionAlumnoPK = capacitacionAlumnoPK;
        this.notaFinal = notaFinal;
        this.estado = estado;
    }//Cierre del constructor.

    /**
    * Constructor con los parametros de codCapacitacion, codAlumno.
    * @param codCapacitacion variable que hace referencia a la clave primaria de la entidad ALUMNO.
    * @param codAlumno variable que hace referencia a la clave primaria de la entidad ALUMNO.
    */
    public CapacitacionAlumno(int codCapacitacion, String codAlumno) {
        this.capacitacionAlumnoPK = new CapacitacionAlumnoPK(codCapacitacion, codAlumno);
    }//Cierre del constructor.

    public CapacitacionAlumnoPK getCapacitacionAlumnoPK() {
        return capacitacionAlumnoPK;
    }

    public void setCapacitacionAlumnoPK(CapacitacionAlumnoPK capacitacionAlumnoPK) {
        this.capacitacionAlumnoPK = capacitacionAlumnoPK;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionAlumnoPK != null ? capacitacionAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAlumno)) {
            return false;
        }
        CapacitacionAlumno other = (CapacitacionAlumno) object;
        if ((this.capacitacionAlumnoPK == null && other.capacitacionAlumnoPK != null) || (this.capacitacionAlumnoPK != null && !this.capacitacionAlumnoPK.equals(other.capacitacionAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.CapacitacionAlumno[ capacitacionAlumnoPK=" + capacitacionAlumnoPK + " ]";
    }
    
}
