import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame {

    private JButton alumnosButton;
    private JButton carrerasButton;
    private JButton informesButton;
    private ArrayList<Alumno> alumnos; // Añadido
    private ArrayList<Carrera> carreras;

    public MenuPrincipal(ArrayList<Alumno> alumnos, ArrayList<Carrera> carreras) { // Recibe el ArrayList de alumnos
        this.alumnos = alumnos; // Guarda la referencia al ArrayList
        this.carreras = carreras;
        setTitle("Menú Principal");
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color backgroundColor = new Color(30, 30, 30);
        Color buttonColor = new Color(60, 60, 60);
        Color textColor = new Color(200, 200, 200);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));
        mainPanel.setBackground(backgroundColor);

        alumnosButton = new JButton("Alumnos");
        alumnosButton.setBackground(buttonColor);
        alumnosButton.setForeground(textColor);
        mainPanel.add(alumnosButton);

        carrerasButton = new JButton("Carreras");
        carrerasButton.setBackground(buttonColor);
        carrerasButton.setForeground(textColor);
        mainPanel.add(carrerasButton);

        informesButton = new JButton("Informes");
        informesButton.setBackground(buttonColor);
        informesButton.setForeground(textColor);
        mainPanel.add(informesButton);

        alumnosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AgregarAlumno appAlumno = new AgregarAlumno(MenuPrincipal.this, alumnos);
                appAlumno.setVisible(true);
            }
        });

        carrerasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuPrincipal.this, "Gestión de carreras aún no implementada.");
            }
        });

        informesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuPrincipal.this, "Generación de informes aún no implementada.");
            }
        });

        add(mainPanel);
    }
}
