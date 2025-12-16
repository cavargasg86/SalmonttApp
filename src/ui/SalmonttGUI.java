package ui;

import data.GestorEntidades;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfaz Gráfica del Sistema Salmontt
 * Permite ingresar y visualizar entidades del sistema
 *
 * Semana 8: GUI con JFrame
 */
public class SalmonttGUI extends JFrame {

    // Componentes
    private GestorEntidades gestor;
    private JTextArea areaTexto;
    private JComboBox<String> comboTipoEntidad;

    // Constructor
    public SalmonttGUI() {
        this.gestor = new GestorEntidades();
        inicializarVentana();
        crearComponentes();

        // Cargar datos de prueba al inicio
        gestor.cargarDatosDePrueba();
        actualizarAreaTexto("Sistema inicializado con datos de prueba\n");
    }

    /**
     * Inicializa la configuración de la ventana
     */
    private void inicializarVentana() {
        setTitle("🐟 Sistema Salmontt - Gestión de Entidades");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(new BorderLayout(10, 10));
    }

    /**
     * Crea todos los componentes de la GUI
     */
    private void crearComponentes() {
        // Panel superior - Título
        JPanel panelTitulo = crearPanelTitulo();
        add(panelTitulo, BorderLayout.NORTH);

        // Panel central - Área de texto
        JPanel panelCentral = crearPanelCentral();
        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior - Botones
        JPanel panelBotones = crearPanelBotones();
        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Crea el panel del título
     */
    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 204));
        panel.setPreferredSize(new Dimension(0, 80));

        JLabel lblTitulo = new JLabel("🐟 SISTEMA SALMONTT");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);

        JLabel lblSubtitulo = new JLabel("Gestión Integrada de Entidades");
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSubtitulo.setForeground(Color.WHITE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(lblTitulo);
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    /**
     * Crea el panel central con área de texto
     */
    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaTexto.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBorder(BorderFactory.createTitledBorder("📋 Información del Sistema"));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Crea el panel de botones
     */
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botón: Agregar Proveedor
        JButton btnAgregarProveedor = new JButton("🏢 Agregar Proveedor");
        btnAgregarProveedor.setFont(new Font("Arial", Font.BOLD, 14));
        btnAgregarProveedor.addActionListener(e -> mostrarFormularioProveedor());

        // Botón: Agregar Empleado
        JButton btnAgregarEmpleado = new JButton("👤 Agregar Empleado");
        btnAgregarEmpleado.setFont(new Font("Arial", Font.BOLD, 14));
        btnAgregarEmpleado.addActionListener(e -> mostrarFormularioEmpleado());

        // Botón: Mostrar Todas
        JButton btnMostrarTodas = new JButton("📋 Mostrar Todas");
        btnMostrarTodas.setFont(new Font("Arial", Font.BOLD, 14));
        btnMostrarTodas.addActionListener(e -> mostrarTodasLasEntidades());

        // Botón: Estadísticas
        JButton btnEstadisticas = new JButton("📊 Estadísticas");
        btnEstadisticas.setFont(new Font("Arial", Font.BOLD, 14));
        btnEstadisticas.addActionListener(e -> mostrarEstadisticas());

        // Botón: Limpiar Pantalla
        JButton btnLimpiar = new JButton("🗑️ Limpiar Pantalla");
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 14));
        btnLimpiar.addActionListener(e -> limpiarPantalla());

        // Botón: Salir
        JButton btnSalir = new JButton("❌ Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 14));
        btnSalir.setBackground(new Color(220, 53, 69));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.addActionListener(e -> salir());

        panel.add(btnAgregarProveedor);
        panel.add(btnAgregarEmpleado);
        panel.add(btnMostrarTodas);
        panel.add(btnEstadisticas);
        panel.add(btnLimpiar);
        panel.add(btnSalir);

        return panel;
    }

    /**
     * Muestra formulario para agregar proveedor
     */
    private void mostrarFormularioProveedor() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField txtRut = new JTextField();
        JTextField txtRazon = new JTextField();
        JTextField txtRubro = new JTextField();
        JTextField txtContacto = new JTextField();

        panel.add(new JLabel("RUT:"));
        panel.add(txtRut);
        panel.add(new JLabel("Razón Social:"));
        panel.add(txtRazon);
        panel.add(new JLabel("Rubro:"));
        panel.add(txtRubro);
        panel.add(new JLabel("Contacto:"));
        panel.add(txtContacto);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Agregar Proveedor", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Proveedor proveedor = new Proveedor(
                        txtRut.getText(),
                        txtRazon.getText(),
                        txtRubro.getText(),
                        txtContacto.getText()
                );

                gestor.agregarEntidad(proveedor);
                actualizarAreaTexto("✓ Proveedor agregado exitosamente:\n");
                areaTexto.append(proveedor.toString() + "\n\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar proveedor: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Muestra formulario para agregar empleado
     */
    private void mostrarFormularioEmpleado() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField txtRut = new JTextField();
        JTextField txtNombres = new JTextField();
        JTextField txtApellidos = new JTextField();
        JTextField txtCargo = new JTextField();
        JTextField txtArea = new JTextField();

        panel.add(new JLabel("RUT:"));
        panel.add(txtRut);
        panel.add(new JLabel("Nombres:"));
        panel.add(txtNombres);
        panel.add(new JLabel("Apellidos:"));
        panel.add(txtApellidos);
        panel.add(new JLabel("Cargo:"));
        panel.add(txtCargo);
        panel.add(new JLabel("Área:"));
        panel.add(txtArea);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Agregar Empleado", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Empleado empleado = new Empleado(
                        txtRut.getText(),
                        txtNombres.getText(),
                        txtApellidos.getText(),
                        txtCargo.getText(),
                        txtArea.getText()
                );

                gestor.agregarEntidad(empleado);
                actualizarAreaTexto("✓ Empleado agregado exitosamente:\n");
                areaTexto.append(empleado.toString() + "\n\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar empleado: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Muestra todas las entidades en el área de texto
     */
    private void mostrarTodasLasEntidades() {
        actualizarAreaTexto("");

        // Redirigir System.out al área de texto temporalmente
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        java.io.PrintStream old = System.out;
        System.setOut(ps);

        gestor.mostrarTodasLasEntidades();

        System.out.flush();
        System.setOut(old);

        areaTexto.setText(baos.toString());
        areaTexto.setCaretPosition(0); // Scroll al inicio
    }

    /**
     * Muestra estadísticas
     */
    private void mostrarEstadisticas() {
        actualizarAreaTexto("");

        // Redirigir System.out al área de texto
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        java.io.PrintStream old = System.out;
        System.setOut(ps);

        gestor.mostrarEstadisticasPorTipo();

        System.out.flush();
        System.setOut(old);

        areaTexto.setText(baos.toString());
    }

    /**
     * Limpia el área de texto
     */
    private void limpiarPantalla() {
        areaTexto.setText("");
    }

    /**
     * Actualiza el área de texto
     */
    private void actualizarAreaTexto(String texto) {
        areaTexto.setText(texto);
    }

    /**
     * Cierra la aplicación
     */
    private void salir() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Método main para ejecutar la GUI
     */
    public static void main(String[] args) {
        // Usar el Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ejecutar en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            SalmonttGUI gui = new SalmonttGUI();
            gui.setVisible(true);
        });
    }
}