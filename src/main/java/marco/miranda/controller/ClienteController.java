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
import marco.miranda.model.Cliente;
import marco.miranda.service.IClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> lista = service.listar();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
		
		@GetMapping("/{id}")
		public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id) {
			Cliente obj = service.leerPorId(id);
			if (obj.getIdCliente() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente cliente) {
			Cliente obj = service.registrar(cliente);
			//clientes/
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente) {
			Cliente obj = service.modificar(cliente);
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
			Cliente obj = service.leerPorId(id);
			if (obj.getIdCliente() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	
}

