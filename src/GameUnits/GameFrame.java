package GameUnits;

import GameManager.GameWin;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public static void initFrame(JFrame jFrame){
        jFrame.setSize(600,600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public static void paintMainWin(Graphics g){
        for(int i = 0 ; i < 4 ; i++){
            g.setColor(Color.BLUE);
            g.fillRect(60*(i+3),60,60,60);
            g.setColor(Color.RED);
            g.fillRect(60*(i+3),480,60,60);
        }
        g.setColor(Color.BLACK);
        for(int i = 0 ; i <= 8 ; i++){
            g.drawLine(60+60*i,60,60+60*i,540);
            g.drawLine(60,60+60*i,540,60+60*i);
        }

    }
}
