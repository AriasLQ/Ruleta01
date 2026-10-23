package Vista;

import Controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu {
    private final JFrame frame = new JFrame("RULETA - Casino Black Cat");
    private SessionController session;

    public VentanaMenu(SessionController session) {
        this.session = session;
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        configurarVentana();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void configurarVentana() {
        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton btnJugar = new JButton("Jugar");
        JButton btnHistorial = new JButton("Historial");
        JButton btnEstadisticas = new JButton("Estadísticas");
        JButton btnSalir = new JButton("Cerrar Sesión");

        panelBotones.add(btnJugar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnEstadisticas);
        panelBotones.add(btnSalir);

        JTextArea txtInfo = new JTextArea("Bienvenido/a al menú principal.\n\nA la izquierda tienes las opciones de juego.");
        txtInfo.setEditable(false);
        txtInfo.setOpaque(false);
        txtInfo.setMargin(new Insets(10, 10, 10, 10));

        JLabel lblUsuario = new JLabel("Usuario activo: " + session.getNombreUsuario());

        frame.add(panelBotones, BorderLayout.WEST);
        frame.add(txtInfo, BorderLayout.CENTER);
        frame.add(lblUsuario, BorderLayout.SOUTH);

        btnJugar.addActionListener(e -> abrirVentanaJuego());
        btnHistorial.addActionListener(e -> abrirVentanaHistorial());
        btnSalir.addActionListener(e -> cerrarSesion());
    }

    private void abrirVentanaJuego() {
        frame.dispose();
        new VentanaRuleta(session).mostrarVentana();
    }

    private void abrirVentanaHistorial() {
        frame.dispose();
        new VentanaHistorial(session).mostrarVentana();
    }

    private void cerrarSesion() {
        session.cerrarSesion();
        frame.dispose();
        new VentanaLogin(session).mostrarVentana();
    }
}