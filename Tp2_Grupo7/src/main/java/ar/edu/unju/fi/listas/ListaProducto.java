package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Producto;

@Component
public class ListaProducto {
	
	private List<Producto> productos;

	public ListaProducto() {
		this.productos = new ArrayList<>();
		this.productos.add(new Producto("Alimento Can Club",001,599.99,"Alimentos",10,"Es un alimento completo y balanceado para un perro normalmente activo. Posee las proteínas, vitaminas, minerales y ácidos grasos necesarios que el perro adulto necesita para estar sano y está hecho con ingredientes de calidad."));
		this.productos.add(new Producto("Alimento Dar Win",002,750,"Alimentos",15,"DrDarwin High Evolution es un alimento superpremium para perros con actividad física intensa. Rico en carne de cordero y arroz, con extractos naturales de yuca para una mejor digestión, con omega 3 y omega 6 para una piel y pelo sanos y brillantes, con antioxidantes naturales, \r\n"
				+"con taurina para una mejor función ocular y cerebral, con glucosamina y condroitina para unos huesos y articulaciones fuertes, \r\nelaborado en crujientes croquetas que reducen la aparición de sarro y placa en la dentadura de tu mascota. \r\nSu fórmula equilibrada aporta toda la energía que tu perro necesita pero controlando su peso ideal."));
		this.productos.add(new Producto("Toallas Humedas",003,800,"Higiene",10,"Toallitas húmedas para limpieza rápida y fácil de tus mascotas. Elimina mugre y bacterias, a la vez que limpia y deodoriza, dejando un agradable aroma cítrico. Ideales para limpiar zona interna de las orejas y almohadillas de patitas."));
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Producto buscarProductoByCodigo(int codigo) {
		for(Producto p : this.productos) {
			if(p.getCodigo() == codigo) {
				return p;
			}
		}
		return null;
	}

		
}
