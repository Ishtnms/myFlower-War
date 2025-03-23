package GameManager;

import GameUnits.GameFrame;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {
    static GameWin gameWin = new GameWin();
    public static  GameWin getGameWin(){
        return gameWin;
    }
    public void lunch(){
        GameFrame.initFrame(this);
        repaint();
    }
    Image offScreenImage ;
    @Override
    public void paint(Graphics g){
        offScreenImage = this.createImage(600,600);
        Graphics gImage = offScreenImage.getGraphics();
        GameFrame.paintMainWin(gImage);
        g.drawImage(offScreenImage,0,0,null);
    }
}
