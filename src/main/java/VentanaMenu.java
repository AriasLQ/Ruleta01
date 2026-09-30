import javax.swing.*;
import java.awt.*;

public class VentanaMenu {
    private final JFrame frame = new JFrame("RULETA - Casino Black Cat");
    private final String nombreUsuario;

    public VentanaMenu(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void configurarVentana() {
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton btnJugar = new JButton("Jugar");
        JButton btnHistorial = new JButton("Historial");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnJugar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnSalir);

        JTextArea txtInfo = new JTextArea("Bienvenido/a al menú principal.\n\nA la izquierda tienes las opciones de juego.");
        txtInfo.setEditable(false);
        txtInfo.setOpaque(false);
        txtInfo.setMargin(new Insets(10, 10, 10, 10));

        JLabel lblUsuario = new JLabel("Usuario activo: " + nombreUsuario);

        frame.add(panelBotones, BorderLayout.WEST);
        frame.add(txtInfo, BorderLayout.CENTER);
        frame.add(lblUsuario, BorderLayout.SOUTH);

        btnSalir.addActionListener(e -> System.exit(0));
    }

}