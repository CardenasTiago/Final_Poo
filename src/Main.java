import javax.swing.SwingUtilities;
import views.SistemaUniversitario;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaUniversitario().setVisible(true);
        });
    }
}