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
 * Entidad que almacena los cursos que pertenecen a un programa.
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 */
@Entity
@Table(name = "programa_curso")
@NamedQueries({
    @NamedQuery(name = "ProgramaCurso.findAll", query = "SELECT p FROM ProgramaCurso p")})
public class ProgramaCurso implements Serializable {
    /*
    *serial de la version.
    */    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    /*
    *objeto de la clase ProgramaCursoPK.
    */ 
    protected ProgramaCursoPK programaCursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN")
    /*
    *Indica el orden en el que se deben tomar los cursos.
    */
    private short orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    /*
    *indica el estado del curso.
    */
    private String estado;
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    /*
    *Codigo del curso a tomar.
    */    
    private Curso curso;
    @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    /*
    *Codigo del programa al que pertenece.
    */  
    private Programa programa;
    
    /*
    *Constructor vacio de la clase.
    */  
    public ProgramaCurso() {
    }
    /*
    *Constructor de la clase.
    * @param programaCursoPK objeto de la clase programaCursoPK
    */  
    public ProgramaCurso(ProgramaCursoPK programaCursoPK) {
        this.programaCursoPK = programaCursoPK;
    }
    /*
    *Constructor de la clase.
    * @param programaCursoPK objeto de la clase programaCursoPK
    * @param orden orden en el que se deben tomar los cursos
    * @param estado indica el estado del curso
    */  
    public ProgramaCurso(ProgramaCursoPK programaCursoPK, short orden, String estado) {
        this.programaCursoPK = programaCursoPK;
        this.orden = orden;
        this.estado = estado;
    }
    /*
    *Constructor de la clase.
    * @param codPrograma Codigo del programa al que pertenece.
    * @param codCurso Codigo que identifica al curso.
    */  
    public ProgramaCurso(String codPrograma, String codCurso) {
        this.programaCursoPK = new ProgramaCursoPK(codPrograma, codCurso);
    }

    public ProgramaCursoPK getProgramaCursoPK() {
        return programaCursoPK;
    }

    public void setProgramaCursoPK(ProgramaCursoPK programaCursoPK) {
        this.programaCursoPK = programaCursoPK;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
    /**
    * Metodo para obtner el codigo Hash
    * @return hash devuelve el codigo hash. 
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaCursoPK != null ? programaCursoPK.hashCode() : 0);
        return hash;
    }
    /**
    * Metodo para comparar objetos 
    * @return devuelve el resultado de la comparacion 
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaCurso)) {
            return false;
        }
        ProgramaCurso other = (ProgramaCurso) object;
        if ((this.programaCursoPK == null && other.programaCursoPK != null) || (this.programaCursoPK != null && !this.programaCursoPK.equals(other.programaCursoPK))) {
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
        return "ec.edu.espe.EducaT.ProgramaCurso[ programaCursoPK=" + programaCursoPK + " ]";
    }
    
}
