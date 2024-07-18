// Clase EmpleadoPorHoras que hereda de Empleado
public class EmpleadoPorHoras extends Empleado {
    private double horas; // horas trabajadas en una semana
    private double sueldo; // sueldo por hora

    // Constructor
    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial,
                            double sueldo, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        this.sueldo = sueldo;
        this.horas = horas;
    }

    // Implementación del método abstracto ingresos
    @Override
    public double ingresos() {
        if (horas <= 40) { // no hay tiempo extra
            return sueldo * horas;
        } else { // tiempo extra
            return 40 * sueldo + (horas - 40) * sueldo * 1.5;
        }
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("Empleado por horas: %s\n%s: %.2f\n%s: %.2f",
            super.toString(), "Horas trabajadas", horas, "Sueldo por hora", sueldo);
    }
}
