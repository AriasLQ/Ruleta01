package Modelo;

public class Resultado {
    private int numeroGanador;
    private boolean acierto;

    public Resultado(int numeroGanador, boolean acierto) {
        this.numeroGanador = numeroGanador;
        this.acierto = acierto;
    }

    public int getNumeroGanador() {
        return this.numeroGanador;
    }

    public boolean isAcierto() {
        return this.acierto;
    }
}