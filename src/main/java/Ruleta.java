import java.util.Random;

public class Ruleta {
    public static final int NUMERO_CASILLAS = 37;
    public static final int MAX_HISTORIAL = 100;

    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;

    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

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