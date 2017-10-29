/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Santiago de Cali (Cali - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: N1-Alcancia-Java
  Autor: Joan Andrés Buriticá Salazar
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package edu.jabs.alcancia.mundo;

/**
 * Clase que representa una alcancía.
 */
public class Alcancia
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Número de monedas de $50 que hay en la alcancía.
     */
    private int numeroMonedas50;

    /**
     * Número de monedas de $100 que hay en la alcancía.
     */
    private int numeroMonedas100;

    /**
     * Número de monedas de $200 que hay en la alcancía.
     */
    private int numeroMonedas200;

    /**
     * Número de monedas de $500 que hay en la alcancía.
     */
    private int numeroMonedas500;

    /**
     * Número de monedas de $1000 que hay en la alcancía.
     */
    private int numeroMonedas1000;

    /**
     * Estado de la alcancía. <br>
     * 0 indica que no está rota. <br>
     * 1 indica que está rota.
     */
    private int estado;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye la alcancía. <br>
     * <b>post: </b> El número de monedas de 50, número de monedas de 100, número de monedas de 200, número de monedas de 500, número de monedas de 1000 y el estado fueron
     * incializados en 0.
     */
    public Alcancia( )
    {
        numeroMonedas50 = 0;
        numeroMonedas100 = 0;
        numeroMonedas200 = 0;
        numeroMonedas500 = 0;
        numeroMonedas1000 = 0;
        estado = 0;
    }

    /**
     * Retorna el número de monedas de $50 que hay en la alcancía.
     * @return Número de monedas de $50 en la alcancía.
     */
    public int darNumeroMonedas50( )
    {
        return numeroMonedas50;
    }

    /**
     * Retorna el número de monedas de $100 que hay en la alcancía.
     * @return Número de monedas de $100 en la alcancía.
     */
    public int darNumeroMonedas100( )
    {
        return numeroMonedas100;
    }

    /**
     * Retorna el número de monedas de $200 que hay en la alcancía.
     * @return Número de monedas de $200 en la alcancía.
     */
    public int darNumeroMonedas200( )
    {
        return numeroMonedas200;
    }

    /**
     * Retorna el número de monedas de $500 que hay en la alcancía.
     * @return Número de monedas de $500 en la alcancía.
     */
    public int darNumeroMonedas500( )
    {
        return numeroMonedas500;
    }

    /**
     * Retorna el número de monedas de $1000 que hay en la alcancía.
     * @return Número de monedas de $1000 en la alcancía.
     */
    public int darNumeroMonedas1000( )
    {
        return numeroMonedas1000;
    }

    /**
     * Informa si la alcancía está rota o no.
     * @return Retorna 1 si está rota, 0 en caso contrario.
     */
    public int darEstado( )
    {
        return estado;
    }

    /**
     * Retorna el total de dinero que hay en la alcancía.
     * @return Total de dinero que hay en la alcancía.
     */
    public int calcularTotalDinero( )
    {
        return numeroMonedas1000 * 1000 + numeroMonedas50 * 50 + numeroMonedas100 * 100 + numeroMonedas200 * 200 + numeroMonedas500 * 500;
    }

    /**
     * Retorna el estado de la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota.<br>
     * @return Cadena que informa la cantidad de monedas que había en la alcancía y la cantidad total de dinero.
     */
    public String darEstadoAlcancia( )
    {
        int totalDinero = calcularTotalDinero( );

        return "La alcancía tenía: \n " + numeroMonedas50 + " moneda(s) de $50 \n " + numeroMonedas100 + " moneda(s) de $100 \n " + numeroMonedas200 + " moneda(s) de $200 \n " + numeroMonedas500 + " moneda(s) de $500 \n " + numeroMonedas1000
                + " moneda(s) de $1000 \n " + "Para un total de $" + totalDinero + " pesos.";
    }

    /**
     * Agrega una moneda de $50 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $50 en la alcancía.
     */
    public void agregarMoneda50( )
    {
        numeroMonedas50 = numeroMonedas50 + 1;
    }

    /**
     * Agrega una moneda de $100 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $100 en la alcancía.
     */
    public void agregarMoneda100( )
    {
        numeroMonedas100 = numeroMonedas100 + 1;
    }

    /**
     * Agrega una moneda de $200 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $200 en la alcancía.
     */
    public void agregarMoneda200( )
    {
        numeroMonedas200 = numeroMonedas200 + 1;
    }

    /**
     * Agrega una moneda de $500 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en una la cantidad de monedas de $500 en la alcancía.
     */
    public void agregarMoneda500( )
    {
        numeroMonedas500 = numeroMonedas500 + 1;
    }

    /**
     * Agrega una moneda de $1000 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $1000 en la alcancía.
     */
    public void agregarMoneda1000( )
    {
        numeroMonedas1000 = numeroMonedas1000 + 1;
    }

    /**
     * Rompe la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>La alcancía está rota.
     */
    public void romperAlcancia( )
    {
        estado = 1;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}

