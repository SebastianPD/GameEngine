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
 * @author cs-student
 */
public class phaseWall {
    Rectangle rectangle;
    double width = 40;
    double height = 40;
    double x;
    double y;
  
    phaseWall(Pane container){
        
    rectangle = new Rectangle(width, height, Color.GREY);
    
    container.getChildren().add(rectangle);
    }
    
    
    void update (double x, double y){
        
    rectangle.relocate(x, y);
    
}
}
