package marco.miranda.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import marco.miranda.model.Registro;

public interface IRegistroService extends ICRUD<Registro> {
	
	Page<Registro> listarPageable(Pageable pageable);
	

}
