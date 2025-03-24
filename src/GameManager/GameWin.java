package GameManager;

import GameUnits.GameBoard;
import GameUnits.GameFrame;
import GameUnits.GamePosition;
import GameUnits.PiecesPlayWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWin extends JFrame implements MouseListener {

    static GameWin gameWin = new GameWin();
    public static  GameWin getGameWin(){

        return gameWin;
    }
    public void lunch(){
        addMouseListener(this);
        GameFrame.initFrame(this);
        repaint();
    }
    Image offScreenImage ;
    @Override
    public void paint(Graphics g){
        offScreenImage = this.createImage(600,600);
        Graphics gImage = offScreenImage.getGraphics();
        GameFrame.paintMainWin(gImage);
        for(int r = 0 ; r < 8 ; r++){
            for(int c = 0 ; c < 8 ; c++){
                if(GameBoard.getGameBoard().board[r][c] != null){
                GameBoard.getGameBoard().board[r][c].paintSelf(gImage);}
            }
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
   //GameBoard.getGameBoard().play(GamePosition.getP(e.getY()),GamePosition.getP(e.getX()));
        new PiecesPlayWin(GamePosition.getP(e.getY()),GamePosition.getP(e.getX()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
