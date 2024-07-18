public class TestEmpleadoPorComision {
    public static void main(String[] args) {
        // Crear un objeto EmpleadoPorComision
        EmpleadoPorComision empleado = new EmpleadoPorComision(
            "Sue", "Jones", "222-22-2222", 10000, .06);

        // Obtener datos del empleado
        System.out.println("Información del empleado obtenida por los métodos obtener: ");
        System.out.printf("%s %s\n", "El primer nombre es", empleado.obtenerPrimerNombre());
        System.out.printf("%s %s\n", "El apellido paterno es", empleado.obtenerApellidoPaterno());
        System.out.printf("%s %s\n", "El número de seguro social es", empleado.obtenerNumeroSeguroSocial());
        System.out.printf("%s %.2f\n", "Las ventas brutas son", empleado.obtenerVentasBrutas());
        System.out.printf("%s %.2f\n", "La tarifa de comisión es", empleado.obtenerTarifaComision());

        // Obtener los ingresos del empleado
        System.out.printf("\n%s: %.2f\n", "Los ingresos son", empleado.ingresos());

        // Mostrar la información completa del empleado
        System.out.printf("\n%s:\n\n%s\n", "La representación de cadena completa es", empleado);
    }
}
