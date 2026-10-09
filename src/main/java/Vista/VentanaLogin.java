package Vista;

import Controlador.SessionController;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List USUARIOS = new ArrayList<>();
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
        if (USUARIOS.isEmpty()) {
            USUARIOS.add(new Usuario("admin", "administrable", "admin"));
            USUARIOS.add(new Usuario("", "user", "user"));
        }
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

        String nombreUsuario = validarCredenciales(user, password);
        if (!nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "¡Acceso concedido! Bienvenido, " + nombreUsuario);
            frame.dispose();

            new VentanaMenu(nombreUsuario).mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String validarCredenciales(String u, String p) {
        for (Object obj : USUARIOS) {
            Usuario usr = (Usuario) obj;

            if (usr.validarCredenciales(u, p)) {
                return usr.getNombre();
            }
        }
        return "";
    }

    private void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro().mostrarVentana();
    }
}
