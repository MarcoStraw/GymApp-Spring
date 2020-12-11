package marco.miranda.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import marco.miranda.dto.ActividadResumenDTO;
import marco.miranda.model.Actividad;

public interface IActividadService extends ICRUD<Actividad> {
	
	Page<Actividad> listarPageable(Pageable pageable);
	
    List<ActividadResumenDTO> listarResumen();
	
	byte[] generarReporte();

}
