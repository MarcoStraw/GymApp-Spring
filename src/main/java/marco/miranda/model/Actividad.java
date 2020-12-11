package marco.miranda.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de Actividad")
@Entity
@Table(name = "Actividad")
public class Actividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idActividad;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_Instructor", nullable = false, foreignKey = @ForeignKey(name = "FK_actividad_instructor"))
	private Instructor instructor;
	
	@ApiModelProperty(notes = "Nombres de la Actividad tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre de la Actividad debe tener minimo 3 caracteres")
	@Column(name = "nombre",nullable = false,length = 20)
	private String nombre;
	
	@ApiModelProperty(notes = "Nombres de la Modalidad tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre de la Modalidad debe tener minimo 3 caracteres")
	@Column(name = "modalidad",nullable = false,length = 20)
	private String modalidad;

	@Column(name = "empieza")
	private LocalDate empieza;
	
	@Column(name = "acaba")
	private LocalDate acaba;
	
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ActividadRegistro", joinColumns = @JoinColumn(name = "id_Actividad", referencedColumnName = "idActividad"), inverseJoinColumns = @JoinColumn(name = "id_Registros", referencedColumnName = "idRegistros"))
	private List<Registro> Registro;*/
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ActividadCliente", joinColumns = @JoinColumn(name = "id_Actividad", referencedColumnName = "idActividad"), inverseJoinColumns = @JoinColumn(name = "id_Cliente", referencedColumnName = "idCliente"))
	private List<Cliente> Cliente;
	
	
	//Getter and setters
	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public LocalDate getEmpieza() {
		return empieza;
	}

	public void setEmpieza(LocalDate empieza) {
		this.empieza = empieza;
	}

	public LocalDate getAcaba() {
		return acaba;
	}

	public void setAcaba(LocalDate acaba) {
		this.acaba = acaba;
	}

	public List<Cliente> getCliente() {
		return Cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		Cliente = cliente;
	}
	
	
	
	
	
}
