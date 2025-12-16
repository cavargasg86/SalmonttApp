package model;

/**
 * Clase que representa un empleado de la empresa Salmontt
 * Implementa Registrable para ser gestionado en el sistema
 *
 * Semana 8: Nueva entidad que implementa Registrable
 */
public class Empleado implements Registrable {
    // Atributos privados
    private String rut;
    private String nombres;
    private String apellidos;
    private String cargo;
    private String area;
    private String codigo;

    // Constructor por defecto
    public Empleado() {
        this.codigo = "EMP-" + System.currentTimeMillis();
    }

    // Constructor con parámetros
    public Empleado(String rut, String nombres, String apellidos, String cargo, String area) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.area = area;
        this.codigo = "EMP-" + System.currentTimeMillis();
    }

    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    // IMPLEMENTACIÓN DE LA INTERFAZ REGISTRABLE

    @Override
    public void mostrarResumen() {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.printf("│ 👤 %-48s│%n", "EMPLEADO");
        System.out.printf("│ RUT: %-47s│%n", rut);
        System.out.printf("│ Nombre: %-44s│%n", getNombreCompleto());
        System.out.printf("│ Cargo: %-45s│%n", cargo);
        System.out.printf("│ Área: %-46s│%n", area);
        System.out.printf("│ Código: %-44s│%n", codigo);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    @Override
    public String obtenerIdentificador() {
        return codigo;
    }

    @Override
    public String obtenerTipo() {
        return "Empleado";
    }

    @Override
    public String toString() {
        return String.format("Empleado: %s - %s (%s)", getNombreCompleto(), cargo, area);
    }
}