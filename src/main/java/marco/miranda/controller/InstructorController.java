package marco.miranda.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import marco.miranda.exeception.ModeloNotFoundException;
import marco.miranda.model.Instructor;
import marco.miranda.service.IInstructorService;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

	@Autowired
	private IInstructorService service;
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Instructor>> listar() {
		List<Instructor> lista = service.listar();
		return new ResponseEntity<List<Instructor>>(lista, HttpStatus.OK);
	}
		
		@GetMapping("/{id}")
		public ResponseEntity<Instructor> listarPorId(@PathVariable("id") Integer id) {
			Instructor obj = service.leerPorId(id);
			if (obj.getIdInstructor() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			return new ResponseEntity<Instructor>(obj, HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Instructor instructor) {
			Instructor obj = service.registrar(instructor);
			//instructores/
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instructor.getIdInstructor()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Instructor> modificar(@Valid @RequestBody Instructor instructor) {
			Instructor obj = service.modificar(instructor);
			return new ResponseEntity<Instructor>(obj, HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
			Instructor obj = service.leerPorId(id);
			if (obj.getIdInstructor() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	
}
