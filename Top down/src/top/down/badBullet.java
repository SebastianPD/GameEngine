/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.down;

import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author cs-student
 */
public class badBullet {
    
    Rectangle rectangle;
    double x;
    double y;
    double vy = 0;
    double vx=0 ;
    double width = 20;
    double height = 20;
    
    long scorep = 0;
    
   AudioClip hit;
    URL hitsound = getClass().getResource("/resource/sound/deathsound1.wav");
    
    boolean isDead=false;
    
    TopDown gameInstance;
    
    Text Points;
    
    
    boolean uP=false;
    boolean dP=false;   
    boolean lP=false;
    boolean rP=false;
  
    //Pane container;
     
    
    badBullet (Pane container, TopDown gameInstance){
    
     this.gameInstance = gameInstance;  
        hit = new AudioClip(hitsound.toString());
        
    rectangle = new Rectangle(10, 10, 20, 10);
    rectangle.setFill(Color.RED);
    container.getChildren().add(rectangle);
    
    
    
    }
    
    void update (double t){
  
    
    y = vy*t + y;
    x = vx*t + x;
    rectangle.relocate(x,y);
    
  
    
    //LastTimeStep = t;
    
    
    
}
  
  void checkB(Pane root){
    
    for (int i = 0 ; i < gameInstance.walls.size(); i++){
     
         Wall currentWall = gameInstance.walls.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentWall.x;
              double box2Right = currentWall.x + currentWall.width;
              double box2Top = currentWall.y;
              double box2Bottom = currentWall.y + currentWall.height;
                   
                     if (   
                (
                    ((box1Left >= box2Left) && (box1Left <= box2Right)) 
                    || ((box1Right >= box2Left) && (box1Right <= box2Right))
                    || ((box2Left >= box1Left) && (box2Left <= box1Right))
                    || ((box2Right >= box1Left) && (box2Right <= box1Right))
                )
                    &&
                (
                    (box1Top >= box2Top) && (box1Top <= box2Bottom) 
                    || ((box1Bottom >= box2Top) && (box1Bottom <= box2Bottom))
                    || ((box2Top >= box1Top) && (box2Top <= box1Bottom))
                    || ((box2Bottom >= box1Top) && (box2Bottom <= box1Bottom))
                     )    
            ){
                   
                root.getChildren().remove(rectangle);
                
          
                 isDead=true;       
               
                
                
                
                     }
             
     
     }
  
  }
    
  void checkP(Pane root){
    
    
     
         
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = gameInstance.player.x;
              double box2Right = gameInstance.player.x + 20;
              double box2Top = gameInstance.player.y;
              double box2Bottom = gameInstance.player.y + 20;
                   
                     if (   
                (
                    ((box1Left >= box2Left) && (box1Left <= box2Right)) 
                    || ((box1Right >= box2Left) && (box1Right <= box2Right))
                    || ((box2Left >= box1Left) && (box2Left <= box1Right))
                    || ((box2Right >= box1Left) && (box2Right <= box1Right))
                )
                    &&
                (
                    (box1Top >= box2Top) && (box1Top <= box2Bottom) 
                    || ((box1Bottom >= box2Top) && (box1Bottom <= box2Bottom))
                    || ((box2Top >= box1Top) && (box2Top <= box1Bottom))
                    || ((box2Bottom >= box1Top) && (box2Bottom <= box1Bottom))
                     )    
            ){
                   
                root.getChildren().remove(rectangle);
                gameInstance.player.x=10;
                gameInstance.player.y=10;
               
                
                gameInstance.player.scorel=gameInstance.player.scorel-1;
                
                String scoreLife = String.valueOf("Life:"+gameInstance.player.scorel);
    
                gameInstance.player.lifeP.setText(scoreLife);
                hit.play();
                
                if (gameInstance.player.scorel <= 0){
                
                
     
                gameInstance.player.lifeP.setText("GAME OVER");
                gameInstance.player.x=9000;
                gameInstance.player.y=9000;
          
                 isDead=true;       
               
                
                
                
                     }
                     }
             
     
    
  
  }
    
}
