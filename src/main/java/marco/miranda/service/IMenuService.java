package marco.miranda.service;

import java.util.List;

import marco.miranda.model.Menu;

public interface IMenuService  extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
