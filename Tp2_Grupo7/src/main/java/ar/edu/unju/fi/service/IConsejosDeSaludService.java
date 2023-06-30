package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ConsejosDeSalud;

public interface IConsejosDeSaludService {
    List<ConsejosDeSalud> getLista();

    List<ConsejosDeSalud> getListaActivos();

    void guardar(ConsejosDeSalud consejo);

    ConsejosDeSalud getById(Long id);

    void modificar(ConsejosDeSalud consejo);

    void eliminar(ConsejosDeSalud consejo);
}
