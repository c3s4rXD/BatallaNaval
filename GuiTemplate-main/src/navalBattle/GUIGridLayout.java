package navalBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * carlos.drada@correounivalle.edu.co
 * cesar.hincapie@correounivalle.edu.co
 *
 */
public class GUIGridLayout extends JFrame
{
    /*
    Atributos
    */
    public static final String BEGINNING_MESSAGE="Batalla naval \n"
            +"\nPresiona Jugar para comenzar."
            +"\nTu Mision: destruir los botes de tu rival antes que el."
            +"\nPara acomodar tus botes deberas seleccionar una de las imagenes en azul y seleccionar si se ubicara horizontal o verticalmente."
            +"\nPara realizar tu ataque deberas hacer click en cualquier imagen del panel principal.\n"
            +"\nPodras organizar tus navios horizontal o verticalmente"
            +"\nAl oprimir un panel podras ver algunas imagenes , cada una con un significado distinto:"
            +"\nX roja: Mala suerte en esta ocasion, tu ataque no fue efectivo y cayó al agua."
            +"\nKBOOM: Felicidades, golpeaste un navio enemigo."
            +"\nFUEGO: Has hundido todos los navios enemigos, ganaste.";

    private Listener listener;
    private JPanel panelDePosiciones, panelPrincipal, panelEnemigo, PanelDeUsuario;
    private ImageIcon fondo, imagenesLetras, imagenesNumeros, tocadoImagen, hundido, agua ;
    private JButton BotonIniciar, BotonComoJugar, verPanelRival, desactivarPanelRival;
    private Celdas[][] panelPosicionCeldas, panelPrincipalCeldas, panelCeldasRival;
    private ControlNavalBattle controlNavalBattle;
    private ImageIcon fragatas, portaAviones, submarino, destructores;


    /**
     * Constructor de la clase GUI
     */
    public GUIGridLayout()
    {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Juego Batalla Naval");
        //this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
    Ubicar las letras en el panel para las columnas
    */
    private void setImagenesLetras(ImageIcon image, Celdas[][] celdas, JPanel panel)
    {
        for(int i=1; i <= 10; i++)
        {
            image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-letras.jpg")));
            celdas[0][i].setIcon(image);
            celdas[0][i].removeActionListener(listener);
            celdas[0][i].setBorder(null);
            panel.updateUI();
        }
    }

    /*
    Ubicar numeros en los paneles para las filas
    */
    private void setImagenesNumeros(ImageIcon image, Celdas[][] celdas, JPanel panel)
    {
        for(int i=1; i <= 10; i++)
        {
            image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-numeros.jpg")));
            celdas[i][0].setIcon(image);
            celdas[i][0].removeActionListener(listener);
            celdas[i][0].setBorder(null);
            panel.updateUI();
        }
    }

    /*
    Ubicar las celdas en los paneles
    */
    private void setCeldas(ImageIcon image, Celdas[][] celdas, JPanel panel, ActionListener theListener)
    {
        for(int i=0; i < 11; i++)
        {
            for(int index=0; index < 11; index++)
            {
                celdas[i][index]=new Celdas(i, index, false);
                celdas[i][index].setIcon(image);
                celdas[i][index].setBorder(null);
                panel.add(celdas[i][index]);
                celdas[i][index].addActionListener(theListener);
                if(celdas==panelCeldasRival)
                {
                    celdas[i][index].setVisible(false);
                }
            }
        }
    }

    /*
    Ubicar el portaaviones en los paneles
    */
    private void setPortaAviones(int theOption, int place, Celdas celda1, Celdas celda2, Celdas celda3, Celdas celda4)
    {
        if(theOption==JOptionPane.YES_OPTION)
        {
            if(place >=1 && place<=3)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteBajaPortaAviones.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        celda4.setIcon(portaAviones);
                    }
                }
            }
            if(place > 3 && place <=10)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-portaAviones.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        celda4.setIcon(portaAviones);
                    }
                }
            }
        }
        if(theOption==JOptionPane.NO_OPTION)
        {
            if(place >=8 && place <=10)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteIzquierdaPortaAviones.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        celda4.setIcon(portaAviones);
                    }
                }
            }
            if(place >= 1 && place <=7)
            {
                for(int i=1; i <=4; i++)
                {
                    portaAviones=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteDerechaPortaAviones.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(portaAviones);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(portaAviones);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(portaAviones);
                    }
                    if(i==4)
                    {
                        celda4.setIcon(portaAviones);
                    }
                }
            }
        }
    }

    /*
    Ubica los submarinos en las celdas
    */
    private void setSubmarinos(int theOption, int place, Celdas celda1, Celdas celda2, Celdas celda3)
    {
        if(theOption==JOptionPane.YES_OPTION)
        {
            if(place >= 9 && place <=10)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-submarino.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(submarino);
                    }
                }
            }
            if(place >=1 && place <9)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteBajaSubmarino.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(submarino);
                    }
                }
            }
        }
        if(theOption==JOptionPane.NO_OPTION)
        {
            if(place >= 9 && place <= 10)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteIzquierdaSubmarino.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(submarino);
                    }
                }
            }

            if(place >= 1 && place < 9)
            {
                for(int i=1; i <=3; i++)
                {
                    submarino=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteDerechaSubmarino.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(submarino);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(submarino);
                    }
                    if(i==3)
                    {
                        celda3.setIcon(submarino);
                    }
                }
            }
        }
    }

    /*
    Ubica los destructores en las celdas del panel
    */
    private void setDestructores(int theOption, int place, Celdas celda1, Celdas celda2)
    {
        if(theOption==JOptionPane.YES_OPTION)
        {
            if(place==10)
            {
                for(int i=1; i <=2; i++)
                {
                    destructores=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-destructor.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(destructores);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(destructores);
                    }
                }
            }
            if(place >= 1 && place <= 9)
            {
                for(int i=1; i <=2; i++)
                {
                    destructores=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteBajaDestructor.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(destructores);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(destructores);
                    }
                }
            }
        }
        if(theOption==JOptionPane.NO_OPTION)
        {
            if(place==10)
            {
                for(int i=1; i <=2; i++)
                {
                    destructores=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteIzquierdaDestructor.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(destructores);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(destructores);
                    }
                }
            }
            if(place >=1 && place <=9)
            {
                for(int i=1; i <=2; i++)
                {
                    destructores=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +i+"-parteDerechaDestructor.jpg")));
                    if(i==1)
                    {
                        celda1.setIcon(destructores);
                    }
                    if(i==2)
                    {
                        celda2.setIcon(destructores);
                    }
                }
            }
        }
    }


    private void initGUI()
    {
        //Set up JFrame Layout
        this.getContentPane().setLayout(new GridLayout(2,2));

        listener=new Listener();
        controlNavalBattle=new ControlNavalBattle();
        //Set JComponents
        /*
        Creacion de las celdas y las imagenes.
        */
        panelCeldasRival=new Celdas[11][11];
        panelPosicionCeldas=new Celdas[11][11];
        panelPrincipalCeldas=new Celdas[11][11];
        fondo=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo.jpg")));
        hundido=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/hundido.jpg")));
        tocadoImagen=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/tocado.jpg")));
        agua=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/agua.jpg")));
        fragatas=new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fragatas.jpg")));

        /*
        Panel de posicion
        */
        panelDePosiciones=new JPanel();
        panelDePosiciones.setPreferredSize(new Dimension(600,400));
        panelDePosiciones.setBorder(BorderFactory.createTitledBorder("Panel jugador"));
        this.add(panelDePosiciones, this.getContentPane());
        setCeldas(fondo, panelPosicionCeldas, panelDePosiciones, listener);
        setImagenesLetras(imagenesLetras, panelPosicionCeldas, panelDePosiciones);
        setImagenesNumeros(imagenesNumeros, panelPosicionCeldas, panelDePosiciones);

        /*
        Panel principal
         */
        panelPrincipal=new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(600,400));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder("Panel a atacar"));
        this.add(panelPrincipal, this.getContentPane());
        setCeldas(fondo, panelPrincipalCeldas, panelPrincipal, listener);
        setImagenesLetras(imagenesLetras, panelPrincipalCeldas, panelPrincipal);
        setImagenesNumeros(imagenesNumeros, panelPrincipalCeldas, panelPrincipal);

        /*
        Panel Rival
         */
        panelEnemigo=new JPanel();
        panelEnemigo.setPreferredSize(new Dimension(600,400));
        panelEnemigo.setBorder(BorderFactory.createTitledBorder("Panel rival"));
        this.add(panelEnemigo, this.getContentPane());
        setCeldas(fondo, panelCeldasRival, panelEnemigo, listener);
        setImagenesLetras(imagenesLetras, panelCeldasRival, panelEnemigo);
        setImagenesNumeros(imagenesNumeros, panelCeldasRival, panelEnemigo);

        /*
        Panel de botones
         */
        PanelDeUsuario=new JPanel();
        PanelDeUsuario.setPreferredSize(new Dimension(600,400));
        PanelDeUsuario.setBorder(BorderFactory.createTitledBorder("Panel de usuario"));
        this.add(PanelDeUsuario, this.getContentPane());

        /*
        Creando el boton jugar
        */
        BotonIniciar=new JButton("     Jugar    ");
        BotonIniciar.addActionListener(listener);
        PanelDeUsuario.add(BotonIniciar);

        /*
        Creando el boton para visualizar el panel rival
        */
        verPanelRival=new JButton("Ver panel rival");
        verPanelRival.addActionListener(listener);
        PanelDeUsuario.add(verPanelRival);

        /*
        Creando el boton para dejar de ver el panel rival
        */
        desactivarPanelRival=new JButton("Ocultar panel rival");
        desactivarPanelRival.addActionListener(listener);
        PanelDeUsuario.add(desactivarPanelRival);

        /*
        Creacion del boton de informacion sobre como jugar
        */
        BotonComoJugar=new JButton("Como jugar");
        BotonComoJugar.addActionListener(listener);
        PanelDeUsuario.add(BotonComoJugar);
    }


    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            GUIGridLayout miProjectGUI = new GUIGridLayout();
        });
    }

    private class Listener implements ActionListener
    {
        /*
        Atributos

        */
        private int  armamento=0, step=1, primeraVez=0, golpes=0;
        private boolean ubicacionBotes=false;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*
            Accion boton para jugar
            */
            if(e.getSource()==BotonIniciar)
            {
                ubicacionBotes=true;
                JOptionPane.showMessageDialog(null, "Ubica el porta aviones (valor celdas:4)");
                BotonIniciar.setEnabled(false);
            }

            /*
            Accion boton sobre como jugar
            */
            if(e.getSource()==BotonComoJugar)
            {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /*
            Accion boton para ver el panel del rival
            */
            if(e.getSource()==verPanelRival)
            {
                for (int i = 0; i < 11; i++)
                {
                    for (int index = 0; index < 11; index++)
                    {
                        panelCeldasRival[i][index].setVisible(true);
                    }
                }
                panelEnemigo.updateUI();
            }

            /*
            Accion para deshabilitar la opcion de ver el panel rival
            */
            if(e.getSource()==desactivarPanelRival)
            {
                for (int i = 0; i < 11; i++)
                {
                    for (int index = 0; index < 11; index++)
                    {
                        panelCeldasRival[i][index].setVisible(false);
                    }
                }
                panelEnemigo.updateUI();
            }

            /*
            El jugador inicia el juego
            */
            else if(ubicacionBotes)
            {
                /*
                Ubica los botes en una celda en especifico
                */
                for(int i=0; i < 11; i++)
                {
                    for(int j=0; j < 11; j++)
                    {
                        if (e.getSource() == panelPosicionCeldas[i][j])
                        {
                            /*
                            Ubicar el portaAviones
                            */
                            if (step == 1)
                            {
                                int option = JOptionPane.showConfirmDialog(panelDePosiciones, "¿Deseas ubicar el bote verticalmente? (Si eliges 'No' el barco se ubicara horizontalmente)",
                                        "Choice Window", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION)
                                {
                                    if (panelPosicionCeldas[i][j].getFilas() >= 1 && panelPosicionCeldas[i][j].getFilas() <= 3)
                                    {
                                        panelPosicionCeldas[i][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i + 1][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i + 2][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i + 3][j].setAreaSeleccionada();
                                        setPortaAviones(option, panelPosicionCeldas[i][j].getFilas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i + 1][j],
                                                panelPosicionCeldas[i + 2][j], panelPosicionCeldas[i + 3][j]);
                                        panelDePosiciones.updateUI();
                                        JOptionPane.showMessageDialog(null, "Ahora ubica tus 2 submarinos (celdas ocupadas:3)");
                                        step++;
                                    }
                                    if(panelPosicionCeldas[i][j].getFilas() > 3 && panelPosicionCeldas[i][j].getFilas() <= 10)
                                    {
                                        panelPosicionCeldas[i][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i - 1][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i - 2][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i - 3][j].setAreaSeleccionada();
                                        setPortaAviones(option, panelPosicionCeldas[i][j].getFilas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i - 1][j],
                                                panelPosicionCeldas[i - 2][j], panelPosicionCeldas[i - 3][j]);
                                        panelDePosiciones.updateUI();
                                        JOptionPane.showMessageDialog(null, "Ahora ubica tus 2 submarinos (celdas ocupadas:3)");
                                        step++;
                                    }
                                }

                                if (option == JOptionPane.NO_OPTION)
                                {
                                    if (panelPosicionCeldas[i][j].getColumnas() >=8 && panelPosicionCeldas[i][j].getColumnas() <= 10)
                                    {
                                        panelPosicionCeldas[i][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i][j - 1].setAreaSeleccionada();
                                        panelPosicionCeldas[i][j - 2].setAreaSeleccionada();
                                        panelPosicionCeldas[i][j - 3].setAreaSeleccionada();
                                        setPortaAviones(option, panelPosicionCeldas[i][j].getColumnas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i][j - 1],
                                                panelPosicionCeldas[i][j - 2], panelPosicionCeldas[i][j - 3]);
                                        panelDePosiciones.updateUI();
                                        JOptionPane.showMessageDialog(null, "Ahora ubica tus 2 submarinos (celdas ocupadas:3)");
                                        step++;
                                    }
                                    if(panelPosicionCeldas[i][j].getColumnas() >= 1 && panelPosicionCeldas[i][j].getColumnas() < 8)
                                    {
                                        panelPosicionCeldas[i][j].setAreaSeleccionada();
                                        panelPosicionCeldas[i][j + 1].setAreaSeleccionada();
                                        panelPosicionCeldas[i][j + 2].setAreaSeleccionada();
                                        panelPosicionCeldas[i][j + 3].setAreaSeleccionada();
                                        setPortaAviones(option, panelPosicionCeldas[i][j].getColumnas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i][j + 1],
                                                panelPosicionCeldas[i][j + 2], panelPosicionCeldas[i][j + 3]);
                                        panelDePosiciones.updateUI();
                                        JOptionPane.showMessageDialog(null, "Ahora ubica tus 2 submarinos (celdas ocupadas:3)");
                                        step++;
                                    }
                                }
                            }

                            /*
                            Ubica los submarinos
                            */
                            if (step == 2)
                            {
                                if (primeraVez >= 1)
                                {
                                    int option = JOptionPane.showConfirmDialog(panelDePosiciones, "¿Deseas ubicar el bote verticalmente? (Si eliges 'No' el barco se ubicara horizontalmente)",
                                            "Choice Window", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION)
                                    {
                                        if (panelPosicionCeldas[i][j].getFilas() >= 9 && panelPosicionCeldas[i][j].getFilas() <= 10)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i - 1][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i - 2][j].setAreaSeleccionada();
                                            setSubmarinos(option, panelPosicionCeldas[i][j].getFilas(), panelPosicionCeldas[i][j],
                                                    panelPosicionCeldas[i - 1][j], panelPosicionCeldas[i - 2][j]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }

                                        if(panelPosicionCeldas[i][j].getFilas() >= 1 && panelPosicionCeldas[i][j].getFilas() < 9)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i + 1][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i + 2][j].setAreaSeleccionada();
                                            setSubmarinos(option, panelPosicionCeldas[i][j].getFilas(), panelPosicionCeldas[i][j],
                                                    panelPosicionCeldas[i + 1][j], panelPosicionCeldas[i + 2][j]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }
                                    }

                                    if (option == JOptionPane.NO_OPTION)
                                    {
                                        if (panelPosicionCeldas[i][j].getColumnas() >= 9 && panelPosicionCeldas[i][j].getColumnas() <= 10)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i][j - 1].setAreaSeleccionada();
                                            panelPosicionCeldas[i][j - 2].setAreaSeleccionada();
                                            setSubmarinos(option, panelPosicionCeldas[i][j].getColumnas(), panelPosicionCeldas[i][j],
                                                    panelPosicionCeldas[i][j - 1], panelPosicionCeldas[i][j - 2]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }
                                        if(panelPosicionCeldas[i][j].getColumnas() >= 1 && panelPosicionCeldas[i][j].getColumnas() < 9)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i][j + 1].setAreaSeleccionada();
                                            panelPosicionCeldas[i][j + 2].setAreaSeleccionada();
                                            setSubmarinos(option, panelPosicionCeldas[i][j].getColumnas(), panelPosicionCeldas[i][j],
                                                    panelPosicionCeldas[i][j + 1], panelPosicionCeldas[i][j + 2]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }
                                    }
                                }
                                primeraVez++;
                                if (armamento == 2)
                                {
                                    JOptionPane.showMessageDialog(null, "Ahora ubica los destructores (Valor de celdas:2)");
                                    armamento = 0;
                                    primeraVez=0;
                                    step++;
                                }
                            }

                            /*
                            Ubica los destructores
                            */
                            if (step == 3)
                            {
                                if (primeraVez >= 1)
                                {
                                    int option = JOptionPane.showConfirmDialog(panelDePosiciones, "¿Deseas ubicar el bote verticalmente? (Si eliges 'No' el barco se ubicara horizontalmente)",
                                            "Choice Window", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION)
                                    {
                                        if (panelPosicionCeldas[i][j].getFilas() == 10)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i - 1][j].setAreaSeleccionada();
                                            setDestructores(option, panelPosicionCeldas[i][j].getFilas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i - 1][j]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }

                                        if (panelPosicionCeldas[i][j].getFilas() >= 1 && panelPosicionCeldas[i][j].getFilas() <= 9)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i + 1][j].setAreaSeleccionada();
                                            setDestructores(option, panelPosicionCeldas[i][j].getFilas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i + 1][j]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }
                                    }

                                    if (option == JOptionPane.NO_OPTION)
                                    {
                                        if (panelPosicionCeldas[i][j].getColumnas() == 10)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i][j - 1].setAreaSeleccionada();
                                            setDestructores(option, panelPosicionCeldas[i][j].getColumnas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i][j - 1]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }

                                        if (panelPosicionCeldas[i][j].getColumnas() >= 1 && panelPosicionCeldas[i][j].getColumnas() <= 9)
                                        {
                                            panelPosicionCeldas[i][j].setAreaSeleccionada();
                                            panelPosicionCeldas[i][j + 1].setAreaSeleccionada();
                                            setDestructores(option, panelPosicionCeldas[i][j].getColumnas(), panelPosicionCeldas[i][j], panelPosicionCeldas[i][j + 1]);
                                            panelDePosiciones.updateUI();
                                            armamento++;
                                        }
                                    }
                                }
                                primeraVez++;
                                if (armamento == 3)
                                {
                                    JOptionPane.showMessageDialog(null, "Ahora ubica las 4(cuatro) fragatas disponibles (Valor de celda : 1)");
                                    armamento = 0;
                                    primeraVez=0;
                                    step++;
                                }
                            }

                            /*
                            Ubica las fragatas
                            */
                            if (step == 4)
                            {
                                if (primeraVez >= 1)
                                {
                                    panelPosicionCeldas[i][j].setIcon(fragatas); panelPosicionCeldas[i][j].setAreaSeleccionada();
                                    panelPosicionCeldas[i][j].setNombreDelNavio("fragatas");
                                    panelDePosiciones.updateUI();
                                    armamento++;
                                }
                                if (armamento == 4)
                                {
                                    JOptionPane.showMessageDialog(null, "Es hora de atacar");
                                    step++;
                                }
                                primeraVez++;
                            }
                        }
                    }
                }

                /*
                El enemigo empieza primero
                */
                if (step == 5)
                {
                    /*
                    Determina si el jugador gana o pierde
                    */
                    controlNavalBattle.setPanelRival(panelEnemigo, panelCeldasRival);
                    verPanelRival.updateUI();
                    boolean win=controlNavalBattle.ganador(golpes);
                    boolean enemyWin=controlNavalBattle.rivalGano();
                    /*
                    Mientras el jugardor no gane seguira atacando al jugador
                    */
                    if (!win)
                    {
                        for (int i = 0; i < 11; i++)
                        {
                            for (int j = 0; j < 11; j++)
                            {
                                if (e.getSource() == panelPrincipalCeldas[i][j])
                                {
                                    if(panelCeldasRival[i][j].getChosenArea())
                                    {
                                        panelPrincipalCeldas[i][j].setIcon(tocadoImagen);
                                        panelPrincipal.updateUI();
                                        golpes++;
                                    }
                                    if(!panelCeldasRival[i][j].getChosenArea())
                                    {
                                        panelPrincipalCeldas[i][j].setIcon(agua);
                                        panelPrincipal.updateUI();
                                    }
                                    if(panelCeldasRival[i][j].getNombreDelNavio().equals("fragatas"))
                                    {
                                        panelPrincipalCeldas[i][j].setIcon(hundido);
                                        panelPrincipal.updateUI();
                                    }
                                }
                            }
                        }
                        if(primeraVez >= 1)
                        {
                            controlNavalBattle.aciertoRival(panelDePosiciones, panelPosicionCeldas);
                        }
                        primeraVez++;
                    }

                    /*
                    Cuando gane el rival :
                    */
                    if(enemyWin)
                    {
                        for(int i=1; i < 11; i++)
                        {
                            for(int j=1; j < 11; j++)
                            {
                                if(panelPosicionCeldas[i][j].getChosenArea())
                                {
                                    panelPosicionCeldas[i][j].setIcon(hundido);
                                    panelDePosiciones.updateUI();
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Has perdido, gracias por jugar");
                        System.exit(0);
                    }

                    /*
                    Cuando gane el jugador:
                    */
                    if(win)
                    {
                        for(int i=1; i < 11; i++)
                        {
                            for(int j=1; j < 11; j++)
                            {
                                if(panelCeldasRival[i][j].getChosenArea())
                                {
                                    panelPrincipalCeldas[i][j].setIcon(hundido);
                                    panelPrincipal.updateUI();
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Ganaste, felicidades , vuelve a jugar cuando gustes");
                        System.exit(0);
                    }
                }
            }
        }
    }
}

