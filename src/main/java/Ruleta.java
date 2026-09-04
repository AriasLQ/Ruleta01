import java.util.Random;
import java.util.Scanner;
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

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(in);
            ejecutarOpcion(opcion, in);
        } while (opcion != 3);
        in.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Casino Black Cat ---");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Ver estadísticas");
        System.out.println("3. Salir");
        System.out.print("Elija una opción: ");
    }

    public static int leerOpcion(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número: ");
            in.next(); 
        }
        return in.nextInt();
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        if (opcion == 1) {
            iniciarRonda(in);
        } else if (opcion == 2) {
            mostrarEstadisticas();
        } else if (opcion == 3) {
            System.out.println("Saliendo del sistema...");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void iniciarRonda(Scanner in) {
        char tipo = leerTipoApuesta(in);
        int apuesta = leerMontoApuesta(in); // <-- Lógica delegada

        int numero = girarRuleta();
        boolean acerto = evaluarResultado(numero, tipo);

        registrarResultado(numero, apuesta, acerto);
        mostrarResultado(numero, tipo, apuesta, acerto);
    }

    public static int leerMontoApuesta(Scanner in) {
        int apuesta;
        do {
            System.out.print("Ingrese el monto a apostar (mayor a 0): ");
            while (!in.hasNextInt()) {
                System.out.print("Monto inválido. Ingrese un número mayor a 0: ");
                in.next();
            }
            apuesta = in.nextInt();

            if (apuesta <= 0) {
                System.out.println("Error: El monto de la apuesta debe ser mayor a 0.");
            }
        } while (apuesta <= 0);
        return apuesta;
    }

    public static char leerTipoApuesta(Scanner in) {
        char tipo;
        boolean esValido = false;
        do {
            System.out.print("Tipo de apuesta (P: Par, I: Impar, R: Rojo, N: Negro): ");
            tipo = in.next().toUpperCase().charAt(0);

            if (tipo == 'P' || tipo == 'I' || tipo == 'R' || tipo == 'N') {
                esValido = true;
            } else {
                System.out.println("Opción incorrecta. Debe ingresar P, I, R o N.");
            }
        } while (!esValido);

        return tipo;
    }

    public static int girarRuleta() {
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

    public static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) return true;
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        } else {
            System.out.println("Historial lleno. No se pueden registrar más rondas.");
        }
    }

    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {
//
        System.out.println("El número ganador es: " + numero);
        if (acierto) {
            System.out.println("¡Felicidades! Has ganado tu apuesta.");
        } else {
            System.out.println("Has perdido la apuesta.");
        }
    }

    public static int calcularMontoTotal() {
        int total = 0;
        for (int i = 0; i < historialSize; i++) {
            total += historialApuestas[i];
        }
        return total;
    }

    public static int calcularTotalAciertos() {
        int aciertos = 0;
        for (int i = 0; i < historialSize; i++) {
            if (historialAciertos[i]) {
                aciertos++;
            }
        }
        return aciertos;
    }

    public static void mostrarEstadisticas() {
        int montoTotal = calcularMontoTotal();
        int totalAciertos = calcularTotalAciertos();

        System.out.println("\n--- Estadísticas ---");
        System.out.println("Rondas jugadas: " + historialSize);
        System.out.println("Monto total apostado: " + montoTotal);
        System.out.println("Cantidad total de aciertos: " + totalAciertos);

        if (historialSize > 0) {
            double porcentaje = (totalAciertos * 100.0) / historialSize;
            System.out.println("Porcentaje de aciertos: " + porcentaje + "%");
        }
    }
}
