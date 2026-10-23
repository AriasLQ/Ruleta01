package Vista;

import Controlador.SessionController;
import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {
    private final JFrame frame = new JFrame("Estadísticas - Casino Black Cat");
    private SessionController session;

    public VentanaEstadisticas(SessionController session) {
        this.session = session;
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}