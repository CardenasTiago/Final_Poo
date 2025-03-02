package views;

import models.*;

public class DatosPrueba {

    public static void cargarDatosPrueba(SistemaUniversitario sistema) {
        // Crear materias del primer año
        Materia elem1 = new Materia("IF001", "Elementos de Informática", true, 1);
        Materia epa = new Materia("IF002", "Expresión de Problemas y Algoritmos", true, 1);
        Materia algebra = new Materia("MA045", "Álgebra", true, 1);
        Materia ayp1 = new Materia("IF003", "Algorítmica y Programación I", true, 2);
        Materia elmd = new Materia("MA008", "Elementos de Lógica y Matemática Discreta", true, 2);
        Materia analisisMatematico = new Materia("MA046", "Análisis Matemático", true, 2);

        // Crear materias del segundo año
        Materia sistemasOrganizaciones = new Materia("IF004", "Sistemas y Organizaciones", true, 3);
        Materia arquitecturaComputadoras = new Materia("IF005", "Arquitectura de Computadoras", true, 3);
        Materia ayp2 = new Materia("IF006", "Algorítmica y Programación II", true, 3);
        Materia estadistica = new Materia("MA006", "Estadística", true, 3);
        Materia basesDatos1 = new Materia("IF007", "Bases de Datos I", true, 4);
        Materia programacionOrientadaObjetos = new Materia("IF030", "Programación y Diseño Orientado a Objetos", true, 4);
        Materia ingenieriaSoftware1 = new Materia("IF031", "Ingeniería de Software I", true, 4);

        // Crear materias del tercer año
        Materia labProgramacion = new Materia("IF009", "Laboratorio de Programación y Lenguajes", true, 5);
        Materia fundamentosInformatica = new Materia("IF013", "Fundamentos Teóricos de Informática", true, 5);
        Materia ingenieriaSoftware2 = new Materia("IF033", "Ingeniería de Software II", true, 5);
        Materia introduccionConcurrencia = new Materia("IF038", "Introducción a la Concurrencia", true, 5);
        Materia sistemasOperativos = new Materia("IF037", "Sistemas Operativos", true, 6);
        Materia labSoftware = new Materia("IF055", "Laboratorio de Software", true, 6);
        Materia basesDatos2 = new Materia("IF044", "Bases de Datos II", true, 6);
        Materia seminarioLegales1 = new Materia("IF056", "Seminario de Aspectos Legales y Profesionales I", true, 6);

        // Crear materias del cuarto año
        Materia redesTransmisionDatos = new Materia("IF019", "Redes y Transmisión de Datos", true, 7);
        Materia paradigmasLenguajes = new Materia("IF020", "Paradigmas y Lenguajes de Programación", true, 7);
        Materia tallerNuevasTecnologias = new Materia("IF017","Taller de nuevas tecnologias", true, 7);
        Materia sistemasDistribuidos = new Materia("IF022", "Sistemas Distribuidos", true, 8);
        Materia sistemasInteligentes = new Materia("IF059", "Sistemas Inteligentes", true, 8);
        Materia ingenieriaSoftware3 = new Materia("IF035", "Ingeniería de Software III", true, 8);
        Materia seminarioLegales2 = new Materia("IF057", "Seminario de Aspectos Legales y Profesionales II", true, 8);

        // Crear materias del quinto año
        Materia sistemasParalelos = new Materia("IF061", "Sistemas Paralelos", true, 9);
        Materia sistemasTiempoReal = new Materia("IF060", "Sistemas de Tiempo Real", true, 9);
        Materia seminarioSeguridad = new Materia("IF063", "Seminario de Seguridad", true, 9);
        Materia basesDatosDistribuidas = new Materia("IF062", "Bases de Datos Distribuidas", true, 9);
        Materia modelosSimulacion = new Materia("IF027", "Modelos y Simulación", true, 10);
        Materia proyectoSoftware = new Materia("IF042", "Proyecto de Software", true, 10);

        // Definir correlativas
        // Primer año
        ayp1.agregarCorrelativa(epa);
        
        // Segundo año
        arquitecturaComputadoras.agregarCorrelativa(elem1); // IF005 requiere IF001
        ayp2.agregarCorrelativa(ayp1); // IF006 requiere IF003
        ayp2.agregarCorrelativa(elmd); // IF006 requiere MA008
        estadistica.agregarCorrelativa(algebra); // MA006 requiere MA045
        estadistica.agregarCorrelativa(analisisMatematico); // MA006 requiere MA046
        basesDatos1.agregarCorrelativa(ayp2); // IF007 requiere IF006
        programacionOrientadaObjetos.agregarCorrelativa(ayp2); // IF030 requiere IF006
        ingenieriaSoftware1.agregarCorrelativa(ayp1); // IF031 requiere IF003
        ingenieriaSoftware1.agregarCorrelativa(sistemasOrganizaciones); // IF031 requiere IF004

        // Tercer año
        labProgramacion.agregarCorrelativa(basesDatos1); // IF009 requiere IF007
        fundamentosInformatica.agregarCorrelativa(ayp2); // IF013 requiere IF006
        fundamentosInformatica.agregarCorrelativa(elmd); // IF013 requiere MA008
        ingenieriaSoftware2.agregarCorrelativa(ingenieriaSoftware1); // IF033 requiere IF031
        ingenieriaSoftware2.agregarCorrelativa(estadistica); // IF033 requiere MA006
        introduccionConcurrencia.agregarCorrelativa(arquitecturaComputadoras); // IF038 requiere IF005
        introduccionConcurrencia.agregarCorrelativa(ayp2); // IF038 requiere IF006
        sistemasOperativos.agregarCorrelativa(introduccionConcurrencia); // IF037 requiere IF038
        labSoftware.agregarCorrelativa(basesDatos1); // IF055 requiere IF007
        labSoftware.agregarCorrelativa(programacionOrientadaObjetos); // IF055 requiere IF030
        labSoftware.agregarCorrelativa(ingenieriaSoftware1); // IF055 requiere IF031
        basesDatos2.agregarCorrelativa(basesDatos1); // IF044 requiere IF007
        seminarioLegales1.agregarCorrelativa(sistemasOrganizaciones); // IF056 requiere IF004

        // Cuarto año
        redesTransmisionDatos.agregarCorrelativa(sistemasOperativos); // IF019 requiere IF037
        paradigmasLenguajes.agregarCorrelativa(ayp2); // IF020 requiere IF006
        sistemasDistribuidos.agregarCorrelativa(redesTransmisionDatos); // IF022 requiere IF019
        tallerNuevasTecnologias.agregarCorrelativa(labSoftware);
        sistemasInteligentes.agregarCorrelativa(fundamentosInformatica); // IF059 requiere IF013
        ingenieriaSoftware3.agregarCorrelativa(ingenieriaSoftware2); // IF035 requiere IF033
        seminarioLegales2.agregarCorrelativa(seminarioLegales1); // IF057 requiere IF056

        // Quinto año
        sistemasParalelos.agregarCorrelativa(labProgramacion); // IF061 requiere IF009
        sistemasParalelos.agregarCorrelativa(sistemasDistribuidos); // IF061 requiere IF022
        sistemasTiempoReal.agregarCorrelativa(sistemasOperativos); // IF060 requiere IF037
        basesDatosDistribuidas.agregarCorrelativa(basesDatos2); // IF062 requiere IF044
        basesDatosDistribuidas.agregarCorrelativa(redesTransmisionDatos); // IF062 requiere IF019
        modelosSimulacion.agregarCorrelativa(estadistica); // IF027 requiere MA006
        modelosSimulacion.agregarCorrelativa(sistemasDistribuidos); // IF027 requiere IF022
        proyectoSoftware.agregarCorrelativa(ingenieriaSoftware3); // IF042 requiere IF035

        // Crear planes de estudio
        PlanEstudio LicSistemas = new PlanA("Lic. en Sistemas");
        LicSistemas.agregarMateriaObligatoria(elem1);
        LicSistemas.agregarMateriaObligatoria(epa);
        LicSistemas.agregarMateriaObligatoria(algebra);
        LicSistemas.agregarMateriaObligatoria(ayp1);
        LicSistemas.agregarMateriaObligatoria(elmd);
        LicSistemas.agregarMateriaObligatoria(analisisMatematico);
        LicSistemas.agregarMateriaObligatoria(sistemasOrganizaciones);
        LicSistemas.agregarMateriaObligatoria(arquitecturaComputadoras);
        LicSistemas.agregarMateriaObligatoria(ayp2);
        LicSistemas.agregarMateriaObligatoria(estadistica);
        LicSistemas.agregarMateriaObligatoria(basesDatos1);
        LicSistemas.agregarMateriaObligatoria(programacionOrientadaObjetos);
        LicSistemas.agregarMateriaObligatoria(ingenieriaSoftware1);
        LicSistemas.agregarMateriaObligatoria(labProgramacion);
        LicSistemas.agregarMateriaObligatoria(fundamentosInformatica);
        LicSistemas.agregarMateriaObligatoria(ingenieriaSoftware2);
        LicSistemas.agregarMateriaObligatoria(introduccionConcurrencia);
        LicSistemas.agregarMateriaObligatoria(sistemasOperativos);
        LicSistemas.agregarMateriaObligatoria(labSoftware);
        LicSistemas.agregarMateriaObligatoria(basesDatos2);
        LicSistemas.agregarMateriaObligatoria(seminarioLegales1);
        LicSistemas.agregarMateriaObligatoria(redesTransmisionDatos);
        LicSistemas.agregarMateriaObligatoria(paradigmasLenguajes);
        LicSistemas.agregarMateriaObligatoria(sistemasDistribuidos);
        LicSistemas.agregarMateriaObligatoria(tallerNuevasTecnologias);
        LicSistemas.agregarMateriaObligatoria(sistemasInteligentes);
        LicSistemas.agregarMateriaObligatoria(ingenieriaSoftware3);
        LicSistemas.agregarMateriaObligatoria(seminarioLegales2);
        LicSistemas.agregarMateriaObligatoria(sistemasParalelos);
        LicSistemas.agregarMateriaObligatoria(sistemasTiempoReal);
        LicSistemas.agregarMateriaObligatoria(seminarioSeguridad);
        LicSistemas.agregarMateriaObligatoria(basesDatosDistribuidas);
        LicSistemas.agregarMateriaObligatoria(modelosSimulacion);
        LicSistemas.agregarMateriaObligatoria(proyectoSoftware);

        // Crear carreras
        Carrera sistemas = new Carrera("Licenciatura en Sistemas", LicSistemas, 0);

        // Agregar carreras al sistema
        sistema.getCarreras().add(sistemas);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(LicSistemas);


        Materia introCienciasAmbientales = new Materia("ICA001", "Introducción a las Ciencias Ambientales", true, 1);
        Materia introSociedadCulturaAmbiente = new Materia("ICA002", "Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", true, 1);
        Materia matematica1 = new Materia("MA001", "Matemática I para Ciencias Naturales", true, 1);
        Materia quimicaGeneral = new Materia("QU001", "Química General e Inorgánica", true, 1);
        Materia introProblematicaAmbiental = new Materia("ICA003", "Introducción a la Problemática Ambiental", true, 1);
        Materia fisica1 = new Materia("FI001", "Física I para Ciencias Naturales", true, 1);
        Materia matematica2 = new Materia("MA002", "Matemática II para Ciencias Naturales", true, 1);
        Materia quimicaOrganica = new Materia("QU002", "Química Orgánica", true, 1);

        // Crear materias del segundo año
        Materia introBiologia = new Materia("BIO001", "Introducción a la Biología", true, 2);
        Materia introGeologia = new Materia("GEO001", "Introducción a la Geología", true, 2);
        Materia sociedadAmbiente = new Materia("ICA004", "Sociedad y Ambiente", true, 2);
        Materia legislacionAmbiental = new Materia("DER001", "Legislación Ambiental", true, 2);
        Materia diversidadBiologica = new Materia("BIO002", "Diversidad Biológica", true, 2);
        Materia geografiaFisica = new Materia("GEO002", "Geografía Física para Ciencias Ambientales", true, 2);
        Materia economiaAmbiente = new Materia("ECO001", "Economía y Ambiente", true, 2);
        Materia estadistica1 = new Materia("EST001", "Estadística I para Ciencias Naturales", true, 2);

        // Crear materias del tercer año
        Materia quimicaAmbiental = new Materia("QU003", "Química Ambiental y Contaminación", true, 3);
        Materia energiasRenovables = new Materia("ICA005", "Energías Renovables", true, 3);
        Materia ecologiaGeneral = new Materia("BIO003", "Ecología General", true, 3);
        Materia comunicacionAmbiental = new Materia("ICA006", "Comunicación Ambiental", true, 3);
        Materia hidrologia = new Materia("GEO003", "Hidrología y Gestión del Agua", true, 3);
        Materia tecnicasTratamiento = new Materia("ICA007", "Técnicas de Tratamiento y Saneamiento", true, 3);
        Materia filosofiaCiencia = new Materia("FIL001", "Filosofía, Epistemología y Metodología de la Ciencia", true, 3);
        Materia teledeteccionSIG = new Materia("GEO004", "Teledetección y SIG", true, 3);

        // Crear materias del cuarto año
        Materia conservacionBiodiversidad = new Materia("BIO004", "Conservación de la Biodiversidad", true, 4);
        Materia administracionAmbiental = new Materia("ICA008", "Administración Ambiental", true, 4);
        Materia gestionAmbientesUrbanos = new Materia("ICA009", "Gestión de Ambientes Urbanos", true, 4);
        Materia tallerMetodologia = new Materia("ICA010", "Taller de Metodología de la Investigación", true, 4);
        Materia gestionAmbientesRurales = new Materia("ICA011", "Gestión de Ambientes Rurales", true, 4);
        Materia gestionRecursosNaturales = new Materia("ICA012", "Gestión Integral de Recursos Naturales", true, 4);
        Materia cambioGlobal = new Materia("ICA013", "Cambio Global", true, 4);
        Materia seminarioFueguino = new Materia("ICA014", "Seminario de Problemática Fueguina", true, 4);

        // Crear materias del quinto año
        Materia desarrolloEconomicoSostenible = new Materia("ECO002", "Desarrollo Económico Sostenible", true, 5);
        Materia ordenamientoTerritorial = new Materia("ICA015", "Ordenamiento Ambiental del Territorio", true, 5);
        Materia tallerEvaluacionImpacto = new Materia("ICA016", "Taller de Evaluación de Impacto Ambiental", true, 5);
        Materia tallerTrabajoFinal = new Materia("ICA017", "Taller de Trabajo Final", true, 5);
        Materia optativa1 = new Materia("OPT001", "Optativa I", false, 5);
        Materia optativa2 = new Materia("OPT002", "Optativa II", false, 5);

        // Definir correlativas
        // Segundo año
        introBiologia.agregarCorrelativa(introCienciasAmbientales); // BIO001 requiere ICA001
        introGeologia.agregarCorrelativa(introCienciasAmbientales); // GEO001 requiere ICA001
        sociedadAmbiente.agregarCorrelativa(introSociedadCulturaAmbiente); // ICA004 requiere ICA002
        legislacionAmbiental.agregarCorrelativa(introProblematicaAmbiental); // DER001 requiere ICA003
        diversidadBiologica.agregarCorrelativa(introBiologia); // BIO002 requiere BIO001
        geografiaFisica.agregarCorrelativa(introGeologia); // GEO002 requiere GEO001
        economiaAmbiente.agregarCorrelativa(introProblematicaAmbiental); // ECO001 requiere ICA003
        estadistica1.agregarCorrelativa(matematica1); // EST001 requiere MA001

        // Tercer año
        quimicaAmbiental.agregarCorrelativa(quimicaGeneral); // QU003 requiere QU001
        energiasRenovables.agregarCorrelativa(introProblematicaAmbiental); // ICA005 requiere ICA003
        ecologiaGeneral.agregarCorrelativa(introBiologia); // BIO003 requiere BIO001
        comunicacionAmbiental.agregarCorrelativa(sociedadAmbiente); // ICA006 requiere ICA004
        hidrologia.agregarCorrelativa(geografiaFisica); // GEO003 requiere GEO002
        tecnicasTratamiento.agregarCorrelativa(quimicaAmbiental); // ICA007 requiere QU003
        filosofiaCiencia.agregarCorrelativa(introSociedadCulturaAmbiente); // FIL001 requiere ICA002
        teledeteccionSIG.agregarCorrelativa(geografiaFisica); // GEO004 requiere GEO002

        // Cuarto año
        conservacionBiodiversidad.agregarCorrelativa(diversidadBiologica); // BIO004 requiere BIO002
        administracionAmbiental.agregarCorrelativa(legislacionAmbiental); // ICA008 requiere DER001
        gestionAmbientesUrbanos.agregarCorrelativa(sociedadAmbiente); // ICA009 requiere ICA004
        tallerMetodologia.agregarCorrelativa(filosofiaCiencia); // ICA010 requiere FIL001
        gestionAmbientesRurales.agregarCorrelativa(economiaAmbiente); // ICA011 requiere ECO001
        gestionRecursosNaturales.agregarCorrelativa(ecologiaGeneral); // ICA012 requiere BIO003
        cambioGlobal.agregarCorrelativa(ecologiaGeneral); // ICA013 requiere BIO003
        seminarioFueguino.agregarCorrelativa(sociedadAmbiente); // ICA014 requiere ICA004

        // Quinto año
        desarrolloEconomicoSostenible.agregarCorrelativa(economiaAmbiente); // ECO002 requiere ECO001
        ordenamientoTerritorial.agregarCorrelativa(geografiaFisica); // ICA015 requiere GEO002
        tallerEvaluacionImpacto.agregarCorrelativa(legislacionAmbiental); // ICA016 requiere DER001
        tallerTrabajoFinal.agregarCorrelativa(tallerMetodologia); // ICA017 requiere ICA010
        optativa1.agregarCorrelativa(conservacionBiodiversidad); // OPT001 requiere BIO004
        optativa2.agregarCorrelativa(conservacionBiodiversidad); // OPT002 requiere BIO004

        // Crear planes de estudio
        PlanEstudio planCienciasAmbientales = new PlanA("Plan de Estudios de Licenciatura en Ciencias Ambientales");
        planCienciasAmbientales.agregarMateriaObligatoria(introCienciasAmbientales);
        planCienciasAmbientales.agregarMateriaObligatoria(introSociedadCulturaAmbiente);
        planCienciasAmbientales.agregarMateriaObligatoria(matematica1);
        planCienciasAmbientales.agregarMateriaObligatoria(quimicaGeneral);
        planCienciasAmbientales.agregarMateriaObligatoria(introProblematicaAmbiental);
        planCienciasAmbientales.agregarMateriaObligatoria(fisica1);
        planCienciasAmbientales.agregarMateriaObligatoria(matematica2);
        planCienciasAmbientales.agregarMateriaObligatoria(quimicaOrganica);
        planCienciasAmbientales.agregarMateriaObligatoria(introBiologia);
        planCienciasAmbientales.agregarMateriaObligatoria(introGeologia);
        planCienciasAmbientales.agregarMateriaObligatoria(sociedadAmbiente);
        planCienciasAmbientales.agregarMateriaObligatoria(legislacionAmbiental);
        planCienciasAmbientales.agregarMateriaObligatoria(diversidadBiologica);
        planCienciasAmbientales.agregarMateriaObligatoria(geografiaFisica);
        planCienciasAmbientales.agregarMateriaObligatoria(economiaAmbiente);
        planCienciasAmbientales.agregarMateriaObligatoria(estadistica1);
        planCienciasAmbientales.agregarMateriaObligatoria(quimicaAmbiental);
        planCienciasAmbientales.agregarMateriaObligatoria(energiasRenovables);
        planCienciasAmbientales.agregarMateriaObligatoria(ecologiaGeneral);
        planCienciasAmbientales.agregarMateriaObligatoria(comunicacionAmbiental);
        planCienciasAmbientales.agregarMateriaObligatoria(hidrologia);
        planCienciasAmbientales.agregarMateriaObligatoria(tecnicasTratamiento);
        planCienciasAmbientales.agregarMateriaObligatoria(filosofiaCiencia);
        planCienciasAmbientales.agregarMateriaObligatoria(teledeteccionSIG);
        planCienciasAmbientales.agregarMateriaObligatoria(conservacionBiodiversidad);
        planCienciasAmbientales.agregarMateriaObligatoria(administracionAmbiental);
        planCienciasAmbientales.agregarMateriaObligatoria(gestionAmbientesUrbanos);
        planCienciasAmbientales.agregarMateriaObligatoria(tallerMetodologia);
        planCienciasAmbientales.agregarMateriaObligatoria(gestionAmbientesRurales);
        planCienciasAmbientales.agregarMateriaObligatoria(gestionRecursosNaturales);
        planCienciasAmbientales.agregarMateriaObligatoria(cambioGlobal);
        planCienciasAmbientales.agregarMateriaObligatoria(seminarioFueguino);
        planCienciasAmbientales.agregarMateriaObligatoria(desarrolloEconomicoSostenible);
        planCienciasAmbientales.agregarMateriaObligatoria(ordenamientoTerritorial);
        planCienciasAmbientales.agregarMateriaObligatoria(tallerEvaluacionImpacto);
        planCienciasAmbientales.agregarMateriaObligatoria(tallerTrabajoFinal);
        planCienciasAmbientales.agregarMateriaObligatoria(optativa1);
        planCienciasAmbientales.agregarMateriaObligatoria(optativa2);

        // Crear carreras
        Carrera cienciasAmbientales = new Carrera("Licenciatura en Ciencias Ambientales", planCienciasAmbientales, 5);

        // Agregar carreras al sistema
        sistema.getCarreras().add(cienciasAmbientales);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planCienciasAmbientales);

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante(1001, "Juan Pérez");
        estudiante1.setCarrera(sistemas);
        estudiante1.inscribirEnMateria(elem1);

    }
}