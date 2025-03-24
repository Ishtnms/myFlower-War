package GameUnits;

import GameManager.GameManagers;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.net.http.WebSocket;

public class PiecesPlayWin extends JFrame{
    int r = 0 ;
    int c = 0 ;

    JButton jButtonRoot = new JButton("Root");
    JButton jButtonStem = new JButton("Stem");
    JButton jButtonLeaf = new JButton("Leaf");
    public PiecesPlayWin(int r , int c ){
        this.r = r ;
        this.c = c ;
        setLayout(new FlowLayout());
        addButton();
        setBounds(500,500,70 ,135 );
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void addButton(){
        jButtonLeaf.addActionListener((e) -> {GameBoard.getGameBoard().play(r,c, GameManagers.PiecesType.Leaf);
            dispose();});
        jButtonStem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameBoard.getGameBoard().play(r,c, GameManagers.PiecesType.Stem);
                dispose();
            }
        });
        jButtonRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameBoard.getGameBoard().play(r,c, GameManagers.PiecesType.Root);
                dispose();
            }
        });
        add(jButtonLeaf);
        add(jButtonRoot);
        add(jButtonStem);
    }

}
