package model;

import java.util.ArrayList;

/**
 * Subclase que representa un centro de cultivo de salmón
 * HEREDA de UnidadOperativa y agrega atributos específicos
 *
 * Semana 7: Sobrescribe mostrarInformacion() para polimorfismo
 */
/**
 * Subclase que representa un centro de cultivo de salmón
 * HEREDA de UnidadOperativa (que implementa Registrable)
 *
 * Semana 8: Hereda implementación de Registrable pero puede sobrescribir
 */
public class CentroCultivo extends UnidadOperativa {
    // Atributos específicos de CentroCultivo
    private double toneladasProduccion;
    private String tipoCultivo; // Ej: "Salmón Atlántico", "Salmón Coho"
    private ArrayList<Produccion> registrosProduccion;

    // Constructor por defecto
    public CentroCultivo() {
        super(); // Llama al constructor de la superclase
        this.registrosProduccion = new ArrayList<>();
    }

    /**
     * Constructor con parámetros
     * Usa super() para inicializar atributos heredados
     */
    public CentroCultivo(String nombre, String comuna, double toneladasProduccion, String tipoCultivo) {
        super(nombre, comuna); // Inicializa atributos de la superclase
        this.toneladasProduccion = toneladasProduccion;
        this.tipoCultivo = tipoCultivo;
        this.registrosProduccion = new ArrayList<>();
    }

    // Getters y Setters específicos
    public double getToneladasProduccion() {
        return toneladasProduccion;
    }

    public void setToneladasProduccion(double toneladasProduccion) {
        if (toneladasProduccion < 0) {
            throw new IllegalArgumentException("Las toneladas no pueden ser negativas");
        }
        this.toneladasProduccion = toneladasProduccion;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public ArrayList<Produccion> getRegistrosProduccion() {
        return registrosProduccion;
    }

    // Método para agregar registros de producción (composición)
    public void agregarRegistroProduccion(Produccion produccion) {
        if (produccion != null) {
            this.registrosProduccion.add(produccion);
        }
    }

    // Método para calcular producción total de registros
    public double calcularProduccionTotal() {
        double total = 0;
        for (Produccion p : registrosProduccion) {
            total += p.getToneladasMensuales();
        }
        return total;
    }

    /**
     * Sobrescritura del método getTipo()
     */
    @Override
    public String getTipo() {
        return "Centro de Cultivo";
    }

    /**
     * SOBRESCRITURA del método toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════════════════════════════\n");
        sb.append(String.format("🐟 CENTRO DE CULTIVO\n"));
        sb.append(String.format("   Nombre: %s\n", nombre));
        sb.append(String.format("   Comuna: %s\n", comuna));
        sb.append(String.format("   Tipo de cultivo: %s\n", tipoCultivo));
        sb.append(String.format("   Producción anual: %.2f toneladas\n", toneladasProduccion));

        if (!registrosProduccion.isEmpty()) {
            sb.append("   Registros mensuales:\n");
            for (Produccion p : registrosProduccion) {
                sb.append("     └─ ").append(p.toString()).append("\n");
            }
        }
        sb.append("═══════════════════════════════════════════════════════════════");

        return sb.toString();
    }

    /**
     * NUEVO MÉTODO PARA SEMANA 7: Polimorfismo
     * SOBRESCRIBE mostrarInformacion() de UnidadOperativa
     * Muestra información específica del Centro de Cultivo
     */
    /**
     * SEMANA 8: Sobrescritura de mostrarResumen() de Registrable
     */
    @Override
    public void mostrarResumen() {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.printf("│ 🐟 %-48s│%n", "CENTRO DE CULTIVO");
        System.out.printf("│ Nombre: %-44s│%n", nombre);
        System.out.printf("│ Comuna: %-44s│%n", comuna);
        System.out.printf("│ Tipo: %-46s│%n", tipoCultivo);
        System.out.printf("│ Producción: %-38.2f ton. │%n", toneladasProduccion);
        System.out.printf("│ Código: %-44s│%n", codigo);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║  🐟 CENTRO DE CULTIVO                                        ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.printf("║  Nombre: %-52s║%n", nombre);
        System.out.printf("║  Comuna: %-52s║%n", comuna);
        System.out.printf("║  Tipo de cultivo: %-43s║%n", tipoCultivo);
        System.out.printf("║  Producción anual: %-39.2f ton. ║%n", toneladasProduccion);

        if (!registrosProduccion.isEmpty()) {
            System.out.println("║  ─────────────────────────────────────────────────────────   ║");
            System.out.printf("║  Registros mensuales: %-39d║%n", registrosProduccion.size());
            for (Produccion p : registrosProduccion) {
                System.out.printf("║    • %s %-10d: %.2f ton.%-23s║%n",
                        p.getMes(), p.getAño(), p.getToneladasMensuales(), "");
            }
        }

        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}