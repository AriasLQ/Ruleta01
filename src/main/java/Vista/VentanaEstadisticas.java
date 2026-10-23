package Vista;

import Controlador.EstadisticasController;
import Controlador.SessionController;
import Modelo.Estadisticas;
import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {
    private final JFrame frame = new JFrame("Estadísticas - Casino Black Cat");
    private SessionController session;
    private EstadisticasController estadisticasController;

    private JLabel lblTotalJugadas;
    private JLabel lblVictorias;
    private JLabel lblRachaMaxima;
    private JLabel lblTipoMasJugado;

    public VentanaEstadisticas(SessionController session) {
        this.session = session;
        this.estadisticasController = new EstadisticasController(session);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        configurarVentana();
        cargarDatos();
    }

    private void configurarVentana() {
        JLabel lblTitulo = new JLabel("Estadísticas de: " + session.getNombreUsuario(), SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelStats = new JPanel(new GridLayout(4, 1, 5, 5));
        panelStats.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblTotalJugadas = new JLabel("Total de jugadas: ");
        lblVictorias = new JLabel("Victorias (Porcentaje): ");
        lblRachaMaxima = new JLabel("Racha máxima: ");
        lblTipoMasJugado = new JLabel("Tipo más jugado: ");

        panelStats.add(lblTotalJugadas);
        panelStats.add(lblVictorias);
        panelStats.add(lblRachaMaxima);
        panelStats.add(lblTipoMasJugado);

        JPanel panelSur = new JPanel();
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> volverAlMenu());
        panelSur.add(btnVolver);

        frame.add(lblTitulo, BorderLayout.NORTH);
        frame.add(panelStats, BorderLayout.CENTER);
        frame.add(panelSur, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        Estadisticas stats = estadisticasController.obtenerEstadisticasUsuario();

        lblTotalJugadas.setText("Total de jugadas: " + stats.getTotalJugadas());
        lblVictorias.setText(String.format("Victorias (Porcentaje): %d (%.2f%%)", stats.getVictorias(), stats.getPorcentajeVictorias()));
        lblRachaMaxima.setText("Racha máxima: " + stats.getRachaMaxima());

        String tipo = (stats.getTipoMasJugado() != null) ? stats.getTipoMasJugado().name() : "Ninguno";
        lblTipoMasJugado.setText("Tipo más jugado: " + tipo);
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