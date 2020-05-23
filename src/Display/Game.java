/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author User
 */
public class Game {
   // public Game(){
    public static void main(String[]args){ 
        
        DisplayImage ex=new DisplayImage();
        EventQueue.invokeLater(()->{
            ex.validate();
            ex.setVisible(true);
        });
        KeyAdapter listener = new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    ex.dispose();
                    Level1 l1=new Level1();  
                    Sound s=new Sound();
                    s.play();
                    s.stop();
                }
                
            }
        };

        ex.addKeyListener(listener);
    }
}
