package navalBattle;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

/**
 * This class is used for ...


 */
public class ControlNavalBattle
{
    /*
    Atributos
    */
    private int  numAciertos=0, paso=1, armas=0;
    private ImageIcon tocar, hundido, agua, fragatas;
    private ImageIcon portaAviones, submarino, destructors;

    /*
    Constructor of the class
    */
    public ControlNavalBattle()
    {
        hundido=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/hundido.jpg")));
        tocar=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/tocado.jpg")));
        agua=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/agua.jpg")));
        fragatas=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fragatas.jpg")));
    }

    /*
    Ubicar el panel rival
    */
    public void setPanelRival(JPanel panel, Celdas[][] celdas)
    {
        Random randoNum=new Random();
        /*
        Ubicar el protaaviones
        */
        if(paso==1)
        {
            int num1=randoNum.nextInt(10)+1;
            int num2=randoNum.nextInt(10)+1;
            int horizontallyOrVertically=randoNum.nextInt(2)+1;
            if(horizontallyOrVertically==1)
            {
                if(celdas[num1][num2].getFilas() >= 1 && celdas[num1][num2].getFilas() <= 3 && !celdas[num1][num2].getChosenArea())
                {
                    celdas[num1][num2].setAreaSeleccionada();
                    celdas[num1 + 1][num2].setAreaSeleccionada();
                    celdas[num1 + 2][num2].setAreaSeleccionada();
                    celdas[num1 + 3][num2].setAreaSeleccionada();
                    setPortaAviones(horizontallyOrVertically, celdas[num1][num2].getFilas(), celdas[num1][num2], celdas[num1 + 1][num2],
                            celdas[num1 + 2][num2], celdas[num1 + 3][num2]);
                    panel.updateUI();
                    paso++;
                }
                if(celdas[num1][num2].getFilas() > 3 && celdas[num1][num2].getFilas() < 9 && !celdas[num1][num2].getChosenArea())
                {
                    celdas[num1][num2].setAreaSeleccionada();
                    celdas[num1 - 1][num2].setAreaSeleccionada();
                    celdas[num1 - 2][num2].setAreaSeleccionada();
                    celdas[num1 - 3][num2].setAreaSeleccionada();
                    setPortaAviones(horizontallyOrVertically, celdas[num1][num2].getFilas(), celdas[num1][num2], celdas[num1 - 1][num2],
                            celdas[num1 - 2][num2], celdas[num1 - 3][num2]);
                    panel.updateUI();
                    paso++;
                }
            }
            if(horizontallyOrVertically==2)
            {
                if(celdas[num1][num2].getColumnas() >= 8 && celdas[num1][num2].getColumnas() <= 10 && !celdas[num1][num2].getChosenArea())
                {
                    celdas[num1][num2].setAreaSeleccionada();
                    celdas[num1][num2 - 1].setAreaSeleccionada();
                    celdas[num1][num2 - 2].setAreaSeleccionada();
                    celdas[num1][num2 - 3].setAreaSeleccionada();
                    setPortaAviones(horizontallyOrVertically, celdas[num1][num2].getColumnas(), celdas[num1][num2], celdas[num1][num2 - 1],
                            celdas[num1][num2 - 2], celdas[num1][num2 - 3]);
                    panel.updateUI();
                    paso++;
                }
                if(celdas[num1][num2].getColumnas() >= 1 && celdas[num1][num2].getColumnas() < 8 && !celdas[num1][num2].getChosenArea())
                {
                    celdas[num1][num2].setAreaSeleccionada();
                    celdas[num1][num2 + 1].setAreaSeleccionada();
                    celdas[num1][num2 + 2].setAreaSeleccionada();
                    celdas[num1][num2 + 3].setAreaSeleccionada();
                    setPortaAviones(horizontallyOrVertically, celdas[num1][num2].getColumnas(), celdas[num1][num2], celdas[num1][num2 + 1],
                            celdas[num1][num2 + 2], celdas[num1][num2 + 3]);
                    panel.updateUI();
                    paso++;
                }
            }
        }

        /*
        ubica los submarinos
        */
        if(paso==2)
        {
            while(armas < 2)
            {
                int num1 = randoNum.nextInt(10) + 1;
                int num2 = randoNum.nextInt(10) + 1;
                while(celdas[num1][num2].getChosenArea())
                {
                    num1 = randoNum.nextInt(10) + 1;
                    num2 = randoNum.nextInt(10) + 1;
                }
                int horizontallyOrVertically = randoNum.nextInt(2) + 1;
                if (horizontallyOrVertically == 1)
                {
                    if (celdas[num1][num2].getFilas() >= 9 && celdas[num1][num2].getFilas() <= 10 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1 - 1][num2].getChosenArea() && !celdas[num1 - 2][num2].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1 - 1][num2].setAreaSeleccionada();
                        celdas[num1 - 2][num2].setAreaSeleccionada();
                        setSubmarinos(horizontallyOrVertically, celdas[num1][num2].getFilas(), celdas[num1][num2],
                                celdas[num1 - 1][num2], celdas[num1 - 2][num2]);
                        panel.updateUI();
                        armas++;
                    }
                    if(celdas[num1][num2].getFilas() >= 1 && celdas[num1][num2].getFilas() <=8 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1 + 1][num2].getChosenArea() && !celdas[num1 + 2][num2].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1 + 1][num2].setAreaSeleccionada();
                        celdas[num1 + 2][num2].setAreaSeleccionada();
                        setSubmarinos(horizontallyOrVertically, celdas[num1][num2].getFilas(), celdas[num1][num2],
                                celdas[num1 + 1][num2], celdas[num1 + 2][num2]);
                        panel.updateUI();
                        armas++;
                    }
                }
                if (horizontallyOrVertically == 2)
                {
                    if(celdas[num1][num2].getColumnas() == 10 || celdas[num1][num2].getColumnas() == 9 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1][num2 - 1].getChosenArea() && !celdas[num1][num2 - 2].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1][num2 - 1].setAreaSeleccionada();
                        celdas[num1][num2 - 2].setAreaSeleccionada();
                        setSubmarinos(horizontallyOrVertically, celdas[num1][num2].getColumnas(), celdas[num1][num2],
                                celdas[num1][num2 - 1], celdas[num1][num2 - 2]);
                        panel.updateUI();
                        armas++;
                    }
                    if(celdas[num1][num2].getColumnas() >= 1 && celdas[num1][num2].getColumnas() < 9 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1][num2 + 1].getChosenArea() && !celdas[num1][num2 + 2].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1][num2 + 1].setAreaSeleccionada();
                        celdas[num1][num2 + 2].setAreaSeleccionada();
                        setSubmarinos(horizontallyOrVertically, celdas[num1][num2].getColumnas(), celdas[num1][num2],
                                celdas[num1][num2 + 1], celdas[num1][num2 + 2]);
                        panel.updateUI();
                        armas++;
                    }
                }
            }

            if (armas == 2)
            {
                paso++;
                armas=0;
            }
        }

        /*
        Ubica los destructoress
        */
        if(paso==3)
        {
            while(armas < 3)
            {
                int num1 = randoNum.nextInt(10) + 1;
                int num2 = randoNum.nextInt(10) + 1;
                while(celdas[num1][num2].getChosenArea())
                {
                    num1 = randoNum.nextInt(10) + 1;
                    num2 = randoNum.nextInt(10) + 1;
                }
                int horizontallyOrVertically = randoNum.nextInt(2) + 1;
                if(horizontallyOrVertically==1)
                {
                    if(celdas[num1][num2].getFilas() == 10 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1 - 1][num2].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1 - 1][num2].setAreaSeleccionada();
                        setDestructores(horizontallyOrVertically, celdas[num1][num2].getFilas(), celdas[num1][num2], celdas[num1 - 1][num2]);
                        panel.updateUI();
                        armas++;
                    }

                    if (celdas[num1][num2].getFilas() >= 1 && celdas[num1][num2].getFilas() < 9 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1 + 1][num2].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1 + 1][num2].setAreaSeleccionada();
                        setDestructores(horizontallyOrVertically, celdas[num1][num2].getFilas(), celdas[num1][num2], celdas[num1 + 1][num2]);
                        panel.updateUI();
                        armas++;
                    }
                }
                if(horizontallyOrVertically==2)
                {
                    if (celdas[num1][num2].getColumnas() == 10 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1][num2 - 1].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1][num2 - 1].setAreaSeleccionada();
                        setDestructores(horizontallyOrVertically, celdas[num1][num2].getColumnas(), celdas[num1][num2], celdas[num1][num2 - 1]);
                        panel.updateUI();
                        armas++;
                    }

                    if (celdas[num1][num2].getColumnas() >= 1 && celdas[num1][num2].getColumnas() < 9 && !celdas[num1][num2].getChosenArea()
                            && !celdas[num1][num2 + 1].getChosenArea())
                    {
                        celdas[num1][num2].setAreaSeleccionada();
                        celdas[num1][num2 + 1].setAreaSeleccionada();
                        setDestructores(horizontallyOrVertically, celdas[num1][num2].getColumnas(), celdas[num1][num2], celdas[num1][num2 + 1]);
                        panel.updateUI();
                        armas++;
                    }
                }
            }
            if (armas == 3)
            {
                paso++;
                armas=0;
            }
        }

        /*
        Ubicar fragatas
        */
        if(paso==4)
        {
            while(armas < 4)
            {
                int num1 = randoNum.nextInt(10) + 1;
                int num2 = randoNum.nextInt(10) + 1;
                while(celdas[num1][num2].getChosenArea())
                {
                    num1 = randoNum.nextInt(10) + 1;
                    num2 = randoNum.nextInt(10) + 1;
                }
                if(!celdas[num1][num2].getChosenArea())
                {
                    celdas[num1][num2].setIcon(fragatas); celdas[num1][num2].setAreaSeleccionada();
                    celdas[num1][num2].setNombreDelNavio("frigates");
                    panel.updateUI();
                    armas++;
                }
            }
            if (armas > 4)
            {
                paso++;
            }
        }
    }

    /*
    Verificar los golpes del rival
    */
    public void aciertoRival(JPanel panel, Celdas[][] celdas)
    {
        Random random=new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        if(celdas[num1][num2].getChosenArea())
        {
            celdas[num1][num2].setIcon(tocar);
            panel.updateUI();
            numAciertos++;
        }
        if(!celdas[num1][num2].getChosenArea())
        {
            celdas[num1][num2].setIcon(agua);
            panel.updateUI();
        }
        if(celdas[num1][num2].getNombreDelNavio().equals("fragatas"))
        {
            celdas[num1][num2].setIcon(hundido);
            panel.updateUI();
        }
    }

    /*
    Determina si el jugador es el que gana
    */
    public boolean ganador(int aciertos)
    {
        boolean ganador=false;
        if(aciertos==20)
        {
            ganador=true;
        }
        return ganador;
    }

    /*
    Determina si el rival es el ganador
    */
    public boolean rivalGano()
    {
        boolean victoria=false;
        if(numAciertos==20)
        {
            victoria=true;
        }
        return victoria;
    }

    /*
    Ubica el portaAviones en el panel rival
    */
    private void setPortaAviones(int eleccion, int posicion, Celdas cel1, Celdas cel2, Celdas cel3, Celdas cel4)
    {
        if(eleccion==1)
        {
            if(posicion >=1 && posicion<=3)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteBajaPortaAviones.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        cel4.setIcon(portaAviones);
                    }
                }
            }
            if(posicion > 3 && posicion <=10)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-portaAviones.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        cel4.setIcon(portaAviones);
                    }
                }
            }
        }
        if(eleccion==2)
        {
            if(posicion >=8 && posicion <=10)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteIzquierdaPortaAviones.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        cel4.setIcon(portaAviones);
                    }
                }
            }
            if(posicion >= 1 && posicion <=7)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteDerechaPortaAviones.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        cel4.setIcon(portaAviones);
                    }
                }
            }
        }
    }

    /*
    Ubica los submarinos en el panel Rival
    */
    private void setSubmarinos(int opcion, int posicion, Celdas cel1, Celdas cel2, Celdas cel3)
    {
        if(opcion==1)
        {
            if(posicion >= 9 && posicion <=10)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-submarino.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(submarino);
                    }
                }
            }
            if(posicion >=1 && posicion <9)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteBajaSubmarino.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(submarino);
                    }
                }
            }
        }
        if(opcion==2)
        {
            if(posicion >= 9 && posicion <= 10)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteIzquierdaSubmarino.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(submarino);
                    }
                }
            }

            if(posicion >= 1 && posicion < 9)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteDerechaSubmarino.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        cel3.setIcon(submarino);
                    }
                }
            }
        }
    }

    /*
    Ubica los destructores en el panel rival
    */
    private void setDestructores(int opcion, int place, Celdas cel1, Celdas cel2)
    {
        if(opcion==1)
        {
            if(place==10)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-destructor.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(destructors);
                    }
                }
            }
            if(place >= 1 && place <= 9)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteBajaDestructor.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(destructors);
                    }
                }
            }
        }
        if(opcion==2)
        {
            if(place==10)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteIzquierdaDestructor.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(destructors);
                    }
                }
            }
            if(place >=1 && place <=9)
            {
                for(int i=1; i <=2; i++)
                {
                    destructors=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteDerechaDestructor.jpg")));
                    if(i==1)
                    {
                        cel1.setIcon(destructors);
                    }
                    if(i==2)
                    {
                        cel2.setIcon(destructors);
                    }
                }
            }
        }
    }
}
