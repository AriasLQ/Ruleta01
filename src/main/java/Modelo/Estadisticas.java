package Modelo;

import java.util.List;

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

    public void calcularTotalYVictorias(List<Resultado> historial) {
        if (historial == null || historial.isEmpty()) {
            this.totalJugadas = 0;
            this.victorias = 0;
            return;
        }

        this.totalJugadas = historial.size();

        int contVictorias = 0;
        for (Resultado r : historial) {
            if (r.isAcierto()) {
                contVictorias++;
            }
        }
        this.victorias = contVictorias;
    }
}