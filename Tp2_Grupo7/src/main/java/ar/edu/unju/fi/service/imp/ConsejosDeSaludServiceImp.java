package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ConsejosDeSalud;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.service.IConsejosDeSaludService;

@Service
public class ConsejosDeSaludServiceImp implements IConsejosDeSaludService {

    @Autowired
    private ListaConsejos listaConsejos;

    @Override
    public List<ConsejosDeSalud> getLista() {
        return listaConsejos.getConsejos();
    }

    @Override
    public List<ConsejosDeSalud> getListaActivos() {
        return listaConsejos.getConsejos().stream().filter(ConsejosDeSalud::isEstado).collect(Collectors.toList());
    }

    @Override
    public void guardar(ConsejosDeSalud consejo) {
        listaConsejos.getConsejos().add(consejo);
    }

    @Override
    public ConsejosDeSalud getById(Long id) {
        return listaConsejos.getConsejos().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
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
        listaConsejos.getConsejos().remove(consejo);
    }
}
