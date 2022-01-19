import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main{
    private static Rute[][] ruteArray;
    static Main prog;

    public static void main(String[] args){
        ruteArray = new Rute[3][3];

        JFrame vindu = new JFrame("Tic-Tac-Toe");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //inneholder spillet, med evt. knapper under
        JPanel oppsett = new JPanel();
        oppsett.setLayout(new BoxLayout(oppsett, BoxLayout.Y_AXIS));

        //selve 3x3 rutene med spillet
        JPanel spill = new JPanel();
        spill.setLayout(new GridLayout(3, 3));

        //reset knapp osv
        JPanel knapper = new JPanel();

        //tekstlig beskrivelse av neste steg, evt vinner
        JPanel infoPanel = new JPanel();
        JLabel info = new JLabel("Spiller 1 velger rute");
        info.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));

        for(int i = 0; i < 3; i++){
            for(int e = 0; e < 3; e++){
                Rute rute = new Rute(info, ruteArray);
                ruteArray[i][e] = rute;
                spill.add(rute);
            }
        }

        Reset reset = new Reset(ruteArray, info);
        knapper.add(reset);

        infoPanel.add(info);

        oppsett.add(spill);
        oppsett.add(knapper);
        oppsett.add(infoPanel);
        vindu.add(oppsett);

        vindu.pack();
        vindu.setVisible(true);
    }
}
