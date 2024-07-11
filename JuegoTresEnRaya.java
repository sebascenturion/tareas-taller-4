import java.util.Random;

public class JuegoTresEnRaya {
    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        Random random = new Random();

        // Ciclo de juego hasta que haya un ganador o empate
        while (juego.hayGanador() == TresEnRaya.EstadoCasilla.V && !juego.hayEmpate()) {
            // Turno de X (jugador humano)
            if (juego.obtenerTurnoActual() == TresEnRaya.EstadoCasilla.X) {
                int fila, columna;
                fila = random.nextInt(3);
                columna = random.nextInt(3);
                while (!juego.realizarMovimiento(fila, columna)) {
                    fila = random.nextInt(3);
                    columna = random.nextInt(3);
                }
            } else {
                // Turno de O (computadora, jugada aleatoria)
                int fila, columna;
                fila = random.nextInt(3);
                columna = random.nextInt(3);
                while (!juego.realizarMovimiento(fila, columna)) {
                    fila = random.nextInt(3);
                    columna = random.nextInt(3);
                }
            }
        }

        // Mostrar estado final del tablero
        juego.imprimirTablero();

        // Verificar resultado del juego
        TresEnRaya.EstadoCasilla ganador = juego.hayGanador();
        if (ganador != TresEnRaya.EstadoCasilla.V) {
            System.out.println("¡El jugador " + ganador + " ha ganado!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }
}
