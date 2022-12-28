/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aldmaze;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tomch
 */
public class Methods {
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
        
        filter(musi, files);
        
        int size = files.size();
        Random rand = new Random();

        
        int piece = rand.nextInt(size);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(files.get(piece)));
        panel.add(label);        
        Dimension sizepiece = label.getPreferredSize();
        label.setBounds(coordinationY*100, coordinationX*100, sizepiece.width, sizepiece.height);
        
        area[coordinationY][coordinationX] = files.get(piece);
        return area;
    }
    
    public static void filter(int[] musi, ArrayList<String> files){
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
    
    }
    
    static void fill(ArrayList<String> filesorigin){
        for (int k = 1; k < 8; k++) {
                    filesorigin.add("./data/piece" + k +".png");
                }
    }
}
