package data;

import model.*;

import java.util.ArrayList;

/**
 * Gestor que maneja todas las entidades registrables del sistema
 * Usa instanceof para diferenciar comportamientos
 *
 * Semana 8: Gestión con interfaz Registrable e instanceof
 */
public class GestorEntidades {

    // Colección polimórfica usando la interfaz Registrable
    private ArrayList<Registrable> entidades;

    // Constructor
    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    /**
     * Agrega una entidad registrable a la colección
     */
    public void agregarEntidad(Registrable entidad) {
        if (entidad != null) {
            entidades.add(entidad);
            System.out.println("✓ Entidad agregada: " + entidad.obtenerTipo() +
                    " - " + entidad.obtenerIdentificador());
        }
    }

    /**
     * Carga datos de ejemplo en el sistema
     */
    public void cargarDatosDePrueba() {
        System.out.println("\n📦 Cargando datos de prueba...\n");

        // Centros de Cultivo
        CentroCultivo centro1 = new CentroCultivo("Centro Hualaihué", "Hualaihué",
                1250.5, "Salmón Atlántico");
        agregarEntidad(centro1);

        CentroCultivo centro2 = new CentroCultivo("Centro Ancud", "Ancud",
                1450.8, "Salmón Coho");
        agregarEntidad(centro2);

        // Plantas de Proceso
        PlantaProceso planta1 = new PlantaProceso("Planta Puerto Montt", "Puerto Montt",
                85.5, 120, "Fileteado");
        agregarEntidad(planta1);

        PlantaProceso planta2 = new PlantaProceso("Planta Castro", "Castro",
                62.3, 85, "Ahumado");
        agregarEntidad(planta2);

        // Proveedores
        Proveedor prov1 = new Proveedor("76.123.456-7", "Alimentos Marinos S.A.",
                "Alimentos para peces", "+56912345678");
        agregarEntidad(prov1);

        Proveedor prov2 = new Proveedor("78.987.654-3", "Equipos Acuícolas Ltda.",
                "Equipamiento industrial", "+56987654321");
        agregarEntidad(prov2);

        // Empleados
        Empleado emp1 = new Empleado("12.345.678-9", "Juan", "Pérez López",
                "Gerente de Producción", "Producción");
        agregarEntidad(emp1);

        Empleado emp2 = new Empleado("13.456.789-0", "María", "González Rivas",
                "Jefa de Calidad", "Control de Calidad");
        agregarEntidad(emp2);

        System.out.println("\n✓ Total de entidades cargadas: " + entidades.size() + "\n");
    }

    /**
     * MÉTODO CLAVE PARA SEMANA 8
     * Muestra todas las entidades usando instanceof para diferenciar
     */
    public void mostrarTodasLasEntidades() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║     LISTADO COMPLETO DE ENTIDADES (CON instanceof)          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();

        if (entidades.isEmpty()) {
            System.out.println("⚠ No hay entidades registradas");
            return;
        }

        int contador = 1;

        for (Registrable entidad : entidades) {
            System.out.printf("[%d] Tipo detectado: %s%n", contador, entidad.obtenerTipo());

            // USO DE INSTANCEOF PARA DIFERENCIAR COMPORTAMIENTOS
            if (entidad instanceof CentroCultivo) {
                System.out.println("    → Es un CENTRO DE CULTIVO");
                entidad.mostrarResumen();

                // Casting para acceder a métodos específicos
                CentroCultivo centro = (CentroCultivo) entidad;
                System.out.printf("    ℹ Información adicional: Produce %s%n",
                        centro.getTipoCultivo());

            } else if (entidad instanceof PlantaProceso) {
                System.out.println("    → Es una PLANTA DE PROCESO");
                entidad.mostrarResumen();

                // Casting para acceder a métodos específicos
                PlantaProceso planta = (PlantaProceso) entidad;
                System.out.printf("    ℹ Información adicional: Productividad %.2f ton/día por empleado%n",
                        planta.calcularProductividadPorEmpleado());

            } else if (entidad instanceof Proveedor) {
                System.out.println("    → Es un PROVEEDOR");
                entidad.mostrarResumen();

                // Casting para acceder a métodos específicos
                Proveedor proveedor = (Proveedor) entidad;
                System.out.printf("    ℹ Información adicional: RUT %s%n",
                        proveedor.getRut());

            } else if (entidad instanceof Empleado) {
                System.out.println("    → Es un EMPLEADO");
                entidad.mostrarResumen();

                // Casting para acceder a métodos específicos
                Empleado empleado = (Empleado) entidad;
                System.out.printf("    ℹ Información adicional: Trabaja en %s%n",
                        empleado.getArea());

            } else {
                // Caso genérico para cualquier otra entidad
                System.out.println("    → Es una entidad genérica");
                entidad.mostrarResumen();
            }

            System.out.println();
            contador++;
        }

        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("✓ Total de entidades mostradas: " + entidades.size());
        System.out.println("═══════════════════════════════════════════════════════════════");
    }

    /**
     * Muestra estadísticas por tipo usando instanceof
     */
    public void mostrarEstadisticasPorTipo() {
        int centros = 0, plantas = 0, proveedores = 0, empleados = 0, otros = 0;

        for (Registrable entidad : entidades) {
            if (entidad instanceof CentroCultivo) {
                centros++;
            } else if (entidad instanceof PlantaProceso) {
                plantas++;
            } else if (entidad instanceof Proveedor) {
                proveedores++;
            } else if (entidad instanceof Empleado) {
                empleados++;
            } else {
                otros++;
            }
        }

        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║  📊 ESTADÍSTICAS POR TIPO DE ENTIDAD                         ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.printf("║  🐟 Centros de Cultivo:    %-34d║%n", centros);
        System.out.printf("║  🏭 Plantas de Proceso:    %-34d║%n", plantas);
        System.out.printf("║  🏢 Proveedores:           %-34d║%n", proveedores);
        System.out.printf("║  👤 Empleados:             %-34d║%n", empleados);
        System.out.printf("║  📦 Otros:                 %-34d║%n", otros);
        System.out.println("║  ─────────────────────────────────────────────────────────   ║");
        System.out.printf("║  📋 TOTAL:                 %-34d║%n", entidades.size());
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }

    /**
     * Retorna la lista de entidades
     */
    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Limpia todas las entidades
     */
    public void limpiarEntidades() {
        entidades.clear();
        System.out.println("✓ Todas las entidades han sido eliminadas");
    }

    /**
     * Retorna el número de entidades
     */
    public int contarEntidades() {
        return entidades.size();
    }
}