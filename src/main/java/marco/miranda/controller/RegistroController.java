package marco.miranda.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import marco.miranda.model.Registro;
import marco.miranda.service.IRegistroService;



@RestController
@RequestMapping("/registros")
public class RegistroController {

	@Autowired
	private IRegistroService service;
	
	@GetMapping
	public ResponseEntity<List<Registro>> listar() {
		List<Registro> lista = service.listar();
		return new ResponseEntity<List<Registro>>(lista, HttpStatus.OK);
	}
		
		@GetMapping("/{id}")
		public ResponseEntity<Registro> listarPorId(@PathVariable("id") Integer id) {
			Registro obj = service.leerPorId(id);
			if (obj.getIdRegistros() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			return new ResponseEntity<Registro>(obj, HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Registro registro) {
			Registro obj = service.registrar(registro);
			//registros/
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(registro.getIdRegistros()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Registro> modificar(@Valid @RequestBody Registro registro) {
			Registro obj = service.modificar(registro);
			return new ResponseEntity<Registro>(obj, HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
			Registro obj = service.leerPorId(id);
			if (obj.getIdRegistros() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	
}
