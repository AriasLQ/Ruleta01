import javax.swing.*;
import java.awt.*;



public class VentanaRuleta {
    private final JFrame frame = new JFrame("Juego - Casino Black Cat");
    private final String nombreUsuario;

    public VentanaRuleta(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private JComboBox<String> cmbTipoApuesta;
    private JTextField txtMonto;
    private JLabel lblResultado;

    private void configurarVentana() {
        JPanel panelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] opcionesApuesta = {"Par (P)", "Impar (I)", "Rojo (R)", "Negro (N)"};
        cmbTipoApuesta = new JComboBox<>(opcionesApuesta);
        txtMonto = new JTextField(10);

        panelFormulario.add(new JLabel("Tipo de apuesta:"));
        panelFormulario.add(cmbTipoApuesta);
        panelFormulario.add(new JLabel("Monto a apostar:"));
        panelFormulario.add(txtMonto);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGirar = new JButton("Girar Ruleta");
        JButton btnVolver = new JButton("Volver al Menú");
        panelBotones.add(btnGirar);
        panelBotones.add(btnVolver);

        JPanel panelSur = new JPanel(new BorderLayout());
        lblResultado = new JLabel("Haz tu apuesta para comenzar.", SwingConstants.CENTER);
        lblResultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelSur.add(panelBotones, BorderLayout.NORTH);
        panelSur.add(lblResultado, BorderLayout.SOUTH);

        frame.add(new JLabel("Jugador: " + nombreUsuario, SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(panelFormulario, BorderLayout.CENTER);
        frame.add(panelSur, BorderLayout.SOUTH);
    }
}