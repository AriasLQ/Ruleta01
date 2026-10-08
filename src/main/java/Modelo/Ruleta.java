package Modelo;

import java.util.Random;

public class Ruleta {
    private final int NUMERO_CASILLAS = 37;
    private final int MAX_HISTORIAL = 100;

    private int[] historialNumeros;
    private int[] historialApuestas;
    private boolean[] historialAciertos;
    private int historialSize;

    private Random rng;
    private int[] numerosRojos;

    public Ruleta() {
        this.historialNumeros = new int[MAX_HISTORIAL];
        this.historialApuestas = new int[MAX_HISTORIAL];
        this.historialAciertos = new boolean[MAX_HISTORIAL];
        this.historialSize = 0;
        this.rng = new Random();
        this.numerosRojos = new int[]{
                1, 3, 5, 7, 9, 12, 14, 16, 18,
                19, 21, 23, 25, 27, 30, 32, 34, 36
        };
    }

    public static int girar() {
        return rng.nextInt(NUMERO_CASILLAS);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) return false;
        if (tipo == 'P') return numero % 2 == 0;
        if (tipo == 'I') return numero % 2 != 0;
        if (tipo == 'R') return esRojo(numero);
        if (tipo == 'N') return !esRojo(numero);
        return false;
    }

    private static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) return true;
        }
        return false;
    }

    public static boolean registrarJugada(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
            return true;
        }
        return false;
    }
}