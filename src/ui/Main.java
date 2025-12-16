package ui;

import data.GestorEntidades;

/**
 * Clase principal para demostración por consola
 * Muestra el uso de interfaces, instanceof y polimorfismo
 *
 * Semana 8: Integración completa
 *
 * NOTA: Para ejecutar la GUI, usar SalmonttGUI.main()
 */
public class Main {

    private static final String SEPARADOR = "═".repeat(80);

    public static void main(String[] args) {
        mostrarEncabezado();

        // Crear gestor de entidades
        GestorEntidades gestor = new GestorEntidades();

        // PASO 1: Cargar datos de prueba
        System.out.println(SEPARADOR);
        System.out.println("PASO 1: Cargar entidades que implementan Registrable");
        System.out.println(SEPARADOR);

        gestor.cargarDatosDePrueba();

        // PASO 2: Mostrar todas las entidades con instanceof
        System.out.println("\n" + SEPARADOR);
        System.out.println("PASO 2: Recorrer colección y diferenciar con instanceof");
        System.out.println(SEPARADOR);
        System.out.println();

        gestor.mostrarTodasLasEntidades();

        // PASO 3: Mostrar estadísticas
        System.out.println("\n" + SEPARADOR);
        System.out.println("PASO 3: Estadísticas por tipo (usando instanceof)");
        System.out.println(SEPARADOR);
        System.out.println();

        gestor.mostrarEstadisticasPorTipo();

        // PASO 4: Explicación de conceptos
        mostrarExplicacionConceptos();

        // PASO 5: Información sobre la GUI
        mostrarInfoGUI();

        mostrarPieDePagina();
    }

    /**
     * Muestra el encabezado del sistema
     */
    private static void mostrarEncabezado() {
        System.out.println(SEPARADOR);
        System.out.println("🐟  SISTEMA SALMONTT - EVALUACIÓN SUMATIVA SEMANA 8");
        System.out.println("    Interfaces + Polimorfismo + instanceof + GUI");
        System.out.println("    Desarrollo Orientado a Objetos I");
        System.out.println(SEPARADOR);
        System.out.println();
    }

    /**
     * Explica los conceptos implementados
     */
    private static void mostrarExplicacionConceptos() {
        System.out.println("\n" + SEPARADOR);
        System.out.println("📚 CONCEPTOS IMPLEMENTADOS EN SEMANA 8");
        System.out.println(SEPARADOR);
        System.out.println();

        System.out.println("1️⃣  INTERFAZ REGISTRABLE:");
        System.out.println("    • Define un contrato común para todas las entidades");
        System.out.println("    • Métodos abstractos: mostrarResumen(), obtenerIdentificador(), obtenerTipo()");
        System.out.println("    • Implementada por: UnidadOperativa, Proveedor, Empleado");
        System.out.println();

        System.out.println("2️⃣  HERENCIA:");
        System.out.println("    • UnidadOperativa es la superclase");
        System.out.println("    • CentroCultivo y PlantaProceso heredan de UnidadOperativa");
        System.out.println("    • Todas heredan la implementación de Registrable");
        System.out.println();

        System.out.println("3️⃣  POLIMORFISMO:");
        System.out.println("    • ArrayList<Registrable> puede contener cualquier entidad");
        System.out.println("    • CentroCultivo, PlantaProceso, Proveedor, Empleado en la misma lista");
        System.out.println("    • Invocación dinámica de métodos según el tipo real");
        System.out.println();

        System.out.println("4️⃣  INSTANCEOF:");
        System.out.println("    • Permite identificar el tipo exacto de cada objeto");
        System.out.println("    • Útil para aplicar lógica específica según el tipo");
        System.out.println("    • Usado en GestorEntidades para diferenciar comportamientos");
        System.out.println();

        System.out.println("5️⃣  COLECCIONES GENÉRICAS:");
        System.out.println("    • ArrayList<Registrable> almacena todas las entidades");
        System.out.println("    • Tipo seguro en tiempo de compilación");
        System.out.println("    • Facilita operaciones comunes sobre la colección");
        System.out.println();
    }

    /**
     * Muestra información sobre cómo ejecutar la GUI
     */
    private static void mostrarInfoGUI() {
        System.out.println(SEPARADOR);
        System.out.println("🖥️  INTERFAZ GRÁFICA DISPONIBLE");
        System.out.println(SEPARADOR);
        System.out.println();
        System.out.println("El sistema incluye una GUI completa desarrollada con Swing.");
        System.out.println();
        System.out.println("Para ejecutar la interfaz gráfica:");
        System.out.println("  1. En IntelliJ IDEA, abre: ui/SalmonttGUI.java");
        System.out.println("  2. Clic derecho → Run 'SalmonttGUI.main()'");
        System.out.println();
        System.out.println("Funcionalidades de la GUI:");
        System.out.println("  🏢 Agregar Proveedores con formulario");
        System.out.println("  👤 Agregar Empleados con formulario");
        System.out.println("  📋 Mostrar todas las entidades");
        System.out.println("  📊 Ver estadísticas por tipo");
        System.out.println("  🗑️ Limpiar pantalla");
        System.out.println();
    }

    /**
     * Muestra el pie de página
     */
    private static void mostrarPieDePagina() {
        System.out.println(SEPARADOR);
        System.out.println("✅ REQUISITOS CUMPLIDOS - SEMANA 8:");
        System.out.println(SEPARADOR);
        System.out.println();
        System.out.println("  ✓ Interfaz Registrable definida e implementada");
        System.out.println("  ✓ Herencia: UnidadOperativa → CentroCultivo, PlantaProceso");
        System.out.println("  ✓ 4 tipos de entidades diferentes: Centro, Planta, Proveedor, Empleado");
        System.out.println("  ✓ Colección ArrayList<Registrable> polimórfica");
        System.out.println("  ✓ Uso de instanceof para diferenciar tipos");
        System.out.println("  ✓ GUI funcional con JFrame y formularios");
        System.out.println("  ✓ Ingreso de datos desde la GUI");
        System.out.println("  ✓ Visualización de resultados en GUI y consola");
        System.out.println();
        System.out.println(SEPARADOR);
        System.out.println("🎓 Sistema ejecutado exitosamente - Duoc UC");
        System.out.println(SEPARADOR);
    }
}