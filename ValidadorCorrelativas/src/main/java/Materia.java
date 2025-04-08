import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    @Setter
    @Getter
    private String nombre;
    @Getter
    private List<Materia> correlativas;

    public Materia( String nombre ) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }
    public void agregarCorrelativas ( List<Materia> correlativas) {
        this.correlativas.addAll(correlativas);
    }
}