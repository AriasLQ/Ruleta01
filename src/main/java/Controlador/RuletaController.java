package Controlador;

import Modelo.Ruleta;
import Modelo.TipoApuesta;
import Modelo.Resultado;

public class RuletaController {
    private Ruleta ruleta;
    private final SessionController session;

    public RuletaController(SessionController session) {
        this.ruleta = new Ruleta();
        this.session = session;
    }

    public Resultado realizarApuesta(int monto, TipoApuesta tipo) {
        int numeroGanador = ruleta.girar();
        boolean acierto = ruleta.evaluarResultado(numeroGanador, tipo);
        ruleta.registrarJugada(numeroGanador, monto, acierto);

        Resultado resultado = new Resultado(numeroGanador, acierto, tipo);
        if (session.hayUsuario()) {
            session.getUsuarioActual().agregarResultado(resultado);
        }
        return resultado;
    }
}