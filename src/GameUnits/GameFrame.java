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
            g.drawImage(GameImg.gameMap,50,50, null);
    }
}
