package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.ConsejosDeSalud;

public interface IConsejosDeSaludService {

    List<ConsejosDeSalud> getLista();

    void guardar(ConsejosDeSalud consejo);

    ConsejosDeSalud getById(int id);

    void modificar(ConsejosDeSalud consejo);

    void eliminar(ConsejosDeSalud consejo);

    ConsejosDeSalud getConsejo();
}
