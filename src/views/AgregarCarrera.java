package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.*;

public class AgregarCarrera extends JDialog {

    private final Color COLOR_FONDO = SistemaUniversitario.COLOR_FONDO;
    private final Color COLOR_BOTON = SistemaUniversitario.COLOR_BOTON;
    private final Color COLOR_TEXTO = SistemaUniversitario.COLOR_TEXTO;
    private final Color COLOR_BORDE = SistemaUniversitario.COLOR_BORDE;

    private final SistemaUniversitario sistema;
    private final JTextField nombreCarreraField;
    private final JSpinner optativasRequeridas;
    private final JComboBox<PlanEstudio> planEstudioCombo;

    public AgregarCarrera(SistemaUniversitario sistema) {
        super(sistema, "Agregar Carrera", true);
        this.sistema = sistema;

        setLayout(new GridBagLayout());
        setSize(800, 300); // Tamaño fijo
        setMinimumSize(new Dimension(500, 300)); // Tamaño mínimo
        setLocationRelativeTo(sistema); // Centrar la ventana
        getContentPane().setBackground(COLOR_FONDO);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Panel para datos básicos de la carrera
        JPanel datosCarreraPanel = new JPanel(new GridBagLayout());
        datosCarreraPanel.setBorder(BorderFactory.createTitledBorder("Datos de la Carrera"));
        datosCarreraPanel.setBackground(COLOR_FONDO);
        ((TitledBorder) datosCarreraPanel.getBorder()).setTitleColor(COLOR_TEXTO);

        // Nombre de la carrera
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(COLOR_TEXTO);
        nombreCarreraField = new JTextField(20);
        nombreCarreraField.setBackground(COLOR_BOTON);
        nombreCarreraField.setForeground(COLOR_TEXTO);
        nombreCarreraField.setCaretColor(COLOR_TEXTO);

        // Plan de estudio
        JLabel planLabel = new JLabel("Plan de Estudio:");
        planLabel.setForeground(COLOR_TEXTO);
        planEstudioCombo = new JComboBox<>(sistema.getPlanesEstudio().toArray(new PlanEstudio[0]));
        planEstudioCombo.setBackground(COLOR_BOTON);
        planEstudioCombo.setForeground(COLOR_TEXTO);

        // Materias optativas requeridas
        JLabel optativasLabel = new JLabel("Materias Optativas Requeridas:");
        optativasLabel.setForeground(COLOR_TEXTO);
        optativasRequeridas = new JSpinner(new SpinnerNumberModel(2, 0, 10, 1));
        optativasRequeridas.setBackground(COLOR_BOTON);

        // Acceder al campo de texto interno del JSpinner y configurar sus colores
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) optativasRequeridas.getEditor();
        JTextField textField = editor.getTextField();
        textField.setForeground(COLOR_TEXTO); // Color del texto
        textField.setBackground(COLOR_BOTON); // Color de fondo
        textField.setCaretColor(COLOR_TEXTO); // Color del cursor

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

        // Botón guardar carrera
        JButton guardarCarreraBtn = crearBoton("Guardar Carrera");
        guardarCarreraBtn.addActionListener(e -> guardarCarrera());

        // Agregar todos los paneles a la ventana principal
        gbc.gridx = 0; gbc.gridy = 0;
        add(datosCarreraPanel, gbc);

        gbc.gridy = 1;
        add(guardarCarreraBtn, gbc);

        // Configuración final de la ventana
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

    private void guardarCarrera() {
        if (nombreCarreraField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la carrera");
            return;
        }

        Carrera nuevaCarrera = new Carrera(
            nombreCarreraField.getText(),
            (PlanEstudio) planEstudioCombo.getSelectedItem(),
            (int) optativasRequeridas.getValue()
        );

        sistema.getCarreras().add(nuevaCarrera);
        JOptionPane.showMessageDialog(this, "Carrera agregada exitosamente");
        dispose();
    }
}