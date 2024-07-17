import java.util.Arrays;

public class ConjuntoEnteros {
    private boolean[] conjunto;

    // Constructor sin argumentos: inicializa el conjunto vacío
    public ConjuntoEnteros() {
        conjunto = new boolean[101];
    }

    // eliminar: establezco false en la posicion en la que se encuentra el valor
    public void eliminarElemento(int valorAEliminar) {
        if (valorAEliminar >= 0 && valorAEliminar <= 100) {
            conjunto[valorAEliminar] = false;
        }
    }

    // Interseccion: recibo como parámetro dos conjuntos y los voy comparando. creo un nuevo conjunto para guardar los elementos que se repiten en ambos conjuntos hallando asi la intereseccion
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
    // Insertar: controlo que esté en el rango aceptable y si está en el mismo establezco la posición en true
    public void insertarElemento(int valorAInsertar) {
        if (valorAInsertar >= 0 && valorAInsertar <= 100) {
            conjunto[valorAInsertar] = true;
        }
    }

    // toString(): creo un string builder para construir la cadena que va a representar el conjunto. Si inicializo un conjunto {7, 8, 9} el arreglo va a tener true en esas posiciones y durante el for se van a guardar en el string builder. Despues del for le hago trim para borrar el espacio y el string devolería ""7,8,9""
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
    // Union: tomo todos los elementos de un conjunto y los junto con los del otro elemento para crear el conjunto union 
    public static ConjuntoEnteros union(ConjuntoEnteros conjunto1, ConjuntoEnteros conjunto2) {
        ConjuntoEnteros union = new ConjuntoEnteros();
        for (int i = 0; i < union.conjunto.length; i++) {
            union.conjunto[i] = conjunto1.conjunto[i] || conjunto2.conjunto[i];
        }
        return union;
    }
}
