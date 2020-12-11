package marco.miranda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import marco.miranda.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
