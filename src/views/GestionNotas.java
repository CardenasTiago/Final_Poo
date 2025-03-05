package views;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import models.*;

class GestionNotas extends JDialog {
    public GestionNotas(SistemaUniversitario parent) {
        super(parent, "Gestión de Notas", true);
        setLayout(new BorderLayout(10, 10));
        setSize(500, 400); // Tamaño fijo
        setLocationRelativeTo(parent); // Centrar la ventana
        getContentPane().setBackground(SistemaUniversitario.COLOR_FONDO);

        // Panel de selección de estudiante y materia
        JPanel panelSeleccion = new JPanel(new GridLayout(2, 2, 5, 5));
        panelSeleccion.setBackground(SistemaUniversitario.COLOR_FONDO);

        // Combo box para estudiantes
        JComboBox<Estudiante> comboEstudiantes = new JComboBox<>(
                new Vector<>(parent.getEstudiantes())
        );
        comboEstudiantes.setBackground(SistemaUniversitario.COLOR_BOTON);
        comboEstudiantes.setForeground(SistemaUniversitario.COLOR_TEXTO);

        // Combo box para materias
        DefaultComboBoxModel<Materia> modeloMaterias = new DefaultComboBoxModel<>();
        JComboBox<Materia> comboMaterias = new JComboBox<>(modeloMaterias);
        comboMaterias.setBackground(SistemaUniversitario.COLOR_BOTON);
        comboMaterias.setForeground(SistemaUniversitario.COLOR_TEXTO);

        // Etiquetas
        JLabel estudianteLabel = new JLabel("Estudiante:");
        estudianteLabel.setForeground(Color.WHITE); // Texto en blanco
        JLabel materiaLabel = new JLabel("Materia:");
        materiaLabel.setForeground(Color.WHITE); // Texto en blanco

        panelSeleccion.add(estudianteLabel);
        panelSeleccion.add(comboEstudiantes);
        panelSeleccion.add(materiaLabel);
        panelSeleccion.add(comboMaterias);

        // Listener para actualizar las materias cuando se selecciona un estudiante
        comboEstudiantes.addActionListener(e -> {
            Estudiante estudianteSeleccionado = (Estudiante) comboEstudiantes.getSelectedItem();
            if (estudianteSeleccionado != null) {
                // Limpiar el modelo de materias
                modeloMaterias.removeAllElements();

                // Cargar las materias inscritas por el estudiante
                for (Materia materia : estudianteSeleccionado.getMateriasInscriptas()) {
                    modeloMaterias.addElement(materia);
                }
            }
        });

        // Panel de notas
        JPanel panelNotas = new JPanel(new GridLayout(3, 2, 5, 5));
        panelNotas.setBackground(SistemaUniversitario.COLOR_FONDO);

        // Spinners para notas parcial y final
        SpinnerNumberModel modeloParcial = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1); // Rango de 0.0 a 10.0, incremento de 0.1
        JSpinner spinnerParcial = new JSpinner(modeloParcial);
        JSpinner.NumberEditor editorParcial = new JSpinner.NumberEditor(spinnerParcial, "#0.0"); // Formato de un decimal
        spinnerParcial.setEditor(editorParcial);
        spinnerParcial.setBackground(SistemaUniversitario.COLOR_BOTON);
        spinnerParcial.setForeground(SistemaUniversitario.COLOR_TEXTO);

        SpinnerNumberModel modeloFinal = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1); // Rango de 0.0 a 10.0, incremento de 0.1
        JSpinner spinnerFinal = new JSpinner(modeloFinal);
        JSpinner.NumberEditor editorFinal = new JSpinner.NumberEditor(spinnerFinal, "#0.0"); // Formato de un decimal
        spinnerFinal.setEditor(editorFinal);
        spinnerFinal.setBackground(SistemaUniversitario.COLOR_BOTON);
        spinnerFinal.setForeground(SistemaUniversitario.COLOR_TEXTO);

        JCheckBox checkPromocion = new JCheckBox("Materia promocionable");
        checkPromocion.setBackground(SistemaUniversitario.COLOR_FONDO);
        checkPromocion.setForeground(SistemaUniversitario.COLOR_TEXTO);

        JLabel parcialLabel = new JLabel("Nota Parcial:");
        parcialLabel.setForeground(Color.WHITE); // Texto en blanco
        JLabel finalLabel = new JLabel("Nota Final:");
        finalLabel.setForeground(Color.WHITE); // Texto en blanco
        JLabel promocionLabel = new JLabel("Promoción:");
        promocionLabel.setForeground(Color.WHITE); // Texto en blanco

        panelNotas.add(parcialLabel);
        panelNotas.add(spinnerParcial);
        panelNotas.add(finalLabel);
        panelNotas.add(spinnerFinal);
        panelNotas.add(promocionLabel);
        panelNotas.add(checkPromocion);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(SistemaUniversitario.COLOR_FONDO);
        JButton botonGuardar = new JButton("Guardar Notas");
        botonGuardar.setBackground(SistemaUniversitario.COLOR_BOTON);
        botonGuardar.setForeground(SistemaUniversitario.COLOR_TEXTO);
        botonGuardar.setFocusPainted(false);
        botonGuardar.setBorder(BorderFactory.createLineBorder(SistemaUniversitario.COLOR_BORDE, 1));
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.setBackground(SistemaUniversitario.COLOR_BOTON);
        botonCerrar.setForeground(SistemaUniversitario.COLOR_TEXTO);
        botonCerrar.setFocusPainted(false);
        botonCerrar.setBorder(BorderFactory.createLineBorder(SistemaUniversitario.COLOR_BORDE, 1));

        // Acción para guardar las notas
        botonGuardar.addActionListener(e -> {
            Estudiante estudianteSeleccionado = (Estudiante) comboEstudiantes.getSelectedItem();
            Materia materiaSeleccionada = (Materia) comboMaterias.getSelectedItem();

            // Validar que se haya seleccionado un estudiante y una materia
            if (estudianteSeleccionado == null || materiaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un estudiante y una materia.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener las notas
            double notaParcial = (double) spinnerParcial.getValue();
            double notaFinal = (double) spinnerFinal.getValue();

            // Registrar las notas en la materia
            estudianteSeleccionado.registrarNota(materiaSeleccionada, notaParcial);
            estudianteSeleccionado.registrarNotaFinal(materiaSeleccionada, notaFinal);

            JOptionPane.showMessageDialog(this, "Notas guardadas correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });

        // Acción para cerrar la ventana
        botonCerrar.addActionListener(e -> dispose()); // Cierra la ventana

        panelBotones.add(botonGuardar);
        panelBotones.add(botonCerrar);

        // Agregar todo al panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(SistemaUniversitario.COLOR_FONDO);
        panelPrincipal.add(panelSeleccion, BorderLayout.NORTH);
        panelPrincipal.add(panelNotas, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        
    }
}