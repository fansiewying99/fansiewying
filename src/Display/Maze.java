/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Maze extends JPanel{
    public Maze(){}
    private int xAxis;
    private int yAxis;
    private String imagePath;
    protected boolean isBlocked;
    protected boolean showItem;
    protected boolean isExit;
    protected boolean canExit;
    protected boolean win;
    int ruby;
    //0=path, 1=block, 2=item, 3=locked exit, 4=opened exit
    int[][]mazeL1={ {1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1},
                    {1,0,1,0,1, 0,1,0,0,0, 0,2,1,1,1, 1,1,1,1,1},
                    {1,0,1,0,0, 0,1,0,1,1, 1,0,1,0,0, 0,1,1,1,1},
                    {1,0,0,0,1, 1,1,0,0,0, 0,0,0,0,1, 0,0,0,1,1},
                    {1,0,1,0,0, 0,0,0,1,1, 1,0,1,1,1, 0,0,0,0,1},
                    {1,0,1,0,1, 1,1,0,1,0, 0,0,1,1,1, 0,0,0,0,1},
                    {1,0,1,0,1, 0,0,0,1,1, 1,0,1,1,1, 0,0,0,1,1},
                    {1,0,1,0,1, 1,1,0,1,1, 1,0,1,1,1, 1,1,1,1,1},
                    {1,0,0,0,0, 0,0,0,0,1, 1,0,1,1,1, 1,1,1,1,1},
                    {1,0,0,0,1, 0,0,0,1,1, 1,0,0,0,0, 0,0,0,0,3},
                    {1,0,0,0,0, 0,0,0,0,1, 1,0,1,1,1, 1,1,1,1,1},
                    {1,0,0,0,0, 0,0,0,0,1, 1,0,1,1,1, 1,1,1,1,1},
                    {1,0,1,0,1, 0,1,0,0,0, 0,0,0,0,0, 1,1,1,1,1},
                    {1,0,1,0,0, 0,1,0,1,1, 1,0,1,1,0, 0,0,1,1,1},
                    {1,0,0,0,1, 1,1,0,0,0, 0,0,1,1,1, 0,0,0,2,1},
                    {1,0,1,0,0, 0,0,0,1,1, 1,0,1,1,1, 0,1,1,1,1},
                    {1,0,1,0,1, 1,1,0,1,0, 0,0,0,0,1, 0,1,1,1,1},
                    {1,0,1,5,1, 0,0,0,1,0, 1,0,1,2,1, 0,1,1,1,1},
                    {1,0,1,0,1, 1,1,0,1,0, 1,0,1,1,1, 1,1,1,1,1},
                    {1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1}
                };
    public int[][]getmaze(){
        return mazeL1;
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
    public boolean getBlock(){
        return isBlocked;
    }
    
    public void isBlocked(int x, int y){
        if(mazeL1[y][x]==1){
            isBlocked=true;
        }
        else if(mazeL1[y][x]==0){
            isBlocked=false;
        }
    }
    public void showItem(int x,int y){
        if(mazeL1[y][x]==2){
            showItem=true;
        }
        else 
            showItem=false;
    }
    public boolean getShowItem(){
        return showItem;
    }
    public void isExit(int x, int y){
        if(mazeL1[y][x]==3){
            isExit=true;
        }
        else if(mazeL1[y][x]==4){
            isExit=true;
        }
        else
            isExit=false;
    }
    public boolean getIsExit(){
        return isExit;
    }
}