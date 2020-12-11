package marco.miranda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import marco.miranda.model.Registro;

public interface IRegistroRepo extends JpaRepository<Registro, Integer> {

}
