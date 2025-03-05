package views;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import models.*;

class GestionNotas extends JDialog {
    public GestionNotas(SistemaUniversitario parent) {
        super(parent, "Gestión de Notas", true);
        setLayout(new BorderLayout(10, 10));
        setSize(500, 400); 
        setLocationRelativeTo(parent); 
        getContentPane().setBackground(SistemaUniversitario.COLOR_FONDO);

       
        JPanel panelSeleccion = new JPanel(new GridLayout(2, 2, 5, 5));
        panelSeleccion.setBackground(SistemaUniversitario.COLOR_FONDO);

       
        JComboBox<Estudiante> comboEstudiantes = new JComboBox<>(
                new Vector<>(parent.getEstudiantes())
        );
        comboEstudiantes.setBackground(SistemaUniversitario.COLOR_BOTON);
        comboEstudiantes.setForeground(SistemaUniversitario.COLOR_TEXTO);

        
        DefaultComboBoxModel<Materia> modeloMaterias = new DefaultComboBoxModel<>();
        JComboBox<Materia> comboMaterias = new JComboBox<>(modeloMaterias);
        comboMaterias.setBackground(SistemaUniversitario.COLOR_BOTON);
        comboMaterias.setForeground(SistemaUniversitario.COLOR_TEXTO);

        
        JLabel estudianteLabel = new JLabel("Estudiante:");
        estudianteLabel.setForeground(Color.WHITE); 
        JLabel materiaLabel = new JLabel("Materia:");
        materiaLabel.setForeground(Color.WHITE); 

        panelSeleccion.add(estudianteLabel);
        panelSeleccion.add(comboEstudiantes);
        panelSeleccion.add(materiaLabel);
        panelSeleccion.add(comboMaterias);

        
        comboEstudiantes.addActionListener(e -> {
            Estudiante estudianteSeleccionado = (Estudiante) comboEstudiantes.getSelectedItem();
            if (estudianteSeleccionado != null) {
                
                modeloMaterias.removeAllElements();

                
                for (Materia materia : estudianteSeleccionado.getMateriasInscriptas()) {
                    modeloMaterias.addElement(materia);
                }
            }
        });

        
        JPanel panelNotas = new JPanel(new GridLayout(3, 2, 5, 5));
        panelNotas.setBackground(SistemaUniversitario.COLOR_FONDO);

       
        SpinnerNumberModel modeloParcial = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1); 
        JSpinner spinnerParcial = new JSpinner(modeloParcial);
        JSpinner.NumberEditor editorParcial = new JSpinner.NumberEditor(spinnerParcial, "#0.0"); 
        spinnerParcial.setEditor(editorParcial);
        spinnerParcial.setBackground(SistemaUniversitario.COLOR_BOTON);
        spinnerParcial.setForeground(SistemaUniversitario.COLOR_TEXTO);

        SpinnerNumberModel modeloFinal = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1); 
        JSpinner spinnerFinal = new JSpinner(modeloFinal);
        JSpinner.NumberEditor editorFinal = new JSpinner.NumberEditor(spinnerFinal, "#0.0"); 
        spinnerFinal.setEditor(editorFinal);
        spinnerFinal.setBackground(SistemaUniversitario.COLOR_BOTON);
        spinnerFinal.setForeground(SistemaUniversitario.COLOR_TEXTO);

        JCheckBox checkPromocion = new JCheckBox("Materia promocionable");
        checkPromocion.setBackground(SistemaUniversitario.COLOR_FONDO);
        checkPromocion.setForeground(SistemaUniversitario.COLOR_TEXTO);

        JLabel parcialLabel = new JLabel("Nota Parcial:");
        parcialLabel.setForeground(Color.WHITE); 
        JLabel finalLabel = new JLabel("Nota Final:");
        finalLabel.setForeground(Color.WHITE); 
        JLabel promocionLabel = new JLabel("Promoción:");
        promocionLabel.setForeground(Color.WHITE); 

        panelNotas.add(parcialLabel);
        panelNotas.add(spinnerParcial);
        panelNotas.add(finalLabel);
        panelNotas.add(spinnerFinal);
        panelNotas.add(promocionLabel);
        panelNotas.add(checkPromocion);

       
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

        
        botonGuardar.addActionListener(e -> {
            Estudiante estudianteSeleccionado = (Estudiante) comboEstudiantes.getSelectedItem();
            Materia materiaSeleccionada = (Materia) comboMaterias.getSelectedItem();
        

            if (estudianteSeleccionado == null || materiaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un estudiante y una materia.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            double notaParcial = (double) spinnerParcial.getValue();
            double notaFinal = (double) spinnerFinal.getValue();
        
            try {
                estudianteSeleccionado.registrarNota(materiaSeleccionada, notaParcial);
                estudianteSeleccionado.registrarNotaFinal(materiaSeleccionada, notaFinal);
        
                JOptionPane.showMessageDialog(this, "Notas guardadas correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        botonCerrar.addActionListener(e -> dispose()); 

        panelBotones.add(botonGuardar);
        panelBotones.add(botonCerrar);

       
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(SistemaUniversitario.COLOR_FONDO);
        panelPrincipal.add(panelSeleccion, BorderLayout.NORTH);
        panelPrincipal.add(panelNotas, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        
    }
}