package marco.miranda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import marco.miranda.model.Registro;
import marco.miranda.repo.IRegistroRepo;
import marco.miranda.service.IRegistroService;

@Service
public class RegistroServiceImpl implements IRegistroService{

	@Autowired
	private IRegistroRepo repo;
	
	@Override
	public Registro registrar(Registro obj) {
		return repo.save(obj);
	}
	
	@Override
	public Registro modificar(Registro obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Registro> listar(){
		return repo.findAll();
	}
	
	@Override
	public Page<Registro> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Registro leerPorId(Integer id) {
		Optional<Registro> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Registro();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
