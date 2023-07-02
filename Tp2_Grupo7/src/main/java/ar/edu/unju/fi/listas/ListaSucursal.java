package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.entity.Sucursal;

@Component
public class ListaSucursal {

	private List<Sucursal> sucursales;
	
	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
	public List<Sucursal> getSucursales() {
		return this.sucursales;
	}

	public ListaSucursal() {
		super();
		
		this.sucursales = new ArrayList<>();
		this.sucursales.add(new Sucursal(1, "sucursal principal", "3915 Av General Belgrano", "Jujuy", LocalDate.now(), "sucursalPrincipal@gmail.com", "388-4999999" ));
		this.sucursales.add(new Sucursal(2, "segunda sucursal", "542 Av San Martin", "Jujuy", LocalDate.now(), "segundaSucursal.com", "388-49777777" ));
		this.sucursales.add(new Sucursal(3, "tercera sucursal", "712 Sarmiento", "Jujuy", LocalDate.now(), "terceraSucursal@gmail.com", "388-4988888" ));
	}
	
	public Sucursal buscarSucursalById(int id) {
		if(this.getSucursales().size() > 0) {	
			for(Sucursal item : this.sucursales) {
				if(item.getId() == id) {
					return item;
				}
			}
		}
		
		return null;
	}
	
}
