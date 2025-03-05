package views;

import models.*;

public class DatosPrueba {

    public static void cargarDatosPrueba(SistemaUniversitario sistema) {
        // Crear materias del primer cuatrimestre
        Materia elem1 = new Materia("IF001", "Elementos de Informática", true, 1);
        Materia epa = new Materia("IF002", "Expresión de Problemas y Algoritmos", true, 1);
        Materia algebra = new Materia("MA045", "Álgebra", true, 1);
        Materia ayp1 = new Materia("IF003", "Algorítmica y Programación I", true, 2);
        Materia elmd = new Materia("MA008", "Elementos de Lógica y Matemática Discreta", true, 2);
        Materia analisisMatematico = new Materia("MA046", "Análisis Matemático", true, 2);

        // Crear materias del segundo cuatrimestre
        Materia sistemasOrganizaciones = new Materia("IF004", "Sistemas y Organizaciones", true, 3);
        Materia arquitecturaComputadoras = new Materia("IF005", "Arquitectura de Computadoras", true, 3);
        Materia ayp2 = new Materia("IF006", "Algorítmica y Programación II", true, 3);
        Materia estadistica = new Materia("MA006", "Estadística", true, 3);
        Materia basesDatos1 = new Materia("IF007", "Bases de Datos I", true, 4);
        Materia programacionOrientadaObjetos = new Materia("IF030", "Programación y Diseño Orientado a Objetos", true, 4);
        Materia ingenieriaSoftware1 = new Materia("IF031", "Ingeniería de Software I", true, 4);

        // Crear materias del tercer cuatrimestre
        Materia labProgramacion = new Materia("IF009", "Laboratorio de Programación y Lenguajes", true, 5);
        Materia fundamentosInformatica = new Materia("IF013", "Fundamentos Teóricos de Informática", true, 5);
        Materia ingenieriaSoftware2 = new Materia("IF033", "Ingeniería de Software II", true, 5);
        Materia introduccionConcurrencia = new Materia("IF038", "Introducción a la Concurrencia", true, 5);
        Materia sistemasOperativos = new Materia("IF037", "Sistemas Operativos", true, 6);
        Materia labSoftware = new Materia("IF055", "Laboratorio de Software", true, 6);
        Materia basesDatos2 = new Materia("IF044", "Bases de Datos II", true, 6);
        Materia seminarioLegales1 = new Materia("IF056", "Seminario de Aspectos Legales y Profesionales I", true, 6);

        // Crear materias del cuarto cuatrimestre
        Materia redesTransmisionDatos = new Materia("IF019", "Redes y Transmisión de Datos", true, 7);
        Materia paradigmasLenguajes = new Materia("IF020", "Paradigmas y Lenguajes de Programación", true, 7);
        Materia tallerNuevasTecnologias = new Materia("IF017","Taller de nuevas tecnologias", true, 7);
        Materia sistemasDistribuidos = new Materia("IF022", "Sistemas Distribuidos", true, 8);
        Materia sistemasInteligentes = new Materia("IF059", "Sistemas Inteligentes", true, 8);
        Materia ingenieriaSoftware3 = new Materia("IF035", "Ingeniería de Software III", true, 8);
        Materia seminarioLegales2 = new Materia("IF057", "Seminario de Aspectos Legales y Profesionales II", true, 8);

        // Crear materias del quinto cuatrimestre
        Materia sistemasParalelos = new Materia("IF061", "Sistemas Paralelos", true, 9);
        Materia sistemasTiempoReal = new Materia("IF060", "Sistemas de Tiempo Real", true, 9);
        Materia seminarioSeguridad = new Materia("IF063", "Seminario de Seguridad", true, 9);
        Materia basesDatosDistribuidas = new Materia("IF062", "Bases de Datos Distribuidas", true, 9);
        Materia modelosSimulacion = new Materia("IF027", "Modelos y Simulación", true, 10);
        Materia proyectoSoftware = new Materia("IF042", "Proyecto de Software", true, 10);

        // Definir correlativas
        // Primer cuatrimestre
        ayp1.agregarCorrelativa(epa);
        analisisMatematico.agregarCorrelativa(algebra);
        
        // Segundo cuatrimestre
        arquitecturaComputadoras.agregarCorrelativa(elem1); // IF005 requiere IF001
        ayp2.agregarCorrelativa(ayp1); // IF006 requiere IF003
        ayp2.agregarCorrelativa(elmd); // IF006 requiere MA008
        estadistica.agregarCorrelativa(algebra); // MA006 requiere MA045
        estadistica.agregarCorrelativa(analisisMatematico); // MA006 requiere MA046
        basesDatos1.agregarCorrelativa(ayp2); // IF007 requiere IF006
        programacionOrientadaObjetos.agregarCorrelativa(ayp2); // IF030 requiere IF006
        ingenieriaSoftware1.agregarCorrelativa(ayp1); // IF031 requiere IF003
        ingenieriaSoftware1.agregarCorrelativa(sistemasOrganizaciones); // IF031 requiere IF004

        // Tercer cuatrimestre
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

        // Cuarto cuatrimestre
        redesTransmisionDatos.agregarCorrelativa(sistemasOperativos); // IF019 requiere IF037
        paradigmasLenguajes.agregarCorrelativa(ayp2); // IF020 requiere IF006
        sistemasDistribuidos.agregarCorrelativa(redesTransmisionDatos); // IF022 requiere IF019
        tallerNuevasTecnologias.agregarCorrelativa(labSoftware);
        sistemasInteligentes.agregarCorrelativa(fundamentosInformatica); // IF059 requiere IF013
        ingenieriaSoftware3.agregarCorrelativa(ingenieriaSoftware2); // IF035 requiere IF033
        seminarioLegales2.agregarCorrelativa(seminarioLegales1); // IF057 requiere IF056

        // Quinto cuatrimestre
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

        Estudiante estudiante1 = new Estudiante(001, "Tiago Cardenas");
        estudiante1.setCarrera(sistemas);

        estudiante1.inscribirEnMateria(elem1);
        estudiante1.inscribirEnMateria(epa);
        estudiante1.inscribirEnMateria(algebra);
        estudiante1.inscribirEnMateria(ayp1);
        estudiante1.inscribirEnMateria(elmd);
        estudiante1.inscribirEnMateria(analisisMatematico);
        
        // Aprobar materias del primer cuatrimestre
        estudiante1.aprobarCursada(elem1);
        estudiante1.aprobarCursada(epa);
        estudiante1.aprobarCursada(algebra);
        estudiante1.aprobarCursada(ayp1);
        estudiante1.aprobarCursada(elmd);
        estudiante1.aprobarCursada(analisisMatematico);

        // Aprobar finales de algunas materias del primer cuatrimestre
        estudiante1.aprobarFinal(elem1);
        estudiante1.aprobarFinal(epa);
        estudiante1.aprobarFinal(algebra);


        estudiante1.inscribirEnMateria(sistemasOrganizaciones);
        estudiante1.inscribirEnMateria(arquitecturaComputadoras);
        estudiante1.inscribirEnMateria(ayp2);
        estudiante1.inscribirEnMateria(estadistica);

        // Aprobar materias del segundo cuatrimestre
        estudiante1.aprobarCursada(sistemasOrganizaciones);
        estudiante1.aprobarCursada(arquitecturaComputadoras);
        estudiante1.aprobarCursada(ayp2);
        estudiante1.aprobarCursada(estadistica);

        // Aprobar finales de algunas materias del segundo cuatrimestre
        estudiante1.aprobarFinal(sistemasOrganizaciones);
        estudiante1.aprobarFinal(arquitecturaComputadoras);




        Estudiante estudiante6 = new Estudiante(006, "Julio Gomez");
        estudiante6.setCarrera(sistemas);

        // Inscribir y aprobar todas las materias del primer cuatrimestre
        estudiante6.inscribirEnMateria(elem1);
        estudiante6.inscribirEnMateria(epa);
        estudiante6.inscribirEnMateria(algebra);
        estudiante6.inscribirEnMateria(ayp1);
        estudiante6.inscribirEnMateria(elmd);
        estudiante6.inscribirEnMateria(analisisMatematico);

        estudiante6.aprobarCursada(elem1);
        estudiante6.aprobarCursada(epa);
        estudiante6.aprobarCursada(algebra);
        estudiante6.aprobarCursada(ayp1);
        estudiante6.aprobarCursada(elmd);
        estudiante6.aprobarCursada(analisisMatematico);

        estudiante6.aprobarFinal(elem1);
        estudiante6.aprobarFinal(epa);
        estudiante6.aprobarFinal(algebra);
        estudiante6.aprobarFinal(ayp1);
        estudiante6.aprobarFinal(elmd);
        estudiante6.aprobarFinal(analisisMatematico);

        // Inscribir y aprobar todas las materias del segundo cuatrimestre
        estudiante6.inscribirEnMateria(sistemasOrganizaciones);
        estudiante6.inscribirEnMateria(arquitecturaComputadoras);
        estudiante6.inscribirEnMateria(ayp2);
        estudiante6.inscribirEnMateria(estadistica);

        estudiante6.aprobarCursada(sistemasOrganizaciones);
        estudiante6.aprobarCursada(arquitecturaComputadoras);
        estudiante6.aprobarCursada(ayp2);
        estudiante6.aprobarCursada(estadistica);

        estudiante6.aprobarFinal(sistemasOrganizaciones);
        estudiante6.aprobarFinal(arquitecturaComputadoras);
        estudiante6.aprobarFinal(ayp2);
        estudiante6.aprobarFinal(estadistica);

        // Inscribir y aprobar todas las materias del tercer cuatrimestre
        estudiante6.inscribirEnMateria(basesDatos1);
        estudiante6.inscribirEnMateria(programacionOrientadaObjetos);
        estudiante6.inscribirEnMateria(ingenieriaSoftware1);

        estudiante6.aprobarCursada(basesDatos1);
        estudiante6.aprobarCursada(programacionOrientadaObjetos);
        estudiante6.aprobarCursada(ingenieriaSoftware1);

        estudiante6.aprobarFinal(basesDatos1);
        estudiante6.aprobarFinal(programacionOrientadaObjetos);
        estudiante6.aprobarFinal(ingenieriaSoftware1);

        // Inscribir y aprobar todas las materias del cuarto cuatrimestre
        estudiante6.inscribirEnMateria(labProgramacion);
        estudiante6.inscribirEnMateria(fundamentosInformatica);
        estudiante6.inscribirEnMateria(ingenieriaSoftware2);
        estudiante6.inscribirEnMateria(introduccionConcurrencia);
        estudiante6.inscribirEnMateria(sistemasOperativos);
        estudiante6.inscribirEnMateria(labSoftware);
        estudiante6.inscribirEnMateria(basesDatos2);
        estudiante6.inscribirEnMateria(seminarioLegales1);

        estudiante6.aprobarCursada(labProgramacion);
        estudiante6.aprobarCursada(fundamentosInformatica);
        estudiante6.aprobarCursada(ingenieriaSoftware2);
        estudiante6.aprobarCursada(introduccionConcurrencia);
        estudiante6.aprobarCursada(sistemasOperativos);
        estudiante6.aprobarCursada(labSoftware);
        estudiante6.aprobarCursada(basesDatos2);
        estudiante6.aprobarCursada(seminarioLegales1);

        estudiante6.aprobarFinal(labProgramacion);
        estudiante6.aprobarFinal(fundamentosInformatica);
        estudiante6.aprobarFinal(ingenieriaSoftware2);
        estudiante6.aprobarFinal(introduccionConcurrencia);
        estudiante6.aprobarFinal(sistemasOperativos);
        estudiante6.aprobarFinal(labSoftware);
        estudiante6.aprobarFinal(basesDatos2);
        estudiante6.aprobarFinal(seminarioLegales1);

        // Inscribir y aprobar todas las materias del quinto cuatrimestre
        estudiante6.inscribirEnMateria(redesTransmisionDatos);
        estudiante6.inscribirEnMateria(paradigmasLenguajes);
        estudiante6.inscribirEnMateria(tallerNuevasTecnologias);
        estudiante6.inscribirEnMateria(sistemasDistribuidos);
        estudiante6.inscribirEnMateria(sistemasInteligentes);
        estudiante6.inscribirEnMateria(ingenieriaSoftware3);
        estudiante6.inscribirEnMateria(seminarioLegales2);

        estudiante6.aprobarCursada(redesTransmisionDatos);
        estudiante6.aprobarCursada(paradigmasLenguajes);
        estudiante6.aprobarCursada(tallerNuevasTecnologias);
        estudiante6.aprobarCursada(sistemasDistribuidos);
        estudiante6.aprobarCursada(sistemasInteligentes);
        estudiante6.aprobarCursada(ingenieriaSoftware3);
        estudiante6.aprobarCursada(seminarioLegales2);

        estudiante6.aprobarFinal(redesTransmisionDatos);
        estudiante6.aprobarFinal(paradigmasLenguajes);
        estudiante6.aprobarFinal(tallerNuevasTecnologias);
        estudiante6.aprobarFinal(sistemasDistribuidos);
        estudiante6.aprobarFinal(sistemasInteligentes);
        estudiante6.aprobarFinal(ingenieriaSoftware3);
        estudiante6.aprobarFinal(seminarioLegales2);

        // Inscribir y aprobar todas las materias del sexto cuatrimestre
        estudiante6.inscribirEnMateria(sistemasParalelos);
        estudiante6.inscribirEnMateria(sistemasTiempoReal);
        estudiante6.inscribirEnMateria(seminarioSeguridad);
        estudiante6.inscribirEnMateria(basesDatosDistribuidas);
        estudiante6.inscribirEnMateria(modelosSimulacion);
        estudiante6.inscribirEnMateria(proyectoSoftware);

        estudiante6.aprobarCursada(sistemasParalelos);
        estudiante6.aprobarCursada(sistemasTiempoReal);
        estudiante6.aprobarCursada(seminarioSeguridad);
        estudiante6.aprobarCursada(basesDatosDistribuidas);
        estudiante6.aprobarCursada(modelosSimulacion);
        estudiante6.aprobarCursada(proyectoSoftware);

        estudiante6.aprobarFinal(sistemasParalelos);
        estudiante6.aprobarFinal(sistemasTiempoReal);
        estudiante6.aprobarFinal(seminarioSeguridad);
        estudiante6.aprobarFinal(basesDatosDistribuidas);
        estudiante6.aprobarFinal(modelosSimulacion);
        estudiante6.aprobarFinal(proyectoSoftware);

        // Agregar carreras al sistema
        sistema.getCarreras().add(sistemas);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(LicSistemas);
        
        // Agregar estudiante
        sistema.getEstudiantes().add(estudiante1);
        sistema.getEstudiantes().add(estudiante6);




        Materia introCienciasAmbientales = new Materia("ICA001", "Introducción a las Ciencias Ambientales", true, 1);
        Materia introSociedadCulturaAmbiente = new Materia("ICA002", "Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", true, 1);
        Materia matematica1 = new Materia("MA001", "Matemática I para Ciencias Naturales", true, 1);
        Materia quimicaGeneral = new Materia("QU001", "Química General e Inorgánica", true, 1);
        Materia introProblematicaAmbiental = new Materia("ICA003", "Introducción a la Problemática Ambiental", true, 2);
        Materia fisica1 = new Materia("FI001", "Física I para Ciencias Naturales", true, 2);
        Materia matematica2 = new Materia("MA002", "Matemática II para Ciencias Naturales", true, 2);
        Materia quimicaOrganica = new Materia("QU002", "Química Orgánica", true, 2);

        // Crear materias del segundo cuatrimestre
        Materia introBiologia = new Materia("BIO001", "Introducción a la Biología", true, 3);
        Materia introGeologia = new Materia("GEO001", "Introducción a la Geología", true, 3);
        Materia sociedadAmbiente = new Materia("ICA004", "Sociedad y Ambiente", true, 3);
        Materia legislacionAmbiental = new Materia("DER001", "Legislación Ambiental", true, 3);
        Materia diversidadBiologica = new Materia("BIO002", "Diversidad Biológica", true, 4);
        Materia geografiaFisica1 = new Materia("GEO002", "Geografía Física para Ciencias Ambientales", true, 4);
        Materia economiaAmbiente = new Materia("ECO001", "Economía y Ambiente", true, 4);
        Materia estadistica1 = new Materia("EST001", "Estadística I para Ciencias Naturales", true, 4);

        // Crear materias del tercer cuatrimestre
        Materia quimicaAmbiental = new Materia("QU003", "Química Ambiental y Contaminación", true, 5);
        Materia energiasRenovables = new Materia("ICA005", "Energías Renovables", true, 5);
        Materia ecologiaGeneral = new Materia("BIO003", "Ecología General", true, 5);
        Materia comunicacionAmbiental = new Materia("ICA006", "Comunicación Ambiental", true, 5);
        Materia hidrologia = new Materia("GEO003", "Hidrología y Gestión del Agua", true, 6);
        Materia tecnicasTratamiento = new Materia("ICA007", "Técnicas de Tratamiento y Saneamiento", true, 6);
        Materia filosofiaCiencia = new Materia("FIL001", "Filosofía, Epistemología y Metodología de la Ciencia", true, 6);
        Materia teledeteccionSIG = new Materia("GEO004", "Teledetección y SIG", true, 6);

        // Crear materias del cuarto cuatrimestre
        Materia conservacionBiodiversidad = new Materia("BIO004", "Conservación de la Biodiversidad", true, 7);
        Materia administracionAmbiental = new Materia("ICA008", "Administración Ambiental", true, 7);
        Materia gestionAmbientesUrbanos = new Materia("ICA009", "Gestión de Ambientes Urbanos", true, 7);
        Materia tallerMetodologia = new Materia("ICA010", "Taller de Metodología de la Investigación", true, 7);
        Materia gestionAmbientesRurales = new Materia("ICA011", "Gestión de Ambientes Rurales", true, 8);
        Materia gestionRecursosNaturales = new Materia("ICA012", "Gestión Integral de Recursos Naturales", true, 8);
        Materia cambioGlobal = new Materia("ICA013", "Cambio Global", true, 8);
        Materia seminarioFueguino = new Materia("ICA014", "Seminario de Problemática Fueguina", true, 8);

        // Crear materias del quinto cuatrimestre
        Materia desarrolloEconomicoSostenible = new Materia("ECO002", "Desarrollo Económico Sostenible", true, 9);
        Materia ordenamientoTerritorial = new Materia("ICA015", "Ordenamiento Ambiental del Territorio", true, 9);
        Materia tallerEvaluacionImpacto = new Materia("ICA016", "Taller de Evaluación de Impacto Ambiental", true, 10);
        Materia tallerTrabajoFinal = new Materia("ICA017", "Taller de Trabajo Final", true, 10);
        Materia optativa1 = new Materia("OPT001", "Optativa I", false, 9);
        Materia optativa2 = new Materia("OPT002", "Optativa II", false, 10);

        // Definir correlativas
        // Segundo cuatrimestre
        introBiologia.agregarCorrelativa(introCienciasAmbientales); // BIO001 requiere ICA001
        introGeologia.agregarCorrelativa(introCienciasAmbientales); // GEO001 requiere ICA001
        sociedadAmbiente.agregarCorrelativa(introSociedadCulturaAmbiente); // ICA004 requiere ICA002
        legislacionAmbiental.agregarCorrelativa(introProblematicaAmbiental); // DER001 requiere ICA003
        diversidadBiologica.agregarCorrelativa(introBiologia); // BIO002 requiere BIO001
        geografiaFisica1.agregarCorrelativa(introGeologia); // GEO002 requiere GEO001
        economiaAmbiente.agregarCorrelativa(introProblematicaAmbiental); // ECO001 requiere ICA003
        estadistica1.agregarCorrelativa(matematica1); // EST001 requiere MA001

        // Tercer cuatrimestre
        quimicaAmbiental.agregarCorrelativa(quimicaGeneral); // QU003 requiere QU001
        energiasRenovables.agregarCorrelativa(introProblematicaAmbiental); // ICA005 requiere ICA003
        ecologiaGeneral.agregarCorrelativa(introBiologia); // BIO003 requiere BIO001
        comunicacionAmbiental.agregarCorrelativa(sociedadAmbiente); // ICA006 requiere ICA004
        hidrologia.agregarCorrelativa(geografiaFisica1); // GEO003 requiere GEO002
        tecnicasTratamiento.agregarCorrelativa(quimicaAmbiental); // ICA007 requiere QU003
        filosofiaCiencia.agregarCorrelativa(introSociedadCulturaAmbiente); // FIL001 requiere ICA002
        teledeteccionSIG.agregarCorrelativa(geografiaFisica1); // GEO004 requiere GEO002

        // Cuarto cuatrimestre
        conservacionBiodiversidad.agregarCorrelativa(diversidadBiologica); // BIO004 requiere BIO002
        administracionAmbiental.agregarCorrelativa(legislacionAmbiental); // ICA008 requiere DER001
        gestionAmbientesUrbanos.agregarCorrelativa(sociedadAmbiente); // ICA009 requiere ICA004
        tallerMetodologia.agregarCorrelativa(filosofiaCiencia); // ICA010 requiere FIL001
        gestionAmbientesRurales.agregarCorrelativa(economiaAmbiente); // ICA011 requiere ECO001
        gestionRecursosNaturales.agregarCorrelativa(ecologiaGeneral); // ICA012 requiere BIO003
        cambioGlobal.agregarCorrelativa(ecologiaGeneral); // ICA013 requiere BIO003
        seminarioFueguino.agregarCorrelativa(sociedadAmbiente); // ICA014 requiere ICA004

        // Quinto cuatrimestre
        desarrolloEconomicoSostenible.agregarCorrelativa(economiaAmbiente); // ECO002 requiere ECO001
        ordenamientoTerritorial.agregarCorrelativa(geografiaFisica1); // ICA015 requiere GEO002
        tallerEvaluacionImpacto.agregarCorrelativa(legislacionAmbiental); // ICA016 requiere DER001
        tallerTrabajoFinal.agregarCorrelativa(tallerMetodologia); // ICA017 requiere ICA010
        optativa1.agregarCorrelativa(conservacionBiodiversidad); // OPT001 requiere BIO004
        optativa2.agregarCorrelativa(conservacionBiodiversidad); // OPT002 requiere BIO004

        // Crear planes de estudio
        PlanEstudio planCienciasAmbientales = new PlanB("Licenciatura en Ciencias Ambientales");
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
        planCienciasAmbientales.agregarMateriaObligatoria(geografiaFisica1);
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
        Carrera cienciasAmbientales = new Carrera("Licenciatura en Ciencias Ambientales", planCienciasAmbientales, 2);

        Estudiante estudiante2 = new Estudiante(002, "Carina Ballan");
        estudiante2.setCarrera(cienciasAmbientales);


        estudiante2.inscribirEnMateria(introCienciasAmbientales);
        estudiante2.inscribirEnMateria(introSociedadCulturaAmbiente);
        estudiante2.inscribirEnMateria(matematica1);
        estudiante2.inscribirEnMateria(quimicaGeneral);

        // Aprobar materias del primer cuatrimestre
        estudiante2.aprobarCursada(introCienciasAmbientales);
        estudiante2.aprobarCursada(introSociedadCulturaAmbiente);
        estudiante2.aprobarCursada(matematica1);
        estudiante2.aprobarCursada(quimicaGeneral);

        // Aprobar finales de algunas materias del primer cuatrimestre
        estudiante2.aprobarFinal(introCienciasAmbientales);
        estudiante2.aprobarFinal(introSociedadCulturaAmbiente);
        estudiante2.aprobarFinal(matematica1);

        estudiante2.inscribirEnMateria(introProblematicaAmbiental);
        estudiante2.inscribirEnMateria(fisica1);
        estudiante2.inscribirEnMateria(matematica2);
        estudiante2.inscribirEnMateria(quimicaOrganica);

        // Aprobar materias del segundo cuatrimestre
        estudiante2.aprobarCursada(introProblematicaAmbiental);
        estudiante2.aprobarCursada(fisica1);
        estudiante2.aprobarCursada(matematica2);
        estudiante2.aprobarCursada(quimicaOrganica);

        // Aprobar finales de algunas materias del segundo cuatrimestre
        estudiante2.aprobarFinal(introProblematicaAmbiental);
        estudiante2.aprobarFinal(fisica1);

        // Agregar carreras al sistema
        sistema.getCarreras().add(cienciasAmbientales);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planCienciasAmbientales);

        //Agregas Estudiante
        sistema.getEstudiantes().add(estudiante2);


        //INGENIERIA
        // Crear materias del primer cuatrimestre
        Materia introCalculo = new Materia("C2", "Introducción al Cálculo", true, 1);
        Materia introSociedadCulturaAmbienteIng = new Materia("C1", "Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", true, 1);
        Materia sistemasRepresentacion = new Materia("ING2", "Sistemas de Representación", true, 1);
        Materia quimica = new Materia("ABG2", "Química", true, 1);
        Materia introIngenieria = new Materia("ING1", "Introducción a la Ingeniería", true, 1);

        // Crear materias del segundo cuatrimestre
        Materia matematica1Ing = new Materia("C3", "Matemática I", true, 2);
        Materia fisica1Ing = new Materia("ING3", "Física I", true, 2);
        Materia pensamientoSistemico = new Materia("ING4", "Pensamiento Sistémico", true, 2);
        Materia algebraIng = new Materia("C4", "Álgebra", true, 2);

        // Crear materias del tercer cuatrimestre
        Materia introEconomia = new Materia("ECO1", "Introducción a la Economía", true, 3);
        Materia matematica2Ing = new Materia("C5", "Matemática II", true, 3);
        Materia mecanicaElemental = new Materia("ING7", "Mecánica Elemental", true, 3);
        Materia programacionMetodosNumericos = new Materia("ING8", "Programación y Métodos Numéricos", true, 3);

        // Crear materias del cuarto cuatrimestre
        Materia matematica3 = new Materia("ING40", "Matemática III Para Ingenieros", true, 4);
        Materia estaticaResistenciaMateriales = new Materia("ING10", "Estática y Resistencia de los Materiales", true, 4);
        Materia fisica2 = new Materia("ING5", "Física II", true, 4);
        Materia estadisticaIng = new Materia("ECO11", "Estadística", true, 4);
        Materia examenIngles1 = new Materia("ExID1", "Examen Nivel I de Inglés", true, 4);

        // Crear materias del quinto cuatrimestre
        Materia organizacionProduccion1 = new Materia("ING6", "Organización de la Producción I", true, 5);
        Materia mecanicaFluidos = new Materia("ING12", "Mecánica de los Fluidos", true, 5);
        Materia cienciaMateriales = new Materia("ING14", "Ciencia de los Materiales", true, 5);
        Materia termodinamica = new Materia("ING18", "Termodinámica", true, 5);
        Materia electrotecnia = new Materia("ING19", "Electrotecnia", true, 5);
        Materia seminarioEntrevistas = new Materia("ING91", "Seminario de entrevistas profesionales", true, 5);

        // Crear materias del sexto cuatrimestre
        Materia procesosFabricacion = new Materia("ING16", "Procesos de Fabricación", true, 6);
        Materia organizacionProduccion2 = new Materia("ING17", "Organización de la Producción II", true, 6);
        Materia seminarioProblematicaFueguina = new Materia("SEM1", "Seminario de Problemática Fueguina", true, 6);
        Materia mecanismosElementosMaquinas = new Materia("ING21", "Mecanismos y Elementos de Máquinas", true, 6);
        Materia termotecniaMaquinariaTermica = new Materia("ING22", "Termotecnia y Maquinaria Térmica", true, 6);

        // Crear materias del séptimo cuatrimestre
        Materia marketingInteligenciaComercial = new Materia("ING11", "Marketing e Inteligencia Comercial", true, 7);
        Materia calidad = new Materia("ING20", "Calidad", true, 7);
        Materia investigacionOperativa = new Materia("ING23", "Investigación Operativa", true, 7);
        Materia sistemasControlIndustrial = new Materia("ING25", "Sistemas de Control Industrial", true, 7);
        Materia costosIndustriales = new Materia("ING28", "Costos Industriales", true, 7);

        // Crear materias del octavo cuatrimestre
        Materia mantenimiento = new Materia("ING24", "Mantenimiento", true, 8);
        Materia desarrolloProductos = new Materia("ING26", "Desarrollo de Productos", true, 8);
        Materia instalacionesIndustriales = new Materia("ING29", "Instalaciones Industriales", true, 8);
        Materia inversionProyectos = new Materia("ING32", "Inversión y Proyectos", true, 8);
        Materia examenIngles2 = new Materia("ExID2", "Examen Nivel II de Inglés", true, 8);

        // Crear materias del noveno cuatrimestre
        Materia recursosHumanos = new Materia("ING27", "Recursos Humanos", true, 9);
        Materia seguridadHigieneGestionAmbiental = new Materia("ING41", "Seguridad e Higiene y Gestión Ambiental", true, 9);
        Materia optativa1Ing = new Materia("OPT30", "Optativa 1", false, 9);
        Materia legislacion = new Materia("ING34", "Legislación", true, 9);
        Materia tallerCreacionEmpresas = new Materia("GE13", "Taller de Creación de Empresas", true, 9);
        Materia trabajoFinal1 = new Materia("TFING1", "Trabajo Final 1", true, 9);
        Materia examenPortugues1 = new Materia("ExID4", "Examen Nivel I de Portugués", true, 9);

        // Crear materias del décimo cuatrimestre
        Materia direccionIndustrialGerenciamiento = new Materia("ING15", "Dirección Industrial y Gerenciamiento", true, 10);
        Materia distribucionLogistica = new Materia("ING30", "Distribución y Logística", true, 10);
        Materia seminarioLeanManufacturing = new Materia("ING33", "Seminario Lean Manufacturing y Teoría de las Restricciones", true, 10);
        Materia optativa2Ing = new Materia("OPT31", "Optativa 2", false, 10);
        Materia seminarioPensamientoSistemico = new Materia("ING42", "Seminario de Pensamiento Sistémico", true, 10);
        Materia trabajoFinal2 = new Materia("TFING2", "Trabajo Final 2", true, 10);
        Materia examenIngles3 = new Materia("ExID3", "Examen Nivel III de Inglés", true, 10);
        Materia practicaProfesionalSupervisada = new Materia("PPSING", "Práctica Profesional Supervisada", true, 10);

        // Definir correlativas
        // Segundo cuatrimestre
        matematica1Ing.agregarCorrelativa(introCalculo); // C3 requiere C2
        fisica1Ing.agregarCorrelativa(introCalculo); // ING3 requiere C2
        pensamientoSistemico.agregarCorrelativa(introSociedadCulturaAmbienteIng); // ING4 requiere C1
        pensamientoSistemico.agregarCorrelativa(introIngenieria); // ING4 requiere ING1
        algebraIng.agregarCorrelativa(introCalculo); // C4 requiere C2

        // Tercer cuatrimestre
        matematica2Ing.agregarCorrelativa(matematica1Ing); // C5 requiere C3
        matematica2Ing.agregarCorrelativa(algebraIng); // C5 requiere C4
        mecanicaElemental.agregarCorrelativa(matematica1Ing); // ING7 requiere C3
        mecanicaElemental.agregarCorrelativa(fisica1Ing); // ING7 requiere ING3
        programacionMetodosNumericos.agregarCorrelativa(matematica1Ing); // ING8 requiere C3
        programacionMetodosNumericos.agregarCorrelativa(algebraIng); // ING8 requiere C4

        // Cuarto cuatrimestre
        matematica3.agregarCorrelativa(matematica2Ing); // ING40 requiere C5
        estaticaResistenciaMateriales.agregarCorrelativa(quimica); // ING10 requiere ABG2
        estaticaResistenciaMateriales.agregarCorrelativa(sistemasRepresentacion); // ING10 requiere ING2
        estaticaResistenciaMateriales.agregarCorrelativa(mecanicaElemental); // ING10 requiere ING7
        fisica2.agregarCorrelativa(matematica2Ing); // ING5 requiere C5
        fisica2.agregarCorrelativa(mecanicaElemental); // ING5 requiere ING7
        estadisticaIng.agregarCorrelativa(matematica2Ing); // ECO11 requiere C5

        // Quinto cuatrimestre
        organizacionProduccion1.agregarCorrelativa(introIngenieria); // ING6 requiere ING1
        organizacionProduccion1.agregarCorrelativa(pensamientoSistemico); // ING6 requiere ING4
        organizacionProduccion1.agregarCorrelativa(introEconomia); // ING6 requiere ECO1
        mecanicaFluidos.agregarCorrelativa(sistemasRepresentacion); // ING12 requiere ING2
        mecanicaFluidos.agregarCorrelativa(mecanicaElemental); // ING12 requiere ING7
        mecanicaFluidos.agregarCorrelativa(matematica3); // ING12 requiere ING40
        cienciaMateriales.agregarCorrelativa(quimica); // ING14 requiere ABG2
        cienciaMateriales.agregarCorrelativa(estaticaResistenciaMateriales); // ING14 requiere ING10
        termodinamica.agregarCorrelativa(quimica); // ING18 requiere ABG2
        termodinamica.agregarCorrelativa(matematica3); // ING18 requiere ING40
        electrotecnia.agregarCorrelativa(fisica2); // ING19 requiere ING5
        electrotecnia.agregarCorrelativa(matematica3); // ING19 requiere ING40
        seminarioEntrevistas.agregarCorrelativa(introEconomia); // ING91 requiere ECO1
        seminarioEntrevistas.agregarCorrelativa(introIngenieria); // ING91 requiere ING1

        // Sexto cuatrimestre
        procesosFabricacion.agregarCorrelativa(mecanicaFluidos); // ING16 requiere ING12
        procesosFabricacion.agregarCorrelativa(cienciaMateriales); // ING16 requiere ING14
        procesosFabricacion.agregarCorrelativa(termodinamica); // ING16 requiere ING18
        procesosFabricacion.agregarCorrelativa(electrotecnia); // ING16 requiere ING19
        organizacionProduccion2.agregarCorrelativa(organizacionProduccion1); // ING17 requiere ING6
        seminarioProblematicaFueguina.agregarCorrelativa(introEconomia); // SEM1 requiere ECO1
        seminarioProblematicaFueguina.agregarCorrelativa(organizacionProduccion1); // SEM1 requiere ING6
        mecanismosElementosMaquinas.agregarCorrelativa(cienciaMateriales); // ING21 requiere ING14
        termotecniaMaquinariaTermica.agregarCorrelativa(mecanicaFluidos); // ING22 requiere ING12
        termotecniaMaquinariaTermica.agregarCorrelativa(termodinamica); // ING22 requiere ING18

        // Séptimo cuatrimestre
        marketingInteligenciaComercial.agregarCorrelativa(introEconomia); // ING11 requiere ECO1
        marketingInteligenciaComercial.agregarCorrelativa(organizacionProduccion1); // ING11 requiere ING6
        calidad.agregarCorrelativa(organizacionProduccion2); // ING20 requiere ING17
        calidad.agregarCorrelativa(estadisticaIng); // ING20 requiere ECO11
        investigacionOperativa.agregarCorrelativa(organizacionProduccion2); // ING23 requiere ING17
        investigacionOperativa.agregarCorrelativa(estadisticaIng); // ING23 requiere ECO11
        sistemasControlIndustrial.agregarCorrelativa(electrotecnia); // ING25 requiere ING19
        sistemasControlIndustrial.agregarCorrelativa(mecanismosElementosMaquinas); // ING25 requiere ING21
        sistemasControlIndustrial.agregarCorrelativa(termotecniaMaquinariaTermica); // ING25 requiere ING22
        costosIndustriales.agregarCorrelativa(organizacionProduccion2); // ING28 requiere ING17

        // Octavo cuatrimestre
        mantenimiento.agregarCorrelativa(calidad); // ING24 requiere ING20
        mantenimiento.agregarCorrelativa(sistemasControlIndustrial); // ING24 requiere ING25
        desarrolloProductos.agregarCorrelativa(marketingInteligenciaComercial); // ING26 requiere ING11
        desarrolloProductos.agregarCorrelativa(cienciaMateriales); // ING26 requiere ING14
        desarrolloProductos.agregarCorrelativa(calidad); // ING26 requiere ING20
        instalacionesIndustriales.agregarCorrelativa(electrotecnia); // ING29 requiere ING19
        instalacionesIndustriales.agregarCorrelativa(mecanismosElementosMaquinas); // ING29 requiere ING21
        instalacionesIndustriales.agregarCorrelativa(termotecniaMaquinariaTermica); // ING29 requiere ING22
        instalacionesIndustriales.agregarCorrelativa(sistemasControlIndustrial); // ING29 requiere ING25
        inversionProyectos.agregarCorrelativa(marketingInteligenciaComercial); // ING32 requiere ING11
        inversionProyectos.agregarCorrelativa(costosIndustriales); // ING32 requiere ING28
        examenIngles2.agregarCorrelativa(examenIngles1); // ExID2 requiere ExID1

        // Noveno cuatrimestre
        recursosHumanos.agregarCorrelativa(calidad); // ING27 requiere ING20
        seguridadHigieneGestionAmbiental.agregarCorrelativa(calidad); // ING41 requiere ING20
        optativa1Ing.agregarCorrelativa(mantenimiento); // OPT30 requiere ING24
        optativa1Ing.agregarCorrelativa(desarrolloProductos); // OPT30 requiere ING26
        optativa1Ing.agregarCorrelativa(inversionProyectos); // OPT30 requiere ING32
        legislacion.agregarCorrelativa(calidad); // ING34 requiere ING20
        tallerCreacionEmpresas.agregarCorrelativa(desarrolloProductos); // GE13 requiere ING26
        trabajoFinal1.agregarCorrelativa(instalacionesIndustriales); // TFING1 requiere ING29
        trabajoFinal1.agregarCorrelativa(inversionProyectos); // TFING1 requiere ING32

        // Décimo cuatrimestre
        direccionIndustrialGerenciamiento.agregarCorrelativa(legislacion); // ING15 requiere ING34
        direccionIndustrialGerenciamiento.agregarCorrelativa(recursosHumanos); // ING15 requiere ING27
        distribucionLogistica.agregarCorrelativa(inversionProyectos); // ING30 requiere ING32
        distribucionLogistica.agregarCorrelativa(legislacion); // ING30 requiere ING34
        seminarioLeanManufacturing.agregarCorrelativa(calidad); // ING33 requiere ING20
        seminarioLeanManufacturing.agregarCorrelativa(investigacionOperativa); // ING33 requiere ING23
        optativa2Ing.agregarCorrelativa(mantenimiento); // OPT31 requiere ING24
        optativa2Ing.agregarCorrelativa(desarrolloProductos); // OPT31 requiere ING26
        optativa2Ing.agregarCorrelativa(inversionProyectos); // OPT31 requiere ING32
        seminarioPensamientoSistemico.agregarCorrelativa(recursosHumanos); // ING42 requiere ING27
        trabajoFinal2.agregarCorrelativa(trabajoFinal1); // TFING2 requiere TFING1
        trabajoFinal2.agregarCorrelativa(tallerCreacionEmpresas); // TFING2 requiere GE13
        examenIngles3.agregarCorrelativa(examenIngles2); // ExID3 requiere ExID2
        practicaProfesionalSupervisada.agregarCorrelativa(costosIndustriales); // PPSING requiere ING28
        practicaProfesionalSupervisada.agregarCorrelativa(instalacionesIndustriales); // PPSING requiere ING29

        // Crear planes de estudio
        PlanEstudio planIngenieriaIndustrial = new PlanC("Ingeniería Industrial");
        planIngenieriaIndustrial.agregarMateriaObligatoria(introCalculo);
        planIngenieriaIndustrial.agregarMateriaObligatoria(introSociedadCulturaAmbienteIng);
        planIngenieriaIndustrial.agregarMateriaObligatoria(sistemasRepresentacion);
        planIngenieriaIndustrial.agregarMateriaObligatoria(quimica);
        planIngenieriaIndustrial.agregarMateriaObligatoria(introIngenieria);
        planIngenieriaIndustrial.agregarMateriaObligatoria(matematica1Ing);
        planIngenieriaIndustrial.agregarMateriaObligatoria(fisica1Ing);
        planIngenieriaIndustrial.agregarMateriaObligatoria(pensamientoSistemico);
        planIngenieriaIndustrial.agregarMateriaObligatoria(algebraIng);
        planIngenieriaIndustrial.agregarMateriaObligatoria(introEconomia);
        planIngenieriaIndustrial.agregarMateriaObligatoria(matematica2Ing);
        planIngenieriaIndustrial.agregarMateriaObligatoria(mecanicaElemental);
        planIngenieriaIndustrial.agregarMateriaObligatoria(programacionMetodosNumericos);
        planIngenieriaIndustrial.agregarMateriaObligatoria(matematica3);
        planIngenieriaIndustrial.agregarMateriaObligatoria(estaticaResistenciaMateriales);
        planIngenieriaIndustrial.agregarMateriaObligatoria(fisica2);
        planIngenieriaIndustrial.agregarMateriaObligatoria(estadisticaIng);
        planIngenieriaIndustrial.agregarMateriaObligatoria(examenIngles1);
        planIngenieriaIndustrial.agregarMateriaObligatoria(organizacionProduccion1);
        planIngenieriaIndustrial.agregarMateriaObligatoria(mecanicaFluidos);
        planIngenieriaIndustrial.agregarMateriaObligatoria(cienciaMateriales);
        planIngenieriaIndustrial.agregarMateriaObligatoria(termodinamica);
        planIngenieriaIndustrial.agregarMateriaObligatoria(electrotecnia);
        planIngenieriaIndustrial.agregarMateriaObligatoria(seminarioEntrevistas);
        planIngenieriaIndustrial.agregarMateriaObligatoria(procesosFabricacion);
        planIngenieriaIndustrial.agregarMateriaObligatoria(organizacionProduccion2);
        planIngenieriaIndustrial.agregarMateriaObligatoria(seminarioProblematicaFueguina);
        planIngenieriaIndustrial.agregarMateriaObligatoria(mecanismosElementosMaquinas);
        planIngenieriaIndustrial.agregarMateriaObligatoria(termotecniaMaquinariaTermica);
        planIngenieriaIndustrial.agregarMateriaObligatoria(marketingInteligenciaComercial);
        planIngenieriaIndustrial.agregarMateriaObligatoria(calidad);
        planIngenieriaIndustrial.agregarMateriaObligatoria(investigacionOperativa);
        planIngenieriaIndustrial.agregarMateriaObligatoria(sistemasControlIndustrial);
        planIngenieriaIndustrial.agregarMateriaObligatoria(costosIndustriales);
        planIngenieriaIndustrial.agregarMateriaObligatoria(mantenimiento);
        planIngenieriaIndustrial.agregarMateriaObligatoria(desarrolloProductos);
        planIngenieriaIndustrial.agregarMateriaObligatoria(instalacionesIndustriales);
        planIngenieriaIndustrial.agregarMateriaObligatoria(inversionProyectos);
        planIngenieriaIndustrial.agregarMateriaObligatoria(examenIngles2);
        planIngenieriaIndustrial.agregarMateriaObligatoria(recursosHumanos);
        planIngenieriaIndustrial.agregarMateriaObligatoria(seguridadHigieneGestionAmbiental);
        planIngenieriaIndustrial.agregarMateriaObligatoria(optativa1Ing);
        planIngenieriaIndustrial.agregarMateriaObligatoria(legislacion);
        planIngenieriaIndustrial.agregarMateriaObligatoria(tallerCreacionEmpresas);
        planIngenieriaIndustrial.agregarMateriaObligatoria(trabajoFinal1);
        planIngenieriaIndustrial.agregarMateriaObligatoria(examenPortugues1);
        planIngenieriaIndustrial.agregarMateriaObligatoria(direccionIndustrialGerenciamiento);
        planIngenieriaIndustrial.agregarMateriaObligatoria(distribucionLogistica);
        planIngenieriaIndustrial.agregarMateriaObligatoria(seminarioLeanManufacturing);
        planIngenieriaIndustrial.agregarMateriaObligatoria(optativa2Ing);
        planIngenieriaIndustrial.agregarMateriaObligatoria(seminarioPensamientoSistemico);
        planIngenieriaIndustrial.agregarMateriaObligatoria(trabajoFinal2);
        planIngenieriaIndustrial.agregarMateriaObligatoria(examenIngles3);
        planIngenieriaIndustrial.agregarMateriaObligatoria(practicaProfesionalSupervisada);

        // Crear carreras
        Carrera ingenieriaIndustrial = new Carrera("Ingeniería Industrial", planIngenieriaIndustrial, 2);

        // Crear estudiante
        Estudiante estudiante3 = new Estudiante(003, "Lionel Capriata");
        estudiante3.setCarrera(ingenieriaIndustrial);


        estudiante3.inscribirEnMateria(introCalculo);
        estudiante3.inscribirEnMateria(introSociedadCulturaAmbienteIng);
        estudiante3.inscribirEnMateria(sistemasRepresentacion);
        estudiante3.inscribirEnMateria(quimica);
        estudiante3.inscribirEnMateria(introIngenieria);

        // Aprobar materias del primer año
        estudiante3.aprobarCursada(introCalculo);
        estudiante3.aprobarCursada(introSociedadCulturaAmbienteIng);
        estudiante3.aprobarCursada(sistemasRepresentacion);
        estudiante3.aprobarCursada(quimica);
        estudiante3.aprobarCursada(introIngenieria);

        // Aprobar finales de algunas materias del primer año
        estudiante3.aprobarFinal(introCalculo);
        estudiante3.aprobarFinal(introSociedadCulturaAmbienteIng);
        estudiante3.aprobarFinal(sistemasRepresentacion);
        estudiante3.aprobarFinal(quimica);
        estudiante3.aprobarFinal(introIngenieria);


        estudiante3.inscribirEnMateria(matematica1Ing);
        estudiante3.inscribirEnMateria(fisica1Ing);
        estudiante3.inscribirEnMateria(pensamientoSistemico);
        estudiante3.inscribirEnMateria(algebraIng);

        // Aprobar materias del segundo año
        estudiante3.aprobarCursada(matematica1Ing);
        estudiante3.aprobarCursada(fisica1Ing);
        estudiante3.aprobarCursada(pensamientoSistemico);
        estudiante3.aprobarCursada(algebraIng);

        // Aprobar finales de algunas materias del segundo año
        estudiante3.aprobarFinal(matematica1Ing);
        estudiante3.aprobarFinal(fisica1Ing);
        estudiante3.aprobarFinal(pensamientoSistemico);
        estudiante3.aprobarFinal(algebraIng);


        estudiante3.inscribirEnMateria(introEconomia);
        estudiante3.inscribirEnMateria(matematica2Ing);
        estudiante3.inscribirEnMateria(mecanicaElemental);
        estudiante3.inscribirEnMateria(programacionMetodosNumericos);


        // Aprobar materias del tercer año
        estudiante3.aprobarCursada(introEconomia);
        estudiante3.aprobarCursada(matematica2Ing);
        estudiante3.aprobarCursada(mecanicaElemental);
        estudiante3.aprobarCursada(programacionMetodosNumericos);

        // Aprobar finales de algunas materias del tercer año
        estudiante3.aprobarFinal(introEconomia);
        estudiante3.aprobarFinal(matematica2Ing);
        estudiante3.aprobarFinal(mecanicaElemental);
        estudiante3.aprobarFinal(programacionMetodosNumericos);

        estudiante3.inscribirEnMateria(matematica3);
        estudiante3.inscribirEnMateria(estaticaResistenciaMateriales);
        estudiante3.inscribirEnMateria(fisica2);
        estudiante3.inscribirEnMateria(estadisticaIng);
        estudiante3.inscribirEnMateria(examenIngles1);


        // Aprobar materias del cuarto año
        estudiante3.aprobarCursada(matematica3);
        estudiante3.aprobarCursada(estaticaResistenciaMateriales);
        estudiante3.aprobarCursada(fisica2);
        estudiante3.aprobarCursada(estadisticaIng);
        estudiante3.aprobarCursada(examenIngles1);

        // Aprobar finales de algunas materias del cuarto año
        estudiante3.aprobarFinal(matematica3);
        estudiante3.aprobarFinal(estaticaResistenciaMateriales);
        estudiante3.aprobarFinal(fisica2);
        estudiante3.aprobarFinal(estadisticaIng);
        estudiante3.aprobarFinal(examenIngles1);

        estudiante3.inscribirEnMateria(organizacionProduccion1);
        estudiante3.inscribirEnMateria(mecanicaFluidos);
        estudiante3.inscribirEnMateria(cienciaMateriales);
        estudiante3.inscribirEnMateria(termodinamica);
        estudiante3.inscribirEnMateria(electrotecnia);
        estudiante3.inscribirEnMateria(seminarioEntrevistas);

        // Aprobar materias del quinto año
        estudiante3.aprobarCursada(organizacionProduccion1);
        estudiante3.aprobarCursada(mecanicaFluidos);
        estudiante3.aprobarCursada(cienciaMateriales);
        estudiante3.aprobarCursada(termodinamica);
        estudiante3.aprobarCursada(electrotecnia);
        estudiante3.aprobarCursada(seminarioEntrevistas);

        // Aprobar finales de algunas materias del quinto año
        estudiante3.aprobarFinal(organizacionProduccion1);
        estudiante3.aprobarFinal(mecanicaFluidos);
        estudiante3.aprobarFinal(cienciaMateriales);
        estudiante3.aprobarFinal(termodinamica);
        estudiante3.aprobarFinal(electrotecnia);
        estudiante3.aprobarFinal(seminarioEntrevistas);

        estudiante3.inscribirEnMateria(procesosFabricacion);
        estudiante3.inscribirEnMateria(organizacionProduccion2);
        estudiante3.inscribirEnMateria(seminarioProblematicaFueguina);
        estudiante3.inscribirEnMateria(mecanismosElementosMaquinas);
        estudiante3.inscribirEnMateria(termotecniaMaquinariaTermica);

        // Aprobar materias del sexto año
        estudiante3.aprobarCursada(procesosFabricacion);
        estudiante3.aprobarCursada(organizacionProduccion2);
        estudiante3.aprobarCursada(seminarioProblematicaFueguina);
        estudiante3.aprobarCursada(mecanismosElementosMaquinas);
        estudiante3.aprobarCursada(termotecniaMaquinariaTermica);

        // Aprobar finales de algunas materias del sexto año
        estudiante3.aprobarFinal(procesosFabricacion);
        estudiante3.aprobarFinal(organizacionProduccion2);   
        estudiante3.aprobarFinal(seminarioProblematicaFueguina);
        estudiante3.aprobarFinal(mecanismosElementosMaquinas);
        estudiante3.aprobarFinal(termotecniaMaquinariaTermica);

        // Agregar carreras al sistema
        sistema.getCarreras().add(ingenieriaIndustrial);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planIngenieriaIndustrial);

        // Agregar Estudiante

        sistema.getEstudiantes().add(estudiante3);



            //TURISMO
         // Crear materias del primer cuatrimestre
         Materia introTurismo = new Materia("T01", "Introducción al Turismo", true, 1);
         Materia geografiaFisica = new Materia("T02", "Geografía Física", true, 1);
         Materia sociologia = new Materia("T03", "Sociología", true, 1);
         Materia epistemologia = new Materia("T04", "Epistemología", true, 1);
         Materia seminarioPracticas = new Materia("T05", "Seminario: Introducción a las Prácticas Profesionales", true, 1);
 
         // Crear materias del segundo cuatrimestre
         Materia serviciosTransporte = new Materia("T06", "Servicios Turísticos. Transporte", true, 2);
         Materia serviciosAlojamiento = new Materia("T07", "Servicios Turísticos. Alojamiento", true, 2);
         Materia ecologiaConservacion = new Materia("T08", "Ecología y Conservación", true, 2);
         Materia psicologiaSocial = new Materia("T09", "Psicología Social", true, 2);
         Materia parquesNacionales = new Materia("T10", "Parques Nacionales", true, 2);
         Materia geografiaHumana = new Materia("T11", "Geografía Humana", true, 2);
         Materia historiaSocialArgentina = new Materia("T12", "Historia Social Argentina", true, 2);
         Materia practicaProfesional1 = new Materia("T13", "Práctica Profesional I", true, 2);
 
         // Crear materias del tercer cuatrimestre
         Materia serviciosAgenciasViajes = new Materia("T14", "Servicios Turísticos. Agencias de Viajes", true, 3);
         Materia psicosociologiaGrupos = new Materia("T15", "Psicosociología de los Grupos y de las Instituciones", true, 3);
         Materia patrimonioCultural = new Materia("T16", "Patrimonio Cultural", true, 3);
         Materia metodologiaInvestigacion = new Materia("T17", "Metodología de la Investigación Social", true, 3);
         Materia recursosJuridicos = new Materia("T18", "Recursos Jurídicos", true, 3);
         Materia teoriaAdministracion = new Materia("T19", "Teoría de la Administración", true, 3);
         Materia practicaProfesional2 = new Materia("T20", "Práctica Profesional II", true, 3);
 
         // Crear materias del cuarto cuatrimestre
         Materia administracionEmpresasTurismo = new Materia("T21", "Administración de Empresas Turísticas", true, 4);
         Materia economia = new Materia("T22", "Economía", true, 4);
         Materia antropologiaCultural = new Materia("T23", "Antropología Cultural", true, 4);
         Materia politicaTuristica = new Materia("T24", "Política Turística", true, 4);
         Materia historiaAmericana = new Materia("T25", "Historia Americana", true, 4);
         Materia practicaProfesional3 = new Materia("T26", "Práctica Profesional III", true, 4);
 
         // Crear materias del quinto cuatrimestre
         Materia planificacionTuristica = new Materia("T27", "Planificación Turística", true, 5);
         Materia investigacionTuristica = new Materia("T28", "Investigación Turística", true, 5);
         Materia practicaProfesional4 = new Materia("T29", "Práctica Profesional IV", true, 5);
         Materia seminarioOptativo1 = new Materia("T30", "Seminario Optativo I", false, 5);
         Materia seminarioOptativo2 = new Materia("T31", "Seminario Optativo II", false, 5);
         Materia tesinaGrado = new Materia("T32", "Tesina de Grado", true, 5);
 
         // Definir correlativas
         // Segundo cuatrimestre
         serviciosTransporte.agregarCorrelativa(introTurismo); // T06 requiere T01
         serviciosAlojamiento.agregarCorrelativa(introTurismo); // T07 requiere T01
         ecologiaConservacion.agregarCorrelativa(geografiaFisica); // T08 requiere T02
         psicologiaSocial.agregarCorrelativa(sociologia); // T09 requiere T03
         parquesNacionales.agregarCorrelativa(geografiaFisica); // T10 requiere T02
         parquesNacionales.agregarCorrelativa(ecologiaConservacion); // T10 requiere T08
         geografiaHumana.agregarCorrelativa(geografiaFisica); // T11 requiere T02
         historiaSocialArgentina.agregarCorrelativa(sociologia); // T12 requiere T03
         practicaProfesional1.agregarCorrelativa(introTurismo); // T13 requiere T01
         practicaProfesional1.agregarCorrelativa(geografiaFisica); // T13 requiere T02
         practicaProfesional1.agregarCorrelativa(seminarioPracticas); // T13 requiere T05
 
         // Tercer cuatrimestre
         serviciosAgenciasViajes.agregarCorrelativa(introTurismo); // T14 requiere T01
         serviciosAgenciasViajes.agregarCorrelativa(serviciosTransporte); // T14 requiere T06
         serviciosAgenciasViajes.agregarCorrelativa(serviciosAlojamiento); // T14 requiere T07
         psicosociologiaGrupos.agregarCorrelativa(psicologiaSocial); // T15 requiere T09
         patrimonioCultural.agregarCorrelativa(historiaSocialArgentina); // T16 requiere T12
         metodologiaInvestigacion.agregarCorrelativa(epistemologia); // T17 requiere T04
         practicaProfesional2.agregarCorrelativa(serviciosTransporte); // T20 requiere T06
         practicaProfesional2.agregarCorrelativa(serviciosAlojamiento); // T20 requiere T07
         practicaProfesional2.agregarCorrelativa(practicaProfesional1); // T20 requiere T13
 
         // Cuarto cuatrimestre
         administracionEmpresasTurismo.agregarCorrelativa(serviciosAgenciasViajes); // T21 requiere T14
         administracionEmpresasTurismo.agregarCorrelativa(teoriaAdministracion); // T21 requiere T19
         politicaTuristica.agregarCorrelativa(introTurismo); // T24 requiere T01
         politicaTuristica.agregarCorrelativa(sociologia); // T24 requiere T03
         politicaTuristica.agregarCorrelativa(psicosociologiaGrupos); // T24 requiere T15
         historiaAmericana.agregarCorrelativa(historiaSocialArgentina); // T25 requiere T12
         practicaProfesional3.agregarCorrelativa(serviciosAgenciasViajes); // T26 requiere T14
         practicaProfesional3.agregarCorrelativa(practicaProfesional2); // T26 requiere T20
 
         // Quinto cuatrimestre
         planificacionTuristica.agregarCorrelativa(introTurismo); // T27 requiere T01
         planificacionTuristica.agregarCorrelativa(metodologiaInvestigacion); // T27 requiere T17
         investigacionTuristica.agregarCorrelativa(metodologiaInvestigacion); // T28 requiere T17
         practicaProfesional4.agregarCorrelativa(practicaProfesional3); // T29 requiere T26
         seminarioOptativo1.agregarCorrelativa(planificacionTuristica); // T30 requiere T27
         seminarioOptativo2.agregarCorrelativa(planificacionTuristica); // T31 requiere T27
 
         // Crear planes de estudio
         PlanEstudio planTurismo = new PlanA("Licenciatura en Turismo");
         planTurismo.agregarMateriaObligatoria(introTurismo);
         planTurismo.agregarMateriaObligatoria(geografiaFisica);
         planTurismo.agregarMateriaObligatoria(sociologia);
         planTurismo.agregarMateriaObligatoria(epistemologia);
         planTurismo.agregarMateriaObligatoria(seminarioPracticas);
         planTurismo.agregarMateriaObligatoria(serviciosTransporte);
         planTurismo.agregarMateriaObligatoria(serviciosAlojamiento);
         planTurismo.agregarMateriaObligatoria(ecologiaConservacion);
         planTurismo.agregarMateriaObligatoria(psicologiaSocial);
         planTurismo.agregarMateriaObligatoria(parquesNacionales);
         planTurismo.agregarMateriaObligatoria(geografiaHumana);
         planTurismo.agregarMateriaObligatoria(historiaSocialArgentina);
         planTurismo.agregarMateriaObligatoria(practicaProfesional1);
         planTurismo.agregarMateriaObligatoria(serviciosAgenciasViajes);
         planTurismo.agregarMateriaObligatoria(psicosociologiaGrupos);
         planTurismo.agregarMateriaObligatoria(patrimonioCultural);
         planTurismo.agregarMateriaObligatoria(metodologiaInvestigacion);
         planTurismo.agregarMateriaObligatoria(recursosJuridicos);
         planTurismo.agregarMateriaObligatoria(teoriaAdministracion);
         planTurismo.agregarMateriaObligatoria(practicaProfesional2);
         planTurismo.agregarMateriaObligatoria(administracionEmpresasTurismo);
         planTurismo.agregarMateriaObligatoria(economia);
         planTurismo.agregarMateriaObligatoria(antropologiaCultural);
         planTurismo.agregarMateriaObligatoria(politicaTuristica);
         planTurismo.agregarMateriaObligatoria(historiaAmericana);
         planTurismo.agregarMateriaObligatoria(practicaProfesional3);
         planTurismo.agregarMateriaObligatoria(planificacionTuristica);
         planTurismo.agregarMateriaObligatoria(investigacionTuristica);
         planTurismo.agregarMateriaObligatoria(practicaProfesional4);
         planTurismo.agregarMateriaObligatoria(tesinaGrado);
         planTurismo.agregarMateriaObligatoria(seminarioOptativo1);
         planTurismo.agregarMateriaObligatoria(seminarioOptativo2);
 
         // Crear carreras
         Carrera turismo = new Carrera("Licenciatura en Turismo", planTurismo,0);

         Estudiante estudiante4 = new Estudiante(004, "Lazaro Cardenas");
         estudiante4.setCarrera(turismo);
 

         estudiante4.inscribirEnMateria(introTurismo);
         estudiante4.inscribirEnMateria(geografiaFisica);
         estudiante4.inscribirEnMateria(sociologia);
         estudiante4.inscribirEnMateria(epistemologia);
         estudiante4.inscribirEnMateria(seminarioPracticas);


         // Aprobar materias del primer cuatrimestre
         estudiante4.aprobarCursada(introTurismo);
         estudiante4.aprobarCursada(geografiaFisica);
         estudiante4.aprobarCursada(sociologia);
         estudiante4.aprobarCursada(epistemologia);
         estudiante4.aprobarCursada(seminarioPracticas);
 
         // Aprobar finales de algunas materias del primer cuatrimestre
         estudiante4.aprobarFinal(introTurismo);
         estudiante4.aprobarFinal(geografiaFisica);
         estudiante4.aprobarFinal(sociologia);
         estudiante4.aprobarFinal(epistemologia);
         estudiante4.aprobarFinal(seminarioPracticas);
 

         estudiante4.inscribirEnMateria(serviciosTransporte);
         estudiante4.inscribirEnMateria(serviciosAlojamiento);
         estudiante4.inscribirEnMateria(ecologiaConservacion);
         estudiante4.inscribirEnMateria(psicologiaSocial);
         estudiante4.inscribirEnMateria(parquesNacionales);
         estudiante4.inscribirEnMateria(geografiaHumana);
         estudiante4.inscribirEnMateria(historiaSocialArgentina);
         estudiante4.inscribirEnMateria(practicaProfesional1);

         // Aprobar materias del segundo cuatrimestre
         estudiante4.aprobarCursada(serviciosTransporte);
         estudiante4.aprobarCursada(serviciosAlojamiento);
         estudiante4.aprobarCursada(ecologiaConservacion);
         estudiante4.aprobarCursada(psicologiaSocial);
         estudiante4.aprobarCursada(parquesNacionales);
         estudiante4.aprobarCursada(geografiaHumana);
         estudiante4.aprobarCursada(historiaSocialArgentina);
         estudiante4.aprobarCursada(practicaProfesional1);
 
         // Aprobar finales de algunas materias del segundo cuatrimestre
         estudiante4.aprobarFinal(serviciosTransporte);
         estudiante4.aprobarFinal(serviciosAlojamiento);
         estudiante4.aprobarFinal(ecologiaConservacion);
        estudiante4.aprobarFinal(psicologiaSocial);
         estudiante4.aprobarFinal(parquesNacionales);
         estudiante4.aprobarFinal(geografiaHumana);
         estudiante4.aprobarFinal(historiaSocialArgentina);
         estudiante4.aprobarFinal(practicaProfesional1);

         estudiante4.inscribirEnMateria(serviciosAgenciasViajes);
         estudiante4.inscribirEnMateria(psicosociologiaGrupos);
         estudiante4.inscribirEnMateria(patrimonioCultural);
         estudiante4.inscribirEnMateria(metodologiaInvestigacion);
         estudiante4.inscribirEnMateria(recursosJuridicos);
         estudiante4.inscribirEnMateria(teoriaAdministracion);
         estudiante4.inscribirEnMateria(practicaProfesional2);

         // Aprobar materias del tercer cuatrimestre
         estudiante4.aprobarCursada(serviciosAgenciasViajes);
         estudiante4.aprobarCursada(psicosociologiaGrupos);
         estudiante4.aprobarCursada(patrimonioCultural);
         estudiante4.aprobarCursada(metodologiaInvestigacion);
         estudiante4.aprobarCursada(recursosJuridicos);
         estudiante4.aprobarCursada(teoriaAdministracion);
         estudiante4.aprobarCursada(practicaProfesional2);
 
         // Aprobar finales de algunas materias del tercer cuatrimestre
         estudiante4.aprobarFinal(serviciosAgenciasViajes);
         estudiante4.aprobarFinal(psicosociologiaGrupos);
         estudiante4.aprobarFinal(patrimonioCultural);
         estudiante4.aprobarFinal(metodologiaInvestigacion);
         estudiante4.aprobarFinal(recursosJuridicos);
         estudiante4.aprobarFinal(teoriaAdministracion);
         estudiante4.aprobarFinal(practicaProfesional2);

         estudiante4.inscribirEnMateria(administracionEmpresasTurismo);
         estudiante4.inscribirEnMateria(economia);
         estudiante4.inscribirEnMateria(antropologiaCultural);
         estudiante4.inscribirEnMateria(politicaTuristica);
         estudiante4.inscribirEnMateria(historiaAmericana);
         estudiante4.inscribirEnMateria(practicaProfesional3);

         // Aprobar materias del cuarto cuatrimestre
         estudiante4.aprobarCursada(administracionEmpresasTurismo);
         estudiante4.aprobarCursada(economia);
         estudiante4.aprobarCursada(antropologiaCultural);
         estudiante4.aprobarCursada(politicaTuristica);
         estudiante4.aprobarCursada(historiaAmericana);
         estudiante4.aprobarCursada(practicaProfesional3);
 
         // Aprobar finales de algunas materias del cuarto cuatrimestre
         estudiante4.aprobarFinal(administracionEmpresasTurismo);
         estudiante4.aprobarFinal(economia);
         estudiante4.aprobarFinal(politicaTuristica);
         estudiante4.aprobarFinal(historiaAmericana);
         estudiante4.aprobarFinal(practicaProfesional3);
         estudiante4.aprobarFinal(antropologiaCultural);
 

         // Agregar carreras al sistema
         sistema.getCarreras().add(turismo);
 
         // Agregar planes de estudio al sistema
         sistema.getPlanesEstudio().add(planTurismo);

         sistema.getEstudiantes().add(estudiante4);
         
            // Crear materias del primer cuatrimestre
        Materia introSociedadCulturaAmbienteSoc = new Materia("C1", "Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", true, 1);
        Materia introPensamientoPoliticoSocial = new Materia("C2", "Introducción al Pensamiento Político y Social", true, 1);
        Materia epistemologiaCienciasSociales = new Materia("C3", "Epistemología de las Ciencias Sociales", true, 1);
        Materia introCalculoSoc = new Materia("C4", "Introducción al Cálculo", true, 1);

        // Crear materias del segundo cuatrimestre
        Materia fundamentosSociologia = new Materia("C5", "Fundamentos de Sociología", true, 2);
        Materia fundamentosCienciaPolitica = new Materia("C6", "Fundamentos de Ciencia Política", true, 2);
        Materia introEconomiaSoc = new Materia("C7", "Introducción a la Economía", true, 2);
        Materia historiaSocialGeneral = new Materia("C8", "Historia Social General", true, 2);

        // Crear materias del tercer cuatrimestre
        Materia teoriaSocial1 = new Materia("C9", "Teoría Social I", true, 3);
        Materia historiaSocialLatinoamericana = new Materia("C10", "Historia Social Latinoamericana", true, 3);
        Materia metodologiaInvestigacionCienciasSociales = new Materia("C11", "Metodología de Investigación en Ciencias Sociales", true, 3);
        Materia macroeconomia1 = new Materia("C12", "Macroeconomía I", true, 3);

        // Crear materias del cuarto cuatrimestre
        Materia teoriaSocial2 = new Materia("C13", "Teoría Social II", true, 4);
        Materia antropologiaSocial = new Materia("C14", "Antropología Social", true, 4);
        Materia estadisticaSoc = new Materia("C15", "Estadística", true, 4);
        Materia seminarioProblematicaFueguinaSoc = new Materia("C16", "Seminario de Problemática Fueguina", true, 4);
        Materia examenIngles1Soc = new Materia("C17", "Examen Nivel I de Inglés", true, 4);

        // Crear materias del quinto cuatrimestre
        Materia teoriaSocial3 = new Materia("C18", "Teoría Social III", true, 5);
        Materia conflictoCambioSocial = new Materia("C19", "Conflicto y Cambio Social", true, 5);
        Materia metodologiaInvestigacion1 = new Materia("C20", "Metodología de la Investigación I", true, 5);
        Materia historiaSocialArgentinaSoc = new Materia("C21", "Historia Social Argentina", true, 5);

        // Crear materias del sexto cuatrimestre
        Materia metodologiaInvestigacion2 = new Materia("C22", "Metodología de la Investigación II", true, 6);
        Materia desarrolloSocialTerritorial = new Materia("C23", "Desarrollo Social y Territorial", true, 6);
        Materia analisisSociedadArgentinaContemporanea = new Materia("C24", "Análisis de la Sociedad Argentina Contemporánea", true, 6);
        Materia poblacionEstructuraSocial = new Materia("C25", "Población y Estructura Social", true, 6);

        // Crear materias del séptimo cuatrimestre
        Materia seminarioA = new Materia("C26", "Seminario A", true, 7);
        Materia sociologiaCultura = new Materia("C27", "Sociología de la Cultura", true, 7);
        Materia sociologiaInstituciones = new Materia("C28", "Sociología de las Instituciones", true, 7);
        Materia sociologiaPolitica = new Materia("C29", "Sociología Política", true, 7);

        // Crear materias del octavo cuatrimestre
        Materia seminarioB = new Materia("C30", "Seminario B", true, 8);
        Materia seminarioC = new Materia("C31", "Seminario C", true, 8);
        Materia politicasPublicasProyectosIntervencionSocial = new Materia("C32", "Políticas Públicas y Proyectos de Intervención Social", true, 8);
        Materia tallerInvestigacion1 = new Materia("C33", "Taller de Investigación I", true, 8);

        // Crear materias del noveno cuatrimestre
        Materia optativaA = new Materia("C34", "Optativa A", false, 9);
        Materia optativaB = new Materia("C35", "Optativa B", false, 9);
        Materia tallerInvestigacion2 = new Materia("C36", "Taller de Investigación II", true, 9);
        Materia examenIngles2Soc = new Materia("C37", "Examen Nivel II de Inglés", true, 9);

        // Crear materias del décimo cuatrimestre
        Materia tallerIntegracionFinal = new Materia("C38", "Taller de Integración Final", true, 10);
        Materia examenIngles3Soc = new Materia("C39", "Examen Nivel III de Inglés", true, 10);
        Materia examenPortugues1Soc = new Materia("C40", "Examen Nivel I de Portugués", true, 10);

        // Definir correlativas
        // Segundo cuatrimestre
        fundamentosSociologia.agregarCorrelativa(introPensamientoPoliticoSocial); // C5 requiere C2
        fundamentosCienciaPolitica.agregarCorrelativa(introPensamientoPoliticoSocial); // C6 requiere C2

        // Tercer cuatrimestre
        teoriaSocial1.agregarCorrelativa(fundamentosSociologia); // C9 requiere C5
        metodologiaInvestigacionCienciasSociales.agregarCorrelativa(epistemologiaCienciasSociales); // C11 requiere C3
        macroeconomia1.agregarCorrelativa(introEconomiaSoc); // C12 requiere C7

        // Cuarto cuatrimestre
        teoriaSocial2.agregarCorrelativa(teoriaSocial1); // C13 requiere C9
        antropologiaSocial.agregarCorrelativa(introPensamientoPoliticoSocial); // C14 requiere C2
        estadisticaSoc.agregarCorrelativa(introCalculoSoc); // C15 requiere C4
        seminarioProblematicaFueguinaSoc.agregarCorrelativa(fundamentosSociologia); // C16 requiere C5
        seminarioProblematicaFueguinaSoc.agregarCorrelativa(metodologiaInvestigacionCienciasSociales); // C16 requiere C11

        // Quinto cuatrimestre
        teoriaSocial3.agregarCorrelativa(teoriaSocial2); // C18 requiere C13
        conflictoCambioSocial.agregarCorrelativa(teoriaSocial1); // C19 requiere C9
        metodologiaInvestigacion1.agregarCorrelativa(metodologiaInvestigacionCienciasSociales); // C20 requiere C11
        historiaSocialArgentinaSoc.agregarCorrelativa(historiaSocialGeneral); // C21 requiere C8

        // Sexto cuatrimestre
        metodologiaInvestigacion2.agregarCorrelativa(metodologiaInvestigacion1); // C22 requiere C20
        metodologiaInvestigacion2.agregarCorrelativa(estadisticaSoc); // C22 requiere C15
        desarrolloSocialTerritorial.agregarCorrelativa(introSociedadCulturaAmbienteSoc); // C23 requiere C1
        desarrolloSocialTerritorial.agregarCorrelativa(introPensamientoPoliticoSocial); // C23 requiere C2
        analisisSociedadArgentinaContemporanea.agregarCorrelativa(teoriaSocial3); // C24 requiere C18
        analisisSociedadArgentinaContemporanea.agregarCorrelativa(historiaSocialArgentinaSoc); // C24 requiere C21
        poblacionEstructuraSocial.agregarCorrelativa(teoriaSocial1); // C25 requiere C9
        poblacionEstructuraSocial.agregarCorrelativa(metodologiaInvestigacion1); // C25 requiere C20

        // Séptimo cuatrimestre
        seminarioA.agregarCorrelativa(metodologiaInvestigacion2); // C26 requiere C22
        sociologiaCultura.agregarCorrelativa(teoriaSocial2); // C27 requiere C13
        sociologiaCultura.agregarCorrelativa(antropologiaSocial); // C27 requiere C14
        sociologiaInstituciones.agregarCorrelativa(teoriaSocial2); // C28 requiere C13
        sociologiaPolitica.agregarCorrelativa(teoriaSocial2); // C29 requiere C13

        // Octavo cuatrimestre
        seminarioB.agregarCorrelativa(metodologiaInvestigacion2); // C30 requiere C22
        seminarioC.agregarCorrelativa(metodologiaInvestigacion2); // C31 requiere C22
        politicasPublicasProyectosIntervencionSocial.agregarCorrelativa(teoriaSocial1); // C32 requiere C9
        politicasPublicasProyectosIntervencionSocial.agregarCorrelativa(fundamentosCienciaPolitica); // C32 requiere C6
        tallerInvestigacion1.agregarCorrelativa(metodologiaInvestigacion2); // C33 requiere C22
        tallerInvestigacion1.agregarCorrelativa(analisisSociedadArgentinaContemporanea); // C33 requiere C24

        // Noveno cuatrimestre
        optativaA.agregarCorrelativa(teoriaSocial1); // C34 requiere C9
        optativaB.agregarCorrelativa(teoriaSocial1); // C35 requiere C9
        tallerInvestigacion2.agregarCorrelativa(tallerInvestigacion1); // C36 requiere C33
        examenIngles2Soc.agregarCorrelativa(examenIngles1Soc); // C37 requiere C17

        // Décimo cuatrimestre
        tallerIntegracionFinal.agregarCorrelativa(tallerInvestigacion2); // C38 requiere C36
        examenIngles3Soc.agregarCorrelativa(examenIngles2Soc); // C39 requiere C37

        // Crear planes de estudio
        PlanEstudio planSociologia = new PlanA("Licenciatura en Sociología");
        planSociologia.agregarMateriaObligatoria(introSociedadCulturaAmbienteSoc);
        planSociologia.agregarMateriaObligatoria(introPensamientoPoliticoSocial);
        planSociologia.agregarMateriaObligatoria(epistemologiaCienciasSociales);
        planSociologia.agregarMateriaObligatoria(introCalculoSoc);
        planSociologia.agregarMateriaObligatoria(fundamentosSociologia);
        planSociologia.agregarMateriaObligatoria(fundamentosCienciaPolitica);
        planSociologia.agregarMateriaObligatoria(introEconomiaSoc);
        planSociologia.agregarMateriaObligatoria(historiaSocialGeneral);
        planSociologia.agregarMateriaObligatoria(teoriaSocial1);
        planSociologia.agregarMateriaObligatoria(historiaSocialLatinoamericana);
        planSociologia.agregarMateriaObligatoria(metodologiaInvestigacionCienciasSociales);
        planSociologia.agregarMateriaObligatoria(macroeconomia1);
        planSociologia.agregarMateriaObligatoria(teoriaSocial2);
        planSociologia.agregarMateriaObligatoria(antropologiaSocial);
        planSociologia.agregarMateriaObligatoria(estadisticaSoc);
        planSociologia.agregarMateriaObligatoria(seminarioProblematicaFueguinaSoc);
        planSociologia.agregarMateriaObligatoria(examenIngles1Soc);
        planSociologia.agregarMateriaObligatoria(teoriaSocial3);
        planSociologia.agregarMateriaObligatoria(conflictoCambioSocial);
        planSociologia.agregarMateriaObligatoria(metodologiaInvestigacion1);
        planSociologia.agregarMateriaObligatoria(historiaSocialArgentinaSoc);
        planSociologia.agregarMateriaObligatoria(metodologiaInvestigacion2);
        planSociologia.agregarMateriaObligatoria(desarrolloSocialTerritorial);
        planSociologia.agregarMateriaObligatoria(analisisSociedadArgentinaContemporanea);
        planSociologia.agregarMateriaObligatoria(poblacionEstructuraSocial);
        planSociologia.agregarMateriaObligatoria(seminarioA);
        planSociologia.agregarMateriaObligatoria(sociologiaCultura);
        planSociologia.agregarMateriaObligatoria(sociologiaInstituciones);
        planSociologia.agregarMateriaObligatoria(sociologiaPolitica);
        planSociologia.agregarMateriaObligatoria(seminarioB);
        planSociologia.agregarMateriaObligatoria(seminarioC);
        planSociologia.agregarMateriaObligatoria(politicasPublicasProyectosIntervencionSocial);
        planSociologia.agregarMateriaObligatoria(tallerInvestigacion1);
        planSociologia.agregarMateriaObligatoria(optativaA);
        planSociologia.agregarMateriaObligatoria(optativaB);
        planSociologia.agregarMateriaObligatoria(tallerInvestigacion2);
        planSociologia.agregarMateriaObligatoria(examenIngles2Soc);
        planSociologia.agregarMateriaObligatoria(tallerIntegracionFinal);
        planSociologia.agregarMateriaObligatoria(examenIngles3Soc);
        planSociologia.agregarMateriaObligatoria(examenPortugues1Soc);

        // Crear carreras
        Carrera sociologiaC = new Carrera("Licenciatura en Sociología", planSociologia, 10);

        Estudiante estudiante5 = new Estudiante(005, "Silvia Melchior");
        estudiante5.setCarrera(sociologiaC);


        estudiante5.inscribirEnMateria(introSociedadCulturaAmbienteSoc);
        estudiante5.inscribirEnMateria(introPensamientoPoliticoSocial);
        estudiante5.inscribirEnMateria(epistemologiaCienciasSociales);
        estudiante5.inscribirEnMateria(introCalculoSoc);

        // Aprobar materias del primer cuatrimestre
        estudiante5.aprobarCursada(introSociedadCulturaAmbienteSoc);
        estudiante5.aprobarCursada(introPensamientoPoliticoSocial);
        estudiante5.aprobarCursada(epistemologiaCienciasSociales);
        estudiante5.aprobarCursada(introCalculoSoc);

        // Aprobar finales de algunas materias del primer cuatrimestre
        estudiante5.aprobarFinal(introSociedadCulturaAmbienteSoc);
        estudiante5.aprobarFinal(introPensamientoPoliticoSocial);
        estudiante5.aprobarFinal(epistemologiaCienciasSociales);
        estudiante5.aprobarFinal(introCalculoSoc);

        estudiante5.inscribirEnMateria(fundamentosSociologia);
        estudiante5.inscribirEnMateria(fundamentosCienciaPolitica);
        estudiante5.inscribirEnMateria(introEconomiaSoc);
        estudiante5.inscribirEnMateria(historiaSocialGeneral);

        // Aprobar materias del segundo cuatrimestre
        estudiante5.aprobarCursada(fundamentosSociologia);
        estudiante5.aprobarCursada(fundamentosCienciaPolitica);
        estudiante5.aprobarCursada(introEconomiaSoc);
        estudiante5.aprobarCursada(historiaSocialGeneral);

        // Aprobar finales de algunas materias del segundo cuatrimestre
        estudiante5.aprobarFinal(fundamentosSociologia);
        estudiante5.aprobarFinal(fundamentosCienciaPolitica);
        estudiante5.aprobarFinal(introEconomiaSoc);
        estudiante5.aprobarFinal(historiaSocialGeneral);

        estudiante5.inscribirEnMateria(teoriaSocial1);
        estudiante5.inscribirEnMateria(historiaSocialLatinoamericana);
        estudiante5.inscribirEnMateria(metodologiaInvestigacionCienciasSociales);
        estudiante5.inscribirEnMateria(macroeconomia1);

        // Aprobar materias del tercer cuatrimestre
        estudiante5.aprobarCursada(teoriaSocial1);
        estudiante5.aprobarCursada(historiaSocialLatinoamericana);
        estudiante5.aprobarCursada(metodologiaInvestigacionCienciasSociales);
        estudiante5.aprobarCursada(macroeconomia1);

        // Aprobar finales de algunas materias del tercer cuatrimestre
        estudiante5.aprobarFinal(teoriaSocial1);
        estudiante5.aprobarFinal(metodologiaInvestigacionCienciasSociales);
        estudiante5.aprobarFinal(macroeconomia1);
        estudiante5.aprobarFinal(historiaSocialLatinoamericana);

        estudiante5.inscribirEnMateria(teoriaSocial2);
        estudiante5.inscribirEnMateria(antropologiaSocial);
        estudiante5.inscribirEnMateria(estadisticaSoc);
        estudiante5.inscribirEnMateria(seminarioProblematicaFueguinaSoc);
        estudiante5.inscribirEnMateria(examenIngles1Soc);

        // Aprobar materias del cuarto cuatrimestre
        estudiante5.aprobarCursada(teoriaSocial2);
        estudiante5.aprobarCursada(antropologiaSocial);
        estudiante5.aprobarCursada(estadisticaSoc);
        estudiante5.aprobarCursada(seminarioProblematicaFueguinaSoc);
        estudiante5.aprobarCursada(examenIngles1Soc);

        // Aprobar finales de algunas materias del cuarto cuatrimestre
        estudiante5.aprobarFinal(teoriaSocial2);
        estudiante5.aprobarFinal(antropologiaSocial);
        estudiante5.aprobarFinal(estadisticaSoc);
        estudiante5.aprobarFinal(seminarioProblematicaFueguinaSoc);
        estudiante5.aprobarFinal(examenIngles1Soc);

        estudiante5.inscribirEnMateria(teoriaSocial3);
        estudiante5.inscribirEnMateria(conflictoCambioSocial);
        estudiante5.inscribirEnMateria(metodologiaInvestigacion1);
        estudiante5.inscribirEnMateria(historiaSocialArgentinaSoc);

        // Aprobar materias del quinto cuatrimestre
        estudiante5.aprobarCursada(teoriaSocial3);
        estudiante5.aprobarCursada(conflictoCambioSocial);
        estudiante5.aprobarCursada(metodologiaInvestigacion1);
        estudiante5.aprobarCursada(historiaSocialArgentinaSoc);

        // Aprobar finales de algunas materias del quinto cuatrimestre
        estudiante5.aprobarFinal(teoriaSocial3);
        estudiante5.aprobarFinal(conflictoCambioSocial);
        estudiante5.aprobarFinal(metodologiaInvestigacion1);
        estudiante5.aprobarFinal(historiaSocialArgentinaSoc);

        estudiante5.inscribirEnMateria(metodologiaInvestigacion2);
        estudiante5.inscribirEnMateria(desarrolloSocialTerritorial);
        estudiante5.inscribirEnMateria(analisisSociedadArgentinaContemporanea);
        estudiante5.inscribirEnMateria(poblacionEstructuraSocial);

        // Aprobar materias del sexto cuatrimestre
        estudiante5.aprobarCursada(metodologiaInvestigacion2);
        estudiante5.aprobarCursada(desarrolloSocialTerritorial);
        estudiante5.aprobarCursada(analisisSociedadArgentinaContemporanea);
        estudiante5.aprobarCursada(poblacionEstructuraSocial);

        // Aprobar finales de algunas materias del sexto cuatrimestre
        estudiante5.aprobarFinal(metodologiaInvestigacion2);
        estudiante5.aprobarFinal(analisisSociedadArgentinaContemporanea);
        estudiante5.aprobarFinal(poblacionEstructuraSocial);
        estudiante5.aprobarFinal(desarrolloSocialTerritorial);

        estudiante5.inscribirEnMateria(seminarioA);
        estudiante5.inscribirEnMateria(sociologiaCultura);
        estudiante5.inscribirEnMateria(sociologiaInstituciones);
        estudiante5.inscribirEnMateria(sociologiaPolitica);

        // Aprobar materias del séptimo cuatrimestre
        estudiante5.aprobarCursada(seminarioA);
        estudiante5.aprobarCursada(sociologiaCultura);
        estudiante5.aprobarCursada(sociologiaInstituciones);
        estudiante5.aprobarCursada(sociologiaPolitica);

        // Aprobar finales de algunas materias del séptimo cuatrimestre
        estudiante5.aprobarFinal(seminarioA);
        estudiante5.aprobarFinal(sociologiaCultura);
        estudiante5.aprobarFinal(sociologiaInstituciones);
        estudiante5.aprobarFinal(sociologiaPolitica);

        estudiante5.inscribirEnMateria(seminarioB);
        estudiante5.inscribirEnMateria(seminarioC);
        estudiante5.inscribirEnMateria(politicasPublicasProyectosIntervencionSocial);
        estudiante5.inscribirEnMateria(tallerInvestigacion1);

        // Aprobar materias del octavo cuatrimestre
        estudiante5.aprobarCursada(seminarioB);
        estudiante5.aprobarCursada(seminarioC);
        estudiante5.aprobarCursada(politicasPublicasProyectosIntervencionSocial);
        estudiante5.aprobarCursada(tallerInvestigacion1);

        // Aprobar finales de algunas materias del octavo cuatrimestre
        estudiante5.aprobarFinal(seminarioB);
        estudiante5.aprobarFinal(politicasPublicasProyectosIntervencionSocial);

        // Agregar carreras al sistema
        sistema.getCarreras().add(sociologiaC);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planSociologia);

        sistema.getEstudiantes().add(estudiante5);

    }
}