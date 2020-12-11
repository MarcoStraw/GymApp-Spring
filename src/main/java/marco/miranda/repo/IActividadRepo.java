package marco.miranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import marco.miranda.model.Actividad;

public interface IActividadRepo extends JpaRepository<Actividad, Integer> {
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();

}
