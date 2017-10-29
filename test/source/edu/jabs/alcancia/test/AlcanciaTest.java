/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Santiago de Cali (Cali - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: N1-Alcancia-Java
  Autor: Joan Andrés Buriticá Salazar
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package edu.jabs.alcancia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.jabs.alcancia.mundo.Alcancia;

/**
 * Clase usada para verificar que los métodos de la clase Alcancia están correctamente implementados.
 */
public class AlcanciaTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Alcancia alcancia;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea una alcancía vacía.
     */
    private void setupEscenario1( )
    {
        alcancia = new Alcancia( );
    }

    /**
     * Prueba 1: Se encarga de verificar el método Alcancia. <br>
     * <b> Métodos a probar: </b> <br>
     * Alcancia<br>
     * estaRota<br>
     * darEstadoAlcanciaz<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye la alcancía correctamente.
     */
    @Test
    public void testAlcancia( )
    {
        setupEscenario1( );

        assertEquals( "Después de crearse la alcancía no puede estar rota.", 0, alcancia.darEstado( ) );

        String mensaje = alcancia.darEstadoAlcancia( );
        String mensajeEsperado = "La alcancía tenía: \n 0 moneda(s) de $50 \n 0 moneda(s) de $100 \n 0 moneda(s) de $200 \n 0 moneda(s) de $500 \n 0 moneda(s) de $1000 \n Para un total de $0 pesos.";

        assertEquals( "La alcancía no estaba vacía", mensajeEsperado, mensaje );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método de agregar moneda. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarMoneda50<br>
     * agregarMoneda100<br>
     * agregarMoneda200<br>
     * agregarMoneda500<br>
     * agregarMoneda1000<br>
     * darNumeroMonedas50<br>
     * darNumeroMonedas100<br>
     * darNumeroMonedas200<br>
     * darNumeroMonedas500<br>
     * darNumeroMonedas1000<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan monedas de las distintas denominaciones.
     */
    @Test
    public void testAgregarMoneda( )
    {
        setupEscenario1( );

        alcancia.agregarMoneda1000( );
        alcancia.agregarMoneda50( );
        alcancia.agregarMoneda50( );
        alcancia.agregarMoneda100( );
        alcancia.agregarMoneda200( );
        alcancia.agregarMoneda200( );
        alcancia.agregarMoneda200( );
        alcancia.agregarMoneda500( );
        alcancia.agregarMoneda500( );
        alcancia.agregarMoneda500( );
        alcancia.agregarMoneda1000( );

        assertEquals( "El número de monedas est� equivocado.", 2, alcancia.darNumeroMonedas50( ) );
        assertEquals( "El número de monedas est� equivocado.", 1, alcancia.darNumeroMonedas100( ) );
        assertEquals( "El número de monedas est� equivocado.", 3, alcancia.darNumeroMonedas200( ) );
        assertEquals( "El número de monedas est� equivocado.", 3, alcancia.darNumeroMonedas500( ) );
        assertEquals( "El número de monedas est� equivocado.", 2, alcancia.darNumeroMonedas1000( ) );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método romperAlcancia.<br>
     * <b> Métodos a probar: </b> <br>
     * darEstado<br>
     * romperAlcancia<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se rompe la alcancía cuando está vacía.
     */
    @Test
    public void testRomperAlcancia( )
    {
        setupEscenario1( );

        assertEquals( "Después de crearse la alcancía no puede estar rota", 0, alcancia.darEstado( ) );

        alcancia.romperAlcancia( );
        assertEquals( "Ahora la alcancía debería estar rota", 1, alcancia.darEstado( ) );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método darEstadoAlcancia. <br>
     * <b> Métodos a probar: </b> <br>
     * darEstadoAlcancia<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Había monedas en la alcancía.
     */
    @Test
    public void testDarEstado( )
    {
        setupEscenario1( );
        alcancia.agregarMoneda1000( );
        String mensaje = alcancia.darEstadoAlcancia( );
        String mensajeEsperado = "La alcancía tenía: \n 0 moneda(s) de $50 \n 0 moneda(s) de $100 \n 0 moneda(s) de $200 \n 0 moneda(s) de $500 \n 1 moneda(s) de $1000 \n Para un total de $1000 pesos.";

        assertEquals( "La alcancía no estaba vacía", mensajeEsperado, mensaje );
    }
}