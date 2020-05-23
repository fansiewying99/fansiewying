/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Level1 extends JPanel implements KeyListener{
    private JFrame window=new JFrame("Maze Runner");
    private ImageIcon background=new ImageIcon("images//background.png");
    private int speed=50;
    int getSpeed(){
        return speed;
    }
    private Player player=new Player(5, speed, speed, "images//front.png", true);
    private ImageIcon door=new ImageIcon("images//door.png");
    private ImageIcon maze=new ImageIcon("images//tile1.png");
    private ImageIcon item=new ImageIcon("images//item.png");
    private ImageIcon cover=new ImageIcon("images//dark.png");
    private ImageIcon goal=new ImageIcon("images//goal.png");
    private final Ghost ghost1 = new Ghost(3,350,500,"images//ghost.png", true,this,player);
    private final Ghost ghost2 = new Ghost(3,550,600,"images//ghost.png", true,this,player);
    public int width_of_scene = 1010;
    public int height_of_scene = 1040;
    private int XAXIS_OF_GHOST = 50;
    private int YAXIS_OF_GHOST = 50;
    public boolean result;
    public void setResult(boolean win){
        result=win;
    }
    public boolean result(){
        return result;
    }
    
    private Maze m=new Maze();
    protected Cover C=new Cover();
    private int[][]mazeCover=C.getMazeCover();
    private int[][]mazeL1=m.getmaze();
    private int ruby=3;
    private int light=0;
    
    public Level1(){
        this.setFocusable(true);
        this.addKeyListener(this);
        window.add(this);
        window.setSize(1010,1040);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        Thread thread = new Thread(ghost1);
        thread.start();
        Thread thread2 = new Thread(ghost2);
        thread2.start();
        
        
    }
    public void paint(Graphics g){
        g.translate(0,1);
       g.drawImage(background.getImage(), 0, 0, null);
       player.drawPlayer(g);
       int x=0, y=0;
       for(int row=0; row<mazeL1.length; row++){
            for(int c=0; c<mazeL1.length; c++){
               if(mazeL1[row][c]==1){
                   g.drawImage(maze.getImage(), x, y, null);
                   x=x+speed;
               }
               else if(mazeL1[row][c]==0){
                   x=x+speed;
               }
               else if(mazeL1[row][c]==4){
                   g.drawImage(goal.getImage(), x, y, null);
                   x=x+speed;
               }
               else if(mazeL1[row][c]==2){
                   g.drawImage(item.getImage(), x, y, null);
                   x=x+speed;
               }
               else if(mazeL1[row][c]==3){
                   g.drawImage(door.getImage(), x, y, null);
                   x=x+speed;
               }
               else if(mazeL1[row][c]==5){
                    g.drawImage(new ImageIcon("images//light.png").getImage(), x, y, null);
                    x=x+speed;}
            }
       ghost1.drawGhost (g);  
       
       ghost2.drawGhost(g);
            x=0;
            y=y+speed;
        }
                C.isDark(player.getxPosition(), player.getyPosition());
                C.getMazeCover();
       x=0; y=0;
       for(int row=0; row<mazeCover.length; row++){
            for(int c=0; c<mazeCover.length; c++){
               if(mazeCover[row][c]==5){
                   g.drawImage(cover.getImage(), x, y, null);
                   x=x+speed;
               }
               else if(mazeCover[row][c]==0){
                   x=x+speed;
               }
           }
            x=0;
            y=y+speed;
        }
       
       player.getHpPath();
       if(player.getHp()==5){
           
           g.drawImage(new ImageIcon("images//fullHP.png").getImage(), 700, 5, null);
           
       }
       else if(player.getHp()==4){
           g.drawImage(new ImageIcon("images//HP-1.png").getImage(), 700, 5, null);
       }
       else if(player.getHp()==3){
           g.drawImage(new ImageIcon("images//HP-2.png").getImage(), 700, 5, null);
       }
       else if(player.getHp()==2){
           g.drawImage(new ImageIcon("images//HP-3.png").getImage(), 700, 5, null);
       }
       else if(player.getHp()==1){
           g.drawImage(new ImageIcon("images//HP-4.png").getImage(), 700, 5, null);
       }
       else if(player.getHp()==0){
           
           g.drawImage(new ImageIcon("images//HP0.png").getImage(), 700, 5, null);
            this.repaint();
                window.dispose();
                Loser L=new Loser();
                
                EventQueue.invokeLater(() -> {
                    L.setVisible(true);
                });
                
       }
       
       
       

    }

    
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    }

    @Override
    public void keyPressed (KeyEvent ke){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if (ke.getKeyCode()==KeyEvent.VK_RIGHT){
            m.isBlocked(player.getxPosition()+1, player.getyPosition());
            if(m.getBlock()==true){
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                    player.setImagePath("images//right.png"); 
                    this.repaint();
            }
            else
            {   
                player.setImagePath("images//right.png"); 
                player.setxAxis(player.getxAxis()+speed);
                player.setxPosition(player.getxPosition()+1);
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                this.repaint();
            }   
            if(ruby==0){
                mazeL1[player.getyPosition()][player.getxPosition()]=4;
                player.setxAxis(player.getxAxis()-speed);
                player.setxPosition(player.getxPosition()-1);
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                repaint();
            }
        }
        else if(ke.getKeyCode()==KeyEvent.VK_LEFT){
            m.isBlocked(player.getxPosition()-1, player.getyPosition());
            if(m.getBlock()==true){
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                    player.setImagePath("images//left.png"); 
                    this.repaint();
            }
            else
            {   
                player.setImagePath("images//left.png"); 
                player.setxAxis(player.getxAxis()-speed);
                player.setxPosition(player.getxPosition()-1);
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                this.repaint();
            }
            if(ruby==0){
                mazeL1[player.getyPosition()][player.getxPosition()]=4;
                player.setxAxis(player.getxAxis()+speed);
                player.setxPosition(player.getxPosition()+1);
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                repaint();
            }
            
        }
        else if(ke.getKeyCode()==KeyEvent.VK_UP){
            m.isBlocked(player.getxPosition(), player.getyPosition()-1);
            if(m.getBlock()==true){
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                player.setImagePath("images//back.png"); 
                this.repaint();
            }
            else
            {   
                player.setImagePath("images//back.png"); 
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis()-speed);
                player.setyPosition(player.getyPosition()-1);
                this.repaint();
            }
            if(ruby==0){
                mazeL1[player.getyPosition()][player.getxPosition()]=4;
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis()+speed);
                player.setyPosition(player.getyPosition()+1);
                repaint();
            }     
        }
        else if(ke.getKeyCode()==KeyEvent.VK_DOWN){
            m.isBlocked(player.getxPosition(), player.getyPosition()+1);
            if(m.getBlock()==true){
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis());
                player.setyPosition(player.getyPosition());
                player.setImagePath("images//front.png"); 
                this.repaint();
            }
            else
            {   
                player.setImagePath("images//front.png"); 
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis()+speed);
                player.setyPosition(player.getyPosition()+1);
                this.repaint();
            }
            if(ruby==0){
                mazeL1[player.getyPosition()][player.getxPosition()]=4;
                player.setxAxis(player.getxAxis());
                player.setxPosition(player.getxPosition());
                player.setyAxis(player.getyAxis()-speed);
                player.setyPosition(player.getyPosition()-1);
                repaint();
            }
            
        }
        C.setLight(light);
        C.getLight();
        if(mazeL1[player.getyPosition()][player.getxPosition()]==5){
                mazeL1[player.getyPosition()][player.getxPosition()]=0;
                light+=1;
                C.setLight(light);
                C.getLight();
                this.repaint();
                JOptionPane.showMessageDialog(null, "You found a flash light.");
            } 
        m.showItem(player.getxPosition(),player.getyPosition());
            if(m.getShowItem()==true){
                mazeL1[player.getyPosition()][player.getxPosition()]=0;         
                ruby-=1;
                this.repaint();
                JOptionPane.showMessageDialog(null, "You found an item.");
                System.out.println(ruby);
            }
        m.isExit(player.getxPosition(), player.getyPosition());
        if(m.getIsExit()){
            if(mazeL1[player.getyPosition()][player.getxPosition()]==4)
            {
                this.repaint();
                window.dispose();
                Winner w=new Winner();
                EventQueue.invokeLater(() -> {
                    w.setVisible(true);
                });
            }
            else
            {
                this.repaint();
                JOptionPane.showMessageDialog(null,"The door can't be opened.");
            }
            
        }
        if(ruby==0){
                mazeL1[9][19]=4;
                ruby-=1;
                JOptionPane.showMessageDialog(null,"You have collected all items.");
                this.repaint();
            }
}

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
