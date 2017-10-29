/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Santiago de Cali (Cali - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: N1-Alcancia-Java
  Autor: Joan Andrés Buriticá Salazar
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package edu.jabs.alcancia.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import edu.jabs.alcancia.mundo.Alcancia;

/**
 * Clase principal de la interfaz.
 */
public class InterfazAlcancia extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Alcancia alcancia;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel donde se muestra el estado actual de la alcancía.
     */
    private PanelAlcancia panelAlcancia;

    /**
     * Panel con los botones de las acciones de la aplicación.
     */
    private PanelBotones panelBotones;

    /**
     * Panel donde se seleccionan y agregan las monedas.
     */
    private PanelMonedas panelMonedas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz de la aplicación y la inicializa con una alcancía vacía. <br>
     * <b>post: </b> Se inicializó la ventana principal de la aplicación con sus páneles.
     */
    public InterfazAlcancia( )
    {
        setTitle( "Alcancía" );
        setSize( 600, 650 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        alcancia = new Alcancia( );

        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new BorderLayout( ) );

        panelMonedas = new PanelMonedas( this );
        panelCentral.add( panelMonedas, BorderLayout.NORTH );

        panelAlcancia = new PanelAlcancia( );
        panelCentral.add( panelAlcancia, BorderLayout.CENTER );

        panelBotones = new PanelBotones( this );
        panelCentral.add( panelBotones, BorderLayout.EAST );

        getContentPane( ).add( panelCentral, BorderLayout.CENTER );

        setLocationRelativeTo( null );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega una moneda a la alcancía siempre y cuando no esté rota. <br>
     * <b>post: </b>Se agregó la cantidad indicada a la alcancía o se presentó un mensaje de error si estaba rota.
     * @param pDenominacion Denominación de la moneda que se va a agregar a la alcancía. pDenominacion >0.
     */
    public void agregarMoneda( int pDenominacion )
    {
        if( alcancia.darEstado( ) == 0 )
        {
            if( pDenominacion == 1000 )
            {
                alcancia.agregarMoneda1000( );
                panelMonedas.cambiarCantidad( 1000, alcancia.darNumeroMonedas1000( ) );
            }
            else if( pDenominacion == 50 )
            {
                alcancia.agregarMoneda50( );
                panelMonedas.cambiarCantidad( 50, alcancia.darNumeroMonedas50( ) );
            }
            else if( pDenominacion == 100 )
            {
                alcancia.agregarMoneda100( );
                panelMonedas.cambiarCantidad( 100, alcancia.darNumeroMonedas100( ) );
            }
            else if( pDenominacion == 200 )
            {
                alcancia.agregarMoneda200( );
                panelMonedas.cambiarCantidad( 200, alcancia.darNumeroMonedas200( ) );
            }
            else if( pDenominacion == 500 )
            {
                alcancia.agregarMoneda500( );
                panelMonedas.cambiarCantidad( 500, alcancia.darNumeroMonedas500( ) );
            }

            panelAlcancia.cambiarMensaje( "Se agregaron $" + pDenominacion + " a la alcancía.\nEn la alcancía hay $" + alcancia.calcularTotalDinero( ) + " pesos." );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pueden agregar monedas a una alcancía rota.", "Agregar moneda", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Crea una nueva alcancía. <br>
     * <b>post: </b> Se creó una alcancia nueva.
     */
    public void nuevaAlcancia( )
    {
        alcancia = new Alcancia( );

        panelAlcancia.cambiarImagenAlcancia( false );
        panelAlcancia.cambiarMensaje( "La alcancía está vacía." );

        panelMonedas.cambiarCantidad( 50, alcancia.darNumeroMonedas50( ) );
        panelMonedas.cambiarCantidad( 100, alcancia.darNumeroMonedas100( ) );
        panelMonedas.cambiarCantidad( 200, alcancia.darNumeroMonedas200( ) );
        panelMonedas.cambiarCantidad( 500, alcancia.darNumeroMonedas500( ) );
        panelMonedas.cambiarCantidad( 1000, alcancia.darNumeroMonedas1000( ) );
    }

    /**
     * Rompe la alcancía y actualiza la información mostrada. <br>
     * <b>post: </b>La alcancía está rota.
     */
    public void romperAlcancia( )
    {
        String mensaje = alcancia.darEstadoAlcancia( );
        alcancia.romperAlcancia( );

        panelAlcancia.cambiarImagenAlcancia( true );
        panelAlcancia.cambiarMensaje( "La alcancía está rota." );
        JOptionPane.showMessageDialog( this, mensaje, "Romper alcancía", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Punto de extensión 1.
     */
    public void reqFunc1( )
    {
        String resultado = alcancia.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Punto de extensión 2.
     */
    public void reqFunc2( )
    {
        String resultado = alcancia.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazAlcancia ia = new InterfazAlcancia( );
            ia.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
