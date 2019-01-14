/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.down;

import javafx.scene.layout.Pane;

/**
 *
 * @author Sebastian
 */
public class Level2 {
    
    TopDown gameInstance;
    
    Level2(Pane container, TopDown gameInstance){
    
         for (int i = gameInstance.baddie1.size()-1; i >= 0 ; i--){
             
             container.getChildren().remove(gameInstance.baddie1.get(i).rectangle);
             gameInstance.baddie1.remove(gameInstance.baddie1.get(i));
             
              }
              
              for (int i = gameInstance.baddie2.size()-1; i >= 0 ; i--){
             
             container.getChildren().remove(gameInstance.baddie2.get(i).rectangle);
             gameInstance.baddie2.remove(gameInstance.baddie2.get(i));
             
              }
              for (int i = gameInstance.baddie3.size()-1; i >= 0 ; i--){
             
             container.getChildren().remove(gameInstance.baddie3.get(i).rectangle);
             gameInstance.baddie3.remove(gameInstance.baddie3.get(i));
             
              }
         for (int i = gameInstance.walls.size()-1; i >= 0 ; i--){
             
             container.getChildren().remove(gameInstance.walls.get(i).rectangle);
             gameInstance.walls.remove(gameInstance.walls.get(i));
             
              }
         for (int i = gameInstance.pWalls.size()-1; i >= 0 ; i--){
             
             container.getChildren().remove(gameInstance.pWalls.get(i).rectangle);
             gameInstance.pWalls.remove(gameInstance.pWalls.get(i));
             
              }
         
         
         gameInstance.makeWall(1200,10, 0,0 ); gameInstance.makeWall(1200, 10, 0, 790); gameInstance.makeWall(10, 800, 0, 0); gameInstance.makeWall(10, 800, 1190, 0);
          
          
         gameInstance.makeBaddie3(20, 20, 650, 240); 
         gameInstance.makeBaddie3(20, 20, 650, 240); 
         gameInstance.makeBaddie3(20, 20, 650, 240); 
         gameInstance.makeBaddie3(20, 20, 650, 240); 
         
    }
}
