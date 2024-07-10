import java.util.Arrays;

public class ConjuntoEnteros {
    private boolean[] conjunto;

    // Constructor sin argumentos: inicializa el conjunto vacío
    public ConjuntoEnteros() {
        conjunto = new boolean[101];
    }

    // eliminar
    public void eliminarElemento(int valorAEliminar) {
        if (valorAEliminar >= 0 && valorAEliminar <= 100) {
            conjunto[valorAEliminar] = false;
        }
    }

    // Interseccion
    public static ConjuntoEnteros interseccion(ConjuntoEnteros conjunto1, ConjuntoEnteros conjunto2) {
        ConjuntoEnteros interseccion = new ConjuntoEnteros();
        for (int i = 0; i < interseccion.conjunto.length; i++) {
            interseccion.conjunto[i] = conjunto1.conjunto[i] && conjunto2.conjunto[i];
        }
        return interseccion;
    }
    // igualdad
    public boolean esIgualA(ConjuntoEnteros otroConjunto) {
        return Arrays.equals(this.conjunto, otroConjunto.conjunto);
    }
    // Insertar
    public void insertarElemento(int valorAInsertar) {
        if (valorAInsertar >= 0 && valorAInsertar <= 100) {
            conjunto[valorAInsertar] = true;
        }
    }

    // toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean esVacio = true;
        for (int i = 0; i < conjunto.length; i++) {
            if (conjunto[i]) {
                sb.append(i).append(" ");
                esVacio = false;
            }
        }
        return esVacio ? "---" : sb.toString().trim();

        
    }
    // Union
    public static ConjuntoEnteros union(ConjuntoEnteros conjunto1, ConjuntoEnteros conjunto2) {
        ConjuntoEnteros union = new ConjuntoEnteros();
        for (int i = 0; i < union.conjunto.length; i++) {
            union.conjunto[i] = conjunto1.conjunto[i] || conjunto2.conjunto[i];
        }
        return union;
    }
}
