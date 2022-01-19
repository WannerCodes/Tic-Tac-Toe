import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rute extends JButton{
    static int move = 0;
    static int ant = 1;
    static boolean vunnet = false;
    static ArrayList<Integer> player1Postitions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Postitions = new ArrayList<Integer>();
    JLabel info;
    Rute[][] ruteArray;
    boolean brukt = false;

    Rute(JLabel info, Rute[][] ruteArray){
        int ruteNr = ant;
        ant++;
        this.info = info;
        this.ruteArray = ruteArray;
        initGUI();

        class Trykk implements ActionListener{
            JLabel info;
            Rute rute;
            Rute[][] ruteArray;

            Trykk(JLabel info, Rute rute, Rute[][] ruteArray){
                this.info = info;
                this.rute = rute;
                this.ruteArray = ruteArray;
            }

            @Override
            public void actionPerformed(ActionEvent e){
                if(brukt == false){
                    if(move % 2 == 0){
                        brukt = true;
                        initGUI();
                        setText("X");
                        move++;
                        player1Postitions.add(ruteNr);
                        if(sjekkVinner(player1Postitions)){
                            info.setText("Spiller 1 har vunnet!");
                            for (Rute[] a : ruteArray){
                                for(Rute rute : a){
                                    rute.setEnabled(false);
                                }
                            }
                        }
                        else{
                            info.setText("Spiller 2 velger rute");
                        }
                    }
                    else{
                        brukt = true;
                        initGUI();
                        setText("O");
                        move++;
                        player2Postitions.add(ruteNr);
                        if(sjekkVinner(player2Postitions)){
                            info.setText("Spiller 2 har vunnet");
                            for (Rute[] a : ruteArray){
                                for(Rute rute : a){
                                    rute.setEnabled(false);
                                }
                            }
                        }
                        else info.setText("Spiller 1 velger rute");
                    }
                    if(move == 9) info.setText("Spillet er over");
                }
                else info.setText("Ugyldig trekk");
            }
        }
        this.addActionListener(new Trykk(info, this, ruteArray));
    }

    public void initGUI(){
        setPreferredSize(new Dimension(30,30));
        setOpaque(true);
        setText("");
    }

    private boolean sjekkVinner(ArrayList<Integer> posisjoner){
        if(posisjoner.contains(1) && posisjoner.contains(2) && posisjoner.contains(3)) return true;
        if(posisjoner.contains(4) && posisjoner.contains(5) && posisjoner.contains(6)) return true;
        if(posisjoner.contains(7) && posisjoner.contains(8) && posisjoner.contains(9)) return true;
        if(posisjoner.contains(1) && posisjoner.contains(4) && posisjoner.contains(7)) return true;
        if(posisjoner.contains(2) && posisjoner.contains(5) && posisjoner.contains(8)) return true;
        if(posisjoner.contains(3) && posisjoner.contains(6) && posisjoner.contains(9)) return true;
        if(posisjoner.contains(1) && posisjoner.contains(5) && posisjoner.contains(9)) return true;
        if(posisjoner.contains(3) && posisjoner.contains(5) && posisjoner.contains(7)) return true;
        return false;
    }
}
