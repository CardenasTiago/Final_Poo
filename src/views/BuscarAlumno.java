package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.Alumno;

public class BuscarAlumno extends JFrame {
    private JTextField buscarLegajoField;
    private JButton buscarButton;
    private JTextArea resultadoArea;
    private JButton volverButton;
    private MenuPrincipal menuPrincipal;
    private ArrayList<Alumno> alumnos;

    public BuscarAlumno(MenuPrincipal menuPrincipal, ArrayList<Alumno> alumnos) {
        this.menuPrincipal = menuPrincipal;
        this.alumnos = alumnos;

        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        setTitle("Buscar Alumno");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        buscarLegajoField = new JTextField(15);
        buscarButton = new JButton("Buscar");
        resultadoArea = new JTextArea(5, 30);
        volverButton = new JButton("Volver");
    }

    private void setupLayout() {
        Color backgroundColor = new Color(30, 30, 30);
        Color textColor = new Color(255, 255, 255);
        Color buttonColor = new Color(60, 60, 60);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(backgroundColor);

        // Panel de búsqueda
        JPanel searchPanel = createTitledPanel("Buscar Alumno", backgroundColor, textColor);
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));

        JPanel searchFieldsPanel = new JPanel();
        searchFieldsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchFieldsPanel.setBackground(backgroundColor);

        JLabel buscarLegajoLabel = new JLabel("Legajo:");
        buscarLegajoLabel.setForeground(textColor);
        searchFieldsPanel.add(buscarLegajoLabel);

        styleTextField(buscarLegajoField, backgroundColor, textColor);
        searchFieldsPanel.add(buscarLegajoField);

        styleButton(buscarButton, buttonColor, textColor);
        searchFieldsPanel.add(buscarButton);

        searchPanel.add(searchFieldsPanel);

        resultadoArea.setEditable(false);
        resultadoArea.setBackground(Color.DARK_GRAY);
        resultadoArea.setForeground(textColor);
        resultadoArea.setBorder(BorderFactory.createLineBorder(textColor));
        searchPanel.add(new JScrollPane(resultadoArea));

        mainPanel.add(searchPanel, BorderLayout.CENTER);

        // Panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(backgroundColor);
        styleButton(volverButton, buttonColor, textColor);
        bottomPanel.add(volverButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void setupListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String legajoText = buscarLegajoField.getText();
                    if (legajoText.isEmpty()) {
                        JOptionPane.showMessageDialog(BuscarAlumno.this, "Por favor, ingrese un legajo para buscar.");
                        return;
                    }

                    int legajoBuscado = Integer.parseInt(legajoText);
                    boolean encontrado = false;

                    for (Alumno alumno : alumnos) {
                        if (alumno.getLegajo() == legajoBuscado) {
                            resultadoArea.setText("Alumno encontrado:\n" +
                                    "Nombre: " + alumno.getNombre() + "\n" +
                                    "Legajo: " + alumno.getLegajo() + "\n" +
                                    "Email: " + alumno.getEmail());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        resultadoArea.setText("No se encontró ningún alumno con el legajo " + legajoBuscado);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BuscarAlumno.this, "El legajo debe ser un número.");
                }
            }
        });

        volverButton.addActionListener(e -> {
            AgregarAlumno agregarAlumno = new AgregarAlumno(menuPrincipal, alumnos);
            agregarAlumno.setVisible(true);
            dispose();
        });
    }

    private JPanel createTitledPanel(String title, Color backgroundColor, Color textColor) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(textColor), title,
                0, 0, null, textColor));
        panel.setBackground(backgroundColor);
        return panel;
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