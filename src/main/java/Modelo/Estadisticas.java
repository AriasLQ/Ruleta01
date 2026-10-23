package Modelo;

public class Estadisticas {
    private int totalJugadas;
    private int victorias;
    private double porcentajeVictorias;
    private int rachaMaxima;
    private TipoApuesta tipoMasJugado;

    public Estadisticas() {
        this.totalJugadas = 0;
        this.victorias = 0;
        this.porcentajeVictorias = 0.0;
        this.rachaMaxima = 0;
        this.tipoMasJugado = null;
    }
}