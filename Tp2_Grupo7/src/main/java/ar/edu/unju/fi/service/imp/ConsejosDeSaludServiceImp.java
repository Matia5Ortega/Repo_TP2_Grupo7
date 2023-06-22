package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.ConsejosDeSalud;
import ar.edu.unju.fi.service.IConsejosDeSaludService;

@Service
public class ConsejosDeSaludServiceImp implements IConsejosDeSaludService {

    private List<ConsejosDeSalud> listaConsejos;
    private ConsejosDeSalud consejo;

    @Override
    public List<ConsejosDeSalud> getLista() {
        return listaConsejos;
    }

    @Override
    public void guardar(ConsejosDeSalud consejo) {
        listaConsejos.add(consejo);
    }

    @Override
    public ConsejosDeSalud getById(int id) {
        for (ConsejosDeSalud c : listaConsejos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void modificar(ConsejosDeSalud consejo) {
        ConsejosDeSalud consejoExistente = getById(consejo.getId());
        if (consejoExistente != null) {
            consejoExistente.setTitulo(consejo.getTitulo());
            consejoExistente.setDescripcion(consejo.getDescripcion());
        }
    }

    @Override
    public void eliminar(ConsejosDeSalud consejo) {
        listaConsejos.remove(consejo);
    }

    @Override
    public ConsejosDeSalud getConsejo() {
        return consejo;
    }
}
