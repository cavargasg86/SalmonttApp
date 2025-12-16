package model;

/**
 * Clase base que representa una unidad operativa de Salmontt
 * Implementa la interfaz Registrable
 *
 * Semana 8: Ahora implementa Registrable
 */
public class UnidadOperativa implements Registrable {
    // Atributos protegidos (accesibles desde subclases)
    protected String nombre;
    protected String comuna;
    protected String codigo; // Identificador único

    // Constructor por defecto
    public UnidadOperativa() {
        this.codigo = "UO-" + System.currentTimeMillis();
    }

    // Constructor con parámetros
    public UnidadOperativa(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.codigo = "UO-" + System.currentTimeMillis();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna == null || comuna.trim().isEmpty()) {
            throw new IllegalArgumentException("La comuna no puede estar vacía");
        }
        this.comuna = comuna;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return String.format("Unidad: %s | Comuna: %s", nombre, comuna);
    }

    public String getTipo() {
        return "Unidad Operativa Genérica";
    }

    public void mostrarInformacion() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║  UNIDAD OPERATIVA GENÉRICA                                   ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.printf("║  Nombre: %-52s║%n", nombre);
        System.out.printf("║  Comuna: %-52s║%n", comuna);
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }

    // IMPLEMENTACIÓN DE LA INTERFAZ REGISTRABLE

    @Override
    public void mostrarResumen() {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.printf("│ 📋 %-48s│%n", getTipo());
        System.out.printf("│ Nombre: %-44s│%n", nombre);
        System.out.printf("│ Comuna: %-44s│%n", comuna);
        System.out.printf("│ Código: %-44s│%n", codigo);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    @Override
    public String obtenerIdentificador() {
        return codigo;
    }

    @Override
    public String obtenerTipo() {
        return getTipo();
    }
}