/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.down;

import java.net.URL;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *
 * @author Sebastian
 */
public class TopDown extends Application {
    
    AnimationTimer timer;
    long lastFrame;
    Pane root = new Pane();
    ArrayList<Wall> walls = new ArrayList();
    ArrayList<phaseWall> pWalls = new ArrayList();
    ArrayList<enemy1> baddie1 = new ArrayList();
    ArrayList<enemy2> baddie2 = new ArrayList();
    ArrayList<enemy3> baddie3 = new ArrayList();
    ArrayList<bullet> laser = new ArrayList();
    ArrayList<badBullet> laser2 = new ArrayList();
    boolean uPressed;
    boolean dPressed;
    boolean lPressed;
    boolean rPressed;
    Button btn = new Button();
    
    long level = 1;
    
    AudioClip shoot;
    URL shootsound = getClass().getResource("/resource/sound/bulletsound1.wav");
    
    
    boolean LU;
    boolean LD;
    boolean LL;
    boolean LR;
    Player1 player = new Player1(root, this);
    
    
    
    @Override
    public void start(Stage primaryStage) {
         
        
        
        shoot = new AudioClip(shootsound.toString());
        
       
        
         
//         enemy1 bad1 = new enemy1(root,this);
         
         
         
        
        btn.setText("Start");
        btn.setMinSize(200, 100);
        btn.setOnAction(new EventHandler<ActionEvent>() {
          
          
        public void handle(ActionEvent event) {
               
         makeBaddie1(20, 20, 450, 100);
         makeBaddie1(20, 20, 450, 140);
         makeBaddie1(20, 20, 450, 180);
         makeBaddie1(20, 20, 450, 220);
         makeBaddie1(20, 20, 450, 680);
         makeBaddie1(20, 20, 450, 600);
         makeBaddie1(20, 20, 450, 640);
         makeBaddie1(20, 20, 450, 720);
          
        makeBaddie2(20, 20, 520, 200);
        makeBaddie2(20, 20, 520, 240); 
        makeBaddie2(20, 20, 520, 600);
        makeBaddie2(20, 20, 520, 640); 

         makeBaddie3(20, 20, 650, 200);
         makeBaddie3(20, 20, 650, 240); 
         
         makeWall(1200,10, 0,0 ); makeWall(1200, 10, 0, 790); makeWall(10, 800, 0, 0); makeWall(10, 800, 1190, 0);
         makeWall(40, 300, 260, 0);
         makeWall(160, 40, 0, 260);
         makeWall(360, 40, 40, 440);
         makeWall(40, 360, 540, 0);
         makeWall(40, 360, 540, 440);
         makeWall(320, 40, 800, 320);
         makeWall(320, 40, 800, 440);
         
         makepWall(40, 40, 1100, 380);
         
         player.x = 100;
         player.y = 100;
         player.Points.relocate(50,100);
         player.lifeP.relocate(50,50);
         player.Title.relocate(10000,10000);
         btn.relocate(9000, 9000);
         btn.setDisable(true);
         root.requestFocus();
            }
        });
         
        btn.relocate(500, 400);  
        
         root.setOnKeyPressed((event) -> {
         if (event.getCode() == KeyCode.UP){
            uPressed=true;
            LU=true;
            LD=false;
            LR=false;
            LL=false;
            }
        if (event.getCode() == KeyCode.DOWN){
            dPressed=true;
            LD=true;
            LU=false;
            LR=false;
            LL=false;
            }
        if (event.getCode() == KeyCode.LEFT){
            lPressed=true;
            LL=true;
            LD=false;
            LR=false;
            LU=false;
            }
        if (event.getCode() == KeyCode.RIGHT){
            rPressed=true;
            LR=true;
            LD=false;
            LU=false;
            LL=false;
            }
        if (event.getCode() == KeyCode.SPACE){
            shoot.play();
           makelaser(10, 10, player.x+5, player.y+5);
              // make laser mone different directions. you can do this by giving keycodes
              //true false statements and edit the makelaser class to accept velocity
            
             
             }
         if (event.getCode() == KeyCode.R){
             
             
              for (int i = baddie1.size()-1; i >= 0 ; i--){
             
             root.getChildren().remove(baddie1.get(i).rectangle);
             baddie1.remove(baddie1.get(i));
             
              }
              
              for (int i = baddie2.size()-1; i >= 0 ; i--){
             
             root.getChildren().remove(baddie2.get(i).rectangle);
             baddie2.remove(baddie2.get(i));
             
              }
              for (int i = baddie3.size()-1; i >= 0 ; i--){
             
             root.getChildren().remove(baddie3.get(i).rectangle);
             baddie3.remove(baddie3.get(i));
             
              }
              
              
         makeBaddie1(20, 20, 450, 100);
         makeBaddie1(20, 20, 450, 140);
         makeBaddie1(20, 20, 450, 180);
         makeBaddie1(20, 20, 450, 220);
         makeBaddie1(20, 20, 450, 680);
         makeBaddie1(20, 20, 450, 600);
         makeBaddie1(20, 20, 450, 640);
         makeBaddie1(20, 20, 450, 720);
          
         makeBaddie2(20, 20, 520, 200);
         makeBaddie2(20, 20, 520, 240); 
         makeBaddie2(20, 20, 520, 600);
         makeBaddie2(20, 20, 520, 640); 

         makeBaddie3(20, 20, 650, 200);
         makeBaddie3(20, 20, 650, 240); 
         
         makeWall(1200,10, 0,0 ); makeWall(1200, 10, 0, 790); makeWall(10, 800, 0, 0); makeWall(10, 800, 1190, 0);
         makeWall(40, 300, 260, 0);
         makeWall(160, 40, 0, 260);
         makeWall(360, 40, 40, 440);
         makeWall(40, 360, 540, 0);
         makeWall(40, 360, 540, 440);
         makeWall(320, 40, 800, 320);
         makeWall(320, 40, 800, 440);
         
         
         player.x= 150;
         player.y = 220;
         player.scorel=3;
         player.scorep=0;
         
          String scoreLife = String.valueOf("Life:"+player.scorel);
    
          player.lifeP.setText(scoreLife);
          
          String scorePlayer = String.valueOf("Points:"+player.scorep);
    
          player.Points.setText(scorePlayer);
              
             }
       if (event.getCode() == KeyCode.E){ 
       
          TestLevel test = new TestLevel(root, this);
       //Player1 player = new Player1(root, this);
       }     
            
       if (event.getCode() == KeyCode.DIGIT2){ 
       
          Level2 two = new Level2(root, this);
       //Player1 player = new Player1(root, this);
       }     
       
       
        });
        
        root.setOnKeyReleased((event) -> {
        if (event.getCode() == KeyCode.UP){
           uPressed=false;
            }
        if (event.getCode() == KeyCode.DOWN){
           dPressed=false;
            }
        if (event.getCode() == KeyCode.LEFT){
            lPressed=false;
            }
        if (event.getCode() == KeyCode.RIGHT){
            rPressed=false;
            }
        });
         
         
     
         lastFrame = System.nanoTime();
         timer = new AnimationTimer(){
            @Override
            public void handle(long currentFrame) {
            double Time = (currentFrame-lastFrame)/1000000000.0;

            player.CheckInput();
            player.update(Time);
            player.CheckCol();
            player.CheckCol2();
            player.CheckCol3();
            player.CheckCol4();
            player.CheckCol5();
            player.relocate();

            updatewalls();
            updatePwalls();
            updatebaddie1(Time);
            updatebaddie2(Time);
            updatebaddie3(Time);
            updatebullet(Time);
            updateEbullet(Time);
          
           
       
            
            lastFrame = currentFrame; 
            
            }
        };
         
         
         
         
        timer.start();
        Scene scene = new Scene(root, 1200, 800);
        root.getChildren().add(btn);
        primaryStage.setResizable(false);
        primaryStage.setTitle("TOP DOWN!");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }

    void makeWall(double width, double height, double x, double y) {
    
        Wall newwall = new Wall(root);
        newwall.width = width;
        newwall.height = height;
        newwall.x = x;
        newwall.y = y;
        newwall.rectangle.setWidth(width);
        newwall.rectangle.setHeight(height);
        walls.add(newwall);
        
    }
    
    void makepWall(double width, double height, double x, double y) {
    
        phaseWall newPwall = new phaseWall(root);
        newPwall.width = width;
        newPwall.height = height;
        newPwall.x = x;
        newPwall.y = y;
        newPwall.rectangle.setWidth(width);
        newPwall.rectangle.setHeight(height);
        pWalls.add(newPwall);
           
    }
   
    void updatewalls(){
    
         for (int i = 0 ; i < walls.size(); i++){
        
        walls.get(i).rectangle.relocate(walls.get(i).x, walls.get(i).y);
        
         }
    }
    
    void updatePwalls(){
    
         for (int i = 0 ; i < pWalls.size(); i++){
        
        pWalls.get(i).rectangle.relocate(pWalls.get(i).x, pWalls.get(i).y);
        
         }
    }
    
    void makeBaddie1(double width, double height, double x, double y) {
    
        enemy1 newBaddie1 = new enemy1(root, this);
        newBaddie1.width = width;
        newBaddie1.height = height;
        newBaddie1.x = x;
        newBaddie1.y = y;
        newBaddie1.rectangle.setWidth(width);
        newBaddie1.rectangle.setHeight(height);
        baddie1.add(newBaddie1);
        
    
    }
    
    void makeBaddie2(double width, double height, double x, double y) {
    
        enemy2 newBaddie2 = new enemy2(root, this);
        newBaddie2.width = width;
        newBaddie2.height = height;
        newBaddie2.x = x;
        newBaddie2.y = y;
        newBaddie2.rectangle.setWidth(width);
        newBaddie2.rectangle.setHeight(height);
        baddie2.add(newBaddie2);
        
    
    }
    
    void makeBaddie3(double width, double height, double x, double y) {
    
        enemy3 newBaddie3 = new enemy3(root, this);
        newBaddie3.width = width;
        newBaddie3.height = height;
        newBaddie3.x = x;
        newBaddie3.y = y;
        newBaddie3.rectangle.setWidth(width);
        newBaddie3.rectangle.setHeight(height);
        baddie3.add(newBaddie3);
        
    
    }
    
    
    
    void makelaser(double width, double height, double x, double y) {
    
        bullet newlaser = new bullet(root, this);
        newlaser.width = width;
        newlaser.height = height;
        newlaser.x = x;
        newlaser.y = y;
        newlaser.rectangle.setWidth(width);
        newlaser.rectangle.setHeight(height);
        laser.add(newlaser);
        
    
    }
    
    void makeElaser(double width, double height, double x, double y, double vx, double vy) {
    
        badBullet newlaser2 = new badBullet(root, this);
        newlaser2.width = width;
        newlaser2.height = height;
        newlaser2.x = x;
        newlaser2.y = y;
        newlaser2.vx = vx;
        newlaser2.vy = vy;
        newlaser2.rectangle.setWidth(width);
        newlaser2.rectangle.setHeight(height);
        laser2.add(newlaser2);
        
    
    }
    
    
    void updatebaddie1(double t){
    
         for (int i = 0 ; i < baddie1.size(); i++){
        
       
        
        baddie1.get(i).Check();
        baddie1.get(i).update(t);
        baddie1.get(i).CheckCol();         
        baddie1.get(i).rectangle.relocate(baddie1.get(i).x, baddie1.get(i).y);
        
         }
    }
  
    
    void updatebaddie2(double t){
    
         for (int i = 0 ; i < baddie2.size(); i++){
        baddie2.get(i).Check(); 
        baddie2.get(i).Find(t);
        baddie2.get(i).update(t);
        baddie2.get(i).CheckCol(); 
        baddie2.get(i).rectangle.relocate(baddie2.get(i).x, baddie2.get(i).y);
        
         }
    }
    
    void updatebaddie3(double t){
    
        
        
         for (int i = 0 ; i < baddie3.size(); i++){
        baddie3.get(i).Check();  
        baddie3.get(i).shoot(t);
        baddie3.get(i).update(t);
        baddie3.get(i).CheckCol();  
        baddie3.get(i).rectangle.relocate(baddie3.get(i).x, baddie3.get(i).y);
        
         }
         
         

    }
    
    void updatebullet(double t){
    // TO DO bullet i not my spirt I need to figure out a way to shot with out lossing control.
         
         ArrayList<bullet> deadShots = new ArrayList();
    
        for (int i = 0 ; i < laser.size(); i++){            
            laser.get(i).update(t);
            laser.get(i).checkB(root); 
            laser.get(i).CheckCol3(root);
            laser.get(i).CheckCol4(root);
            laser.get(i).CheckCol5(root);
            //laser.get(i).CheckCol6(root);
            //laser.get(i).Check();
            laser.get(i).rectangle.relocate(laser.get(i).x, laser.get(i).y);
            //laser.get(i).rectangle.
            
            if (laser.get(i).isDead){
                deadShots.add(laser.get(i));
            }
         }

        laser.removeAll(deadShots);
        

    }
    
     void updateEbullet(double t){
    // TO DO bullet i not my spirt I need to figure out a way to shot with out lossing control.
         
         ArrayList<badBullet> deadShots2 = new ArrayList();
    
        for (int i = 0 ; i < laser2.size(); i++){            
            laser2.get(i).update(t);
            laser2.get(i).checkB(root); 
            laser2.get(i).checkP(root); 
            laser2.get(i).rectangle.relocate(laser2.get(i).x, laser2.get(i).y);
           
            
            if (laser2.get(i).isDead){
                deadShots2.add(laser2.get(i));
            }
         }

        laser2.removeAll(deadShots2);
        

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
