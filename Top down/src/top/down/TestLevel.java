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
public class TestLevel {
   
    TopDown gameInstance;
    
    TestLevel(Pane container, TopDown gameInstance){
    
         gameInstance.makeBaddie1(20, 20, 450, 100);
         gameInstance.makeBaddie1(20, 20, 450, 140);
         gameInstance.makeBaddie1(20, 20, 450, 180);
         gameInstance.makeBaddie1(20, 20, 450, 220);
        
    }
}
