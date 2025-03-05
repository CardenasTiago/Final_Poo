package views;

import java.awt.*;
import javax.swing.*;
import models.*;

class AgregarEstudiante extends JDialog {

    DefaultListModel<Estudiante> modeloLista;
    JList<Estudiante> listaEstudiantes;

    public AgregarEstudiante(SistemaUniversitario parent) {
        super(parent, "Agregar Estudiante", true);
        setLayout(new BorderLayout(5, 5));
        setSize(500, 350); 
        setLocationRelativeTo(parent); 
        getContentPane().setBackground(SistemaUniversitario.COLOR_FONDO);

        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntrada.setBackground(SistemaUniversitario.COLOR_FONDO);

        JLabel legajoLabel = new JLabel("Legajo:");
        legajoLabel.setForeground(Color.WHITE); 
        panelEntrada.add(legajoLabel);

        JTextField campoLegajo = new JTextField();
        campoLegajo.setBackground(SistemaUniversitario.COLOR_FONDO);
        campoLegajo.setForeground(Color.WHITE);
        panelEntrada.add(campoLegajo);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE); 
        panelEntrada.add(nombreLabel);

        JTextField campoNombre = new JTextField();
        campoNombre.setBackground(SistemaUniversitario.COLOR_FONDO);
        campoNombre.setForeground(Color.WHITE);
        panelEntrada.add(campoNombre);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(e -> {
            try {
                int legajo = Integer.parseInt(campoLegajo.getText());
                String nombre = campoNombre.getText();
        
                boolean legajoExistente = parent.getEstudiantes().stream()
                        .anyMatch(estudiante -> estudiante.getLegajo() == legajo);
        
                if (legajoExistente) {
                    JOptionPane.showMessageDialog(this, "Ya existe un estudiante con este legajo");
                } else {
                    Estudiante nuevoEstudiante = new Estudiante(legajo, nombre);
                    parent.getEstudiantes().add(nuevoEstudiante);
                    actualizarListaEstudiantes(parent);
                    JOptionPane.showMessageDialog(this, "Estudiante agregado exitosamente");
                    campoLegajo.setText("");
                    campoNombre.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Legajo inválido");
            }
        });

        // Botón Eliminar
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(e -> eliminarEstudiante(parent));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBotones.setBackground(SistemaUniversitario.COLOR_FONDO);
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCampos.setBackground(SistemaUniversitario.COLOR_FONDO);
        panelCampos.add(legajoLabel);
        panelCampos.add(campoLegajo);
        panelCampos.add(nombreLabel);
        panelCampos.add(campoNombre);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(SistemaUniversitario.COLOR_FONDO);
        panelSuperior.add(panelCampos, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        modeloLista = new DefaultListModel<>();
        listaEstudiantes = new JList<>(modeloLista);
        listaEstudiantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaEstudiantes.setBackground(SistemaUniversitario.COLOR_FONDO);
        listaEstudiantes.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(listaEstudiantes);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        actualizarListaEstudiantes(parent);

        setVisible(true);
    }

    private void eliminarEstudiante(SistemaUniversitario parent) {
        Estudiante estudianteSeleccionado = listaEstudiantes.getSelectedValue();
        
        if (estudianteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, seleccione un estudiante de la lista para eliminar", 
                "Selección requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro que desea eliminar al estudiante " + estudianteSeleccionado.toString() + "?",
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
        if (confirmacion == JOptionPane.YES_OPTION) {
            parent.getEstudiantes().remove(estudianteSeleccionado);
            actualizarListaEstudiantes(parent);
            JOptionPane.showMessageDialog(this, "Estudiante eliminado exitosamente");
        }
    }

    private void actualizarListaEstudiantes(SistemaUniversitario parent) {
        modeloLista.clear();
        for (Estudiante estudiante : parent.getEstudiantes()) {
            modeloLista.addElement(estudiante);
        }
    }
}