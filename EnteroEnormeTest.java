public class EnteroEnormeTest {
    public static void main(String[] args) {
        EnteroEnorme num1 = new EnteroEnorme("1234567890123456789012345678901234567890");
        EnteroEnorme num2 = new EnteroEnorme("9876543210987654321098765432109876543210");

        // método parse
        System.out.println("Número 1 (parseado): " + num1.toString());
        System.out.println("Número 2 (parseado): " + num2.toString());

        // método sumar
        num1.sumar(num2);
        System.out.println("Suma: " + num1.toString());

        // Restablecer num1 para demostrar método restar
        num1 = new EnteroEnorme("1234567890123456789012345678901234567890");
        num1.restar(num2);
        System.out.println("Resta: " + num1.toString());

        // métodos de comparación
        System.out.println("¿Es igual? " + num1.esIgualA(num2));
        System.out.println("¿No es igual? " + num1.noEsIgualA(num2));
        System.out.println("¿Es mayor que? " + num1.esMayorQue(num2));
        System.out.println("¿Es menor que? " + num1.esMenorQue(num2));
        System.out.println("¿Es mayor o igual? " + num1.esMayorOIgualA(num2));
        System.out.println("¿Es menor o igual? " + num1.esMenorOIgualA(num2));

        // método esCero
        EnteroEnorme num3 = new EnteroEnorme();
        System.out.println("¿Es cero? " + num3.esCero());

        // método multiplicar
        num1 = new EnteroEnorme("1234567890123456789012345678901234567890");
        num1.multiplicar(num2);
        System.out.println("Multiplicación: " + num1.toString());
    }
}
