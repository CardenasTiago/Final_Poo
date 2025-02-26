package views;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import models.*;

public class SistemaUniversitario extends JFrame {
    // Definición de colores del tema oscuro
    public static final Color COLOR_FONDO = new Color(32, 33, 36);      // Gris muy oscuro
    public static final Color COLOR_BOTON = new Color(60, 63, 65);      // Gris oscuro
    public static final Color COLOR_BOTON_HOVER = new Color(75, 78, 80); // Gris medio
    public static final Color COLOR_TEXTO = new Color(255, 255, 255);   // Blanco
    public static final Color COLOR_BORDE = new Color(90, 90, 90);     // Gris claro

    private List<Estudiante> estudiantes;
    private List<Carrera> carreras;
    private List<PlanEstudio> planesEstudio;

    public SistemaUniversitario() {
        configurarVentana();
        inicializarListas();
        inicializarDatosPrueba();
        crearInterfaz();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Universitaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_FONDO);
    }

    private void inicializarListas() {
        estudiantes = new ArrayList<>();
        carreras = new ArrayList<>();
        planesEstudio = new ArrayList<>();
    }

    private void crearInterfaz() {
        // Panel principal con GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(COLOR_FONDO);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        JLabel titulo = new JLabel("Sistema de Gestión Universitaria", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(COLOR_TEXTO);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titulo, gbc);

        // Panel de botones
        JPanel botonesPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        botonesPanel.setBackground(COLOR_FONDO);

        // Crear botones con estilo moderno oscuro
        JButton[] botones = {
            crearBoton("Agregar Estudiante", e -> new AgregarEstudiante(this)),
            crearBoton("Agregar Carrera", e -> new AgregarCarrera(this)),
            crearBoton("Inscribir en Carrera", e -> new InscribirEstudianteCarrera(this)),
            crearBoton("Inscribir en Materia", e -> new InscripcionMateria(this)),
            crearBoton("Verificar Finalización", e -> verificarFinalizacionCarrera()),
            crearBoton("Gestionar Notas", e -> new GestionNotas(this).setVisible(true))
        };

        for (JButton boton : botones) {
            botonesPanel.add(boton);
        }

        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(botonesPanel, gbc);

        // Agregar panel principal
        add(mainPanel);
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 2),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        boton.setBackground(COLOR_BOTON);
        boton.setForeground(COLOR_TEXTO);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.addActionListener(listener);

        // Efectos hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(COLOR_BOTON_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(COLOR_BOTON);
            }
        });

        return boton;
    }

    private void inicializarDatosPrueba() {
        // Crear algunas materias
        Materia prog1 = new Materia("PRG1", "Programación I", true, 1);
        Materia mate1 = new Materia("MAT1", "Matemática I", true, 1);
        Materia prog2 = new Materia("PRG2", "Programación II", true, 2);
        prog2.agregarCorrelativa(prog1);

        // Crear un plan de estudio (Plan A)
        PlanEstudio planA = new PlanA();
        planA.agregarMateriaObligatoria(prog1);
        planA.agregarMateriaObligatoria(mate1);
        planA.agregarMateriaObligatoria(prog2);

        // Crear una carrera con el plan de estudio
        Carrera sistemas = new Carrera("Licenciatura en Sistemas", planA, 2);
        carreras.add(sistemas);

        // Crear un estudiante
        Estudiante estudiante = new Estudiante(1001, "Juan Pérez");
        estudiante.setCarrera(sistemas);
        estudiantes.add(estudiante);

        // Agregar planes de estudio
        planesEstudio.add(planA);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public List<PlanEstudio> getPlanesEstudio() {
        return planesEstudio;
    }

    private void verificarFinalizacionCarrera() {
        if (estudiantes.isEmpty()) {
            mostrarMensaje("No hay estudiantes registrados");
            return;
        }

        // Personalizar el JOptionPane para el tema oscuro
        UIManager.put("OptionPane.background", COLOR_FONDO);
        UIManager.put("Panel.background", COLOR_FONDO);
        UIManager.put("OptionPane.messageForeground", COLOR_TEXTO);

        Estudiante estudiante = (Estudiante) JOptionPane.showInputDialog(
            this,
            "Seleccione un estudiante:",
            "Verificar Finalización",
            JOptionPane.QUESTION_MESSAGE,
            null,
            estudiantes.toArray(),
            estudiantes.get(0)
        );

        if (estudiante != null) {
            boolean completado = estudiante.getCarrera().haCompletado(estudiante);
            String mensaje = completado ?
                "El estudiante ha completado la carrera" :
                "El estudiante aún no ha completado la carrera";
            mostrarMensaje(mensaje);
        }
    }

    private void mostrarMensaje(String mensaje) {
        // Configurar el look and feel de los diálogos
        UIManager.put("OptionPane.background", COLOR_FONDO);
        UIManager.put("Panel.background", COLOR_FONDO);
        UIManager.put("OptionPane.messageForeground", COLOR_TEXTO);

        JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Información",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaUniversitario sistema = new SistemaUniversitario();
            sistema.setVisible(true);
        });
    }
}