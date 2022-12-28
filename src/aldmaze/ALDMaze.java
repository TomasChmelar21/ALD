/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aldmaze;

import static aldmaze.Methods.fill;
import static aldmaze.Methods.vyberpole;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author tomch
 */
public class ALDMaze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] area_surrounding = new String[10][10];
        ArrayList<String> filesorigin = new ArrayList<String>();
        
        JFrame frame = new JFrame();
        frame.setSize(1050,1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Maze");
        frame.setVisible(true);
        
        JPanel panel = (JPanel)frame.getContentPane();  
        panel.setLayout(null);
        for (int i = 0; i < area_surrounding.length; i++) {
            for (int j = 0; j < area_surrounding[1].length; j++) {
                fill(filesorigin);
                area_surrounding = vyberpole(area_surrounding, i, j, filesorigin, panel);
                filesorigin.clear();
            }
        }
    }
    
    
    
}
