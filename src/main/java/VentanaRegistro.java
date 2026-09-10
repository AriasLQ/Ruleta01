import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblNombre = new JLabel("Nombre Completo:");
    private final JTextField txtNombre = new JTextField(15);
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField(15);
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField(15);
    private final JButton btnRegistrar = new JButton("Registrar");
    private final JButton btnVolver = new JButton("Volver");

    public VentanaRegistro() {
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnRegistrar);
        frame.add(btnVolver);

        btnRegistrar.addActionListener(e -> registrarNuevoUsuario());
        btnVolver.addActionListener(e -> volverAlLogin());
    }


    public void mostrarVentana(){

    }


    public void registrarNuevoUsuario(){

    }


    private void volverAlLogin(){

    }
}