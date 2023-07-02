package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    List<Sucursal> findByProvincia(String provincia);

    List<Sucursal> findByFechaInicioBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
