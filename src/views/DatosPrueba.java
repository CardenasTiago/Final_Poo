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
        Materia introProblematicaAmbiental = new Materia("ICA003", "Introducción a la Problemática Ambiental", true, 2);
        Materia fisica1 = new Materia("FI001", "Física I para Ciencias Naturales", true, 2);
        Materia matematica2 = new Materia("MA002", "Matemática II para Ciencias Naturales", true, 2);
        Materia quimicaOrganica = new Materia("QU002", "Química Orgánica", true, 2);

        // Crear materias del segundo año
        Materia introBiologia = new Materia("BIO001", "Introducción a la Biología", true, 3);
        Materia introGeologia = new Materia("GEO001", "Introducción a la Geología", true, 3);
        Materia sociedadAmbiente = new Materia("ICA004", "Sociedad y Ambiente", true, 3);
        Materia legislacionAmbiental = new Materia("DER001", "Legislación Ambiental", true, 3);
        Materia diversidadBiologica = new Materia("BIO002", "Diversidad Biológica", true, 4);
        Materia geografiaFisica1 = new Materia("GEO002", "Geografía Física para Ciencias Ambientales", true, 4);
        Materia economiaAmbiente = new Materia("ECO001", "Economía y Ambiente", true, 4);
        Materia estadistica1 = new Materia("EST001", "Estadística I para Ciencias Naturales", true, 4);

        // Crear materias del tercer año
        Materia quimicaAmbiental = new Materia("QU003", "Química Ambiental y Contaminación", true, 5);
        Materia energiasRenovables = new Materia("ICA005", "Energías Renovables", true, 5);
        Materia ecologiaGeneral = new Materia("BIO003", "Ecología General", true, 5);
        Materia comunicacionAmbiental = new Materia("ICA006", "Comunicación Ambiental", true, 5);
        Materia hidrologia = new Materia("GEO003", "Hidrología y Gestión del Agua", true, 6);
        Materia tecnicasTratamiento = new Materia("ICA007", "Técnicas de Tratamiento y Saneamiento", true, 6);
        Materia filosofiaCiencia = new Materia("FIL001", "Filosofía, Epistemología y Metodología de la Ciencia", true, 6);
        Materia teledeteccionSIG = new Materia("GEO004", "Teledetección y SIG", true, 6);

        // Crear materias del cuarto año
        Materia conservacionBiodiversidad = new Materia("BIO004", "Conservación de la Biodiversidad", true, 7);
        Materia administracionAmbiental = new Materia("ICA008", "Administración Ambiental", true, 7);
        Materia gestionAmbientesUrbanos = new Materia("ICA009", "Gestión de Ambientes Urbanos", true, 7);
        Materia tallerMetodologia = new Materia("ICA010", "Taller de Metodología de la Investigación", true, 7);
        Materia gestionAmbientesRurales = new Materia("ICA011", "Gestión de Ambientes Rurales", true, 8);
        Materia gestionRecursosNaturales = new Materia("ICA012", "Gestión Integral de Recursos Naturales", true, 8);
        Materia cambioGlobal = new Materia("ICA013", "Cambio Global", true, 8);
        Materia seminarioFueguino = new Materia("ICA014", "Seminario de Problemática Fueguina", true, 8);

        // Crear materias del quinto año
        Materia desarrolloEconomicoSostenible = new Materia("ECO002", "Desarrollo Económico Sostenible", true, 9);
        Materia ordenamientoTerritorial = new Materia("ICA015", "Ordenamiento Ambiental del Territorio", true, 9);
        Materia tallerEvaluacionImpacto = new Materia("ICA016", "Taller de Evaluación de Impacto Ambiental", true, 10);
        Materia tallerTrabajoFinal = new Materia("ICA017", "Taller de Trabajo Final", true, 10);
        Materia optativa1 = new Materia("OPT001", "Optativa I", false, 9);
        Materia optativa2 = new Materia("OPT002", "Optativa II", false, 10);

        // Definir correlativas
        // Segundo año
        introBiologia.agregarCorrelativa(introCienciasAmbientales); // BIO001 requiere ICA001
        introGeologia.agregarCorrelativa(introCienciasAmbientales); // GEO001 requiere ICA001
        sociedadAmbiente.agregarCorrelativa(introSociedadCulturaAmbiente); // ICA004 requiere ICA002
        legislacionAmbiental.agregarCorrelativa(introProblematicaAmbiental); // DER001 requiere ICA003
        diversidadBiologica.agregarCorrelativa(introBiologia); // BIO002 requiere BIO001
        geografiaFisica1.agregarCorrelativa(introGeologia); // GEO002 requiere GEO001
        economiaAmbiente.agregarCorrelativa(introProblematicaAmbiental); // ECO001 requiere ICA003
        estadistica1.agregarCorrelativa(matematica1); // EST001 requiere MA001

        // Tercer año
        quimicaAmbiental.agregarCorrelativa(quimicaGeneral); // QU003 requiere QU001
        energiasRenovables.agregarCorrelativa(introProblematicaAmbiental); // ICA005 requiere ICA003
        ecologiaGeneral.agregarCorrelativa(introBiologia); // BIO003 requiere BIO001
        comunicacionAmbiental.agregarCorrelativa(sociedadAmbiente); // ICA006 requiere ICA004
        hidrologia.agregarCorrelativa(geografiaFisica1); // GEO003 requiere GEO002
        tecnicasTratamiento.agregarCorrelativa(quimicaAmbiental); // ICA007 requiere QU003
        filosofiaCiencia.agregarCorrelativa(introSociedadCulturaAmbiente); // FIL001 requiere ICA002
        teledeteccionSIG.agregarCorrelativa(geografiaFisica1); // GEO004 requiere GEO002

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
        ordenamientoTerritorial.agregarCorrelativa(geografiaFisica1); // ICA015 requiere GEO002
        tallerEvaluacionImpacto.agregarCorrelativa(legislacionAmbiental); // ICA016 requiere DER001
        tallerTrabajoFinal.agregarCorrelativa(tallerMetodologia); // ICA017 requiere ICA010
        optativa1.agregarCorrelativa(conservacionBiodiversidad); // OPT001 requiere BIO004
        optativa2.agregarCorrelativa(conservacionBiodiversidad); // OPT002 requiere BIO004

        // Crear planes de estudio
        PlanEstudio planCienciasAmbientales = new PlanA("Licenciatura en Ciencias Ambientales");
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

        // Agregar carreras al sistema
        sistema.getCarreras().add(cienciasAmbientales);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planCienciasAmbientales);



        //INGENIERIA
        // Crear materias del primer año
        Materia introCalculo = new Materia("C2", "Introducción al Cálculo", true, 1);
        Materia introSociedadCulturaAmbienteIng = new Materia("C1", "Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", true, 1);
        Materia sistemasRepresentacion = new Materia("ING2", "Sistemas de Representación", true, 1);
        Materia quimica = new Materia("ABG2", "Química", true, 1);
        Materia introIngenieria = new Materia("ING1", "Introducción a la Ingeniería", true, 1);

        // Crear materias del segundo año
        Materia matematica1Ing = new Materia("C3", "Matemática I", true, 2);
        Materia fisica1Ing = new Materia("ING3", "Física I", true, 2);
        Materia pensamientoSistemico = new Materia("ING4", "Pensamiento Sistémico", true, 2);
        Materia algebraIng = new Materia("C4", "Álgebra", true, 2);

        // Crear materias del tercer año
        Materia introEconomia = new Materia("ECO1", "Introducción a la Economía", true, 3);
        Materia matematica2Ing = new Materia("C5", "Matemática II", true, 3);
        Materia mecanicaElemental = new Materia("ING7", "Mecánica Elemental", true, 3);
        Materia programacionMetodosNumericos = new Materia("ING8", "Programación y Métodos Numéricos", true, 3);

        // Crear materias del cuarto año
        Materia matematica3 = new Materia("ING40", "Matemática III Para Ingenieros", true, 4);
        Materia estaticaResistenciaMateriales = new Materia("ING10", "Estática y Resistencia de los Materiales", true, 4);
        Materia fisica2 = new Materia("ING5", "Física II", true, 4);
        Materia estadisticaIng = new Materia("ECO11", "Estadística", true, 4);
        Materia examenIngles1 = new Materia("ExID1", "Examen Nivel I de Inglés", true, 4);

        // Crear materias del quinto año
        Materia organizacionProduccion1 = new Materia("ING6", "Organización de la Producción I", true, 5);
        Materia mecanicaFluidos = new Materia("ING12", "Mecánica de los Fluidos", true, 5);
        Materia cienciaMateriales = new Materia("ING14", "Ciencia de los Materiales", true, 5);
        Materia termodinamica = new Materia("ING18", "Termodinámica", true, 5);
        Materia electrotecnia = new Materia("ING19", "Electrotecnia", true, 5);
        Materia seminarioEntrevistas = new Materia("ING91", "Seminario de entrevistas profesionales", true, 5);

        // Crear materias del sexto año
        Materia procesosFabricacion = new Materia("ING16", "Procesos de Fabricación", true, 6);
        Materia organizacionProduccion2 = new Materia("ING17", "Organización de la Producción II", true, 6);
        Materia seminarioProblematicaFueguina = new Materia("SEM1", "Seminario de Problemática Fueguina", true, 6);
        Materia mecanismosElementosMaquinas = new Materia("ING21", "Mecanismos y Elementos de Máquinas", true, 6);
        Materia termotecniaMaquinariaTermica = new Materia("ING22", "Termotecnia y Maquinaria Térmica", true, 6);

        // Crear materias del séptimo año
        Materia marketingInteligenciaComercial = new Materia("ING11", "Marketing e Inteligencia Comercial", true, 7);
        Materia calidad = new Materia("ING20", "Calidad", true, 7);
        Materia investigacionOperativa = new Materia("ING23", "Investigación Operativa", true, 7);
        Materia sistemasControlIndustrial = new Materia("ING25", "Sistemas de Control Industrial", true, 7);
        Materia costosIndustriales = new Materia("ING28", "Costos Industriales", true, 7);

        // Crear materias del octavo año
        Materia mantenimiento = new Materia("ING24", "Mantenimiento", true, 8);
        Materia desarrolloProductos = new Materia("ING26", "Desarrollo de Productos", true, 8);
        Materia instalacionesIndustriales = new Materia("ING29", "Instalaciones Industriales", true, 8);
        Materia inversionProyectos = new Materia("ING32", "Inversión y Proyectos", true, 8);
        Materia examenIngles2 = new Materia("ExID2", "Examen Nivel II de Inglés", true, 8);

        // Crear materias del noveno año
        Materia recursosHumanos = new Materia("ING27", "Recursos Humanos", true, 9);
        Materia seguridadHigieneGestionAmbiental = new Materia("ING41", "Seguridad e Higiene y Gestión Ambiental", true, 9);
        Materia optativa1Ing = new Materia("OPT30", "Optativa 1", false, 9);
        Materia legislacion = new Materia("ING34", "Legislación", true, 9);
        Materia tallerCreacionEmpresas = new Materia("GE13", "Taller de Creación de Empresas", true, 9);
        Materia trabajoFinal1 = new Materia("TFING1", "Trabajo Final 1", true, 9);
        Materia examenPortugues1 = new Materia("ExID4", "Examen Nivel I de Portugués", true, 9);

        // Crear materias del décimo año
        Materia direccionIndustrialGerenciamiento = new Materia("ING15", "Dirección Industrial y Gerenciamiento", true, 10);
        Materia distribucionLogistica = new Materia("ING30", "Distribución y Logística", true, 10);
        Materia seminarioLeanManufacturing = new Materia("ING33", "Seminario Lean Manufacturing y Teoría de las Restricciones", true, 10);
        Materia optativa2Ing = new Materia("OPT31", "Optativa 2", false, 10);
        Materia seminarioPensamientoSistemico = new Materia("ING42", "Seminario de Pensamiento Sistémico", true, 10);
        Materia trabajoFinal2 = new Materia("TFING2", "Trabajo Final 2", true, 10);
        Materia examenIngles3 = new Materia("ExID3", "Examen Nivel III de Inglés", true, 10);
        Materia practicaProfesionalSupervisada = new Materia("PPSING", "Práctica Profesional Supervisada", true, 10);

        // Definir correlativas
        // Segundo año
        matematica1Ing.agregarCorrelativa(introCalculo); // C3 requiere C2
        fisica1Ing.agregarCorrelativa(introCalculo); // ING3 requiere C2
        pensamientoSistemico.agregarCorrelativa(introSociedadCulturaAmbienteIng); // ING4 requiere C1
        pensamientoSistemico.agregarCorrelativa(introIngenieria); // ING4 requiere ING1
        algebraIng.agregarCorrelativa(introCalculo); // C4 requiere C2

        // Tercer año
        matematica2Ing.agregarCorrelativa(matematica1Ing); // C5 requiere C3
        matematica2Ing.agregarCorrelativa(algebraIng); // C5 requiere C4
        mecanicaElemental.agregarCorrelativa(matematica1Ing); // ING7 requiere C3
        mecanicaElemental.agregarCorrelativa(fisica1Ing); // ING7 requiere ING3
        programacionMetodosNumericos.agregarCorrelativa(matematica1Ing); // ING8 requiere C3
        programacionMetodosNumericos.agregarCorrelativa(algebraIng); // ING8 requiere C4

        // Cuarto año
        matematica3.agregarCorrelativa(matematica2Ing); // ING40 requiere C5
        estaticaResistenciaMateriales.agregarCorrelativa(quimica); // ING10 requiere ABG2
        estaticaResistenciaMateriales.agregarCorrelativa(sistemasRepresentacion); // ING10 requiere ING2
        estaticaResistenciaMateriales.agregarCorrelativa(mecanicaElemental); // ING10 requiere ING7
        fisica2.agregarCorrelativa(matematica2Ing); // ING5 requiere C5
        fisica2.agregarCorrelativa(mecanicaElemental); // ING5 requiere ING7
        estadisticaIng.agregarCorrelativa(matematica2Ing); // ECO11 requiere C5

        // Quinto año
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

        // Sexto año
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

        // Séptimo año
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

        // Octavo año
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

        // Noveno año
        recursosHumanos.agregarCorrelativa(calidad); // ING27 requiere ING20
        seguridadHigieneGestionAmbiental.agregarCorrelativa(calidad); // ING41 requiere ING20
        optativa1Ing.agregarCorrelativa(mantenimiento); // OPT30 requiere ING24
        optativa1Ing.agregarCorrelativa(desarrolloProductos); // OPT30 requiere ING26
        optativa1Ing.agregarCorrelativa(inversionProyectos); // OPT30 requiere ING32
        legislacion.agregarCorrelativa(calidad); // ING34 requiere ING20
        tallerCreacionEmpresas.agregarCorrelativa(desarrolloProductos); // GE13 requiere ING26
        trabajoFinal1.agregarCorrelativa(instalacionesIndustriales); // TFING1 requiere ING29
        trabajoFinal1.agregarCorrelativa(inversionProyectos); // TFING1 requiere ING32

        // Décimo año
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
        PlanEstudio planIngenieriaIndustrial = new PlanA("Ingeniería Industrial");
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

        // Agregar carreras al sistema
        sistema.getCarreras().add(ingenieriaIndustrial);

        // Agregar planes de estudio al sistema
        sistema.getPlanesEstudio().add(planIngenieriaIndustrial);



        //TURISMO
         // Crear materias del primer año
         Materia introTurismo = new Materia("T01", "Introducción al Turismo", true, 1);
         Materia geografiaFisica = new Materia("T02", "Geografía Física", true, 1);
         Materia sociologia = new Materia("T03", "Sociología", true, 1);
         Materia epistemologia = new Materia("T04", "Epistemología", true, 1);
         Materia seminarioPracticas = new Materia("T05", "Seminario: Introducción a las Prácticas Profesionales", true, 1);
 
         // Crear materias del segundo año
         Materia serviciosTransporte = new Materia("T06", "Servicios Turísticos. Transporte", true, 2);
         Materia serviciosAlojamiento = new Materia("T07", "Servicios Turísticos. Alojamiento", true, 2);
         Materia ecologiaConservacion = new Materia("T08", "Ecología y Conservación", true, 2);
         Materia psicologiaSocial = new Materia("T09", "Psicología Social", true, 2);
         Materia parquesNacionales = new Materia("T10", "Parques Nacionales", true, 2);
         Materia geografiaHumana = new Materia("T11", "Geografía Humana", true, 2);
         Materia historiaSocialArgentina = new Materia("T12", "Historia Social Argentina", true, 2);
         Materia practicaProfesional1 = new Materia("T13", "Práctica Profesional I", true, 2);
 
         // Crear materias del tercer año
         Materia serviciosAgenciasViajes = new Materia("T14", "Servicios Turísticos. Agencias de Viajes", true, 3);
         Materia psicosociologiaGrupos = new Materia("T15", "Psicosociología de los Grupos y de las Instituciones", true, 3);
         Materia patrimonioCultural = new Materia("T16", "Patrimonio Cultural", true, 3);
         Materia metodologiaInvestigacion = new Materia("T17", "Metodología de la Investigación Social", true, 3);
         Materia recursosJuridicos = new Materia("T18", "Recursos Jurídicos", true, 3);
         Materia teoriaAdministracion = new Materia("T19", "Teoría de la Administración", true, 3);
         Materia practicaProfesional2 = new Materia("T20", "Práctica Profesional II", true, 3);
 
         // Crear materias del cuarto año
         Materia administracionEmpresasTurismo = new Materia("T21", "Administración de Empresas Turísticas", true, 4);
         Materia economia = new Materia("T22", "Economía", true, 4);
         Materia antropologiaCultural = new Materia("T23", "Antropología Cultural", true, 4);
         Materia politicaTuristica = new Materia("T24", "Política Turística", true, 4);
         Materia historiaAmericana = new Materia("T25", "Historia Americana", true, 4);
         Materia practicaProfesional3 = new Materia("T26", "Práctica Profesional III", true, 4);
 
         // Crear materias del quinto año
         Materia planificacionTuristica = new Materia("T27", "Planificación Turística", true, 5);
         Materia investigacionTuristica = new Materia("T28", "Investigación Turística", true, 5);
         Materia practicaProfesional4 = new Materia("T29", "Práctica Profesional IV", true, 5);
         Materia seminarioOptativo1 = new Materia("T30", "Seminario Optativo I", false, 5);
         Materia seminarioOptativo2 = new Materia("T31", "Seminario Optativo II", false, 5);
         Materia tesinaGrado = new Materia("T32", "Tesina de Grado", true, 5);
 
         // Definir correlativas
         // Segundo año
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
 
         // Tercer año
         serviciosAgenciasViajes.agregarCorrelativa(introTurismo); // T14 requiere T01
         serviciosAgenciasViajes.agregarCorrelativa(serviciosTransporte); // T14 requiere T06
         serviciosAgenciasViajes.agregarCorrelativa(serviciosAlojamiento); // T14 requiere T07
         psicosociologiaGrupos.agregarCorrelativa(psicologiaSocial); // T15 requiere T09
         patrimonioCultural.agregarCorrelativa(historiaSocialArgentina); // T16 requiere T12
         metodologiaInvestigacion.agregarCorrelativa(epistemologia); // T17 requiere T04
         practicaProfesional2.agregarCorrelativa(serviciosTransporte); // T20 requiere T06
         practicaProfesional2.agregarCorrelativa(serviciosAlojamiento); // T20 requiere T07
         practicaProfesional2.agregarCorrelativa(practicaProfesional1); // T20 requiere T13
 
         // Cuarto año
         administracionEmpresasTurismo.agregarCorrelativa(serviciosAgenciasViajes); // T21 requiere T14
         administracionEmpresasTurismo.agregarCorrelativa(teoriaAdministracion); // T21 requiere T19
         politicaTuristica.agregarCorrelativa(introTurismo); // T24 requiere T01
         politicaTuristica.agregarCorrelativa(sociologia); // T24 requiere T03
         politicaTuristica.agregarCorrelativa(psicosociologiaGrupos); // T24 requiere T15
         historiaAmericana.agregarCorrelativa(historiaSocialArgentina); // T25 requiere T12
         practicaProfesional3.agregarCorrelativa(serviciosAgenciasViajes); // T26 requiere T14
         practicaProfesional3.agregarCorrelativa(practicaProfesional2); // T26 requiere T20
 
         // Quinto año
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
 
         // Agregar carreras al sistema
         sistema.getCarreras().add(turismo);
 
         // Agregar planes de estudio al sistema
         sistema.getPlanesEstudio().add(planTurismo);

         

    }
}