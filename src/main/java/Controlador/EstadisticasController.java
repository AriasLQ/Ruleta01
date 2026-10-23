package Controlador;

import Modelo.Estadisticas;
import Modelo.Resultado;
import java.util.List;

public class EstadisticasController {
    private final SessionController session;

    public EstadisticasController(SessionController session) {
        this.session = session;
    }

    public Estadisticas obtenerEstadisticasUsuario() {
        Estadisticas stats = new Estadisticas();
        if (session.hayUsuario()) {
            List<Resultado> historial = session.getUsuarioActual().getHistorial();
            stats.calcularTotalYVictorias(historial);
            stats.calcularPorcentajeVictorias();
            stats.calcularRachaMaxima(historial);
            stats.calcularTipoMasJugado(historial);
        }
        return stats;
    }
}