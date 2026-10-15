package Modelo;

public class Resultado {
    private int numeroGanador;
    private boolean acierto;
    private TipoApuesta tipoApuesta; // Agregado para cumplir con el requerimiento

    public Resultado(int numeroGanador, boolean acierto, TipoApuesta tipoApuesta) {
        this.numeroGanador = numeroGanador;
        this.acierto = acierto;
        this.tipoApuesta = tipoApuesta;
    }

    public int getNumeroGanador() {
        return this.numeroGanador;
    }

    public boolean isAcierto() {
        return this.acierto;
    }

    public TipoApuesta getTipoApuesta() {
        return this.tipoApuesta;
    }
}