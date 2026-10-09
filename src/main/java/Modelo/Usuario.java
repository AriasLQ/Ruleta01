package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo;
    private List<Resultado> historial;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.saldo = 0;
        this.historial = new ArrayList<>();
    }

    public Usuario() {
        this("invitado", "", "Invitado");
    }

    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public int getSaldo() {
        return this.saldo;
    }

    public boolean depositar(int monto) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }


    public List<Resultado> getHistorial() {
        return this.historial;
    }

    public void agregarResultado(Resultado resultado) {
        this.historial.add(resultado);
    }
}