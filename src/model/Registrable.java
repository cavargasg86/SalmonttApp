package model;

/**
 * Interfaz que define el contrato común para todas las entidades
 * que pueden ser registradas y gestionadas en el sistema Salmontt
 *
 * Semana 8: Implementación de Interfaces
 */
public interface Registrable {

    /**
     * Método abstracto que debe ser implementado por todas las clases
     * que implementen esta interfaz.
     * Muestra un resumen de la información de la entidad.
     */
    void mostrarResumen();

    /**
     * Método para obtener el identificador único de la entidad
     * @return String con el identificador
     */
    String obtenerIdentificador();

    /**
     * Método para obtener el tipo de entidad
     * @return String con el tipo de entidad
     */
    String obtenerTipo();
}