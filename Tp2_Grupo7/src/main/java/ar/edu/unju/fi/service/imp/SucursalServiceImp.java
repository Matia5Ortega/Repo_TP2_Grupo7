package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.SucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> getLista() {
        return sucursalRepository.findAll();
    }

    @Override
    public void guardar(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal getBy(int id) {
        return sucursalRepository.findById((long) id).orElse(null);
    }

    @Override
    public void modificar(Sucursal sucursal) {
        Sucursal sucursalExistente = sucursalRepository.findById((long) sucursal.getId()).orElse(null);
        if (sucursalExistente != null) {
            sucursalExistente.setNombre(sucursal.getNombre());
            sucursalExistente.setDireccion(sucursal.getDireccion());
            sucursalExistente.setProvincia(sucursal.getProvincia());
            sucursalExistente.setFechaInicio(sucursal.getFechaInicio());
            sucursalExistente.setEmail(sucursal.getEmail());
            sucursalExistente.setTelefono(sucursal.getTelefono());
            sucursalRepository.save(sucursalExistente);
        }
    }

    @Override
    public void eliminar(Sucursal sucursal) {
        sucursalRepository.delete(sucursal);
    }

    @Override
    public Sucursal getSucursal() {
        return new Sucursal();
    }

	@Override
	public void guardarSucursal(Sucursal sucursal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarSucursal(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sucursal obtenerSucursalPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sucursal> obtenerTodasSucursales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sucursal> obtenerSucursalesPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}
}
