package marco.miranda.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import marco.miranda.model.Cliente;


public interface IClienteService extends ICRUD<Cliente> {
	
	Page<Cliente> listarPageable(Pageable pageable);

}
