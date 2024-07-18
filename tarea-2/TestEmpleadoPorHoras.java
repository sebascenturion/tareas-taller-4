public class TestEmpleadoPorHoras {
    public static void main(String[] args) {
        // Crear un objeto EmpleadoPorHoras
        EmpleadoPorHoras empleado = new EmpleadoPorHoras(
            "Juan", "Perez", "111-11-1111", 12.50, 50);

        // Mostrar información del empleado
        System.out.println("Información del empleado por horas:");
        System.out.println(empleado);

        // Calcular y mostrar ingresos
        System.out.printf("Ingresos: $%.2f%n", empleado.ingresos());
    }
}
