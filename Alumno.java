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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "alumno")
/**
* Determinar el query.
*/
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
    * Clave primaria que corresponde a la cédula de identidad del estudiante.
    */
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_ALUMNO")
    private String codAlumno;
    /**
    * Columna que corresponde al nombre y apellido del estudiante.
    */    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE")
    private String nombre;
    /**
    * Columna que corresponde a la direccion de la vivienda del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DIRECCION")
    private String direccion;
    /**
    * Columna que corresponde al telefono, ya sea el movil o el de casa, del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    /**
    * Columna correspondiente al correo electronico del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    /**
    * Columna correspondiente a la fecha de nacimiento del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    /**
    * Columna correspondiente al genero del estudiante, este puede ser masculino (M), femenino (F) u otros (O).
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GENERO")
    private String genero;
    /**
    * Indica la relacion de uno a varios que existe entre la entidad ALUMNO y CAPACITACION. 
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<CapacitacionAlumno> capacitacionAlumnoCollection;
    /**
    * Indica la relacion de uno a varios que existe entre la entidad ALUMNO y CAPACITACION. 
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<ProgramaAlumno> programaAlumnoCollection;

    /**
    * Constructor sin parametros, vacio.
    */
    public Alumno() {
    }//Cierre del constructor.
    
    /**
    * Constructor con el parametro de codAlumno.
    * @param codAlumno variable que hace referencia a la columna codAlumno de la entidad ALUMNO.
    */
    public Alumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }//Cierre del constructor.
    
    /**
    * Constructor con varios parametros.
    * @param codAlumno variable que hace referencia a la columna codAlumno de la entidad ALUMNO.
    * @param nombre variable que hace referencia a la columna nombre de la entidad ALUMNO.
    * @param direccion variable que hace referencia a la columna direccion de la entidad ALUMNO.
    * @param telefono variable que hace referencia a la columna telefono de la entidad ALUMNO.
    * @param correoElectronico variable que hace referencia a la columna correoElectronico de la entidad ALUMNO.
    * @param fechaNacimiento variable que hace referencia a la columna fechaNacimiento de la entidad ALUMNO.
    * @param genero variable que hace referencia a la columna genero de la entidad ALUMNO.
    */
    public Alumno(String codAlumno, String nombre, String direccion, String telefono, String correoElectronico, Date fechaNacimiento, String genero) {
        this.codAlumno = codAlumno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }//Cierre del constructor.

    /**
    * Metodo get para mostrar el atributo codAlumno.
    * @return codAlumno.
    */
    public String getCodAlumno() {
        return codAlumno;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo codAlumno.
    */
    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo nombre.    
    * @return nombre;
    */
    public String getNombre() {
        return nombre;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo nombre.
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo direccion.
    * @return direccion.
    */
    public String getDireccion() {
        return direccion;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo direccion.
    */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo telefono.
    * @return telefono.
    */
    public String getTelefono() {
        return telefono;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo telefono.
    */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo correoElectronico.
    * @return correoElectronico.
    */
    public String getCorreoElectronico() {
        return correoElectronico;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo correoElectronico.
    */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo fechaNacimiento.
    * @return fechaNacimiento.
    */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo fechaNacimiento.
    */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo genero.
    * @return genero.
    */
    public String getGenero() {
        return genero;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo genero.
    */
    public void setGenero(String genero) {
        this.genero = genero;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo capacitacionAlumnoCollection.
    * @return capacitacionAlumnoCollection.
    */
    public Collection<CapacitacionAlumno> getCapacitacionAlumnoCollection() {
        return capacitacionAlumnoCollection;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo capacitacionAlumnoCollection.
    */
    public void setCapacitacionAlumnoCollection(Collection<CapacitacionAlumno> capacitacionAlumnoCollection) {
        this.capacitacionAlumnoCollection = capacitacionAlumnoCollection;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo programaAlumnoCollection.    
    * @return programaAlumnoCollection.
    */
    public Collection<ProgramaAlumno> getProgramaAlumnoCollection() {
        return programaAlumnoCollection;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo programaAlumnoCollection.
    */
    public void setProgramaAlumnoCollection(Collection<ProgramaAlumno> programaAlumnoCollection) {
        this.programaAlumnoCollection = programaAlumnoCollection;
    }//Cierre del metodo.
    
    /**
    * Metodo hasCode sobreescrito.
    * @return hash.
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }//Cierre del metodo.
    
    /**
    * Metodo sobreescrito equals.
    * @return boolen.
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }//Cierre del metodo.
    
    /**
    * Metodo sobreescrito toString.
    * @return cadena de caracteres.
    */
    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.Alumno[ codAlumno=" + codAlumno + " ]";
    }//Cierre del metodo.
    
}//Cierre de la clase.
