package views;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import models.*;

class InscribirEstudianteCarrera extends JDialog {
    public InscribirEstudianteCarrera(SistemaUniversitario parent) {
        super(parent, "Inscribir Estudiante en Carrera", true);
        setLayout(new BorderLayout(10, 10));
        setSize(500, 400); // Tamaño fijo
        setLocationRelativeTo(parent); // Centrar la ventana
        getContentPane().setBackground(SistemaUniversitario.COLOR_FONDO);

        // Modelo para la lista de estudiantes
        DefaultListModel<Estudiante> estudianteModel = new DefaultListModel<>();
        for (Estudiante estudiante : parent.getEstudiantes()) {
            estudianteModel.addElement(estudiante);
        }

        // Lista de estudiantes
        JList<Estudiante> listaEstudiantes = new JList<>(estudianteModel);
        listaEstudiantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollEstudiantes = new JScrollPane(listaEstudiantes);
        scrollEstudiantes.setPreferredSize(new Dimension(300, 150));

        // ComboBox para seleccionar carrera
        JComboBox<Carrera> comboCarrera = new JComboBox<>(
                new Vector<>(parent.getCarreras())
        );

        // Panel de selección
        JPanel selectionPanel = new JPanel(new BorderLayout(5, 5));
        selectionPanel.setBackground(SistemaUniversitario.COLOR_FONDO);
        selectionPanel.add(new JLabel("Seleccione un estudiante:"), BorderLayout.NORTH);
        selectionPanel.add(scrollEstudiantes, BorderLayout.CENTER);

        // Panel para carreras
        JPanel carreraPanel = new JPanel(new BorderLayout(5, 5));
        carreraPanel.setBackground(SistemaUniversitario.COLOR_FONDO);
        carreraPanel.add(new JLabel("Seleccione una carrera:"), BorderLayout.NORTH);
        carreraPanel.add(comboCarrera, BorderLayout.CENTER);

        // Botón de inscripción
        JButton botonInscribir = new JButton("Inscribir");
        botonInscribir.addActionListener(e -> {
            Estudiante estudiante = listaEstudiantes.getSelectedValue();
            Carrera carrera = (Carrera) comboCarrera.getSelectedItem();

            if (estudiante != null && carrera != null) {
                estudiante.setCarrera(carrera);
                JOptionPane.showMessageDialog(this,
                        "Estudiante inscrito exitosamente en " + carrera.getNombre());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Por favor seleccione un estudiante y una carrera");
            }
        });

        // Buscar estudiante
        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
        searchPanel.setBackground(SistemaUniversitario.COLOR_FONDO);
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            for (int i = 0; i < estudianteModel.size(); i++) {
                Estudiante estudiante = estudianteModel.get(i);
                if (estudiante.getNombre().toLowerCase().contains(query) ||
                        String.valueOf(estudiante.getLegajo()).contains(query)) {
                    listaEstudiantes.setSelectedValue(estudiante, true);
                    listaEstudiantes.ensureIndexIsVisible(i);
                    break;
                }
            }
        });

        searchPanel.add(new JLabel("Buscar estudiante:"), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Agregar paneles al frame
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(SistemaUniversitario.COLOR_FONDO);
        mainPanel.add(selectionPanel, BorderLayout.NORTH);
        mainPanel.add(carreraPanel, BorderLayout.CENTER);
        mainPanel.add(botonInscribir, BorderLayout.SOUTH);

        add(searchPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}