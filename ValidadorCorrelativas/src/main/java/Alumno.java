import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    @Getter
    @Setter
    private List<Materia> materiasAprobadas;
    private String nombre;

    public Alumno( String nombre ) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void agregarMateriasAprobadas ( List<Materia> aprobadas ) {
        this.materiasAprobadas.addAll(aprobadas);
    }
    public Boolean estaAprobada(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }
}