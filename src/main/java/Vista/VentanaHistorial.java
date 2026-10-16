package Vista;

import Controlador.SessionController;
import javax.swing.*;
import java.awt.*;

public class VentanaHistorial {
    private final JFrame frame = new JFrame("Historial - Casino Black Cat");
    private SessionController session;

    public VentanaHistorial(SessionController session) {
        this.session = session;

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        configurarVentana();
    }

    private void configurarVentana() {
        JLabel lblTitulo = new JLabel("Historial de Jugadas: " + session.getNombreUsuario(), SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea txtAreaHistorial = new JTextArea();
        txtAreaHistorial.setEditable(false);
        txtAreaHistorial.setText("Cargando historial...");

        JScrollPane scrollPane = new JScrollPane(txtAreaHistorial);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel panelSur = new JPanel();
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> volverAlMenu());
        panelSur.add(btnVolver);

        frame.add(lblTitulo, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelSur, BorderLayout.SOUTH);
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void volverAlMenu() {
        frame.dispose();
        new VentanaMenu(session).mostrarVentana();
    }
}