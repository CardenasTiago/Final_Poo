package views;

import models.*;
import java.util.List;

public class DatosPrueba {

    public static void cargarDatosPrueba(SistemaUniversitario sistema) {
        // Crear materias
        Materia prog1 = new Materia("PRG1", "Programación I", true, 1);
        Materia mate1 = new Materia("MAT1", "Matemática I", true, 1);
        Materia prog2 = new Materia("PRG2", "Programación II", true, 2);
        prog2.agregarCorrelativa(prog1);
        Materia baseDatos1 = new Materia("BD1", "Bases de Datos I", true, 2);
        Materia baseDatos2 = new Materia("BD2", "Bases de Datos II", true, 3);
        baseDatos2.agregarCorrelativa(baseDatos1);
        Materia redes1 = new Materia("RED1", "Redes I", true, 3);
        Materia redes2 = new Materia("RED2", "Redes II", true, 4);
        redes2.agregarCorrelativa(redes1);
        Materia ingSoft1 = new Materia("IS1", "Ingeniería de Software I", true, 4);
        Materia ingSoft2 = new Materia("IS2", "Ingeniería de Software II", true, 5);
        ingSoft2.agregarCorrelativa(ingSoft1);

        // Crear planes de estudio
        PlanEstudio planA = new PlanA("Plan A - Aprobó las cursadas de las correlativas");
        planA.agregarMateriaObligatoria(prog1);
        planA.agregarMateriaObligatoria(mate1);
        planA.agregarMateriaObligatoria(prog2);
        planA.agregarMateriaObligatoria(baseDatos1);
        planA.agregarMateriaObligatoria(baseDatos2);
        planA.agregarMateriaObligatoria(redes1);
        planA.agregarMateriaObligatoria(redes2);
        planA.agregarMateriaObligatoria(ingSoft1);
        planA.agregarMateriaObligatoria(ingSoft2);

        PlanEstudio planB = new PlanB("Plan B - Aprobó los finales de las correlativas");
        planB.agregarMateriaObligatoria(prog1);
        planB.agregarMateriaObligatoria(mate1);
        planB.agregarMateriaObligatoria(prog2);
        planB.agregarMateriaObligatoria(baseDatos1);
        planB.agregarMateriaObligatoria(baseDatos2);
        planB.agregarMateriaObligatoria(redes1);
        planB.agregarMateriaObligatoria(redes2);
        planB.agregarMateriaObligatoria(ingSoft1);
        planB.agregarMateriaObligatoria(ingSoft2);

        // Crear carreras
        Carrera sistemas = new Carrera("Licenciatura en Sistemas", planA, 5);
        Carrera informatica = new Carrera("Ingeniería en Informática", planB, 5);
        Carrera redes = new Carrera("Tecnicatura en Redes", planA, 3);

        // Agregar carreras al sistema
        sistema.getCarreras().add(sistemas);
        sistema.getCarreras().add(informatica);
        sistema.getCarreras().add(redes);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planA);
        sistema.getPlanesEstudio().add(planB);

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante(1001, "Juan Pérez");
        estudiante1.setCarrera(sistemas);
        estudiante1.inscribirMateria(prog1);
        estudiante1.inscribirMateria(mate1);

        Estudiante estudiante2 = new Estudiante(1002, "María Gómez");
        estudiante2.setCarrera(informatica);
        estudiante2.inscribirMateria(prog1);
        estudiante2.inscribirMateria(mate1);
        estudiante2.inscribirMateria(prog2);

        Estudiante estudiante3 = new Estudiante(1003, "Carlos López");
        estudiante3.setCarrera(redes);
        estudiante3.inscribirMateria(redes1);
        estudiante3.inscribirMateria(baseDatos1);

        Estudiante estudiante4 = new Estudiante(1004, "Ana Martínez");
        estudiante4.setCarrera(sistemas);
        estudiante4.inscribirMateria(prog1);
        estudiante4.inscribirMateria(mate1);
        estudiante4.inscribirMateria(prog2);
        estudiante4.inscribirMateria(baseDatos1);

        Estudiante estudiante5 = new Estudiante(1005, "Luis Rodríguez");
        estudiante5.setCarrera(informatica);
        estudiante5.inscribirMateria(prog1);
        estudiante5.inscribirMateria(mate1);
        estudiante5.inscribirMateria(prog2);
        estudiante5.inscribirMateria(baseDatos1);
        estudiante5.inscribirMateria(baseDatos2);

        // Agregar estudiantes al sistema
        sistema.getEstudiantes().add(estudiante1);
        sistema.getEstudiantes().add(estudiante2);
        sistema.getEstudiantes().add(estudiante3);
        sistema.getEstudiantes().add(estudiante4);
        sistema.getEstudiantes().add(estudiante5);
    }
}