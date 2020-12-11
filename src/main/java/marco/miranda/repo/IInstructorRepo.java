package marco.miranda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import marco.miranda.model.Instructor;

public interface IInstructorRepo extends JpaRepository<Instructor, Integer> {

}
