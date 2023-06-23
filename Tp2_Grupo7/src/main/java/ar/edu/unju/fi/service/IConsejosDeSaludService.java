package ar.edu.unju.fi.service;

import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.model.ConsejosDeSalud;

public interface IConsejosDeSaludService {
    ListaConsejos getLista();

    void guardar(ConsejosDeSalud consejo);

    ConsejosDeSalud getById(int id);

    void modificar(ConsejosDeSalud consejo);

    void eliminar(ConsejosDeSalud consejo);

    ConsejosDeSalud getConsejo();
}
