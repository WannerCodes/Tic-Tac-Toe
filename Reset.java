import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reset extends JButton{
    public Reset(Rute[][] array, JLabel info){
        Reseter reseter = new Reseter(array, info, this);
    }

    class Reseter implements ActionListener{
        Rute[][] array;
        JLabel info;
        public Reseter(Rute[][] array, JLabel info, Reset button){
            this.array = array;
            this.info = info;
            button.setText("Reset");
            button.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            info.setText("Spiller 1 velger rute");
            for(Rute[] y : array){
                for(Rute rute: y){
                    rute.initGUI();
                    rute.brukt = false;
                    rute.setEnabled(true);
                }
            }
            array[0][0].player1Postitions = new ArrayList<Integer>();
            array[0][0].player2Postitions = new ArrayList<Integer>();
            array[0][0].move = 0;
        }
    }
}
