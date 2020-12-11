package marco.miranda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Instructor")
@Entity
@Table(name = "Instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInstructor;
	
	@ApiModelProperty(notes = "Nombres del Cliente tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre del Cliente debe tener minimo 3 caracteres")
	@Column(name = "nombre",nullable = false,length = 20)
	private String nombre;
	
	@ApiModelProperty(notes = "El Apellido debe tener minimo 3 caracteres")
	@Size(min = 3, message = "El Apellido debe tener minimo 3 caracteres")
	@Column(name = "apellidos",nullable = false,length = 40)
	private String apellidos;
	
	@ApiModelProperty(notes = "DNI debe tener 8 caracteres")
	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;
	
	@ApiModelProperty(notes = "Telefono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;

	
	public Integer getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(Integer idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
