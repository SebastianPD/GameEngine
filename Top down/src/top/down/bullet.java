/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.down;

import java.net.URL;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author cs-student
 */
public class bullet {
    
    Rectangle rectangle;
    double x;
    double y;
    double vy = 0;
    double vx = 0;
    double width = 20;
    double height = 20;
    
    long scorep = 0;
    
    AudioClip enemyDeath;
    URL enemySound = getClass().getResource("/resource/sound/enemyhit.wav");
    
    boolean isDead=false;
    
    TopDown gameInstance;
    
    Text Points;
    
    
    boolean uP=false;
    boolean dP=false;   
    boolean lP=false;
    boolean rP=false;
  
    //Pane container;
     
    
    bullet (Pane container, TopDown gameInstance){
        

        
      this.gameInstance = gameInstance;  
        enemyDeath = new AudioClip(enemySound.toString());
        
    rectangle = new Rectangle(10, 10, 20, 10);
    rectangle.setFill(Color.TEAL);
    container.getChildren().add(rectangle);
    
    
 
    
    if (gameInstance.uPressed){ 
    vy=-500; vx=0;
      
    }
     if (gameInstance.dPressed){ 
    vy=500; vx=0;
      
    }
     if (gameInstance.rPressed){ 
    vx=500; vy=0;
      
    }
     if (gameInstance.lPressed){ 
    vx=-500;      vy=0;  

      
    }

       if (gameInstance.LU){ 
    vy=-500; vx=0;
      
    }
     if (gameInstance.LD){ 
    vy=500; vx=0;
      
    }
     if (gameInstance.LR){ 
    vx=500; vy=0;
      
    }
     if (gameInstance.LL){ 
    vx=-500;      vy=0;  

      
    }
     
    
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
     void CheckCol3(Pane root){
     for (int i = 0 ; i < gameInstance.baddie1.size(); i++){
     
         enemy1 currentBaddie1 = gameInstance.baddie1.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentBaddie1.x;
              double box2Right = currentBaddie1.x + currentBaddie1.width;
              double box2Top = currentBaddie1.y;
              double box2Bottom = currentBaddie1.y + currentBaddie1.height;
                   
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
                         
                         
                 gameInstance.player.scorep = gameInstance.player.scorep+50;
                
                String scoreplayer = String.valueOf("Points:"+gameInstance.player.scorep);
                gameInstance.player.Points.setText(scoreplayer);
               // Points.setText(scoreplayer); 
                
                enemyDeath.play();   
                root.getChildren().remove(rectangle);
                root.getChildren().remove(currentBaddie1.rectangle);
                gameInstance.baddie1.remove(currentBaddie1);
                 isDead=true;       
               
                
                
                
                     }
             
     
     }
     }
     void CheckCol4(Pane root){
     for (int i = 0 ; i < gameInstance.baddie2.size(); i++){
     
         enemy2 currentBaddie2 = gameInstance.baddie2.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentBaddie2.x;
              double box2Right = currentBaddie2.x + currentBaddie2.width;
              double box2Top = currentBaddie2.y;
              double box2Bottom = currentBaddie2.y + currentBaddie2.height;
                   
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
                gameInstance.player.scorep = gameInstance.player.scorep+100;
                String scoreplayer = String.valueOf("Points:"+gameInstance.player.scorep);
                gameInstance.player.Points.setText(scoreplayer);
                         
                         
                enemyDeath.play();    
                root.getChildren().remove(rectangle);
                root.getChildren().remove(currentBaddie2.rectangle);
                gameInstance.baddie2.remove(currentBaddie2);
                 isDead=true;       
               
                
                
                
                     }
             
     
     }
     }
     
     void CheckCol6(Pane root){
     for (int i = 0 ; i < gameInstance.laser2.size(); i++){
     
         badBullet currentbullet1 = gameInstance.laser2.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentbullet1.x;
              double box2Right = currentbullet1.x + currentbullet1.width;
              double box2Top = currentbullet1.y;
              double box2Bottom = currentbullet1.y + currentbullet1.height;
                   
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
                gameInstance.player.scorep = gameInstance.player.scorep+100;
                String scoreplayer = String.valueOf("Points:"+gameInstance.player.scorep);
                gameInstance.player.Points.setText(scoreplayer);
                         
                         
                //enemyDeath.play();    
                root.getChildren().remove(rectangle);
                root.getChildren().remove(currentbullet1.rectangle);
                gameInstance.laser2.remove(currentbullet1);
                 isDead=true;       
               
                
                
                
                     }
             
     
     }
     }
     
     
    void CheckCol5(Pane root){
     for (int i = 0 ; i < gameInstance.baddie3.size(); i++){
     
         enemy3 currentBaddie3 = gameInstance.baddie3.get(i);
   
     
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentBaddie3.x;
              double box2Right = currentBaddie3.x + currentBaddie3.width;
              double box2Top = currentBaddie3.y;
              double box2Bottom = currentBaddie3.y + currentBaddie3.height;
                   
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
                  enemyDeath.play(); 
                  gameInstance.baddie3.get(i).hitmarker = gameInstance.baddie3.get(i).hitmarker + 1;
                  
                  //System.out.println(gameInstance.baddie3.get(i).hitmarker);
                  root.getChildren().remove(rectangle);
                  isDead=true; 
               
              if(gameInstance.baddie3.get(i).hitmarker>gameInstance.baddie3.get(i).health){
                root.getChildren().remove(currentBaddie3.rectangle);
                gameInstance.baddie3.remove(currentBaddie3);
                gameInstance.player.scorep = gameInstance.player.scorep+200;
                
                String scoreplayer = String.valueOf("Points:"+gameInstance.player.scorep);
                gameInstance.player.Points.setText(scoreplayer);
              
              }
                
                
                
                     }
             
     
     }
     }
    
}
