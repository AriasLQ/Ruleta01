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

    public void calcularPorcentajeVictorias() {
        if (this.totalJugadas > 0) {
            this.porcentajeVictorias = ((double) this.victorias / this.totalJugadas) * 100.0;
        } else {
            this.porcentajeVictorias = 0.0;
        }
    }

    public void calcularRachaMaxima(List<Resultado> historial) {
        if (historial == null || historial.isEmpty()) {
            this.rachaMaxima = 0;
            return;
        }

        int rachaActual = 0;
        int rachaMax = 0;

        for (Resultado r : historial) {
            if (r.isAcierto()) {
                rachaActual++;
                if (rachaActual > rachaMax) {
                    rachaMax = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }
        this.rachaMaxima = rachaMax;
    }

    public void calcularTipoMasJugado(List<Resultado> historial) {
        if (historial == null || historial.isEmpty()) {
            this.tipoMasJugado = null;
            return;
        }

        int[] conteo = new int[TipoApuesta.values().length];
        for (Resultado r : historial) {
            if (r.getTipoApuesta() != null) {
                conteo[r.getTipoApuesta().ordinal()]++;
            }
        }

        int max = -1;
        TipoApuesta masJugado = null;
        for (TipoApuesta tipo : TipoApuesta.values()) {
            if (conteo[tipo.ordinal()] > max) {
                max = conteo[tipo.ordinal()];
                masJugado = tipo;
            }
        }
        this.tipoMasJugado = masJugado;
    }

    public int getTotalJugadas() {
        return totalJugadas;
    }

    public int getVictorias() {
        return victorias;
    }

    public double getPorcentajeVictorias() {
        return porcentajeVictorias;
    }

    public int getRachaMaxima() {
        return rachaMaxima;
    }

    public TipoApuesta getTipoMasJugado() {
        return tipoMasJugado;
    }
}