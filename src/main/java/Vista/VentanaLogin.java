package Vista;

import Controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin {
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrar = new JButton("Registrar");

    private SessionController session;

    public VentanaLogin(SessionController session) {
        this.session = session;

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        frame.add(btnRegistrar);

        btnIngresar.addActionListener(e -> login());
        btnRegistrar.addActionListener(e -> abrirRegistro());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void login() {
        String user = txtUsuario.getText();
        String password = new String(txtClave.getPassword());

        if (session.iniciarSesion(user, password)) {
            JOptionPane.showMessageDialog(frame, "¡Acceso concedido! Bienvenido, " + session.getNombreUsuario());
            frame.dispose();
            new VentanaMenu(session).mostrarVentana(); // Marcará error hasta que actualicemos VentanaMenu
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro(session).mostrarVentana(); // Marcará error hasta que actualicemos VentanaRegistro
    }
}