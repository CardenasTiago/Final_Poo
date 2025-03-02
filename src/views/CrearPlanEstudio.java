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

    // Componentes para gestión de correlativas
    private JList<Materia> listaMaterias;
    private JList<Materia> listaCorrelativas;
    private DefaultListModel<Materia> materiasListModel;
    private DefaultListModel<Materia> correlativasListModel;

    // Panel para mostrar las materias agregadas
    private JPanel panelMateriasAgregadas;
    private DefaultTableModel tableModelMateriasAgregadas; // Referencia al modelo de la tabla de materias agregadas

    // Referencia al panel de correlativas
    private JPanel panelCorrelativas;
    private DefaultTableModel tableModelCorrelativas; // Referencia al modelo de la tabla de correlativas

    public CrearPlanEstudio(SistemaUniversitario sistema) {
        super(sistema, "Crear Plan de Estudio", true);
        this.sistema = sistema;
        this.todasLasMaterias = new ArrayList<>();

        // Inicialización de componentes
        this.materiasListModel = new DefaultListModel<>();
        this.correlativasListModel = new DefaultListModel<>();
        this.listaMaterias = new JList<>(materiasListModel);
        this.listaCorrelativas = new JList<>(correlativasListModel);

        // Configurar ventana
        setLayout(new BorderLayout()); // Cambiado a BorderLayout para mejor distribución
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Organización vertical
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Margen para todo el contenido
        mainPanel.setBackground(COLOR_FONDO); // Fondo gris muy oscuro

        // Panel para datos básicos del plan
        JPanel datosPlanPanel = crearPanelDatosPlan();
        datosPlanPanel.setMinimumSize(new Dimension(700, 120)); // Tamaño mínimo
        datosPlanPanel.setPreferredSize(new Dimension(700, 120)); // Tamaño preferido
        mainPanel.add(datosPlanPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio vertical

        // Panel para gestión de materias
        JPanel materiasPanel = crearPanelMaterias();
        materiasPanel.setMinimumSize(new Dimension(700, 250)); // Tamaño mínimo
        materiasPanel.setPreferredSize(new Dimension(700, 250)); // Tamaño preferido
        mainPanel.add(materiasPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio vertical

        // Panel para mostrar materias agregadas
        panelMateriasAgregadas = crearPanelMateriasAgregadas();
        panelMateriasAgregadas.setMinimumSize(new Dimension(700, 200)); // Tamaño mínimo
        panelMateriasAgregadas.setPreferredSize(new Dimension(700, 200)); // Tamaño preferido
        mainPanel.add(panelMateriasAgregadas);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio vertical

        // Botón guardar plan
        JButton guardarPlanBtn = crearBoton("Guardar Plan", COLOR_BOTON, COLOR_HOVER);
        guardarPlanBtn.addActionListener(e -> guardarPlan());
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(COLOR_FONDO);
        buttonPanel.add(guardarPlanBtn);
        mainPanel.add(buttonPanel);

        // Añadir panel principal a un JScrollPane para permitir scroll si es necesario
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        // Configuración final de la ventana
        setSize(800, 800); // Tamaño aumentado de la ventana
        setMinimumSize(new Dimension(750, 700)); // Tamaño mínimo
        setLocationRelativeTo(sistema);
        setResizable(true); // Permitir redimensionar, pero con tamaños mínimos establecidos
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
        gbc.insets = new Insets(8, 8, 8, 8); // Mayor espacio entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Nombre del plan
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
        nombrePlanField.setPreferredSize(new Dimension(300, 30)); // Establecer tamaño preferido

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
        tipoPlanComboBox.setPreferredSize(new Dimension(300, 30)); // Establecer tamaño preferido

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
        gbc.insets = new Insets(8, 8, 8, 8); // Mayor espacio
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
    
        // Campos para agregar nueva materia
        JTextField codigoField = new JTextField(10);
        JTextField nombreMateriaField = new JTextField(20);
        JCheckBox obligatoriaCheck = new JCheckBox("Obligatoria");
        JCheckBox promocionableCheck = new JCheckBox("Promocionable"); // Nuevo JCheckBox para promoción
        JSpinner cuatrimestreSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
    
        // Estilo y tamaño para componentes
        codigoField.setPreferredSize(new Dimension(100, 30));
        nombreMateriaField.setPreferredSize(new Dimension(200, 30));
        cuatrimestreSpinner.setPreferredSize(new Dimension(80, 30));
    
        // Configurar colores para los campos de texto
        codigoField.setBackground(COLOR_BOTON);
        codigoField.setForeground(COLOR_TEXTO);
        nombreMateriaField.setBackground(COLOR_BOTON);
        nombreMateriaField.setForeground(COLOR_TEXTO);
    
        // Configurar colores para los JCheckBox
        obligatoriaCheck.setBackground(COLOR_FONDO);
        obligatoriaCheck.setForeground(COLOR_TEXTO);
        promocionableCheck.setBackground(COLOR_FONDO);
        promocionableCheck.setForeground(COLOR_TEXTO);
    
        // Configurar colores para el JSpinner
        cuatrimestreSpinner.setBackground(COLOR_BOTON);
    
        // Acceder al campo de texto interno del JSpinner y configurar sus colores
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) cuatrimestreSpinner.getEditor();
        JTextField textField = editor.getTextField();
        textField.setForeground(COLOR_TEXTO); // Color del texto
        textField.setBackground(COLOR_BOTON); // Color de fondo
        textField.setCaretColor(COLOR_TEXTO); // Color del cursor
    
        // Etiquetas con fuente establecida
        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setForeground(COLOR_TEXTO); // Cambiar el color del texto a blanco
    
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(COLOR_TEXTO); // Cambiar el color del texto a blanco
    
        JLabel cuatrimestreLabel = new JLabel("Cuatrimestre:");
        cuatrimestreLabel.setForeground(COLOR_TEXTO); // Cambiar el color del texto a blanco
    
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        cuatrimestreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        obligatoriaCheck.setFont(new Font("Arial", Font.PLAIN, 12));
        promocionableCheck.setFont(new Font("Arial", Font.PLAIN, 12));
    
        // Panel para seleccionar correlativas
        panelCorrelativas = crearPanelCorrelativas();
    
        // Botón para agregar materia
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
    
            // Crear la nueva materia
            Materia nuevaMateria = new Materia(codigo, nombre, obligatoriaCheck.isSelected(), cuatrimestre);
            nuevaMateria.setTienePromocion(promocionableCheck.isSelected()); // Establecer si es promocionable
    
            // Agregar correlativas seleccionadas
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
    
            // Agregar la nueva materia a la lista
            todasLasMaterias.add(nuevaMateria);
    
            // Actualizar la tabla de correlativas
            actualizarTablaCorrelativas();
    
            // Actualizar la tabla de materias agregadas
            actualizarTablaMateriasAgregadas();
    
            // Limpiar campos
            codigoField.setText("");
            nombreMateriaField.setText("");
            obligatoriaCheck.setSelected(false);
            promocionableCheck.setSelected(false); // Limpiar el checkbox de promoción
            cuatrimestreSpinner.setValue(1);
    
            // Limpiar selecciones en la tabla de correlativas
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(false, i, 0);
            }
    
            mostrarMensaje("Materia agregada con éxito.");
        });
    
        // Primera fila
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
    
        // Segunda fila
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
        panel.add(promocionableCheck, gbc); // Agregar el JCheckBox de promoción
    
        gbc.gridx = 4;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(agregarMateriaBtn, gbc);
    
        // Panel de correlativas (tercera fila)
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
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Añadir espacio
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1, true),
                "Seleccionar Correlativas",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                COLOR_TEXTO));
        panel.setBackground(COLOR_FONDO);
    
        // Crear un modelo de tabla con columnas para selección, código y nombre
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
        table.setRowHeight(25); // Filas más altas
    
        // Configurar ancho de columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
    
        // Llenar la tabla con las materias disponibles
        for (Materia materia : todasLasMaterias) {
            Object[] row = {false, materia.getCodigo(), materia.getNombre()};
            tableModelCorrelativas.addRow(row);
        }
    
        // Scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 120)); // Altura fija para el scrollpane
        panel.add(scrollPane, BorderLayout.CENTER);
    
        return panel;
    }

    private JPanel crearPanelMateriasAgregadas() {
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Añadir espacio
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE, 1, true),
                "Materias Agregadas",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                COLOR_TEXTO));
        panel.setBackground(COLOR_FONDO);
    
        // Crear un modelo de tabla con columnas para código, nombre, obligatoria, cuatrimestre, correlativas y promocionable
        String[] columnNames = {"Código", "Nombre", "Obligatoria", "Cuatrimestre", "Correlativas", "Promocion"};
        tableModelMateriasAgregadas = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModelMateriasAgregadas);
        table.setBackground(COLOR_BOTON);
        table.setForeground(COLOR_TEXTO);
        table.setGridColor(COLOR_BORDE);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25); // Filas más altas
    
        // Configurar ancho de columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(200); // Ancho para la columna de correlativas
        table.getColumnModel().getColumn(5).setPreferredWidth(100); // Ancho para la columna de promocionable
    
        // Llenar la tabla con las materias agregadas
        for (Materia materia : todasLasMaterias) {
            // Obtener los códigos de las correlativas
            String correlativas = materia.getCorrelativas().stream()
                    .map(Materia::getCodigo)
                    .reduce((s1, s2) -> s1 + ", " + s2)
                    .orElse(""); // Si no hay correlativas, devuelve una cadena vacía
    
            Object[] row = {
                materia.getCodigo(),
                materia.getNombre(),
                materia.isObligatoria(),
                materia.getCuatrimestre(),
                correlativas,
                materia.getTienePromocion() // Mostrar si es promocionable
            };
            tableModelMateriasAgregadas.addRow(row);
        }
    
        // Scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 150)); // Altura fija para el scrollpane
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
                BorderFactory.createEmptyBorder(8, 16, 8, 16))); // Más padding
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(150, 35)); // Tamaño fijo para botones

        // Efecto hover
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
        // Limpiar la tabla
        tableModelMateriasAgregadas.setRowCount(0);
    
        // Llenar la tabla con las materias agregadas
        for (Materia materia : todasLasMaterias) {
            // Obtener los códigos de las correlativas
            String correlativas = materia.getCorrelativas().stream()
                    .map(Materia::getCodigo)
                    .reduce((s1, s2) -> s1 + ", " + s2)
                    .orElse(""); // Si no hay correlativas, devuelve una cadena vacía
    
            Object[] row = {
                materia.getCodigo(),
                materia.getNombre(),
                materia.isObligatoria(),
                materia.getCuatrimestre(),
                correlativas,
                materia.getTienePromocion() // Mostrar si es promocionable
            };
            tableModelMateriasAgregadas.addRow(row);
        }
    }

    private void actualizarTablaCorrelativas() {
        // Limpiar la tabla
        tableModelCorrelativas.setRowCount(0);
    
        // Llenar la tabla con las materias disponibles
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