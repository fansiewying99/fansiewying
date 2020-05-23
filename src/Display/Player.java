/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import static java.awt.Color.white;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Player{
    public void Player(){}
    private int hp;
    protected int xAxis;
    protected int yAxis;
    protected String imagePath;
    private String hpPath;
    private boolean isAlive;
    private int xPosition;
    private int yPosition;
    
    public void setHp(int hp){
        this.hp=hp;
    }
    public int getHp(){
        return hp;
    }
    public void setxAxis(int xAxis){
        this.xAxis=xAxis;
    }
    public int getxAxis(){
        return xAxis;
    }
    public void setyAxis(int yAxis){
        this.yAxis=yAxis;
    }
    public int getyAxis(){
        return yAxis;
    }
    public void setxPosition(int xPosition){
        this.xPosition=xPosition;
    }
    public int getxPosition(){
        return xPosition;
    }
    public void setyPosition(int yPosition){
        this.yPosition=yPosition;
    }
    public int getyPosition(){
        return yPosition;
    }
    public void setImagePath(String imagePath){
        if(imagePath==null){
            JOptionPane.showMessageDialog(null, "Invalid string!");
        }
        else if(imagePath.length()==0){
            JOptionPane.showMessageDialog(null, "String empty!");
        }
        else
            this.imagePath=imagePath;
    }
    public String getImagePath(){
        return imagePath;
    }
    public void setAlive(boolean isAlive){
        this.isAlive=isAlive;
    }
    public boolean getAlive(){
        return isAlive;
    }
    
    public Player(int hp, int xAxis, int yAxis, String imagePath, boolean isAlive){
        super();
        this.setHp(hp);
        this.setAlive(isAlive);
        this.setImagePath(imagePath);
        this.setxAxis(xAxis);
        this.setyAxis(yAxis);
        this.setxPosition(xAxis/40);
        this.setyPosition(yAxis/40);
    }
    public void drawPlayer(Graphics g){
        ImageIcon img=new ImageIcon(imagePath);
        g.drawImage(img.getImage(), xAxis, yAxis, null);
    }
    
    public void setHpPath(int hp){
        if(hp==5)
            this.hpPath="images//fullHP.png";
        else if(hp==4)
            this.hpPath="images//HP-1.png";
        else if(hp==3)
            this.hpPath="images//HP-2.png";
        else if(hp==2)
            this.hpPath="images//HP-3.png";
        else if(hp==1)
            this.hpPath="images//HP-4.png";
        else
            this.hpPath="images//HP0.png";
        
    }
    public String getHpPath(){
        return hpPath;
    }
 
}
