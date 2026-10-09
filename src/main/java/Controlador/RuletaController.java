package Controlador;

import Modelo.Ruleta;
import Modelo.TipoApuesta;
import Modelo.Resultado;

public class RuletaController {
    private Ruleta ruleta;

    public RuletaController() {
        this.ruleta = new Ruleta();
    }

    public Resultado realizarApuesta(int monto, TipoApuesta tipo) {
        int numeroGanador = ruleta.girar();
        boolean acierto = ruleta.evaluarResultado(numeroGanador, tipo);
        ruleta.registrarJugada(numeroGanador, monto, acierto);

        return new Resultado(numeroGanador, acierto);
    }
}