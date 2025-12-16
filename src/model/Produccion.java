package model;

/**
 * Clase que representa un registro de producción mensual
 * de un centro de cultivo específico
 */
public class Produccion {
    // Atributos privados
    private String mes;
    private int año;
    private double toneladasMensuales;
    private String tipoSalmon;

    // Constructor por defecto
    public Produccion() {
    }

    // Constructor con parámetros
    public Produccion(String mes, int año, double toneladasMensuales, String tipoSalmon) {
        this.mes = mes;
        this.año = año;
        this.toneladasMensuales = toneladasMensuales;
        this.tipoSalmon = tipoSalmon;
    }

    // Getters y Setters
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        if (mes == null || mes.trim().isEmpty()) {
            throw new IllegalArgumentException("El mes no puede estar vacío");
        }
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        if (año < 2000 || año > 2030) {
            throw new IllegalArgumentException("Año debe estar entre 2000 y 2030");
        }
        this.año = año;
    }

    public double getToneladasMensuales() {
        return toneladasMensuales;
    }

    public void setToneladasMensuales(double toneladasMensuales) {
        if (toneladasMensuales < 0) {
            throw new IllegalArgumentException("Las toneladas no pueden ser negativas");
        }
        this.toneladasMensuales = toneladasMensuales;
    }

    public String getTipoSalmon() {
        return tipoSalmon;
    }

    public void setTipoSalmon(String tipoSalmon) {
        this.tipoSalmon = tipoSalmon;
    }

    @Override
    public String toString() {
        return String.format("%s %d: %.2f ton. [%s]",
                mes, año, toneladasMensuales, tipoSalmon);
    }
}