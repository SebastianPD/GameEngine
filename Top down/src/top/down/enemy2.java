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
public class enemy2 {
    
     
    Rectangle rectangle;

    TopDown gameInstance;
    double LastTimeStep;
    double width = 20;
    double height = 20;
    double vy = 0;
    double vx = 0;
    double y = 450;
    double x = 450;
    double changeInterval=4*Math.random()+1;
     double changeTimer=0;
     double I;
    
    
     boolean u;
     boolean d;
     boolean l;
     boolean r;
     
    

    enemy2(Pane container, TopDown gameInstance) {

    u=false;
    d=false;
    l=false;
    r=false; 
    
    I = Math.round(3*Math.random());
        
        
        this.gameInstance = gameInstance;

        rectangle = new Rectangle(x, y, 20, 20);
        rectangle.setFill(Color.ORANGE);
        container.getChildren().add(rectangle);
        
    }
    
    void update (double t){
    
    
   changeInterval=4*Math.random()+1;
   
    y = vy*t + y;
    x = vx*t + x;
    //rectangle.relocate(x, y);
    
    changeTimer +=t;
    
    LastTimeStep=t;
    
    if (changeTimer > changeInterval) {
         
        changebehavior();
        changeTimer=0;
    }
}
  
     void changebehavior(){
    
     I = Math.round(3.1*Math.random());
     
     if(I==0){
     u=true;
     d=false;
     l=false;
     r=false;
     } if (I==1){
     d=true;
     u=false;
     l=false;
     r=false;
     }if (I==2){
     l=true;
     r=false;
     d=false;
     u=false;
     }if (I==3){
     r=true;
     l=false;
     u=false;
     d=false;
     }if (I==4){
     
    }
     
     
     
    }
    
    
    
    void Check(){
   
        
     boolean bottom = (y + 20 > 800);
     boolean top = (y < 0);
     boolean right = (x + 20 > 1200);
     boolean left = (x < 0);
   
             
     
     
     
    if (u && !top){
    vy = -100;}
    else if (d&&!bottom){
    vy = 100;
    }else {
     vy=0;
    }
     

 if (l&&!left){
    vx = -100;}
    else if (r&&!right){
    vx = 100;
    }else {
     I = Math.round(3.1*Math.random());
     vx = 0;
    }
    
    
}

    void Find(double T){

        double DeltaX = gameInstance.player.x - x;
        double DeltaY = gameInstance.player.y - y;
        
        if((DeltaX*DeltaX )+ (DeltaY*DeltaY)< 50000) {
        
       
        
        if ((gameInstance.player.x < x+20)&&(gameInstance.player.x > x)&&(gameInstance.player.y>y)){
                vx=0;
                vy=0;
                vy=150;
                y = vy*T + y;
                x = vx*T + x;
            
            }       
           else  if ((gameInstance.player.x < x+20)&&(gameInstance.player.x > x)&&(gameInstance.player.y<y)){
                vx=0;
                vy=0;
                 vy=-150;
                 y = vy*T + y;
                 x = vx*T + x;
            
            }  
           else  if ((gameInstance.player.y < y+20)&&(gameInstance.player.y > y)&&(gameInstance.player.x>x)){
                vx=0;
                vy=0;
                  vx=150;
                  y = vy*T + y;
                  x = vx*T + x;
            
            }  
           else if ((gameInstance.player.y < y+20)&&(gameInstance.player.y > y)&&(gameInstance.player.x<x)){
            vx=0;
            vy=0;
            vx=-150;
            y = vy*T + y;
            x = vx*T + x;
            }  
           else {
           
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
                x += vx*LastTimeStep*-.1;
                y += vy*LastTimeStep*-.1;
                
            }
           }
    
    }   
  }   
    
}
