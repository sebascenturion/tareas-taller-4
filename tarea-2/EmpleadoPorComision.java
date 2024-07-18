public class EmpleadoPorComision extends Empleado {
    private double ventasBrutas; // ventas semanales totales
    private double tarifaComision; // porcentaje de comisión

    // Constructor
    public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, 
                               double ventasBrutas, double tarifaComision) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        if (ventasBrutas < 0.0) {
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        }

        if (tarifaComision <= 0.0 || tarifaComision >= 1.0) {
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
        }

        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    // Métodos establecer y obtener para ventasBrutas y tarifaComision
    public void establecerVentasBrutas(double ventasBrutas) {
        if (ventasBrutas < 0.0) {
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        }

        this.ventasBrutas = ventasBrutas;
    }

    public double obtenerVentasBrutas() {
        return ventasBrutas;
    }

    public void establecerTarifaComision(double tarifaComision) {
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0) {
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
        }

        this.tarifaComision = tarifaComision;
    }

    public double obtenerTarifaComision() {
        return tarifaComision;
    }

    // Método para calcular los ingresos
    public double ingresos() {
        return obtenerTarifaComision() * obtenerVentasBrutas();
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("%s\n%s: %.2f\n%s: %.2f", 
            super.toString(), 
            "Ventas brutas", obtenerVentasBrutas(), 
            "Tarifa de comisión", obtenerTarifaComision());
    }
}
