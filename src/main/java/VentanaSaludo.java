import javax.swing.*;
import java.awt.*;

public class VentanaSaludo {
    private final JFrame frame  = new JFrame("Lobby  Casino Black Cat");
    private final JLabel lblSaludo;
    private final JButton btnJugar = new JButton("Ir a la ruleta");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaSaludo(String nombreJugador) {
        lblSaludo = new JLabel("Bienvenido al casino Black Cat" + nombreJugador, SwingConstants.CENTER);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnJugar);
        panelBotones.add(btnSalir);

        frame.add(lblSaludo, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.SOUTH);

        btnJugar.addActionListener(e -> iniciarJuego());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    public void mostrarVentana(){
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public void iniciarJuego() {
        frame.dispose();
        System.out.println("*cambiar mensaje");
        Ruleta.menu();
    }

}
