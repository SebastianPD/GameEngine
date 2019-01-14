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
 * @author Sebastian
 */
public class Player1 {
    
    Rectangle rectangle;
    
    TopDown gameInstance;
    
    AudioClip hit;
    URL hitsound = getClass().getResource("/resource/sound/deathsound1.wav");
    
    double vy = 200;
    double vx = 200;
    double vy2 = -200;
    double vx2 = -200;
    double y = 2200;
    double x = 1500;
    double y2 = 220;
    double x2 = 150;
    double LastTimeStep;
    double Life = 3;
    
   
    long scorel = 3;
    
    Text lifeP;
    Text Title;
    
    long scorep = 0;
    
    Text Points;
   
    //double v = Math.sqrt(vy*vy + vx*vx);
    
    boolean uPressed;
    boolean dPressed;
    boolean lPressed;
    boolean rPressed;
    
    Player1(Pane container, TopDown gameInstance){
   
        String scoreplayer = String.valueOf("Points:"+scorep);    
        Points = new Text(scoreplayer);
        Points.setFont(new Font("DejaVu Sans Bold Oblique", 18)); 
        Points.relocate(500,1000);
        
        hit = new AudioClip(hitsound.toString());
       
     String Name = String.valueOf("Top Down");   
      Title = new Text(Name);
     Title.setFont(new Font("Monospace", 80));
      Title.relocate(425,100);
      
   
    String scoreLife = String.valueOf("Life:"+scorel);
    
    lifeP = new Text(scoreLife);
      
    
    lifeP.setFont(new Font("DejaVu Sans Bold Oblique", 18));
    
        
    
    lifeP.relocate(5000,5000);
    
    
        
   uPressed=false;
   dPressed=false;   
   lPressed=false;
   rPressed=false;
   
   
   this.gameInstance = gameInstance;
    
    rectangle = new Rectangle(x, y, 20, 20);
    rectangle.setFill(Color.BLUE);
    
   
    container.getChildren().add(lifeP);
    container.getChildren().add(Points);
    container.getChildren().add(Title);
    container.getChildren().add(rectangle);
      
        
        
        
        
    }
    
    
    void update (double t){
  
    
    y = vy*t + y;
    x = vx*t + x;
    
    LastTimeStep = t;
    
    
    
}
    
    
    void relocate(){
    rectangle.relocate(x, y);
    
    }
    
     void CheckCol5(){
    
    for (int i = 0 ; i < gameInstance.pWalls.size(); i++){
     
             phaseWall currentWall = gameInstance.pWalls.get(i);
             
             
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
           /////
          x = 10;
          y = 10;
               
          gameInstance.level = gameInstance.level+1;
          
          if (gameInstance.level == 2) {
          
          Level2 two = new Level2(gameInstance.root, gameInstance);
              
          }
          
           }
    
    }   
 
 }
  
    void CheckCol(){
    
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
           /////
          
                x = x-vx*LastTimeStep;
                y = y-vy*LastTimeStep;
           
           
           double Centerx = x+10;
           double Centery = y+10;
           
           double boxCx = currentWall.x + .5*currentWall.width;
           double boxCy = currentWall.y + .5*currentWall.height;
           

           
           
           double distanceX =  Math.abs(Centerx - boxCx) - 10 - .5*currentWall.width;
           double distanceY = Math.abs(Centery - boxCy) - 10 - .5*currentWall.height;
           
           double Tx = distanceX/Math.abs(vx);
           double Ty = distanceY/Math.abs(vy);
           
           
            double t = Double.max(Tx, Ty);
            
            
            
            if (Double.isFinite(t)){
                
                if(Tx > Ty){
                x = x+vx*t;
                y = y+vy*LastTimeStep;
                
                
                }
                else if(Tx < Ty){
                x = x+vx*LastTimeStep;
                y = y+vy*t;
             
                }
                else {
                x = x+vx*t;
                y = y+vy*t;
              
                }
            }else{
                x += vx*LastTimeStep*.95;
                y += vy*LastTimeStep*.95;
                
            }
           }
    
    }   
 
 }
    
    void CheckInput (){
     
     boolean bottom = (y + 20 > 800);
     boolean top = (y < 0);
     boolean right = (x + 20 > 1200);
     boolean left = (x < 0);
   
     
    if (gameInstance.uPressed && !top){
    vy = -200;}
    else if (gameInstance.dPressed && !bottom){
    vy = 200;
    }else {
    vy = 0;
    //vy2 = 0;
    }
    
    if (gameInstance.lPressed && !left){
    vx = -200;}
    else if (gameInstance.rPressed && !right){
    vx = 200;
    }else {
    vx = 0;
    //vx2 = 0;
    }
    
    
   if(gameInstance.uPressed && gameInstance.lPressed){
   vx = 0;
   }
   
   if(gameInstance.uPressed && gameInstance.rPressed){
   vx = 0;
   }
   
   if(gameInstance.dPressed && gameInstance.lPressed){
   vx = 0;
   }
   
   if(gameInstance.dPressed && gameInstance.rPressed){
   vx = 0;
   }
    
    
    }
    
     
    void CheckCol2(){
     for (int i = 0 ; i < gameInstance.baddie1.size(); i++){
     
         enemy1 currentpWall = gameInstance.baddie1.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentpWall.x;
              double box2Right = currentpWall.x + currentpWall.width;
              double box2Top = currentpWall.y;
              double box2Bottom = currentpWall.y + currentpWall.height;
                   
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
                   
                hit.play();         
                x=10;
                y=10;
               
                
                scorel=scorel-1;
                
                String scoreLife = String.valueOf("Life:"+scorel);
    
                lifeP.setText(scoreLife);
                
                
                if (scorel <= 0){
                
                
    
                lifeP.setText("GAME OVER");
                x=9000;
                y=9000;
                
           
                }
                     }
             
     
     } 
    }
       
    
    void CheckCol3(){
     for (int i = 0 ; i < gameInstance.baddie2.size(); i++){
     
         enemy2 charger = gameInstance.baddie2.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = charger.x;
              double box2Right = charger.x + charger.width;
              double box2Top = charger.y;
              double box2Bottom = charger.y + charger.height;
                   
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
                   
                hit.play();  
                x=10;
                y=10;
                scorel=scorel-1;
                
                String scoreLife = String.valueOf("Life:"+scorel);
    
                lifeP.setText(scoreLife);
                
                
                if (scorel <= 0){
                
                
    
                lifeP.setText("GAME OVER");
                x=9000;
                y=9000;
                
           
                }
                     }
             
     }
    }
     
//     void CheckCharge (double t) {
//    for (int i = 0 ; i < gameInstance.baddie2.size(); i++){
//     enemy2 charger = gameInstance.baddie2.get(i);
//     
//             
//          
//              double Chargerx = charger.x;
//              double Chargery = charger.y;
//              
//         if ((x+10 == Chargerx+10)&&(y>Chargery)){
//                 System.out.println("Down");
//                 charger.vy=200;
//                  charger.y = charger.vy*t + charger.y;
//                  charger.x = charger.vx*t + charger.x;
//            
//            }       
//           else  if ((x+10 == Chargerx+10)&&(y<Chargery)){
//                System.out.println("Up");
//                 charger.vy=-200;
//                  charger.y = charger.vy*t + charger.y;
//                  charger.x = charger.vx*t + charger.x;
//            
//            }  
//           else  if ((y+10 == Chargery+10)&&(x+10>Chargerx+10)){
//                System.out.println("Right");
//                 charger.vx=200;
//                  charger.y = charger.vy*t + charger.y;
//                  charger.x = charger.vx*t + charger.x;
//            
//            }  
//           else if ((y+10 == Chargery+10)&&(x+10<Chargerx+10)){
//                 System.out.println("Left");
//            charger.vx=-200;
//            charger.y = charger.vy*t + charger.y;
//            charger.x = charger.vx*t + charger.x;
//            }  
//           else {
//           
//           }
//    
//    }
//    }
     
     
     
     
    
 
     void CheckCol4(){
     for (int i = 0 ; i < gameInstance.baddie3.size(); i++){
     
         enemy3 currentpWall = gameInstance.baddie3.get(i);
     
             
                
              double box1Right = x+20;
              double box1Left = x;
              double box1Top = y;
              double box1Bottom = y+20;
              double box2Left = currentpWall.x;
              double box2Right = currentpWall.x + currentpWall.width;
              double box2Top = currentpWall.y;
              double box2Bottom = currentpWall.y + currentpWall.height;
                   
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
                   
                hit.play();  
                x=10;
                y=10;
                scorel=scorel-1;
                
                String scoreLife = String.valueOf("Life:"+scorel);
    
                lifeP.setText(scoreLife);
                
                
                if (scorel <= 0){
                
                
    
                lifeP.setText("GAME OVER");
                x=9000;
                y=9000;
                
           
                }
                     }
             
     
     } 
    }
    
}

//           double Cx = Math.sqrt(Math.pow((boxCx-Centerx),2));
//           double Cy = Math.sqrt(Math.pow((boxCy-Centery),2));
           
//           double c1 = currentWall.y + currentWall.height;
//           double c2 = currentWall.y;
//           double c3 = currentWall.x + currentWall.width;
//           double c4 = currentWall.x;
           
           
//           double angle = Math.atan2(Cy, Cx);
//           double q1 = Math.PI/4;
//           double q2 = (3*Math.PI)/4;
//           double q3 = (5*Math.PI)/4;
//           double q4 = (7*Math.PI)/4;

 // TODO: make a better quadrant system. Centers should be fine and vectors. Now have it colide with different quadrents.
           
           
//          if ( (c3 >= x) && (c1 <= x + rectangle.getWidth()) && (c2 <= y + rectangle.getHeight()) && (c1>= y)) {
//        vx = -1*vx;
//          }
//
//           
//          if (( q1 < angle) && (angle <= q2)){
//          System.out.println("q1 q2");
//              vy = -vy;
//          } 
//           else if (( q3 < angle) && (angle <= q4)){
//          System.out.println("q3 q4");
//          vy = 0;
//          } 
//           
//           
//           System.out.println(angle);
//          else if (( q2 < angle) && (angle <= q3)){
//          
//           System.out.println("q2 q3"); 
//           vx = -vx;
//             if ( (currentpWall.x + currentpWall.width >= x) && (currentpWall.x <= x + rectangle.getWidth()) && (currentpWall.y <= y + rectangle.getHeight()) && (currentpWall.y + currentpWall.height >= y)) {
//          } 
//for (int i = 0 ; i < gameInstance.pWalls.size(); i++){
//     
//         phaseWall currentpWall = gameInstance.pWalls.get(i);
//        
//        if ( (currentpWall.x + currentpWall.width >= x) && (currentpWall.x <= x + rectangle.getWidth()) && (currentpWall.y <= y + rectangle.getHeight()) && (currentpWall.y + currentpWall.height >= y)) { 
//        
//             vx = -1*vx;
//             vy = -1*vy;
//            
//        }
//    }