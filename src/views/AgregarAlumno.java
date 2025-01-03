package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.Alumno;

public class AgregarAlumno extends JFrame {
    private JTextField nombreField;
    private JTextField legajoField;
    private JTextField emailField;
    private JButton addButton;
    private JButton buscarButton;
    private JButton volverButton;
    private JTextArea listaAlumnosArea;
    private MenuPrincipal menuPrincipal;
    private ArrayList<Alumno> alumnos;

    public AgregarAlumno(MenuPrincipal menuPrincipal, ArrayList<Alumno> alumnos) {
        this.menuPrincipal = menuPrincipal;
        this.alumnos = alumnos;

        initializeComponents();
        setupLayout();
        setupListeners();
        actualizarListaAlumnos(); // Mostrar alumnos existentes al iniciar
    }

    private void initializeComponents() {
        setTitle("Agregar Alumno");
        setSize(600, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nombreField = new JTextField(15);
        legajoField = new JTextField(15);
        emailField = new JTextField(15);
        addButton = new JButton("Añadir");
        buscarButton = new JButton("Buscar Alumno");
        volverButton = new JButton("Volver");
        listaAlumnosArea = new JTextArea(10, 40);
        listaAlumnosArea.setEditable(false);
    }

    private void setupLayout() {
        Color backgroundColor = new Color(30, 30, 30);
        Color textColor = new Color(255, 255, 255);
        Color buttonColor = new Color(60, 60, 60);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(backgroundColor);

        // Panel de añadir
        JPanel addPanel = createTitledPanel("Añadir Alumno", backgroundColor, textColor);
        addPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Configurar campos
        styleTextField(nombreField, backgroundColor, textColor);
        styleTextField(legajoField, backgroundColor, textColor);
        styleTextField(emailField, backgroundColor, textColor);
        styleButton(addButton, buttonColor, textColor);
        styleButton(buscarButton, buttonColor, textColor);

        // Añadir componentes al panel de añadir
        gbc.gridx = 0; gbc.gridy = 0;
        addLabeledField(addPanel, "Nombre:", textColor, backgroundColor, gbc);
        gbc.gridx = 1;
        addPanel.add(nombreField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        addLabeledField(addPanel, "Legajo:", textColor, backgroundColor, gbc);
        gbc.gridx = 1;
        addPanel.add(legajoField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        addLabeledField(addPanel, "Email:", textColor, backgroundColor, gbc);
        gbc.gridx = 1;
        addPanel.add(emailField, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        addPanel.add(addButton, gbc);

        mainPanel.add(addPanel, BorderLayout.NORTH);

        // Panel de lista de alumnos
        JPanel listaPanel = createTitledPanel("Lista de Alumnos", backgroundColor, textColor);
        listaPanel.setLayout(new BorderLayout(5, 5));

        // Configurar área de texto para la lista
        listaAlumnosArea.setBackground(Color.DARK_GRAY);
        listaAlumnosArea.setForeground(textColor);
        listaAlumnosArea.setCaretColor(textColor);
        listaAlumnosArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Agregar scroll al área de texto
        JScrollPane scrollPane = new JScrollPane(listaAlumnosArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(textColor));
        listaPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(listaPanel, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBackground(backgroundColor);

        styleButton(volverButton, buttonColor, textColor);
        styleButton(buscarButton, buttonColor, textColor);

        bottomPanel.add(volverButton);
        bottomPanel.add(buscarButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void setupListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    if (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(AgregarAlumno.this, "Por favor, ingrese un nombre.");
                        return;
                    }

                    String legajoText = legajoField.getText();
                    if (legajoText.isEmpty()) {
                        JOptionPane.showMessageDialog(AgregarAlumno.this, "Por favor, ingrese un legajo.");
                        return;
                    }

                    int legajo = Integer.parseInt(legajoText);

                    String email = emailField.getText();
                    if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(AgregarAlumno.this, "Por favor, ingrese un email.");
                        return;
                    }

                    for (Alumno alumno : alumnos) {
                        if (alumno.getLegajo() == legajo) {
                            JOptionPane.showMessageDialog(AgregarAlumno.this,
                                    "Ya existe un alumno con ese legajo.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }


                    Alumno nuevoAlumno = new Alumno(nombre, legajo, email);
                    alumnos.add(nuevoAlumno);

                    JOptionPane.showMessageDialog(AgregarAlumno.this, "Alumno añadido con éxito.");

                    nombreField.setText("");
                    legajoField.setText("");
                    emailField.setText("");

                    actualizarListaAlumnos(); // Actualizar la lista después de agregar
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AgregarAlumno.this, "El legajo debe ser un número.");
                }
            }
        });

        buscarButton.addActionListener(e -> {
            // Crea y muestra el frame de BuscarAlumno
            BuscarAlumno buscarAlumno = new BuscarAlumno(menuPrincipal, alumnos);
            buscarAlumno.setVisible(true);

            // Cierra el frame de AgregarAlumno
            dispose();
        });

        volverButton.addActionListener(e -> {
            dispose();
            menuPrincipal.setVisible(true);
        });
    }

    private void actualizarListaAlumnos() {
        StringBuilder lista = new StringBuilder();
        lista.append(String.format("%-30s %-10s %-30s%n", "Nombre", "Legajo", "Email"));
        lista.append("─".repeat(70)).append("\n");

        for (Alumno alumno : alumnos) {
            lista.append(String.format("%-30s %-10d %-30s%n",
                    alumno.getNombre(),
                    alumno.getLegajo(),
                    alumno.getEmail()));
        }

        listaAlumnosArea.setText(lista.toString());
    }

    private JPanel createTitledPanel(String title, Color backgroundColor, Color textColor) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(textColor), title,
                0, 0, null, textColor));
        panel.setBackground(backgroundColor);
        return panel;
    }

    private void addLabeledField(JPanel panel, String labelText, Color textColor, Color backgroundColor, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText);
        label.setForeground(textColor);
        panel.add(label, gbc);
    }

    private void styleTextField(JTextField textField, Color backgroundColor, Color textColor) {
        textField.setBackground(backgroundColor);
        textField.setForeground(textColor);
        textField.setCaretColor(textColor);
    }

    private void styleButton(JButton button, Color backgroundColor, Color textColor) {
        button.setBackground(backgroundColor);
        button.setForeground(textColor);
    }
}