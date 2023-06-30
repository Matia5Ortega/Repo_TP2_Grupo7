package ar.edu.unju.fi.service;

import java.time.LocalDate;
import java.util.List;
import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
    void guardarSucursal(Sucursal sucursal);
    void eliminarSucursal(Long id);
    Sucursal obtenerSucursalPorId(Long id);
    List<Sucursal> obtenerTodasSucursales();
    List<Sucursal> obtenerSucursalesPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
	List<Sucursal> getLista();
	void guardar(Sucursal sucursal);
	Sucursal getBy(int id);
	void modificar(Sucursal sucursal);
	void eliminar(Sucursal sucursal);
	Sucursal getSucursal();
}
