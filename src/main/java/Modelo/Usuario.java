package Modelo;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.saldo = 0;
    }

    public Usuario() {
        this("invitado", "", "Invitado");
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public int getSaldo() {
        return this.saldo;
    }
}