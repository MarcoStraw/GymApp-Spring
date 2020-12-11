package marco.miranda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import marco.miranda.model.Instructor;
import marco.miranda.repo.IInstructorRepo;
import marco.miranda.service.IInstructorService;

@Service
public class InstructorServiceImpl implements IInstructorService {
	
	@Autowired
	private IInstructorRepo repo;
	
	@Override
	public Instructor registrar(Instructor obj) {
		return repo.save(obj);
	}
	
	@Override
	public Instructor modificar(Instructor obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Instructor> listar(){
		return repo.findAll();
	}
	
	@Override
	public Page<Instructor> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Instructor leerPorId(Integer id) {
		Optional<Instructor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Instructor();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
