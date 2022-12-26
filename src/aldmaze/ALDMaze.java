/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aldmaze;

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
        //String[] allpictures = {"./data/piece1.png", "./data/piece2.png", "./data/piece3.png", "./data/piece4.png", "./data/piece5.png", "./data/piece6.png", "./data/piece7.png", "./data/piece8.png", "./data/piece9.png", "./data/piece10.png"};
        
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
                for (int k = 1; k < 8; k++) {
                    filesorigin.add("./data/piece" + k +".png");
                }
                area_surrounding = vyberpole(area_surrounding, i, j, filesorigin, panel);
                filesorigin.clear();
            }
        }
    }
    
    public static String[][] vyberpole(String[][] area, int coordinationX, int coordinationY, ArrayList<String> files, JPanel panel){
        int musi[] = new int[4];
            if(coordinationY > 0){
                if (area[coordinationY-1][coordinationX].equals("./data/piece1.png") || area[coordinationY-1][coordinationX].equals("./data/piece2.png") || area[coordinationY-1][coordinationX].equals("./data/piece4.png") || area[coordinationY-1][coordinationX].equals("./data/piece6.png")) {               
                    musi[3] = 1;
                }
            }
            else{
                musi[3] = 2;
            }
            if(coordinationX > 0){
                if (area[coordinationY][coordinationX-1].equals("./data/piece1.png") || area[coordinationY][coordinationX-1].equals("./data/piece2.png") || area[coordinationY][coordinationX-1].equals("./data/piece7.png")) {
                    musi[0] = 1;
                }
            }
            else{
                musi[0] = 2;
            }
            /*if (area[coordinationY][coordinationX][i] == 2) {
                maska[i] = 0;
            }
            else{
                maska[i] = area[coordinationY][coordinationX][i];
            }
            if(area[coordinationY][coordinationX][i] == 2){
                musi[i] = 1;
            }*/
        
        if(musi[0] == 1){
            try{
                files.remove(files.indexOf("./data/piece2.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece5.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece6.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece7.png"));
            }catch(Exception e){}
        }
        else if(musi[0] == 0){
            try{
                files.remove(files.indexOf("./data/piece1.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece3.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece4.png"));
            }catch(Exception e){}
        
        }
        if(musi[3] == 1){
            try{
                files.remove(files.indexOf("./data/piece2.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece4.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece5.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece6.png"));
            }catch(Exception e){}
        }
        else if(musi[3] == 0){
            try{
                files.remove(files.indexOf("./data/piece1.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece3.png"));
            }catch(Exception e){}
            try{
                files.remove(files.indexOf("./data/piece7.png"));
            }catch(Exception e){}
        
        }
        
        int size = files.size();
        Random rand = new Random();

        
        int piece = rand.nextInt(size);
        JLabel label = new JLabel();
        //label.setIcon(new ImageIcon("C:\\Users\\tomch\\OneDrive\\Dokumenty\\NetBeansProjects\\ALDMaze\\src\\aldmaze\\piece2.png"));
        label.setIcon(new ImageIcon(files.get(piece)));
        panel.add(label);        
        Dimension sizepiece = label.getPreferredSize();
        label.setBounds(coordinationY*100, coordinationX*100, sizepiece.width, sizepiece.height);
        
        area[coordinationY][coordinationX] = files.get(piece);
        return area;
    }
    
}
