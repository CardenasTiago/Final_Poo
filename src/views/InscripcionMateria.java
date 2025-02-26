package views;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import models.*;

class InscripcionMateria extends JDialog {
    public InscripcionMateria(SistemaUniversitario parent) {
        super(parent, "Inscripción a Materia", true);
        setLayout(new BorderLayout(10, 10));

        // Panel para selección de estudiante
        JPanel panelEstudiante = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Estudiante> comboEstudiantes = new JComboBox<>(
                new Vector<>(parent.getEstudiantes())
        );
        panelEstudiante.add(new JLabel("Estudiante: "));
        panelEstudiante.add(comboEstudiantes);

        // Panel para lista de materias disponibles
        JPanel panelMaterias = new JPanel(new BorderLayout());
        DefaultListModel<Materia> modeloMaterias = new DefaultListModel<>();
        JList<Materia> listaMaterias = new JList<>(modeloMaterias);
        panelMaterias.add(new JLabel("Materias Disponibles:"), BorderLayout.NORTH);
        panelMaterias.add(new JScrollPane(listaMaterias), BorderLayout.CENTER);

        // Panel de información
        JTextArea areaInfo = new JTextArea(5, 40);
        areaInfo.setEditable(false);
        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.add(new JLabel("Información de la materia:"), BorderLayout.NORTH);
        panelInfo.add(new JScrollPane(areaInfo), BorderLayout.CENTER);

        // Actualizar lista de materias cuando se selecciona un estudiante
        comboEstudiantes.addActionListener(e -> {
            Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
            if (estudiante != null && estudiante.getCarrera() != null) {
                modeloMaterias.clear();
                List<Materia> materiasDisponibles = estudiante.getCarrera().getMateriasDisponibles(estudiante);
                for (Materia materia : materiasDisponibles) {
                    modeloMaterias.addElement(materia);
                }
            }
        });

        // Mostrar información de la materia seleccionada
        listaMaterias.addListSelectionListener(e -> {
            Materia materia = listaMaterias.getSelectedValue();
            if (materia != null) {
                StringBuilder info = new StringBuilder();
                info.append("Código: ").append(materia.getCodigo()).append("\n");
                info.append("Nombre: ").append(materia.getNombre()).append("\n");
                info.append("Cuatrimestre: ").append(materia.getCuatrimestre()).append("\n");
                info.append("Correlativas: ").append(
                        materia.getCorrelativas().stream()
                                .map(Materia::getNombre)
                                .collect(Collectors.joining(", "))
                );
                areaInfo.setText(info.toString());
            }
        });

        // Botón de inscripción
        JButton botonInscribir = new JButton("Inscribir");
        botonInscribir.addActionListener(e -> {
            Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
            Materia materia = listaMaterias.getSelectedValue();

            if (estudiante != null && materia != null) {
                // Verificar correlativas
                boolean correlativasAprobadas = materia.getCorrelativas().stream()
                        .allMatch(correlativa -> estudiante.getMateriasAprobadas().contains(correlativa));

                if (!correlativasAprobadas) {
                    JOptionPane.showMessageDialog(this,
                            "No cumple con las correlativas necesarias para inscribirse a " + materia.getNombre());
                    return;
                }

                // Verificar plan de estudio
                PlanEstudio plan = estudiante.getCarrera().getPlanEstudio();
                if (!plan.puedeRecursarMateria(estudiante, materia)) {
                    JOptionPane.showMessageDialog(this,
                            "No cumple con los requisitos del plan de estudio para inscribirse a " + materia.getNombre());
                    return;
                }

                // Inscribir al estudiante
                estudiante.inscribirEnMateria(materia);
                JOptionPane.showMessageDialog(this,
                        "Inscripción exitosa a " + materia.getNombre());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Por favor seleccione un estudiante y una materia");
            }
        });

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(panelEstudiante, BorderLayout.NORTH);
        panelPrincipal.add(panelMaterias, BorderLayout.CENTER);
        panelPrincipal.add(panelInfo, BorderLayout.SOUTH);

        add(panelPrincipal, BorderLayout.CENTER);
        add(botonInscribir, BorderLayout.SOUTH);

        setSize(500, 600);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}