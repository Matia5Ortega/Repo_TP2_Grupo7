package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService {

    private List<Sucursal> listaSucursales;
    private Sucursal sucursal;

    @Override
    public List<Sucursal> getLista() {
        return listaSucursales;
    }

    @Override
    public void guardar(Sucursal sucursal) {
        listaSucursales.add(sucursal);
    }

    @Override
    public Sucursal getBy(int id) {
        for (Sucursal s : listaSucursales) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void modificar(Sucursal sucursal) {
        Sucursal sucursalExistente = getBy(sucursal.getId());
        if (sucursalExistente != null) {
            sucursalExistente.setNombre(sucursal.getNombre());
            sucursalExistente.setDireccion(sucursal.getDireccion());
            sucursalExistente.setProvincia(sucursal.getProvincia());
            sucursalExistente.setFechaInicio(sucursal.getFechaInicio());
            sucursalExistente.setEmail(sucursal.getEmail());
            sucursalExistente.setTelefono(sucursal.getTelefono());
        }
    }

    @Override
    public void eliminar(Sucursal sucursal) {
        listaSucursales.remove(sucursal);
    }

    @Override
    public Sucursal getSucursal() {
        return sucursal;
    }
}
