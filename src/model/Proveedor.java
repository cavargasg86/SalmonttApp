package model;

/**
 * Clase que representa un proveedor de la empresa Salmontt
 * Implementa Registrable para ser gestionado en el sistema
 *
 * Semana 8: Nueva entidad que implementa Registrable
 */
public class Proveedor implements Registrable {
    // Atributos privados
    private String rut;
    private String razonSocial;
    private String rubro;
    private String contacto;
    private String codigo;

    // Constructor por defecto
    public Proveedor() {
        this.codigo = "PROV-" + System.currentTimeMillis();
    }

    // Constructor con parámetros
    public Proveedor(String rut, String razonSocial, String rubro, String contacto) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.rubro = rubro;
        this.contacto = contacto;
        this.codigo = "PROV-" + System.currentTimeMillis();
    }

    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCodigo() {
        return codigo;
    }

    // IMPLEMENTACIÓN DE LA INTERFAZ REGISTRABLE

    @Override
    public void mostrarResumen() {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.printf("│ 🏢 %-48s│%n", "PROVEEDOR");
        System.out.printf("│ RUT: %-47s│%n", rut);
        System.out.printf("│ Razón Social: %-38s│%n", razonSocial);
        System.out.printf("│ Rubro: %-45s│%n", rubro);
        System.out.printf("│ Contacto: %-42s│%n", contacto);
        System.out.printf("│ Código: %-44s│%n", codigo);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    @Override
    public String obtenerIdentificador() {
        return codigo;
    }

    @Override
    public String obtenerTipo() {
        return "Proveedor";
    }

    @Override
    public String toString() {
        return String.format("Proveedor: %s (RUT: %s) - %s", razonSocial, rut, rubro);
    }
}