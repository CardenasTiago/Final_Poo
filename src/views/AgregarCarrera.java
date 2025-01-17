package views;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.*;

public class AgregarCarrera extends JDialog {

    private  Color COLOR_FONDO = SistemaUniversitario.COLOR_FONDO;
    private  Color COLOR_BOTON = SistemaUniversitario.COLOR_BOTON;
    private  Color COLOR_TEXTO = SistemaUniversitario.COLOR_TEXTO;
    private  Color COLOR_BORDE = SistemaUniversitario.COLOR_BORDE;

    private final SistemaUniversitario sistema;
    private final JTextField nombreCarreraField;
    private final JSpinner optativasRequeridas;
    private final JComboBox<PlanEstudio> planEstudioCombo;
    private final DefaultListModel<Materia> materiasObligatoriasListModel;
    private final DefaultListModel<Materia> materiasOptativasListModel;
    private final List<Materia> todasLasMaterias;

    public AgregarCarrera(SistemaUniversitario sistema) {
        super(sistema, "Agregar Carrera", true);
        this.sistema = sistema;
        this.todasLasMaterias = new ArrayList<>();
        
        // Configurar ventana
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Panel para datos básicos de la carrera
        JPanel datosCarreraPanel = new JPanel(new GridBagLayout());
        datosCarreraPanel.setBorder(BorderFactory.createTitledBorder("Datos de la Carrera"));
        datosCarreraPanel.setBackground(sistema.COLOR_FONDO);
        ((TitledBorder) datosCarreraPanel.getBorder()).setTitleColor(sistema.COLOR_TEXTO);
        
        // Nombre de la carrera
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(sistema.COLOR_TEXTO);
        nombreCarreraField = new JTextField(20);
        nombreCarreraField.setBackground(sistema.COLOR_BOTON);
        nombreCarreraField.setForeground(sistema.COLOR_TEXTO);
        nombreCarreraField.setCaretColor(sistema.COLOR_TEXTO);
        
        // Plan de estudio
        JLabel planLabel = new JLabel("Plan de Estudio:");
        planLabel.setForeground(sistema.COLOR_TEXTO);
        planEstudioCombo = new JComboBox<>(PlanEstudio.values());
        planEstudioCombo.setBackground(sistema.COLOR_BOTON);
        planEstudioCombo.setForeground(sistema.COLOR_TEXTO);
        
        // Materias optativas requeridas
        JLabel optativasLabel = new JLabel("Materias Optativas Requeridas:");
        optativasLabel.setForeground(sistema.COLOR_TEXTO);
        optativasRequeridas = new JSpinner(new SpinnerNumberModel(2, 0, 10, 1));
        optativasRequeridas.setBackground(sistema.COLOR_BOTON);
        ((JSpinner.DefaultEditor) optativasRequeridas.getEditor()).getTextField().setForeground(sistema.COLOR_BOTON);
        
        // Agregar componentes al panel de datos
        GridBagConstraints gbcDatos = new GridBagConstraints();
        gbcDatos.insets = new Insets(5, 5, 5, 5);
        gbcDatos.fill = GridBagConstraints.HORIZONTAL;
        
        gbcDatos.gridx = 0; gbcDatos.gridy = 0;
        datosCarreraPanel.add(nombreLabel, gbcDatos);
        gbcDatos.gridx = 1;
        datosCarreraPanel.add(nombreCarreraField, gbcDatos);
        
        gbcDatos.gridx = 0; gbcDatos.gridy = 1;
        datosCarreraPanel.add(planLabel, gbcDatos);
        gbcDatos.gridx = 1;
        datosCarreraPanel.add(planEstudioCombo, gbcDatos);
        
        gbcDatos.gridx = 0; gbcDatos.gridy = 2;
        datosCarreraPanel.add(optativasLabel, gbcDatos);
        gbcDatos.gridx = 1;
        datosCarreraPanel.add(optativasRequeridas, gbcDatos);
        
        // Panel para gestión de materias
        JPanel materiasPanel = new JPanel(new GridBagLayout());
        materiasPanel.setBorder(BorderFactory.createTitledBorder("Gestión de Materias"));
        materiasPanel.setBackground(sistema.COLOR_FONDO);
        ((TitledBorder) materiasPanel.getBorder()).setTitleColor(sistema.COLOR_TEXTO);
        
        // Componentes para agregar nueva materia
        JTextField codigoField = new JTextField(10);
        JTextField nombreMateriaField = new JTextField(20);
        JCheckBox promocionableCheck = new JCheckBox("Promocionable");
        JSpinner anioSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
        
        // Estilo para componentes
        codigoField.setBackground(sistema.COLOR_BOTON);
        codigoField.setForeground(sistema.COLOR_TEXTO);
        nombreMateriaField.setBackground(sistema.COLOR_BOTON);
        nombreMateriaField.setForeground(sistema.COLOR_TEXTO);
        promocionableCheck.setBackground(sistema.COLOR_FONDO);
        promocionableCheck.setForeground(sistema.COLOR_TEXTO);
        anioSpinner.setBackground(sistema.COLOR_BOTON);
        ((JSpinner.DefaultEditor) anioSpinner.getEditor()).getTextField().setForeground(sistema.COLOR_BOTON);
        
        // Botón para agregar materia
        JButton agregarMateriaBtn = crearBoton("Agregar Materia");
        agregarMateriaBtn.addActionListener(e -> {
            Materia nuevaMateria = new Materia(
                codigoField.getText(),
                nombreMateriaField.getText(),
                promocionableCheck.isSelected(),
                (int) anioSpinner.getValue()
            );
            todasLasMaterias.add(nuevaMateria);
            actualizarListasMaterias();
            
            // Limpiar campos
            codigoField.setText("");
            nombreMateriaField.setText("");
            promocionableCheck.setSelected(false);
            anioSpinner.setValue(1);
        });
        
        // Listas de materias
        materiasObligatoriasListModel = new DefaultListModel<>();
        materiasOptativasListModel = new DefaultListModel<>();
        
        JList<Materia> materiasObligatoriasList = new JList<>(materiasObligatoriasListModel);
        JList<Materia> materiasOptativasList = new JList<>(materiasOptativasListModel);
        
        // Estilo para las listas
        materiasObligatoriasList.setBackground(sistema.COLOR_BOTON);
        materiasObligatoriasList.setForeground(sistema.COLOR_TEXTO);
        materiasOptativasList.setBackground(sistema.COLOR_BOTON);
        materiasOptativasList.setForeground(sistema.COLOR_TEXTO);
        
        // Botones para mover materias
        JButton hacerObligatoriaBtn = crearBoton("←  Hacer Obligatoria");
        JButton hacerOptativaBtn = crearBoton("→ Hacer Optativa");
        
        hacerObligatoriaBtn.addActionListener(e -> {
            Materia selected = materiasOptativasList.getSelectedValue();
            if (selected != null) {
                materiasOptativasListModel.removeElement(selected);
                materiasObligatoriasListModel.addElement(selected);
            }
        });
        
        hacerOptativaBtn.addActionListener(e -> {
            Materia selected = materiasObligatoriasList.getSelectedValue();
            if (selected != null) {
                materiasObligatoriasListModel.removeElement(selected);
                materiasOptativasListModel.addElement(selected);
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
        materiasPanel.add(new JLabel("Año:"), gbcMaterias);
        gbcMaterias.gridx = 1;
        materiasPanel.add(anioSpinner, gbcMaterias);
        gbcMaterias.gridx = 2;
        materiasPanel.add(promocionableCheck, gbcMaterias);
        gbcMaterias.gridx = 3;
        materiasPanel.add(agregarMateriaBtn, gbcMaterias);
        
        // Tercera fila: listas de materias
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 2;
        gbcMaterias.gridwidth = 2;
        materiasPanel.add(new JScrollPane(materiasObligatoriasList), gbcMaterias);
        gbcMaterias.gridx = 2;
        materiasPanel.add(new JScrollPane(materiasOptativasList), gbcMaterias);
        
        // Cuarta fila: botones de movimiento
        gbcMaterias.gridx = 0; gbcMaterias.gridy = 3;
        materiasPanel.add(hacerOptativaBtn, gbcMaterias);
        gbcMaterias.gridx = 2;
        materiasPanel.add(hacerObligatoriaBtn, gbcMaterias);
        
        // Botón guardar carrera
        JButton guardarCarreraBtn = crearBoton("Guardar Carrera");
        guardarCarreraBtn.addActionListener(e -> guardarCarrera());
        
        // Agregar todos los paneles a la ventana principal
        gbc.gridx = 0; gbc.gridy = 0;
        add(datosCarreraPanel, gbc);
        
        gbc.gridy = 1;
        add(materiasPanel, gbc);
        
        gbc.gridy = 2;
        add(guardarCarreraBtn, gbc);
        
        // Configuración final de la ventana
        pack();
        setLocationRelativeTo(sistema);
        setVisible(true);
    }
    
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBackground(sistema.COLOR_BOTON);
        boton.setForeground(sistema.COLOR_TEXTO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(sistema.COLOR_BORDE, 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return boton;
    }
    
    private void actualizarListasMaterias() {
        materiasObligatoriasListModel.clear();
        materiasOptativasListModel.clear();
        for (Materia materia : todasLasMaterias) {
            materiasObligatoriasListModel.addElement(materia);
        }
    }
    
    private void guardarCarrera() {
        if (nombreCarreraField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la carrera");
            return;
        }
        
        if (materiasObligatoriasListModel.isEmpty() && materiasOptativasListModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar al menos una materia");
            return;
        }
        
        Carrera nuevaCarrera = new Carrera(
            nombreCarreraField.getText(),
            (PlanEstudio) planEstudioCombo.getSelectedItem(),
            (int) optativasRequeridas.getValue()
        );
        
        // Agregar materias obligatorias
        for (int i = 0; i < materiasObligatoriasListModel.size(); i++) {
            nuevaCarrera.agregarMateriaObligatoria(materiasObligatoriasListModel.getElementAt(i));
        }
        
        // Agregar materias optativas
        for (int i = 0; i < materiasOptativasListModel.size(); i++) {
            nuevaCarrera.agregarMateriaOptativa(materiasOptativasListModel.getElementAt(i));
        }
        
        sistema.getCarreras().add(nuevaCarrera);
        JOptionPane.showMessageDialog(this, "Carrera agregada exitosamente");
        dispose();
    }
}