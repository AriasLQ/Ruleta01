package Vista;

import Controlador.RuletaController;
import Controlador.SessionController;
import Modelo.Resultado;
import Modelo.TipoApuesta;

import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Juego - Casino Black Cat");
    private SessionController session;
    private RuletaController ruletaController;

    private JComboBox<String> cmbTipoApuesta;
    private JTextField txtMonto;
    private JLabel lblResultado;

    public VentanaRuleta(SessionController session) {
        this.session = session;
        this.ruletaController = new RuletaController();

        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        configurarVentana();
    }

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

        frame.add(new JLabel("Jugador: " + session.getNombreUsuario(), SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(panelFormulario, BorderLayout.CENTER);
        frame.add(panelSur, BorderLayout.SOUTH);

        btnGirar.addActionListener(e -> jugarRonda());
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void jugarRonda() {
        int monto;
        try {
            monto = Integer.parseInt(txtMonto.getText());
            if (monto <= 0) {
                JOptionPane.showMessageDialog(frame, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index = cmbTipoApuesta.getSelectedIndex();
        TipoApuesta tipo = (index == 0) ? TipoApuesta.PAR :
                (index == 1) ? TipoApuesta.IMPAR :
                (index == 2) ? TipoApuesta.ROJO : TipoApuesta.NEGRO;

        Resultado resultado = ruletaController.realizarApuesta(monto, tipo);

        String mensaje = "Salió el número: " + resultado.getNumeroGanador() + " | " + (resultado.isAcierto() ? "¡GANASTE!" : "PERDISTE");
        lblResultado.setText(mensaje);
        lblResultado.setForeground(resultado.isAcierto() ? new Color(0, 153, 0) : Color.RED);
    }

    private void volverAlMenu() {
        frame.dispose();
        new VentanaMenu(session).mostrarVentana();
    }
}