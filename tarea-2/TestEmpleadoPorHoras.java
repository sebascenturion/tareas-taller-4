public class TestEmpleadoPorHoras {
    public static void main(String[] args) {
        // Crear un objeto EmpleadoPorHoras
        EmpleadoPorHoras empleado = new EmpleadoPorHoras(
            "Seba", "Centurión", "1234567", 12.50, 24);

        System.out.printf("Sueldo por hora: %.2f%n", empleado.obtenerSueldo());
        System.out.printf("Horas trabajadas: %.2f%n", empleado.obtenerHoras());

        // Calcular y mostrar ingresos
        System.out.printf("Ingresos: $%.2f%n", empleado.ingresos());

        // Modificar los valores del sueldo y las horas
        empleado.establecerSueldo(15.00);
        empleado.establecerHoras(50);

        // Mostrar la información actualizada del empleado
        System.out.println("\n\nInformación actualizada del empleado:");
        System.out.printf("Sueldo por hora: %.2f%n", empleado.obtenerSueldo());
        System.out.printf("Horas trabajadas: %.2f%n", empleado.obtenerHoras());

        // Calcular y mostrar los ingresos actualizados
        System.out.printf("Ingresos actualizados: $%.2f%n", empleado.ingresos());

        // Mostrar la representación de cadena actualizada del empleado
        System.out.println("Representación de cadena actualizada del empleado:");
        System.out.println(empleado);
    }
}
