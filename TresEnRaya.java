public class TresEnRaya {
    // Enum para representar el estado de cada casilla
    public enum EstadoCasilla {
        X, O, V
    }

    private EstadoCasilla[][] tablero; // Tablero del juego
    private EstadoCasilla turnoActual; // Jugador actual que tiene el turno

    // Constructor para inicializar el juego
    public TresEnRaya() {
        tablero = new EstadoCasilla[3][3]; // Tablero de 3x3
        turnoActual = EstadoCasilla.X; // Comienza el jugador X

        // Inicializar todas las casillas del tablero como VACIO
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = EstadoCasilla.V;
            }
        }
    }

    // Método para realizar un movimiento en el tablero
    public boolean realizarMovimiento(int fila, int columna) {
        // Verificar si la casilla está vacía
        if (tablero[fila][columna] == EstadoCasilla.V) {
            // Colocar la marca del jugador actual en la casilla
            tablero[fila][columna] = turnoActual;

            // Cambiar al siguiente turno
            cambiarTurno();

            return true; // Movimiento válido
        } else {
            return false; // Movimiento inválido
        }
    }

    // Método para cambiar al siguiente turno
    private void cambiarTurno() {
        // Cambiar al siguiente turno: si el turno actual es X, cambiar a O, de lo contrario, cambiar a X
        turnoActual = (turnoActual == EstadoCasilla.X) ? EstadoCasilla.O : EstadoCasilla.X;
    }

    // Método para verificar si hay un ganador
    public EstadoCasilla hayGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            // Si los tres elementos de una fila son iguales y no vacíos, hay un ganador
            if (tablero[i][0] != EstadoCasilla.V && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                return tablero[i][0];
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            // Si los tres elementos de una columna son iguales y no vacíos, hay un ganador
            if (tablero[0][j] != EstadoCasilla.V && tablero[0][j] == tablero[1][j] && tablero[0][j] == tablero[2][j]) {
                return tablero[0][j];
            }
        }

        // Verificar diagonales
        // Verificar la diagonal principal
        if (tablero[0][0] != EstadoCasilla.V && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return tablero[0][0];
        }
        // Verificar la diagonal secundaria
        if (tablero[0][2] != EstadoCasilla.V && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return tablero[0][2];
        }

        // No hay ganador
        return EstadoCasilla.V;
    }

    // Método para verificar si hay empate
    public boolean hayEmpate() {
        // Si todas las casillas están llenas y no hay ganador, entonces hay empate
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Si encuentro una casilla vacía, no hay empate
                if (tablero[i][j] == EstadoCasilla.V) {
                    return false; // Todavía hay casillas vacías
                }
            }
        }
        // Todas las casillas están llenas y no hay ganador
        return true;
    }

    // Método para reiniciar el juego
    public void reiniciarJuego() {
        // Reiniciar el tablero y el turno
        turnoActual = EstadoCasilla.X; // Restablecer el turno al jugador X
        // Restablecer todas las casillas del tablero a vacías
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = EstadoCasilla.V;
            }
        }
    }

    // Método para imprimir el estado actual del tablero
    public void imprimirTablero() {
        System.out.println("-------------");
        // Imprimir cada fila del tablero
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                // Imprimir el valor de cada casilla
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Método para obtener el jugador actual que tiene el turno
    public EstadoCasilla obtenerTurnoActual() {
        return turnoActual; // Devolver el jugador que tiene el turno actual
    }
}
