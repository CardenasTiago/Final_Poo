package views;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.*;

public class CrearPlanEstudio extends JDialog {

    private final Color COLOR_FONDO = SistemaUniversitario.COLOR_FONDO;
    private final Color COLOR_BOTON = SistemaUniversitario.COLOR_BOTON;
    private final Color COLOR_TEXTO = SistemaUniversitario.COLOR_TEXTO;
    private final Color COLOR_BORDE = SistemaUniversitario.COLOR_BORDE;

    private final SistemaUniversitario sistema;
    private final JTextField nombrePlanField;
    private final DefaultListModel<Materia> materiasObligatoriasListModel;
    private final DefaultListModel<Materia> materiasOptativasListModel;
    private final List<Materia> todasLasMaterias;
    private final JComboBox<String> tipoPlanComboBox;
    private final JList<Materia> listaCorrelativas;
    private final DefaultListModel<Materia> correlativasListModel;

    public CrearPlanEstudio(SistemaUniversitario sistema) {
        super(sistema, "Crear Plan de Estudio", true);
        this.sistema = sistema;
        this.todasLasMaterias = new ArrayList<>();

        // Configurar ventana
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Panel para datos básicos del plan
        JPanel datosPlanPanel = new JPanel(new GridBagLayout());
        datosPlanPanel.setBorder(BorderFactory.createTitledBorder("Datos del Plan"));
        datosPlanPanel.setBackground(COLOR_FONDO);
        ((TitledBorder) datosPlanPanel.getBorder()).setTitleColor(COLOR_TEXTO);

        // Nombre del plan
        JLabel nombreLabel = new JLabel("Nombre del Plan:");
        nombreLabel.setForeground(COLOR_TEXTO);
        nombrePlanField = new JTextField(20);
        nombrePlanField.setBackground(COLOR_BOTON);
        nombrePlanField.setForeground(COLOR_TEXTO);
        nombrePlanField.setCaretColor(COLOR_TEXTO);

        // Tipo de plan
        JLabel tipoPlanLabel = new JLabel("Tipo de Plan:");
        tipoPlanLabel.setForeground(COLOR_TEXTO);
        tipoPlanComboBox = new JComboBox<>(new String[]{"Plan A", "Plan B", "Plan C", "Plan D", "Plan E"});
        tipoPlanComboBox.setBackground(COLOR_BOTON);
        tipoPlanComboBox.setForeground(COLOR_TEXTO);

        // Agregar componentes al panel de datos
        GridBagConstraints gbcDatos = new GridBagConstraints();
        gbcDatos.insets = new Insets(5, 5, 5, 5);
        gbcDatos.fill = GridBagConstraints.HORIZONTAL;

        gbcDatos.gridx = 0; gbcDatos.gridy = 0;
        datosPlanPanel.add(nombreLabel, gbcDatos);
        gbcDatos.gridx = 1;
        datosPlanPanel.add(nombrePlanField, gbcDatos);

        gbcDatos.gridx = 0; gbcDatos.gridy = 1;
        datosPlanPanel.add(tipoPlanLabel, gbcDatos);
        gbcDatos.gridx = 1;
        datosPlanPanel.add(tipoPlanComboBox, gbcDatos);

        // Panel para gestión de materias
        JPanel materiasPanel = new JPanel(new GridBagLayout());
        materiasPanel.setBorder(BorderFactory.createTitledBorder("Gestión de Materias"));
        materiasPanel.setBackground(COLOR_FONDO);
        ((TitledBorder) materiasPanel.getBorder()).setTitleColor(COLOR_TEXTO);

        // Componentes para agregar nueva materia
        JTextField codigoField = new JTextField(10);
        JTextField nombreMateriaField = new JTextField(20);
        JCheckBox obligatoriaCheck = new JCheckBox("Obligatoria");
        JSpinner cuatrimestreSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));

        // Estilo para el JSpinner
        cuatrimestreSpinner.setBackground(COLOR_BOTON);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) cuatrimestreSpinner.getEditor();
        editor.getTextField().setBackground(COLOR_BOTON); // Fondo del campo de texto
        editor.getTextField().setForeground(COLOR_TEXTO); // Color del texto
        editor.getTextField().setCaretColor(COLOR_TEXTO); // Color del cursor

        // Estilo para componentes
        codigoField.setBackground(COLOR_BOTON);
        codigoField.setForeground(COLOR_TEXTO);
        nombreMateriaField.setBackground(COLOR_BOTON);
        nombreMateriaField.setForeground(COLOR_TEXTO);
        obligatoriaCheck.setBackground(COLOR_FONDO);
        obligatoriaCheck.setForeground(COLOR_TEXTO);
        cuatrimestreSpinner.setBackground(COLOR_BOTON);
        ((JSpinner.DefaultEditor) cuatrimestreSpinner.getEditor()).getTextField().setForeground(COLOR_TEXTO);

        // Lista de correlativas
        correlativasListModel = new DefaultListModel<>();
        listaCorrelativas = new JList<>(correlativasListModel);
        listaCorrelativas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Selección múltiple
        listaCorrelativas.setBackground(COLOR_BOTON);
        listaCorrelativas.setForeground(COLOR_TEXTO);

        // Botón para agregar materia
        JButton agregarMateriaBtn = crearBoton("Agregar Materia");
        agregarMateriaBtn.addActionListener(e -> {
            String codigo = codigoField.getText().trim();
            String nombre = nombreMateriaField.getText().trim();
            int cuatrimestre = (int) cuatrimestreSpinner.getValue();

            if (codigo.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar el código y el nombre de la materia.");
                return;
            }

            // Verificar si el código o el nombre ya existen
            if (existeMateriaConCodigo(codigo)) {
                JOptionPane.showMessageDialog(this, "Ya existe una materia con el código " + codigo + ".");
                return;
            }
            if (existeMateriaConNombre(nombre)) {
                JOptionPane.showMessageDialog(this, "Ya existe una materia con el nombre " + nombre + ".");
                return;
            }

            // Verificar que las correlativas sean de cuatrimestres anteriores
            List<Materia> correlativasSeleccionadas = listaCorrelativas.getSelectedValuesList();
            for (Materia correlativa : correlativasSeleccionadas) {
                if (correlativa.getCuatrimestre() >= cuatrimestre) {
                    JOptionPane.showMessageDialog(this,
                            "Las correlativas deben ser de cuatrimestres anteriores.");
                    return;
                }
            }

            // Crear la nueva materia
            Materia nuevaMateria = new Materia(codigo, nombre, obligatoriaCheck.isSelected(), cuatrimestre);
            for (Materia correlativa : correlativasSeleccionadas) {
                nuevaMateria.agregarCorrelativa(correlativa); // Agregar todas las correlativas seleccionadas
            }

            todasLasMaterias.add(nuevaMateria);
            actualizarListasMaterias();

            // Limpiar campos
            codigoField.setText("");
            nombreMateriaField.setText("");
            obligatoriaCheck.setSelected(false);
            cuatrimestreSpinner.setValue(1);
            listaCorrelativas.clearSelection();
        });

        // Listas de materias obligatorias y optativas
        materiasObligatoriasListModel = new DefaultListModel<>();
        materiasOptativasListModel = new DefaultListModel<>();

        JList<Materia> materiasObligatoriasList = new JList<>(materiasObligatoriasListModel);
        JList<Materia> materiasOptativasList = new JList<>(materiasOptativasListModel);

        // Estilo para las listas
        materiasObligatoriasList.setBackground(COLOR_BOTON);
        materiasObligatoriasList.setForeground(COLOR_TEXTO);
        materiasOptativasList.setBackground(COLOR_BOTON);
        materiasOptativasList.setForeground(COLOR_TEXTO);

        // Botón para eliminar materia obligatoria
        JButton eliminarObligatoriaBtn = crearBoton("Eliminar Materia Obligatoria");
        eliminarObligatoriaBtn.addActionListener(e -> {
            Materia seleccionada = materiasObligatoriasList.getSelectedValue();
            if (seleccionada != null) {
                todasLasMaterias.remove(seleccionada); // Eliminar la materia de la lista principal
                actualizarListasMaterias(); // Actualizar las listas visuales
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una materia obligatoria para eliminar.");
            }
        });

        // Botón para eliminar materia optativa
        JButton eliminarOptativaBtn = crearBoton("Eliminar Materia Optativa");
        eliminarOptativaBtn.addActionListener(e -> {
            Materia seleccionada = materiasOptativasList.getSelectedValue();
            if (seleccionada != null) {
                todasLasMaterias.remove(seleccionada); // Eliminar la materia de la lista principal
                actualizarListasMaterias(); // Actualizar las listas visuales
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una materia optativa para eliminar.");
            }
        });

        // Agregar componentes al panel de materias
        GridBagConstraints gbcMaterias = new GridBagConstraints();
        gbcMaterias.insets = new Insets(5, 5, 5, 5);
        gbcMaterias.fill = GridBagConstraints.HORIZONTAL;

        // Primera fila: campos de nueva materia
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 0;
        materiasPanel.add(new JLabel("Código:"), gbcMaterias);
        gbcMaterias.gridx = 1;
        materiasPanel.add(codigoField, gbcMaterias);
        gbcMaterias.gridx = 2;
        materiasPanel.add(new JLabel("Nombre:"), gbcMaterias);
        gbcMaterias.gridx = 3;
        materiasPanel.add(nombreMateriaField, gbcMaterias);

        // Segunda fila: más campos de nueva materia
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 1;
        materiasPanel.add(new JLabel("Cuatrimestre:"), gbcMaterias);
        gbcMaterias.gridx = 1;
        materiasPanel.add(cuatrimestreSpinner, gbcMaterias);
        gbcMaterias.gridx = 2;
        materiasPanel.add(obligatoriaCheck, gbcMaterias);
        gbcMaterias.gridx = 3;
        materiasPanel.add(agregarMateriaBtn, gbcMaterias);

        // Tercera fila: lista de correlativas
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 2;
        gbcMaterias.gridwidth = 4;
        materiasPanel.add(new JLabel("Correlativas (seleccione materias de cuatrimestres anteriores):"), gbcMaterias);
        gbcMaterias.gridy = 3;
        materiasPanel.add(new JScrollPane(listaCorrelativas), gbcMaterias);

        // Cuarta fila: lista de materias obligatorias
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 4;
        gbcMaterias.gridwidth = 2;
        materiasPanel.add(new JLabel("Materias Obligatorias:"), gbcMaterias);
        gbcMaterias.gridy = 5;
        materiasPanel.add(new JScrollPane(materiasObligatoriasList), gbcMaterias);

        // Quinta fila: lista de materias optativas
        gbcMaterias.gridx = 2; gbcMaterias.gridy = 4;
        gbcMaterias.gridwidth = 2;
        materiasPanel.add(new JLabel("Materias Optativas:"), gbcMaterias);
        gbcMaterias.gridy = 5;
        materiasPanel.add(new JScrollPane(materiasOptativasList), gbcMaterias);

        // Sexta fila: botones para eliminar materias
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 6;
        gbcMaterias.gridwidth = 2;
        materiasPanel.add(eliminarObligatoriaBtn, gbcMaterias);

        gbcMaterias.gridx = 2; gbcMaterias.gridy = 6;
        gbcMaterias.gridwidth = 2;
        materiasPanel.add(eliminarOptativaBtn, gbcMaterias);

        // Botón guardar plan
        JButton guardarPlanBtn = crearBoton("Guardar Plan");
        guardarPlanBtn.addActionListener(e -> guardarPlan());

        // Agregar todos los paneles a la ventana principal
        gbc.gridx = 0; gbc.gridy = 0;
        add(datosPlanPanel, gbc);

        gbc.gridy = 1;
        add(materiasPanel, gbc);

        gbc.gridy = 2;
        add(guardarPlanBtn, gbc);

        // Configuración final de la ventana
        pack();
        setLocationRelativeTo(sistema);
        setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBackground(COLOR_BOTON);
        boton.setForeground(COLOR_TEXTO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return boton;
    }

    private void actualizarListasMaterias() {
        materiasObligatoriasListModel.clear();
        materiasOptativasListModel.clear();
        correlativasListModel.clear();
        for (Materia materia : todasLasMaterias) {
            if (materia.isObligatoria()) {
                materiasObligatoriasListModel.addElement(materia);
            } else {
                materiasOptativasListModel.addElement(materia);
            }
            correlativasListModel.addElement(materia);
        }
    }

    private boolean existeMateriaConCodigo(String codigo) {
        return todasLasMaterias.stream().anyMatch(m -> m.getCodigo().equalsIgnoreCase(codigo));
    }

    private boolean existeMateriaConNombre(String nombre) {
        return todasLasMaterias.stream().anyMatch(m -> m.getNombre().equalsIgnoreCase(nombre));
    }

    private void guardarPlan() {
        if (nombrePlanField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para el plan");
            return;
        }

        if (materiasObligatoriasListModel.isEmpty() && materiasOptativasListModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar al menos una materia obligatoria u optativa");
            return;
        }

        String tipoPlan = (String) tipoPlanComboBox.getSelectedItem();
        PlanEstudio nuevoPlan;

        switch (tipoPlan) {
            case "Plan A":
                nuevoPlan = new PlanA(nombrePlanField.getText());
                break;
            case "Plan B":
                nuevoPlan = new PlanB(nombrePlanField.getText());
                break;
            case "Plan C":
                nuevoPlan = new PlanC(nombrePlanField.getText());
                break;
            case "Plan D":
                nuevoPlan = new PlanD(nombrePlanField.getText());
                break;
            case "Plan E":
                nuevoPlan = new PlanE(nombrePlanField.getText());
                break;
            default:
                nuevoPlan = new PlanA(nombrePlanField.getText());
                break;
        }

        for (int i = 0; i < materiasObligatoriasListModel.size(); i++) {
            nuevoPlan.agregarMateriaObligatoria(materiasObligatoriasListModel.getElementAt(i));
        }

        for (int i = 0; i < materiasOptativasListModel.size(); i++) {
            nuevoPlan.agregarMateriaOptativa(materiasOptativasListModel.getElementAt(i));
        }

        sistema.getPlanesEstudio().add(nuevoPlan);
        JOptionPane.showMessageDialog(this, "Plan de estudio guardado exitosamente");
        dispose();
    }
}