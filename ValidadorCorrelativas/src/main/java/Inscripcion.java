import lombok.Getter;

public class Inscripcion
{
    @Getter
    private Materia materiaSolicitada;
    private Alumno alumno;

    public Inscripcion( Alumno alumno, Materia materia){
        this.alumno = alumno;
        this.materiaSolicitada = materia;
    }

    public Boolean aprobada() {
        if (materiaSolicitada.getCorrelativas().isEmpty()) {
            return true;
        }else {
            return materiaSolicitada.getCorrelativas().stream().allMatch(correlativa -> alumno.estaAprobada(correlativa));
        }
    }
}