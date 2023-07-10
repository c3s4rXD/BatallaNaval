package navalBattle;

import javax.swing.*;

/**
 * This class is used for ...


 */
public class Celdas extends JButton
{
    /*
    Attributes
    */
    private int columnas, filas;
    private boolean areaSeleccionada;
    private String nombreDelNavio;

    /*
    Constructor of the class
    */
    public Celdas(int filas, int columnas, boolean areaSeleccionada)
    {
        this.columnas = columnas;
        this.filas = filas;
        this.areaSeleccionada=false;
        nombreDelNavio="";
    }

    /*
    Get columns
    */
    public int getColumnas()
    {
        return columnas;
    }

    /*
    Get rows
    */
    public int getFilas()
    {
        return filas;
    }

    /*
    Set chosen area
    */
    public void setAreaSeleccionada()
    {
        this.areaSeleccionada=true;
    }

    /*
    Get chosen area
    */
    public boolean getChosenArea()
    {
        return areaSeleccionada;
    }

    /*
    Set the boat name
    */
    public void setNombreDelNavio(String nombre)
    {
        this.nombreDelNavio=nombre;
    }

    /*
    Get boat name
    */
    public String getNombreDelNavio()
    {
        return nombreDelNavio;
    }
}

