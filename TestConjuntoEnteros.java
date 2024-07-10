public class TestConjuntoEnteros {
    public static void main(String[] args) {
        // Crear dos conjuntos de prueba
        ConjuntoEnteros conjunto1 = new ConjuntoEnteros();
        ConjuntoEnteros conjunto2 = new ConjuntoEnteros();

        // Insertar elementos en los conjuntos
        conjunto1.insertarElemento(10);
        conjunto1.insertarElemento(20);
        conjunto1.insertarElemento(30);

        conjunto2.insertarElemento(10);
        conjunto2.insertarElemento(20);
        conjunto2.insertarElemento(30);

        // Mostrar los conjuntos
        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);

        // Unión de los conjuntos
        ConjuntoEnteros union = ConjuntoEnteros.union(conjunto1, conjunto2);
        System.out.println("Unión: " + union);

        // Intersección de los conjuntos
        ConjuntoEnteros interseccion = ConjuntoEnteros.interseccion(conjunto1, conjunto2);
        System.out.println("Intersección: " + interseccion);

        // Eliminar elemento del conjunto1
        conjunto1.eliminarElemento(20);
        System.out.println("Conjunto 1 después de eliminar 20: " + conjunto1);

        // Verificar si dos conjuntos son iguales
        System.out.println("¿Conjunto 1 es igual a Conjunto 2? " + conjunto1.esIgualA(conjunto2));

        // Insertar elementos para que sean iguales
        conjunto1.insertarElemento(40);
        conjunto1.insertarElemento(50);
        conjunto2.insertarElemento(40);
        conjunto2.insertarElemento(50);
        conjunto2.eliminarElemento(20);
        System.out.println("Conjunto 1 después de modificar: " + conjunto1);
        System.out.println("Conjunto 2 después de modificar: " + conjunto2);
        System.out.println("¿Conjunto 1 es igual a Conjunto 2? " + conjunto1.esIgualA(conjunto2));



        //toString
        System.out.println("Conjunto 1: " + conjunto1.toString());
        System.out.println("Conjunto 2: " + conjunto2.toString());

    }
}
