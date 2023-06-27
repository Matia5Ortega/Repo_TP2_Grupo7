package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.ConsejosDeSalud;

public class ListaConsejos {
    private List<ConsejosDeSalud> consejos;

    public ListaConsejos() {
        consejos = new ArrayList<>();
    }

    public List<ConsejosDeSalud> getConsejos() {
        return consejos;
    }

    public void setConsejos(List<ConsejosDeSalud> consejos) {
        this.consejos = consejos;
    }
}

