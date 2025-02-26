package views;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import models.*;

class GestionNotas extends JDialog {
    public GestionNotas(SistemaUniversitario parent) {
        super(parent, "Gestión de Notas", true);
        setLayout(new BorderLayout(10, 10));

        // Panel de selección de estudiante y materia
        JPanel panelSeleccion = new JPanel(new GridLayout(2, 2, 5, 5));
        JComboBox<Estudiante> comboEstudiantes = new JComboBox<>(
                new Vector<>(parent.getEstudiantes())
        );
        DefaultComboBoxModel<Materia> modeloMaterias = new DefaultComboBoxModel<>();
        JComboBox<Materia> comboMaterias = new JComboBox<>(modeloMaterias);

        panelSeleccion.add(new JLabel("Estudiante:"));
        panelSeleccion.add(comboEstudiantes);
        panelSeleccion.add(new JLabel("Materia:"));
        panelSeleccion.add(comboMaterias);

        // Panel de notas
        JPanel panelNotas = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField campoParcial = new JTextField();
        JTextField campoFinal = new JTextField();
        JCheckBox checkPromocion = new JCheckBox("Materia promocionable");

        panelNotas.add(new JLabel("Nota Parcial:"));
        panelNotas.add(campoParcial);
        panelNotas.add(new JLabel("Nota Final:"));
        panelNotas.add(campoFinal);
        panelNotas.add(new JLabel("Promoción:"));
        panelNotas.add(checkPromocion);

        // Actualizar materias cuando se selecciona un estudiante
        comboEstudiantes.addActionListener(e -> {
            Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
            if (estudiante != null) {
                modeloMaterias.removeAllElements();
                for (Materia materia : estudiante.getMateriasInscriptas()) {
                    modeloMaterias.addElement(materia);
                }
            }
        });

        // Actualizar campos cuando se selecciona una materia
        comboMaterias.addActionListener(e -> {
            Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
            Materia materia = (Materia) comboMaterias.getSelectedItem();
            if (estudiante != null && materia != null) {
                campoParcial.setText(String.valueOf(materia.getNotaParcial()));
                campoFinal.setText(String.valueOf(materia.getNotaFinal()));
                checkPromocion.setSelected(materia.getTienePromocion());
            }
        });

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonGuardar = new JButton("Guardar Notas");
        JButton botonCerrar = new JButton("Cerrar");

        botonGuardar.addActionListener(e -> {
            try {
                Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
                Materia materia = (Materia) comboMaterias.getSelectedItem();
                if (estudiante != null && materia != null) {
                    // Guardar notas
                    if (!campoParcial.getText().isEmpty()) {
                        double notaParcial = Double.parseDouble(campoParcial.getText());
                        materia.setNotaParcial(notaParcial);
                    }

                    if (!campoFinal.getText().isEmpty()) {
                        double notaFinal = Double.parseDouble(campoFinal.getText());
                        materia.setNotaFinal(notaFinal);
                    }

                    materia.setTienePromocion(checkPromocion.isSelected());

                    // Verificar si la materia está aprobada
                    if (materia.getNotaFinal() >= 4 || materia.getNotaParcial() >= 4) {
                        estudiante.aprobarMateria(materia); // Mover a aprobadas
                        JOptionPane.showMessageDialog(this, "Materia aprobada y movida a la lista de aprobadas.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Notas guardadas, pero la materia no está aprobada.");
                    }

                    // Actualizar la lista de materias disponibles
                    modeloMaterias.removeAllElements();
                    for (Materia m : estudiante.getMateriasInscriptas()) {
                        modeloMaterias.addElement(m);
                    }

                    // Verificar si se desbloquean nuevas materias
                    estudiante.actualizarMateriasDisponibles();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Por favor ingrese notas válidas (números del 0 al 10)",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        botonCerrar.addActionListener(e -> dispose());
        panelBotones.add(botonGuardar);
        panelBotones.add(botonCerrar);

        // Agregar todo al panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(panelSeleccion, BorderLayout.NORTH);
        panelPrincipal.add(panelNotas, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        pack();
        setLocationRelativeTo(parent);
    }
}