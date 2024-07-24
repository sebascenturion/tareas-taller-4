// Clase EmpleadoPorHoras que hereda de Empleado
public class EmpleadoPorHoras extends Empleado {
    private double horas; // horas trabajadas en una semana
    private double sueldo; // sueldo por hora

    // Constructor
    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial,
                            double sueldo, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        if (sueldo < 0.0) {
            throw new IllegalArgumentException("El sueldo por hora debe ser >= 0.0");
        }
        if (horas < 0.0 || horas > 168.0) {
            throw new IllegalArgumentException("Las horas trabajadas deben estar entre 0 y 168");
        }
        this.sueldo = sueldo;
        this.horas = horas;
    }

    // Métodos establecer y obtener para sueldo
    public void establecerSueldo(double sueldo) {
        if (sueldo < 0.0) {
            throw new IllegalArgumentException("El sueldo por hora debe ser >= 0.0");
        }
        this.sueldo = sueldo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    // Métodos establecer y obtener para horas
    public void establecerHoras(double horas) {
        if (horas < 0.0 || horas > 168.0) {
            throw new IllegalArgumentException("Las horas trabajadas deben estar entre 0 y 168");
        }
        this.horas = horas;
    }

    public double obtenerHoras() {
        return horas;
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
            super.toString(), "Horas trabajadas", obtenerHoras(), "Sueldo por hora", obtenerSueldo());
    }
}
