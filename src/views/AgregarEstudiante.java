package views;

import java.awt.*;
import javax.swing.*;
import models.*;

class AgregarEstudiante extends JDialog {
    // Lista para los estudiantes
    DefaultListModel<Estudiante> modeloLista;

    public AgregarEstudiante(SistemaUniversitario parent) {
        super(parent, "Agregar Estudiante", true);
        setLayout(new BorderLayout(5, 5));

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField campoLegajo = new JTextField();
        JTextField campoNombre = new JTextField();

        panelEntrada.add(new JLabel("Legajo:"));
        panelEntrada.add(campoLegajo);
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(campoNombre);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(e -> {
            try {
                int legajo = Integer.parseInt(campoLegajo.getText());
                String nombre = campoNombre.getText();
                Estudiante nuevoEstudiante = new Estudiante(legajo, nombre);
                parent.getEstudiantes().add(nuevoEstudiante);
                actualizarListaEstudiantes(parent);
                JOptionPane.showMessageDialog(this, "Estudiante agregado exitosamente");
                campoLegajo.setText("");
                campoNombre.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Legajo inválido");
            }
        });

        panelEntrada.add(botonAgregar);

        // Lista de estudiantes
        modeloLista = new DefaultListModel<>();
        JList<Estudiante> listaEstudiantes = new JList<>(modeloLista);
        listaEstudiantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaEstudiantes);
        
        // Agregar el panel de entrada y la lista de estudiantes al diálogo
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Inicializar la lista de estudiantes
        actualizarListaEstudiantes(parent);

        // Ajustar tamaño y hacer visible el diálogo
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    // Método para actualizar la lista de estudiantes
    private void actualizarListaEstudiantes(SistemaUniversitario parent) {
        modeloLista.clear();
        for (Estudiante estudiante : parent.getEstudiantes()) {
            modeloLista.addElement(estudiante);
        }
    }
}
