package marco.miranda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import marco.miranda.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {

}
