package model;

/**
 * Subclase que representa una planta de procesamiento de salmón
 * HEREDA de UnidadOperativa y agrega atributos específicos
 *
 * Semana 7: Sobrescribe mostrarInformacion() para polimorfismo
 */
/**
 * Subclase que representa una planta de procesamiento de salmón
 * HEREDA de UnidadOperativa (que implementa Registrable)
 *
 * Semana 8: Hereda implementación de Registrable pero puede sobrescribir
 */
public class PlantaProceso extends UnidadOperativa {
    // Atributos específicos de PlantaProceso
    private double capacidadProceso; // Toneladas que puede procesar por día
    private int numeroEmpleados;
    private String tipoProceso; // Ej: "Fileteado", "Ahumado", "Congelado"

    // Constructor por defecto
    public PlantaProceso() {
        super(); // Llama al constructor de la superclase
    }

    /**
     * Constructor con parámetros
     * Usa super() para inicializar atributos heredados
     */
    public PlantaProceso(String nombre, String comuna, double capacidadProceso,
                         int numeroEmpleados, String tipoProceso) {
        super(nombre, comuna); // Inicializa atributos de la superclase
        this.capacidadProceso = capacidadProceso;
        this.numeroEmpleados = numeroEmpleados;
        this.tipoProceso = tipoProceso;
    }

    // Getters y Setters específicos
    public double getCapacidadProceso() {
        return capacidadProceso;
    }

    public void setCapacidadProceso(double capacidadProceso) {
        if (capacidadProceso < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.capacidadProceso = capacidadProceso;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        if (numeroEmpleados < 0) {
            throw new IllegalArgumentException("El número de empleados no puede ser negativo");
        }
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    /**
     * Método específico para calcular capacidad mensual
     */
    public double calcularCapacidadMensual() {
        return capacidadProceso * 30; // Asumiendo 30 días al mes
    }

    /**
     * Método específico para calcular productividad por empleado
     */
    public double calcularProductividadPorEmpleado() {
        if (numeroEmpleados == 0) {
            return 0;
        }
        return capacidadProceso / numeroEmpleados;
    }

    /**
     * Sobrescritura del método getTipo()
     */
    @Override
    public String getTipo() {
        return "Planta de Proceso";
    }

    /**
     * SOBRESCRITURA del método toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════════════════════════════\n");
        sb.append(String.format("🏭 PLANTA DE PROCESO\n"));
        sb.append(String.format("   Nombre: %s\n", nombre));
        sb.append(String.format("   Comuna: %s\n", comuna));
        sb.append(String.format("   Tipo de proceso: %s\n", tipoProceso));
        sb.append(String.format("   Capacidad diaria: %.2f toneladas\n", capacidadProceso));
        sb.append(String.format("   Capacidad mensual: %.2f toneladas\n", calcularCapacidadMensual()));
        sb.append(String.format("   Número de empleados: %d\n", numeroEmpleados));
        sb.append(String.format("   Productividad por empleado: %.2f ton/día\n",
                calcularProductividadPorEmpleado()));
        sb.append("═══════════════════════════════════════════════════════════════");

        return sb.toString();
    }

    /**
     * NUEVO MÉTODO PARA SEMANA 7: Polimorfismo
     * SOBRESCRIBE mostrarInformacion() de UnidadOperativa
     * Muestra información específica de la Planta de Proceso
     */
    /**
     * SEMANA 8: Sobrescritura de mostrarResumen() de Registrable
     */
    @Override
    public void mostrarResumen() {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.printf("│ 🏭 %-48s│%n", "PLANTA DE PROCESO");
        System.out.printf("│ Nombre: %-44s│%n", nombre);
        System.out.printf("│ Comuna: %-44s│%n", comuna);
        System.out.printf("│ Proceso: %-43s│%n", tipoProceso);
        System.out.printf("│ Capacidad: %-37.2f ton/día │%n", capacidadProceso);
        System.out.printf("│ Empleados: %-41d│%n", numeroEmpleados);
        System.out.printf("│ Código: %-44s│%n", codigo);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║  🏭 PLANTA DE PROCESO                                        ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.printf("║  Nombre: %-52s║%n", nombre);
        System.out.printf("║  Comuna: %-52s║%n", comuna);
        System.out.printf("║  Tipo de proceso: %-43s║%n", tipoProceso);
        System.out.printf("║  Capacidad diaria: %-35.2f ton. ║%n", capacidadProceso);
        System.out.printf("║  Capacidad mensual: %-34.2f ton. ║%n", calcularCapacidadMensual());
        System.out.println("║  ─────────────────────────────────────────────────────────   ║");
        System.out.printf("║  Personal:                                                   ║%n");
        System.out.printf("║    • Número de empleados: %-35d║%n", numeroEmpleados);
        System.out.printf("║    • Productividad por empleado: %-21.2f ton/día ║%n",
                calcularProductividadPorEmpleado());
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}