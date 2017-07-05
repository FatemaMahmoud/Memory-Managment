/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorymanagment;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class Rectangle {
    
    private int x;
    private int y;
    private Color clr;
    private float height;
    private int width;
    private String name;
   
    
    public Rectangle(int y, float height,Color clr, String name){
        x = 50;
        this.y = y;
        this.height = height;
        width = 195;
        this.clr = clr;
        this.name = name;
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public float getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public Color getColor(){
        return clr;
    }
    
    public String getName(){
        return name;
    }
}
