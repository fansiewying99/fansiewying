/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Cover {
    public Cover(){}
    public boolean isDark;
    public ImageIcon coverPath=new ImageIcon("images//dark.png");
    protected Maze m=new Maze();
    int[][]maze=m.getmaze();
    public boolean getLight;
    int light;
    
    //5=dark, 0=bright
    int[][]mazeCover={  {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5},
                        {5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5}};
    public int[][]getMazeCover(){
        return mazeCover;
    }
    public void setLight(int light){
        this.light=light;
        if(light==0)
            getLight= false;
        else if(light==1)
            getLight=true;
    }
    public boolean getLight(){
        return getLight;
    }
    public void isDark(int x, int y){
        for (int i=0; i<mazeCover.length; i++) {
            for (int j = 0; j<mazeCover.length; j++) {
                mazeCover[i][j] = 5;
            }
        }
        
        this.mazeCover[y][x]=0;
        this.mazeCover[y+1][x]=0;
        this.mazeCover[y][x+1]=0;
        this.mazeCover[y-1][x]=0;
        this.mazeCover[y][x-1]=0;
        this.mazeCover[y+1][x+1]=0;
        this.mazeCover[y-1][x-1]=0;
        this.mazeCover[y+1][x-1]=0;
        this.mazeCover[y-1][x+1]=0;
 
        if(y-2>=0){
            if(maze[y-1][x]==1){
                this.mazeCover[y-2][x]=5;
            }
            else
                this.mazeCover[y-2][x]=0;
            if(maze[y-1][x-1]==1){
                this.mazeCover[y-2][x-1]=5;
            }
            else
                this.mazeCover[y-2][x-1]=0;
            if(maze[y-1][x+1]==1){
                this.mazeCover[y-2][x+1]=5;
            }
            else
                this.mazeCover[y-2][x+1]=0;
        }
        if(x-2>=0&&y+2<mazeCover.length){
            if(maze[y+1][x-1]==1){
                this.mazeCover[y+2][x-2]=5;
            }
            else
                this.mazeCover[y+2][x-2]=0;
        }
        if(x+2<mazeCover.length&&y-2>=0){
            if(maze[y-1][x+1]==1){
                this.mazeCover[y-2][x+2]=5;
            }
            else
                this.mazeCover[y-2][x+2]=0;
        }
        if(x-2>=0&&y-2>=0){
            if(maze[y-1][x-1]==1){
                this.mazeCover[y-2][x-2]=5;
            }
            else
                this.mazeCover[y-2][x-2]=0;
        }
        if(x-2>=0){
            if(maze[y][x-1]==1){
                this.mazeCover[y][x-2]=5;
            }
            else
                this.mazeCover[y][x-2]=0;
            if(maze[y-1][x-1]==1){
                this.mazeCover[y-1][x-2]=5;
            }
            else
                this.mazeCover[y-1][x-2]=0;
            if(maze[y+1][x-1]==1){
                this.mazeCover[y+1][x-2]=5;
            }
            else
                this.mazeCover[y+1][x-2]=0;
        }
        if(y+2<mazeCover.length&&x+2<mazeCover.length){
            if(maze[y+1][x+1]==1){
                this.mazeCover[y+2][x+2]=5;
            }
            else
                this.mazeCover[y+2][x+2]=0;         
        }
        if(y+2<mazeCover.length){
            if(maze[y+1][x]==1){
                this.mazeCover[y+2][x]=5;
            }
            else
                this.mazeCover[y+2][x]=0;
            if(maze[y+1][x+1]==1){
                this.mazeCover[y+2][x+1]=5;
            }
            else
                this.mazeCover[y+2][x+1]=0;
            if(maze[y+1][x-1]==1){
                this.mazeCover[y+2][x-1]=5;
            }
            else
                this.mazeCover[y+2][x-1]=0;
        }
        if(x+2<mazeCover.length){
            if(maze[y][x+1]==1){
                this.mazeCover[y][x+2]=5;
            }
            else
                this.mazeCover[y][x+2]=0;
            this.mazeCover[y+1][x+2]=0;
            if(maze[y+1][x+1]==1){
                this.mazeCover[y+1][x+2]=5;
            }
            else
                this.mazeCover[y+1][x+2]=0;
            if(maze[y-1][x+1]==1){
                this.mazeCover[y-1][x+2]=5;
            }
            else
                this.mazeCover[y-1][x+2]=0;
        }
        //expand vision when get the flash
        if(getLight()==true){
        if(y-3>=0){
            if(maze[y-2][x]==1||maze[y-1][x]==1){
                this.mazeCover[y-3][x]=5;
            }
            else
                this.mazeCover[y-3][x]=0;
            if(maze[y-2][x-1]==1||maze[y-1][x-1]==1){
                this.mazeCover[y-3][x-1]=5;
            }
            else
                this.mazeCover[y-3][x-1]=0;
            if(maze[y-2][x+1]==1||maze[y-1][x+1]==1){
                this.mazeCover[y-3][x+1]=5;
            }
            else
                this.mazeCover[y-3][x+1]=0;
        }
        if(y+3<mazeCover.length){
            if(maze[y+2][x]==1||maze[y+1][x]==1){
                this.mazeCover[y+3][x]=5;
            }
            else
                this.mazeCover[y+3][x]=0;
            if(maze[y+2][x-1]==1||maze[y+1][x-1]==1){
                this.mazeCover[y+3][x-1]=5;
            }
            else
                this.mazeCover[y+3][x-1]=0;
            if(maze[y+2][x+1]==1||maze[y+1][x+1]==1){
                this.mazeCover[y+3][x+1]=5;
            }
            else
                this.mazeCover[y+3][x+1]=0;
        }
            
        if(x+3<mazeCover.length){
            if(maze[y][x+2]==1||maze[y][x+1]==1){
                this.mazeCover[y][x+3]=5;
            }
            else
                this.mazeCover[y][x+3]=0;
            if(maze[y-1][x+2]==1||maze[y-1][x+1]==1){
                this.mazeCover[y-1][x+3]=5;
            }
            else
                this.mazeCover[y-1][x+3]=0;
            if(maze[y+1][x+2]==1||maze[y+1][x+1]==1){
                this.mazeCover[y+1][x+3]=5;
            }
            else
                this.mazeCover[y+1][x+3]=0;
        }

        if(x-3>=0){
            if(maze[y][x-2]==1||maze[y][x-1]==1){
                this.mazeCover[y][x-3]=5;
            }
            else
                this.mazeCover[y][x-3]=0;
            if(maze[y-1][x-2]==1||maze[y-1][x-1]==1){
                this.mazeCover[y-1][x-3]=5;
            }
            else
                this.mazeCover[y-1][x-3]=0;
            if(maze[y+1][x-2]==1||maze[y+1][x-1]==1){
                this.mazeCover[y+1][x-3]=5;
            }
            else
                this.mazeCover[y+1][x-3]=0;
            }
    }
    
    }      
   
}