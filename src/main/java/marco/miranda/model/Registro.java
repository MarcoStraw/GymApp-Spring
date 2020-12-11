package marco.miranda.model;

import java.time.LocalDateTime;
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


import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información del Registro")
@Entity
@Table(name = "Registro")
public class Registro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistros;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_Cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_registro_cliente"))
	private Cliente cliente;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ActividadRegistro", joinColumns = @JoinColumn(name = "id_Registros", referencedColumnName = "idRegistros"), inverseJoinColumns = @JoinColumn(name = "id_Actividad", referencedColumnName = "idActividad"))
	private List<Actividad> Actividades;
	
  
	@Column(name = "hora_entrada")  
	private LocalDateTime hora_entrada;
	
	@Column(name = "hora_salida")
	private LocalDateTime hora_salida;

	public Integer getIdRegistros() {
		return idRegistros;
	}

	public void setIdRegistros(Integer idRegistros) {
		this.idRegistros = idRegistros;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(LocalDateTime hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public LocalDateTime getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(LocalDateTime hora_salida) {
		this.hora_salida = hora_salida;
	}

	public List<Actividad> getActividades() {
		return Actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		Actividades = actividades;
	}
	
	
	

}
