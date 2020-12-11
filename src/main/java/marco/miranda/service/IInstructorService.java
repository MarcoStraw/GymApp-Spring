package marco.miranda.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import marco.miranda.model.Instructor;

public interface IInstructorService extends ICRUD<Instructor> {
	
	Page<Instructor> listarPageable(Pageable pageable);

}
