package marco.miranda.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import marco.miranda.dto.ActividadResumenDTO;
import marco.miranda.model.Actividad;
import marco.miranda.repo.IActividadRepo;
import marco.miranda.service.IActividadService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ActividadServiceImpl implements IActividadService{
	
	@Autowired
	private IActividadRepo repo;
	
	@Override
	public Actividad registrar(Actividad obj) {
		return repo.save(obj);
	}
	
	@Override
	public Actividad modificar (Actividad obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Actividad> listar(){
		return repo.findAll();
	}
	
	@Override
	public Page<Actividad> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Actividad leerPorId(Integer id) {
		Optional<Actividad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Actividad();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public List<ActividadResumenDTO> listarResumen() {
		List<ActividadResumenDTO> actividad = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			ActividadResumenDTO ar = new ActividadResumenDTO ();
			ar.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			ar.setFecha(String.valueOf(x[1]));
			actividad.add(ar);
		});
		return actividad;
	}

	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/consultas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}
	
	

}
