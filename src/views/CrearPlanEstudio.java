package views;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import models.*;

public class CrearPlanEstudio extends JDialog {

    // Colores del tema oscuro
    private final Color COLOR_FONDO = SistemaUniversitario.COLOR_FONDO; // Fondo gris muy oscuro
    private final Color COLOR_BOTON = SistemaUniversitario.COLOR_BOTON; // Botón gris oscuro
    private final Color COLOR_TEXTO = SistemaUniversitario.COLOR_TEXTO; // Texto blanco
    private final Color COLOR_BORDE = SistemaUniversitario.COLOR_BORDE; // Borde gris claro
    private final Color COLOR_HOVER = SistemaUniversitario.COLOR_BOTON_HOVER; // Hover gris medio

    private final SistemaUniversitario sistema;
    private JTextField nombrePlanField;
    private final DefaultListModel<Materia> materiasObligatoriasListModel = new DefaultListModel<>();
    private final DefaultListModel<Materia> materiasOptativasListModel = new DefaultListModel<>();
    private final List<Materia> todasLasMaterias;
    private JComboBox<String> tipoPlanComboBox;

    private JList<Materia> listaMaterias;
    private JList<Materia> listaCorrelativas;
    private DefaultListModel<Materia> materiasListModel;
    private DefaultListModel<Materia> correlativasListModel;

    private JPanel panelMateriasAgregadas;
    private DefaultTableModel tableModelMateriasAgregadas;


    private JPanel panelCorrelativas;
    private DefaultTableModel tableModelCorrelativas; 

    public CrearPlanEstudio(SistemaUniversitario sistema) {
        super(sistema, "Crear Plan de Estudio", true);
        this.sistema = sistema;
        this.todasLasMaterias = new ArrayList<>();

        this.materiasListModel = new DefaultListModel<>();
        this.correlativasListModel = new DefaultListModel<>();
        this.listaMaterias = new JList<>(materiasListModel);
        this.listaCorrelativas = new JList<>(correlativasListModel);

        setLayout(new BorderLayout()); 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        mainPanel.setBackground(COLOR_FONDO); 


        JPanel datosPlanPanel = crearPanelDatosPlan();
        datosPlanPanel.setMinimumSize(new Dimension(700, 120)); 
        datosPlanPanel.setPreferredSize(new Dimension(700, 120)); 
        mainPanel.add(datosPlanPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); 

  
        JPanel materiasPanel = crearPanelMaterias();
        materiasPanel.setMinimumSize(new Dimension(700, 250)); 
        materiasPanel.setPreferredSize(new Dimension(700, 250)); 
        mainPanel.add(materiasPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); 

        
        panelMateriasAgregadas = crearPanelMateriasAgregadas();
        panelMateriasAgregadas.setMinimumSize(new Dimension(700, 200)); 
        panelMateriasAgregadas.setPreferredSize(new Dimension(700, 200)); 
        mainPanel.add(panelMateriasAgregadas);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); 


        JButton guardarPlanBtn = crearBoton("Guardar Plan", COLOR_BOTON, COLOR_HOVER);
        guardarPlanBtn.addActionListener(e -> guardarPlan());
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(COLOR_FONDO);
        buttonPanel.add(guardarPlanBtn);
        mainPanel.add(buttonPanel);

      
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

       
        setSize(700, 700); 
        setMinimumSize(new Dimension(750, 700)); 
        setLocationRelativeTo(sistema);
        setResizable(true); 
        setVisible(true);
    }

    private JPanel crearPanelDatosPlan() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1, true),
                "Datos del Plan",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                COLOR_TEXTO));
        panel.setBackground(COLOR_FONDO);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

     
        JLabel nombreLabel = new JLabel("Nombre del Plan:");
        nombreLabel.setForeground(COLOR_TEXTO);
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        nombrePlanField = new JTextField(20);
        nombrePlanField.setBackground(COLOR_BOTON);
        nombrePlanField.setForeground(COLOR_TEXTO);
        nombrePlanField.setCaretColor(COLOR_TEXTO);
        nombrePlanField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        nombrePlanField.setPreferredSize(new Dimension(300, 30));

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 0.3;
        panel.add(nombreLabel, gbc);
        
        gbc.gridx = 1; 
        gbc.weightx = 0.7;
        panel.add(nombrePlanField, gbc);

        // Tipo de plan
        JLabel tipoPlanLabel = new JLabel("Tipo de Plan:");
        tipoPlanLabel.setForeground(COLOR_TEXTO);
        tipoPlanLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        tipoPlanComboBox = new JComboBox<>(new String[]{"Plan A", "Plan B", "Plan C", "Plan D", "Plan E"});
        tipoPlanComboBox.setBackground(COLOR_BOTON);
        tipoPlanComboBox.setForeground(COLOR_TEXTO);
        tipoPlanComboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        tipoPlanComboBox.setPreferredSize(new Dimension(300, 30)); 

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.3;
        panel.add(tipoPlanLabel, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add(tipoPlanComboBox, gbc);

        return panel;
    }

    private JPanel crearPanelMaterias() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1, true),
                "Gestión de Materias",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                COLOR_TEXTO));
        panel.setBackground(COLOR_FONDO);
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
    
       
        JTextField codigoField = new JTextField(10);
        JTextField nombreMateriaField = new JTextField(20);
        JCheckBox obligatoriaCheck = new JCheckBox("Obligatoria");
        JCheckBox promocionableCheck = new JCheckBox("Promocionable"); 
        JSpinner cuatrimestreSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
    
       
        codigoField.setPreferredSize(new Dimension(100, 30));
        nombreMateriaField.setPreferredSize(new Dimension(200, 30));
        cuatrimestreSpinner.setPreferredSize(new Dimension(80, 30));
    
        
        codigoField.setBackground(COLOR_BOTON);
        codigoField.setForeground(COLOR_TEXTO);
        nombreMateriaField.setBackground(COLOR_BOTON);
        nombreMateriaField.setForeground(COLOR_TEXTO);
    
        
        obligatoriaCheck.setBackground(COLOR_FONDO);
        obligatoriaCheck.setForeground(COLOR_TEXTO);
        promocionableCheck.setBackground(COLOR_FONDO);
        promocionableCheck.setForeground(COLOR_TEXTO);
    
        
        cuatrimestreSpinner.setBackground(COLOR_BOTON);
    
        
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) cuatrimestreSpinner.getEditor();
        JTextField textField = editor.getTextField();
        textField.setForeground(COLOR_TEXTO); 
        textField.setBackground(COLOR_BOTON); 
        textField.setCaretColor(COLOR_TEXTO); 
    
       
        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setForeground(COLOR_TEXTO); 
    
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(COLOR_TEXTO); 
    
        JLabel cuatrimestreLabel = new JLabel("Cuatrimestre:");
        cuatrimestreLabel.setForeground(COLOR_TEXTO); 
    
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        cuatrimestreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        obligatoriaCheck.setFont(new Font("Arial", Font.PLAIN, 12));
        promocionableCheck.setFont(new Font("Arial", Font.PLAIN, 12));
    
      
        panelCorrelativas = crearPanelCorrelativas();
    
        
        JButton agregarMateriaBtn = crearBoton("Agregar Materia", COLOR_BOTON, COLOR_HOVER);
        agregarMateriaBtn.addActionListener(e -> {
            String codigo = codigoField.getText().trim();
            String nombre = nombreMateriaField.getText().trim();
            int cuatrimestre = (int) cuatrimestreSpinner.getValue();
    
            if (codigo.isEmpty() || nombre.isEmpty()) {
                mostrarMensaje("Debe completar el código y el nombre de la materia.");
                return;
            }
    
            if (existeMateriaConCodigo(codigo)) {
                mostrarMensaje("Ya existe una materia con el código " + codigo + ".");
                return;
            }
    
            if (existeMateriaConNombre(nombre)) {
                mostrarMensaje("Ya existe una materia con el nombre " + nombre + ".");
                return;
            }
    
            
            Materia nuevaMateria = new Materia(codigo, nombre, obligatoriaCheck.isSelected(), cuatrimestre);
            nuevaMateria.setTienePromocion(promocionableCheck.isSelected()); // Establecer si es promocionable
    
            
            JScrollPane scrollPaneCorrelativas = (JScrollPane) panelCorrelativas.getComponent(0);
            JTable tablaCorrelativas = (JTable) scrollPaneCorrelativas.getViewport().getView();
            DefaultTableModel tableModel = (DefaultTableModel) tablaCorrelativas.getModel();
    
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                boolean seleccionado = (boolean) tableModel.getValueAt(i, 0);
                if (seleccionado) {
                    String codigoCorrelativa = (String) tableModel.getValueAt(i, 1);
                    Materia correlativa = todasLasMaterias.stream()
                            .filter(m -> m.getCodigo().equals(codigoCorrelativa))
                            .findFirst()
                            .orElse(null);
    
                    if (correlativa != null) {
                        if (correlativa.getCuatrimestre() >= nuevaMateria.getCuatrimestre()) {
                            mostrarMensaje("La materia " + correlativa.getNombre() + " no puede ser correlativa porque es del mismo o un cuatrimestre posterior.");
                            return;
                        }
                        nuevaMateria.agregarCorrelativa(correlativa);
                    }
                }
            }
    
            
            todasLasMaterias.add(nuevaMateria);
    
           
            actualizarTablaCorrelativas();
    
            
            actualizarTablaMateriasAgregadas();
    
            
            codigoField.setText("");
            nombreMateriaField.setText("");
            obligatoriaCheck.setSelected(false);
            promocionableCheck.setSelected(false); 
            cuatrimestreSpinner.setValue(1);
    
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(false, i, 0);
            }
    
            mostrarMensaje("Materia agregada con éxito.");
        });
    
        
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 0.1;
        panel.add(codigoLabel, gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 0.2;
        panel.add(codigoField, gbc);
    
        gbc.gridx = 2;
        gbc.weightx = 0.1;
        panel.add(nombreLabel, gbc);
    
        gbc.gridx = 3;
        gbc.weightx = 0.6;
        panel.add(nombreMateriaField, gbc);
    
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.1;
        panel.add(cuatrimestreLabel, gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 0.2;
        panel.add(cuatrimestreSpinner, gbc);
    
        gbc.gridx = 2;
        gbc.weightx = 0.2;
        panel.add(obligatoriaCheck, gbc);
    
        gbc.gridx = 3;
        gbc.weightx = 0.2;
        panel.add(promocionableCheck, gbc); 
    
        gbc.gridx = 4;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(agregarMateriaBtn, gbc);
    
        
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelCorrelativas, gbc);
    
        return panel;
    }

    private JPanel crearPanelCorrelativas() {
        JPanel panel = new JPanel(new BorderLayout(10, 10)); 
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1, true),
                "Seleccionar Correlativas",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                COLOR_TEXTO));
        panel.setBackground(COLOR_FONDO);
    
        
        String[] columnNames = {"Seleccionar", "Código", "Nombre"};
        tableModelCorrelativas = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : String.class;
            }
        };
        JTable table = new JTable(tableModelCorrelativas);
        table.setBackground(COLOR_BOTON);
        table.setForeground(COLOR_TEXTO);
        table.setGridColor(COLOR_BORDE);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25); 
    
       
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
    
       
        for (Materia materia : todasLasMaterias) {
            Object[] row = {false, materia.getCodigo(), materia.getNombre()};
            tableModelCorrelativas.addRow(row);
        }
    
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 120)); 
        panel.add(scrollPane, BorderLayout.CENTER);
    
        return panel;
    }

    private JPanel crearPanelMateriasAgregadas() {
        JPanel panel = new JPanel(new BorderLayout(10, 10)); 
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1, true),
                "Materias Agregadas",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                COLOR_TEXTO));
        panel.setBackground(COLOR_FONDO);
    
        
        String[] columnNames = {"Código", "Nombre", "Obligatoria", "Cuatrimestre", "Correlativas", "Promocion"};
        tableModelMateriasAgregadas = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModelMateriasAgregadas);
        table.setBackground(COLOR_BOTON);
        table.setForeground(COLOR_TEXTO);
        table.setGridColor(COLOR_BORDE);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25); 
    
       
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(200); 
        table.getColumnModel().getColumn(5).setPreferredWidth(100); 
    
        
        for (Materia materia : todasLasMaterias) {
            
            String correlativas = materia.getCorrelativas().stream()
                    .map(Materia::getCodigo)
                    .reduce((s1, s2) -> s1 + ", " + s2)
                    .orElse(""); 
    
            Object[] row = {
                materia.getCodigo(),
                materia.getNombre(),
                materia.isObligatoria(),
                materia.getCuatrimestre(),
                correlativas,
                materia.getTienePromocion() 
            };
            tableModelMateriasAgregadas.addRow(row);
        }
    
       
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 150)); 
        panel.add(scrollPane, BorderLayout.CENTER);
    
        return panel;
    }

    private JButton crearBoton(String texto, Color colorFondo, Color colorHover) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFondo.darker(), 2),
                BorderFactory.createEmptyBorder(8, 16, 8, 16))); 
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(150, 35)); 

       
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorHover);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorFondo);
            }
        });

        return boton;
    }
    
    private void actualizarTablaMateriasAgregadas() {
      
        tableModelMateriasAgregadas.setRowCount(0);
    
       
        for (Materia materia : todasLasMaterias) {
        
            String correlativas = materia.getCorrelativas().stream()
                    .map(Materia::getCodigo)
                    .reduce((s1, s2) -> s1 + ", " + s2)
                    .orElse(""); 
    
            Object[] row = {
                materia.getCodigo(),
                materia.getNombre(),
                materia.isObligatoria(),
                materia.getCuatrimestre(),
                correlativas,
                materia.getTienePromocion() 
            };
            tableModelMateriasAgregadas.addRow(row);
        }
    }

    private void actualizarTablaCorrelativas() {
       
        tableModelCorrelativas.setRowCount(0);
    
       
        for (Materia materia : todasLasMaterias) {
            Object[] row = {false, materia.getCodigo(), materia.getNombre()};
            tableModelCorrelativas.addRow(row);
        }
    }

    private boolean existeMateriaConCodigo(String codigo) {
        return todasLasMaterias.stream().anyMatch(m -> m.getCodigo().equalsIgnoreCase(codigo));
    }

    private boolean existeMateriaConNombre(String nombre) {
        return todasLasMaterias.stream().anyMatch(m -> m.getNombre().equalsIgnoreCase(nombre));
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void guardarPlan() {
        if (nombrePlanField.getText().isEmpty()) {
            mostrarMensaje("Debe ingresar un nombre para el plan.");
            return;
        }

        if (todasLasMaterias.isEmpty()) {
            mostrarMensaje("Debe agregar al menos una materia.");
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

        for (Materia materia : todasLasMaterias) {
            if (materia.isObligatoria()) {
                nuevoPlan.agregarMateriaObligatoria(materia);
            } else {
                nuevoPlan.agregarMateriaOptativa(materia);
            }
        }

        sistema.getPlanesEstudio().add(nuevoPlan);
        mostrarMensaje("Plan de estudio guardado exitosamente.");
        dispose();
    }
}