package marco.miranda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marco.miranda.model.Archivo;
import marco.miranda.repo.IArchivoRepo;
import marco.miranda.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {
	
	@Autowired
	private IArchivoRepo repo;
	
	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = repo.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}
	
	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		Optional<Archivo> op = repo.findById(idArchivo);
		return op.isPresent() ? op.get().getValue() : new byte[0];
	}

}
