package Display;

import java.awt.Graphics;
import java.awt.Rectangle;
import static java.time.Clock.system;
import java.util.Random;
import javafx.scene.Scene;
import static javafx.util.Duration.millis;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Ghost extends Player implements Runnable{
    
    private Level1 level1;
    Random r =new Random();
    private Player player;
    public int direction = 1;
    private long millis;
    
    public Ghost(int lives, int xAxis, int yAxis, String imagePath, boolean isAlive,Level1 level1,Player player) {
        super(lives, xAxis, yAxis, imagePath, isAlive);
        this.level1 = level1;
        this.player = player;
    }
   
public void drawGhost(Graphics g){
        ImageIcon img=new ImageIcon(imagePath);
        g.drawImage(img.getImage(), xAxis, yAxis, null);
        
    }
    public void kill(){
        int height;
        int width;
        
        Rectangle playerRec = new Rectangle(player.getxAxis(),player.getyAxis(),width=50,height = 50);
        Rectangle evilRect = new Rectangle(this.getxAxis()+2,this.getyAxis()+2,width=45,height=45);
        if(playerRec.contains(evilRect))
        {
                player.setHp((player.getHp())-1);
                player.setHpPath(player.getHp());
        }
}
    public void run(){
        while (true){
            try{
                Thread.sleep(r.nextInt(100));
            }catch(Exception e){
                JOptionPane.showMessageDialog( null ,"Thread interrupted");
                System.exit(1);
            } 
           int height_of_scene = 1040;
            if(getyAxis()<=50)
                direction =1;
            else if (getyAxis()>=height_of_scene-1040)
                direction=-1;
            setyAxis(getyAxis()+5*direction);
            kill();
            level1.repaint();
            
            if(getyAxis() >= height_of_scene-150){
                setyAxis(getyAxis()-950);
            }
            else if(getyAxis() <= 0)
            {
                setyAxis(getyAxis()+100);
            }
            else{
                setyAxis(getyAxis()+20);
            }
            level1.repaint();
        }
    }
}