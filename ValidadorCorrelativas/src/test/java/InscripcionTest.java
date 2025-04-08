import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class InscripcionTest {

    @Test
    public void correlatividadFalla()
    {
        Materia algoritmos = new Materia( "algoritmos" );
        Materia pdep = new Materia( "pdep" );
        List<Materia> listaCorrelativas = Arrays.asList(algoritmos);
        pdep.agregarCorrelativas(listaCorrelativas);
        Alumno messi = new Alumno("messi");
        Inscripcion inscripcion = new Inscripcion(messi, pdep);
        assertFalse(inscripcion.aprobada());
    }
    @Test
    public void correlatividadPasa()
    {
        Materia algoritmos = new Materia( "algoritmos" );
        Materia discreta = new Materia( "discreta" );
        Materia pdep = new Materia( "pdep" );
        List<Materia> listaCorrelativas = Arrays.asList(algoritmos, discreta);
        pdep.agregarCorrelativas(listaCorrelativas);
        Alumno tapia = new Alumno("tapia");
        tapia.agregarMateriasAprobadas(listaCorrelativas);
        Inscripcion inscripcion = new Inscripcion(tapia, pdep);
        assert(inscripcion.aprobada());
    }
    @Test
    public void inscrpcionAMateriaSinCorrelativas()
    {
        Materia algoritmos = new Materia( "algoritmos" );
        Alumno fabra = new Alumno("fabra");
        Inscripcion inscripcion = new Inscripcion(fabra, algoritmos);
        assert(inscripcion.aprobada());
    }
    @Test
    public void fallaInscripcionPorCorrelatividadIncompleta()
    {
        Materia algoritmos = new Materia( "algoritmos" );
        Materia discreta = new Materia( "discreta" );
        Materia pdep = new Materia( "pdep" );
        Materia dds = new Materia( "dds" );
        Materia fisica = new Materia( "fisica" );
        List<Materia> listaCorrelativas = Arrays.asList(algoritmos, discreta, pdep, fisica);
        dds.agregarCorrelativas(listaCorrelativas);
        Alumno advincula = new Alumno("advincula");
        List<Materia> listaAprobadas = Arrays.asList(algoritmos, discreta, pdep);
        advincula.agregarMateriasAprobadas(listaAprobadas);
        Inscripcion inscripcion = new Inscripcion(advincula, dds);
        assertFalse(inscripcion.aprobada());
    }
}