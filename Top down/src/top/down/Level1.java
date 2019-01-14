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
public class Level1 {
     TopDown gameInstance;
    
    Level1(Pane container, TopDown gameInstance){
    
        
        
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
         
               
              
         gameInstance.makeBaddie1(20, 20, 450, 100);
         gameInstance.makeBaddie1(20, 20, 450, 140);
         gameInstance.makeBaddie1(20, 20, 450, 180);
         gameInstance.makeBaddie1(20, 20, 450, 220);
         gameInstance.makeBaddie1(20, 20, 450, 260);
         gameInstance.makeBaddie1(20, 20, 450, 300);
         gameInstance.makeBaddie1(20, 20, 450, 340);
         gameInstance.makeBaddie1(20, 20, 450, 380);
         
         gameInstance.makeBaddie2(20, 20, 520, 200);
         gameInstance.makeBaddie2(20, 20, 520, 240); 

         gameInstance.makeBaddie3(20, 20, 650, 200);
         gameInstance.makeBaddie3(20, 20, 650, 240); 
         
         gameInstance.makeWall(1200,10, 0,0 ); gameInstance.makeWall(1200, 10, 0, 790); gameInstance.makeWall(10, 800, 0, 0); gameInstance.makeWall(10, 800, 1190, 0);
         gameInstance.makeWall(40, 300, 260, 0);
         gameInstance.makeWall(160, 40, 0, 260);
         gameInstance.makeWall(360, 40, 40, 440);
         gameInstance.makeWall(40, 360, 540, 0);
         gameInstance.makeWall(40, 360, 540, 440);
         gameInstance.makeWall(320, 40, 800, 320);
         gameInstance.makeWall(320, 40, 800, 440);
         
    
    }
}
