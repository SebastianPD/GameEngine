/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.down;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sebastian
 */
public class Wall {
    
    Rectangle rectangle;
    double width = 40;
    double height = 40;
    double x;
    double y;
  
    Wall(Pane container){
        
    rectangle = new Rectangle(width, height, Color.BLACK);
    
    container.getChildren().add(rectangle);
    }
    
    
    void update (double x, double y){
        
    rectangle.relocate(x, y);
    
}
}
